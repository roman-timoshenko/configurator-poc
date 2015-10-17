package ru.rsoft.configurator.backend.handlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import ru.rsoft.configurator.core.dto.DesignCreateDto;
import ru.rsoft.configurator.core.dto.DesignDto;
import ru.rsoft.configurator.core.entity.Design;
import ru.rsoft.configurator.core.repository.DesignRepository;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Обработчик ресурса чертежей.
 * <p/>
 * Тип возвращаемого значения указывается в хедере "Accept" запроса.
 * Варианты: "application/json" и "application/xml"
 * Другие можно добавить, подключив дополнительные библиотеки.
 * <p/>
 * Тип передаваемого значения указывается в хедере "Content-Type" запроса.
 * Варианты: "application/json" и "application/xml"
 * Другие можно добавить, подключив дополнительные библиотеки.
 */
@Path("/design")
@Component
public class DesignHandler {

    private final DesignRepository designRepository;

    @Autowired
    public DesignHandler(DesignRepository designRepository) {
        this.designRepository = designRepository;
    }

    @Path("/")
    @POST
    public DesignDto add(@RequestBody DesignCreateDto createDesign) {
        Objects.requireNonNull(createDesign, "empty request body");
        final Design receivedDesign = convert(createDesign);
        final Design addedDesign = designRepository.save(receivedDesign);
        return convert(addedDesign);
    }

    @Path("/")
    @GET
    public List<DesignDto> list() {
        return designRepository.findAll().stream()
                .map(this::convert)
                .collect(Collectors.toList());
    }

    @Path("/{id}")
    @PUT
    public DesignDto update(@PathParam("id") int id, @RequestBody DesignCreateDto designCreateDto) {
        final Design designToUpdate = designRepository.findOne(id);
        if (designToUpdate == null) {
            // надо возвращать 404, если нет такого ресурса
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
        designToUpdate.setName(designCreateDto.getName());
        designToUpdate.setComment(designCreateDto.getComment());
        return convert(designRepository.save(designToUpdate));
    }

    @Path("/{id}")
    @GET
    public DesignDto get(@PathParam("id") int id) {
        final Design design = designRepository.findOne(id);
        if (design == null) {
            // надо возвращать 404, если нет такого ресурса
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
        return convert(design);
    }

    @Path("/{id}")
    @DELETE
    public void delete(@PathParam("id") int id) {
        try {
            designRepository.delete(id);
        } catch (EmptyResultDataAccessException e) {
            // надо возвращать 404, если нет такого ресурса
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
    }

    private DesignDto convert(Design design) {
        return new DesignDto(design.getId(), design.getName(), design.getComment());
    }

    private Design convert(DesignCreateDto designDto) {
        return new Design(designDto.getName(), designDto.getComment());
    }

}
