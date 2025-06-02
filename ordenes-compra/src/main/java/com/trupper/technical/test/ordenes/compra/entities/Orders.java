package com.trupper.technical.test.ordenes.compra.entities;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Table(name = "orders")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Integer id;

    @Column(nullable = false)
    private Long subsidiaryId;

    @Column(nullable = false)
    private String date;

    @Column(nullable = false)
    private Double total;
}
