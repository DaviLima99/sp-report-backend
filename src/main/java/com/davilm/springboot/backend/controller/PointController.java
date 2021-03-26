package com.davilm.springboot.backend.controller;

import com.davilm.springboot.backend.model.Point;
import com.davilm.springboot.backend.repository.PointRepository;
import org.apache.coyote.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class PointController {

    private static final Logger logger = LogManager.getLogger(PointController.class);

    @Autowired
    private PointRepository pointRepository;

    //get all points
    @GetMapping("/points")
    public List<Point> all() {
        return pointRepository.findAll();
    }

    //create point
    @PostMapping("/points")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Point> create(@Valid @RequestBody Point point) {
        logger.info("Creating new point for report system id: {}, {}", point.getId(), point);
        try {
            Point newPoint = pointRepository.save(point);

            return ResponseEntity
                    .created(new URI("/points/" + newPoint.getId()))
                    .eTag(Long.toString(newPoint.getId()))
                    .body(newPoint);
        } catch (URISyntaxException error) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/points/{id}")
    public ResponseEntity<Point> update(@PathVariable Long id, @Valid @RequestBody Point point) {
        Optional<Point> pointExist =  pointRepository.findById(id);
    }
}
