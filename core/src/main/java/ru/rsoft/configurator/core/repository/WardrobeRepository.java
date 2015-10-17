package ru.rsoft.configurator.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.rsoft.configurator.core.entity.Wardrobe;

import java.util.Set;

/**
 *
 */
public interface WardrobeRepository extends JpaRepository<Wardrobe, Integer> {
    /**
     * Очень интересный функционал в Spring JPA.
     * По имени метода и параметрам составляется запрос, который будет выполнен.
     *
     *
     * То есть, достаточно метода с определённым именем, чтобы Spring сам создал
     * простой(!) запрос в базу при его вызове.
     *
     * Подробности тут:
     * http://docs.spring.io/spring-data/jpa/docs/1.9.0.RELEASE/reference/html/#jpa.query-methods.query-creation
     */
    Set<Wardrobe> findByDesignId(int designId);
}
