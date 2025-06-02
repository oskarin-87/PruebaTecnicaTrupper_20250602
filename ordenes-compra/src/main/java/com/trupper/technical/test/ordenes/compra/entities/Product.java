package com.trupper.technical.test.ordenes.compra.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="products")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private Long orderId;

    @Column(nullable = false)
    private String code;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private Double price;
}
