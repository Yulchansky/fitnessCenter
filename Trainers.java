package com.fitness.model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity

public class Trainers {
    @Setter(AccessLevel.NONE)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;

    private String name;
    private String file;
    private String producer;
    private String country;
    private String muscle;
    private int optimal;
    private int max;

    public Trainers(String name, String file, String producer, String country, String muscle, int optimal, int max) {
        this.name = name;
        this.file = file;
        this.producer = producer;
        this.country = country;
        this.muscle = muscle;
        this.optimal = optimal;
        this.max = max;
    }
}
