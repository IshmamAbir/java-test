package com.example.bs23test.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private String location;
}
