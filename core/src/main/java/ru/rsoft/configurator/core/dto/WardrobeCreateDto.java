package ru.rsoft.configurator.core.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.annotation.Nullable;

/**
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class WardrobeCreateDto {
    private final int designId;
    @Nullable
    private final Integer bodyId;
    @Nullable
    private final String comment;

    public WardrobeCreateDto() {
        this(0, 0, null);
    }

    public WardrobeCreateDto(int designId, @Nullable Integer bodyId,
                             @Nullable String comment) {
        this.designId = designId;
        this.bodyId = bodyId;
        this.comment = comment;
    }

    public int getDesignId() {
        return designId;
    }

    @Nullable
    public Integer getBodyId() {
        return bodyId;
    }

    @Nullable
    public String getComment() {
        return comment;
    }

    @Override
    public String toString() {
        return "WardrobeCreateDto{" +
                "designId=" + designId +
                ", bodyId=" + bodyId +
                ", comment='" + comment + '\'' +
                '}';
    }
}
