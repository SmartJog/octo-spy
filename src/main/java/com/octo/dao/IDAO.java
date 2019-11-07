package com.octo.dao;

import java.util.List;
import java.util.function.BiFunction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.octo.model.dto.common.DefaultDTO;

/**
 * Default methods to access database.
 *
 * @param <T>
 *            Entity.
 * @param <Y>
 *            EntityDTO.
 *
 * @author vmoittie
 */
public interface IDAO<T, Y extends DefaultDTO> {

    /**
     * Get entity type.
     *
     * @return Entity type.
     */
    Class<T> getType();

    /**
     * Save entity in database.
     *
     * @param entity
     *            Entity to save
     * @return Entity with generated id.
     */
    T save(T entity);

    /**
     * Load entity by id.
     *
     * @param id
     *            Id of entity
     * @return Entity loaded
     */
    T loadById(Long id);

    /**
     * Load entity.
     *
     * @param predicate
     *            Predicate to filter entity.
     * @return Entity.
     * @throws OctoException
     *             On database error.
     */
    T load(BiFunction<CriteriaBuilder, Root<T>, Predicate> predicate) throws OctoException;

    /**
     * Get all entity.
     *
     * @return All entity.
     */
    List<T> findAll();
}
