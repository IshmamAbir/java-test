package com.example.bs23test.service;

import com.example.bs23test.Repository.LocationRepository;
import com.example.bs23test.dto.LocationDto;
import com.example.bs23test.entity.Location;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LocationService {
    private LocationRepository locationRepository;
    public List<LocationDto> getAllLocation(){
        List<Location> locationList=locationRepository.findAll();
        List<LocationDto> locationDtoList=new ArrayList<>();
        for (Location location:locationList) {
            LocationDto locationDto=new LocationDto();
            BeanUtils.copyProperties(location,locationDto);
            locationDtoList.add(locationDto);
        }
        return locationDtoList;
    }
}
