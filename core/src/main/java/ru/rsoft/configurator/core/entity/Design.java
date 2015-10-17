package ru.rsoft.configurator.core.entity;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.persistence.*;
import java.util.Objects;

/**
 * Чертеж. Может содержать несколько шкафов.
 * <p/>
 * <b>ВНИМАНИЕ!</b>
 * <p/>
 * Хоть и возникает такой соблазн, не стоит делать список шкафов в этой сущности,
 * так как это сильно запутает код и приведет к проблемам с синхронизацией.
 * Такой список нужно доставать из репозитория шкафов по ID чертежа.
 */
@Entity
@Table(name = "DESIGNS")
public class Design {

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

    private Design() {
        this("", null);
    }

    public Design(@Nonnull String name, @Nullable String comment) {
        this.name = Objects.requireNonNull(name, "name for a design must not be null");
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

    public void setName(@Nonnull String name) {
        this.name = name;
    }

    public void setComment(@Nullable String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "Design{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", comment='" + comment + '\'' +
                '}';
    }
}
