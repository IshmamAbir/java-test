package com.example.bs23test.service;

import com.example.bs23test.Repository.StatusRepository;
import com.example.bs23test.dto.StatusDto;
import com.example.bs23test.entity.Status;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class StatusService {
    @Autowired
    private StatusRepository statusRepository;

    public List<StatusDto> getAllPublicStatus(){
        List<Status> statusList=statusRepository.findAllByPublicStatusTrue();
        List<StatusDto> statusDtoList=convertToStatusDto(statusList);
        return statusDtoList;
    }

    public List<StatusDto> getAllPrivateStatus(){
        List<Status> statusList=statusRepository.findAllByPublicStatusFalse();
        List<StatusDto> statusDtoList=convertToStatusDto(statusList);
        return statusDtoList;
    }


    // ----------- Helper -----------

    public List<StatusDto> convertToStatusDto(List<Status> statusList){
        List<StatusDto> statusDtoList=new ArrayList<>();
        for (Status status:statusList) {
            StatusDto statusDto=new StatusDto();
            BeanUtils.copyProperties(status,statusDto);
            statusDtoList.add(statusDto);
        }
        return statusDtoList;
    }

}
