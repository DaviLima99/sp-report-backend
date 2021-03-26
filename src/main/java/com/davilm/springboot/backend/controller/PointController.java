package com.davilm.springboot.backend.controller;

import com.davilm.springboot.backend.model.Point;
import com.davilm.springboot.backend.service.PointService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/api/v1/points")
public class PointController {

    @Autowired
    private PointService pointService;

    //get all points
    @GetMapping()
    public List<Point> all() {
        return pointService.findAll();
    }

    //create point
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Point> create(@Valid @RequestBody Point point) {
        try {
            Point newPoint = pointService.create(point);

            return ResponseEntity
                    .created(new URI("/points/" + newPoint.getId()))
                    .eTag(Long.toString(newPoint.getId()))
                    .body(newPoint);
        } catch (URISyntaxException error) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

//
//    @PutMapping("/points/{id}")
//    public ResponseEntity<Point> update(@PathVariable Long id, @Valid @RequestBody Point point) {
//        Optional<Point> pointExist =  pointRepository.findById(id);
//    }
}
