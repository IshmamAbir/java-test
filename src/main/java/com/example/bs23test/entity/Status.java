package com.example.bs23test.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Status {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long statusId;

    @Column
    private String status;
    @Column
    private String location;
    @Column
    private boolean publicStatus=false;
}
