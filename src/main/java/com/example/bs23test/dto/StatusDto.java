package com.example.bs23test.dto;

import lombok.Data;

@Data
public class StatusDto {
    private long statusId;
    private String status;
    private String location;
    private boolean publicStatus=false;
}
