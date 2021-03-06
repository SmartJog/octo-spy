package com.octo.model.dto.common;

import com.cji.utils.predicate.filter.FilterType;
import com.cji.utils.predicate.filter.FilterType.Type;
import com.cji.utils.predicate.filter.QueryFilter;

/**
 * DTO to search entity by name.
 */
public class SearchByNameDTO extends QueryFilter {
    /**
     * Entity's name.
     */
    @FilterType(type = Type.TEXT)
    private String name;

    /**
     * Construct search dto.
     *
     * @param name
     *            Name.
     */
    public SearchByNameDTO(final String name) {
        setName(name);
    }

    /**
     * Get entity's name.
     *
     * @return Entity's name.
     */
    public String getName() {
        return name;
    }

    /**
     * Set entity's name.
     *
     * @param name
     *            Entity's name.
     */
    public void setName(final String name) {
        this.name = name;
    }
}
