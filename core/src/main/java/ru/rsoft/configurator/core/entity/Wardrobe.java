package ru.rsoft.configurator.core.entity;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.persistence.*;
import java.util.Objects;

/**
 * Шкаф. Обязательно имеет один чертеж, может иметь один корпус.
 * <p/>
 * Стоит обратить внимание на элементы контрактного программирования --
 * аннотации @Nullable и @Nonnull (JSR-305).
 * <p/>
 * Эти аннотации позволяют с помощью статистического анализа
 * (читай IDEA, Eclipse, FindBugs) обнаруживать проблемы, связанные с разыменовыванием
 * null-указателей.
 * <p/>
 * Для чего это нужно? Например, Ide будет давать подсказки к коду, который пытается
 * передать null в параметр, его не принимающий или проверять на null возвращаемое значение,
 * которое не может быть null по определению.
 * <p/>
 * В качестве альтернативы, можно воспользоваться фреймворком Checkers, как это предлагает Oracle,
 * но на данном этапе нахожу это избыточным, поскольку нужно лишь две аннотации, а не целый фреймворк.
 */
@Entity
@Table(name = "WARDROBES")
public class Wardrobe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    @ManyToOne
    @JoinColumn(name = "DESIGN_ID", nullable = false)
    @Nonnull
    private Design design;

    @ManyToOne
    @JoinColumn(name = "BODY_ID", nullable = true)
    @Nullable
    private WardrobeBody body;

    @Column(name = "COMMENT", nullable = true)
    private String comment;

    private Wardrobe() {
        this(new Design("", null), null, null);
    }

    public Wardrobe(@Nonnull Design design, @Nullable WardrobeBody body, @Nullable String comment) {
        this.design = Objects.requireNonNull(design, "design for a wardrobe must not be null");
        this.body = body;
        this.comment = comment;
    }

    public int getId() {
        return id;
    }

    @Nonnull
    public Design getDesign() {
        return design;
    }

    @Nullable
    public WardrobeBody getBody() {
        return body;
    }

    @Nullable
    public String getComment() {
        return comment;
    }


    @Override
    public String toString() {
        return "Wardrobe{" +
                "id=" + id +
                ", design=" + design +
                ", comment=" + comment +
                '}';
    }
}
