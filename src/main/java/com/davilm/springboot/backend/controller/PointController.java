package com.davilm.springboot.backend.controller;

import com.davilm.springboot.backend.model.Point;
import com.davilm.springboot.backend.repository.PointRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class PointController {

    @Autowired
    private PointRepository pointRepository;

    //get all employees
    @GetMapping("/points")
    public List<Point> getAllEmployees() {
        return pointRepository.findAll();
    }


}
