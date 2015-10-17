package ru.rsoft.configurator.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.rsoft.configurator.core.entity.Design;

/**
 * Интерфейс репозитоия чертежей.
 * Общий CRUD (create, read, update, delete), обеспечиваемый стандартным JpaRepository.
 *
 */
public interface DesignRepository extends JpaRepository<Design, Integer> {
}
