package com.energy.energy.api.models.entities;

import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "Box", schema = "Energy")
@Data
public class Box {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Integer packNumber;

    @Column(length = 20, nullable = false)
    private String productionOrder;

    @Column(nullable = false)
    private Integer palletNumber;

    @Column(nullable = false)
    private Integer boxNumber;

    @Column(nullable = false)
    private Integer quantityMetersInBox;

    @Column(precision = 18, scale = 3, nullable = false)
    private BigDecimal boxWeight;

    @Column(nullable = false)
    private Boolean closed;

    @Column(nullable = false)
    private Boolean printed;

    @Column(length = 50)
    private String closedByUserName;

    @Column(length = 50, nullable = false)
    private String userCreate;

    @Column(length = 50, nullable = false)
    private String userEdit;

    @Column(nullable = false)
    private LocalDateTime dateCreate;

    @Column(nullable = false)
    private LocalDateTime dateEdit;

    @OneToMany(mappedBy = "box", fetch = FetchType.LAZY)
    private List<Meter> boxMeters;
}