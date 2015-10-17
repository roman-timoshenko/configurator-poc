package ru.rsoft.configurator.backend.handlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import ru.rsoft.configurator.core.dto.WardrobeCreateDto;
import ru.rsoft.configurator.core.dto.WardrobeDto;
import ru.rsoft.configurator.core.entity.Design;
import ru.rsoft.configurator.core.entity.Wardrobe;
import ru.rsoft.configurator.core.entity.WardrobeBody;
import ru.rsoft.configurator.core.repository.DesignRepository;
import ru.rsoft.configurator.core.repository.WardrobeBodyRepository;
import ru.rsoft.configurator.core.repository.WardrobeRepository;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 */
@Component
@Path("/wardrobe")
public class WardrobeHandler {

    private final DesignRepository designRepository;
    private final WardrobeRepository wardrobeRepository;
    private final WardrobeBodyRepository wardrobeBodyRepository;

    @Autowired
    public WardrobeHandler(DesignRepository designRepository, WardrobeRepository wardrobeRepository, WardrobeBodyRepository wardrobeBodyRepository) {
        this.designRepository = designRepository;
        this.wardrobeRepository = wardrobeRepository;
        this.wardrobeBodyRepository = wardrobeBodyRepository;
    }

    @Path("/")
    @GET
    public List<WardrobeDto> list() {
        return wardrobeRepository.findAll().stream().map(this::convert)
                .collect(Collectors.toList());
    }

    @Path("/{id}")
    @GET
    public WardrobeDto get(@PathParam("id") int id) {
        return convert(requireNotNull(wardrobeRepository.findOne(id)));
    }

    @Path("/")
    @POST
    public WardrobeDto add(@RequestBody WardrobeCreateDto wardrobeCreateDto) {
        return convert(wardrobeRepository.save(convert(wardrobeCreateDto)));
    }

    private <T> T requireNotNull(T object) {
        if (object == null) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
        return object;
    }

    private WardrobeDto convert(Wardrobe wardrobe) {
        return new WardrobeDto(
                wardrobe.getId(),
                wardrobe.getDesign().getId(),
                wardrobe.getBody() == null ? null : wardrobe.getBody().getId(),
                wardrobe.getComment()
        );
    }
    private Wardrobe convert(WardrobeCreateDto wardrobeCreateDto) {
        final Design design = requireNotNull(designRepository.findOne(wardrobeCreateDto.getDesignId()));
        final WardrobeBody wardrobeBody =  wardrobeCreateDto.getBodyId() == null ? null :
                requireNotNull(wardrobeBodyRepository.findOne(wardrobeCreateDto.getBodyId()));
        return new Wardrobe(
                design,
                wardrobeBody,
                wardrobeCreateDto.getComment()
        );
    }
}
