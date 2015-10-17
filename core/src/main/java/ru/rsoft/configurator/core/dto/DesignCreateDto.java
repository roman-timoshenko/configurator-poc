package ru.rsoft.configurator.core.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Objects;

/**
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class DesignCreateDto {
    @Nonnull
    private final String name;
    @Nullable
    private final String comment;

    public DesignCreateDto() {
        this("", null);
    }

    public DesignCreateDto(@Nonnull String name, @Nullable String comment) {
        this.name = Objects.requireNonNull(name, "name should not be null");
        this.comment = comment;
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
        return "CreateDesignDto{" +
                "name='" + name + '\'' +
                ", comment='" + comment + '\'' +
                '}';
    }
}
