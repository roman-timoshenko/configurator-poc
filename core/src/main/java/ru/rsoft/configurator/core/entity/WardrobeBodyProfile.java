package ru.rsoft.configurator.core.entity;

import javax.annotation.Nullable;
import javax.persistence.*;

/**
 *
 */
@Entity
@Table(name = "WARDROBE_BODY_PROFILES")
public class WardrobeBodyProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;
    @ManyToOne
    @JoinColumn(name = "TYPE_ID", nullable = true)
    @Nullable
    private WardrobeBodyProfileType type;
    @ManyToOne
    @JoinColumn(name = "COLOR_ID", nullable = true)
    @Nullable
    private WardrobeBodyProfileColor color;
    @Column(name = "COMMENT", nullable = true)
    @Nullable
    private String comment;

    private WardrobeBodyProfile() {
        this(null, null, null);
    }

    public WardrobeBodyProfile(@Nullable WardrobeBodyProfileType type, @Nullable WardrobeBodyProfileColor color,
            @Nullable String comment) {
        this.type = type;
        this.color = color;
        this.comment = comment;
    }

    public int getId() {
        return id;
    }

    @Nullable
    public WardrobeBodyProfileType getType() {
        return type;
    }

    @Nullable
    public WardrobeBodyProfileColor getColor() {
        return color;
    }

    @Nullable
    public String getComment() {
        return comment;
    }

    @Override
    public String toString() {
        return "WardrobeBodyProfile{" +
                "id=" + id +
                ", type=" + type +
                ", color=" + color +
                ", comment='" + comment + '\'' +
                '}';
    }
}
