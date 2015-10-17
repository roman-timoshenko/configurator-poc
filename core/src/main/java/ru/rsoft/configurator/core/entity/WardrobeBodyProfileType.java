package ru.rsoft.configurator.core.entity;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.persistence.*;
import java.util.Objects;

/**
 *
 */
@Entity
@Table(name = "WARDROBE_BODY_PROFILE_TYPE")
public class WardrobeBodyProfileType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    @Column(name = "NAME", nullable = false)
    @Nonnull
    private String name;

    @Column(name = "COMMENT", nullable = true)
    @Nullable
    private String comment;

    private WardrobeBodyProfileType() {
        this("", null);
    }

    public WardrobeBodyProfileType(@Nonnull String name, @Nullable String comment) {
        this.name = Objects.requireNonNull(name, "name for a wardrobe body profile color must not be null");
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
        return "WardrobeBodyProfileType{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", comment='" + comment + '\'' +
                '}';
    }
}
