package ru.rsoft.configurator.core.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.annotation.Nullable;

/**
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class WardrobeDto {
    private final int id;
    private final int designId;
    @Nullable
    private final Integer bodyId;
    @Nullable
    private final String comment;

    public WardrobeDto() {
        this(0, 0, 0, null);
    }

    public WardrobeDto(int id, int designId, @Nullable Integer bodyId,
            @Nullable String comment) {
        this.id = id;
        this.designId = designId;
        this.bodyId = bodyId;
        this.comment = comment;
    }

    public int getId() {
        return id;
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
        return "WardrobeDto{" +
                "id=" + id +
                ", designId=" + designId +
                ", bodyId=" + bodyId +
                ", comment='" + comment + '\'' +
                '}';
    }
}
