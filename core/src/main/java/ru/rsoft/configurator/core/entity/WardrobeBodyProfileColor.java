package ru.rsoft.configurator.core.entity;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.persistence.*;
import java.util.Objects;

/**
 *
 */
@Entity
@Table(name = "WARDROBE_BODY_PROFILE_COLOR")
public class WardrobeBodyProfileColor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "COMMENT", nullable = true)
    private String comment;

    private WardrobeBodyProfileColor() {
        this("", null);
    }

    public WardrobeBodyProfileColor(@Nonnull String name, @Nullable String comment) {
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
        return "WardrobeBodyProfileColor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", comment='" + comment + '\'' +
                '}';
    }
}
