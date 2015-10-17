package ru.rsoft.configurator.core.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class DesignDto {

    private final int id;
    @Nonnull
    private final String name;
    @Nullable
    private final String comment;

    public DesignDto() {
        this(0, "", null);
    }

    public DesignDto(int id, @Nonnull String name, @Nullable String comment) {
        this.id = id;
        this.name = name;
        this.comment = comment;
    }

    public int getId() {
        return id;
    }

    @Nonnull
    public String getName() {
        return name;
    }

    @Nullable
    public String getComment() {
        return comment;
    }

    @Override
    public String toString() {
        return "DesignDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", comment='" + comment + '\'' +
                '}';
    }
}
