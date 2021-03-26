package com.davilm.springboot.backend.service;
import java.util.List;
import com.davilm.springboot.backend.model.Point;
import com.davilm.springboot.backend.repository.PointRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PointService {

    @Autowired
    private PointRepository repository;

    public List<Point> findAll() {
        return repository.findAll();
    }

    public Point create(Point point) {
        point.setOpen(true);
        point = repository.save(point);
        return point;
    }



}
