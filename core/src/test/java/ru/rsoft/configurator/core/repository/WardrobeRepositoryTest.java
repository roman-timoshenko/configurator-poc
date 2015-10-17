package ru.rsoft.configurator.core.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ru.rsoft.configurator.core.entity.Design;
import ru.rsoft.configurator.core.entity.Wardrobe;

import java.util.Set;
import java.util.UUID;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-test-context.xml"})
public class WardrobeRepositoryTest {

    @Autowired
    private WardrobeRepository wardrobeRepository;
    @Autowired
    private DesignRepository designRepository;

    @Test
    public void testFindByDesignId() throws Exception {
        final String uniqueDesignName = "designName_" + UUID.randomUUID().toString();
        final String uniqueDesignComment = "designComment_" + UUID.randomUUID().toString();
        final Design design = designRepository.save(new Design(uniqueDesignName, uniqueDesignComment));
        final String uniqueWardrobeComment = "wardrobeComment_" + UUID.randomUUID().toString();

        final Wardrobe wardrobeCreated = wardrobeRepository.save(new Wardrobe(design, null, uniqueWardrobeComment));
        final Set<Wardrobe> wardrobesFound = wardrobeRepository.findByDesignId(design.getId());
        assertEquals("number of wardrobes found should be exactly one", 1, wardrobesFound.size());
        final Wardrobe wardrobeFound = wardrobesFound.iterator().next();
        assertEquals("found wardrobe design should be the design wardrobe was created with",
                design.getId(), wardrobeFound.getDesign().getId());
        assertEquals("found wardrobe comment should be the comment wardrobe was created with",
                wardrobeCreated.getComment(), wardrobeFound.getComment());
    }
}