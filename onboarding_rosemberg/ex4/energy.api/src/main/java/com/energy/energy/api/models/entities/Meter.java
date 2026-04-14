package com.energy.energy.api.models.entities;

import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "BoxMeters", schema = "Energy")
@Data
public class Meter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "productionOrder", length = 20)
    private String productionOrder;

    @Column(name = "packNumber")
    private Integer packNumber;

    @Column(name = "boxNumber")
    private Integer boxNumber;

    @Column(name = "eletraNumber", length = 20)
    private String eletraNumber;

    @Column(name = "clientNumber", length = 20)
    private String clientNumber;

    @Column(name = "meterWeight", precision = 18, scale = 3)
    private BigDecimal meterWeight;

    @Column(name = "meterBoxWeight", precision = 18, scale = 3)
    private BigDecimal meterBoxWeight;

    @Column(name = "dateCreate")
    private LocalDateTime dateCreate;

    @Column(name = "dateEdit")
    private LocalDateTime dateEdit;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "boxId")
    private Box box;
}