package ru.rsoft.configurator.core.entity;

import javax.annotation.Nullable;
import javax.persistence.*;

/**
 * Копус шкафа. Имеет тип, профиль, ширину, высоту и глубину.
 */
@Entity
@Table(name = "WARDROBE_BODIES")
public class WardrobeBody {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;
    @ManyToOne
    @JoinColumn(name = "TYPE_ID", nullable = true)
    @Nullable
    private WardrobeBodyType type;
    @ManyToOne
    @JoinColumn(name = "PROFILE_ID", nullable = true)
    @Nullable
    private WardrobeBodyProfile profile;
    @Column(name = "WIDTH", nullable = false)
    private int width;
    @Column(name = "HEIGHT", nullable = false)
    private int height;
    @Column(name = "DEPTH", nullable = false)
    private int depth;

    private WardrobeBody() {
        this(null, null, 0, 0, 0);
    }

    public WardrobeBody(@Nullable WardrobeBodyType type, @Nullable WardrobeBodyProfile profile, int width, int height,
            int depth) {
        this.type = type;
        this.profile = profile;
        this.width = width;
        this.height = height;
        this.depth = depth;
    }

    public int getId() {
        return id;
    }

    @Nullable
    public WardrobeBodyType getType() {
        return type;
    }

    @Nullable
    public WardrobeBodyProfile getProfile() {
        return profile;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getDepth() {
        return depth;
    }

    @Override
    public String toString() {
        return "WardrobeBody{" +
                "id=" + id +
                ", type=" + type +
                ", profile=" + profile +
                ", width=" + width +
                ", height=" + height +
                ", depth=" + depth +
                '}';
    }
}