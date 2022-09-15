package ru.yandex.backend.domain;



import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "nodes")
@Data
@NoArgsConstructor
public class NodeEntity {
    @Id
    private String id;

    @Column(name = "name", nullable = false)
    private String url;

    @Enumerated(EnumType.STRING)
    @Column(name = "type", nullable = false)
    private NodeType type;

    @Column(name = "parent_id")
    private String parentId;

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime date;

    @Column(name = "size")
    private Integer size;
}
