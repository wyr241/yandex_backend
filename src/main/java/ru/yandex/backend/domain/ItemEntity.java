package ru.yandex.backend.domain;



import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "item")
@Data
@NoArgsConstructor
public class ItemEntity {
    @Id
    private String id;

    @Column(name = "url")
    private String url;

    @Enumerated(EnumType.STRING)
    @Column(name = "type", nullable = false)
    private NodeType type;

    @ManyToOne
    @JoinColumn(name = "parent_id")
    private ItemEntity parent;

    @Column(name = "update_date", nullable = false)
    private LocalDateTime update_date;

    @Column(name = "size")
    private Integer size;
}
