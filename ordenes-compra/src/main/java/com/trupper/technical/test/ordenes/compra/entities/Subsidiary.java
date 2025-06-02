package com.trupper.technical.test.ordenes.compra.entities;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "subsidiary")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Subsidiary {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Integer id;

    @Column(nullable = false)
    private String name;
}
