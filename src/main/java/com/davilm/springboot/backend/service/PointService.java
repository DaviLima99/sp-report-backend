package com.davilm.springboot.backend.service;
import java.util.List;
import java.util.Optional;

import com.davilm.springboot.backend.exception.ObjectNotFoundException;
import com.davilm.springboot.backend.model.Point;
import com.davilm.springboot.backend.repository.PointRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Transactional
    public Point update(Point point) {
        Point objNew = this.findExists(point.getId());
        objNew.setTitle(point.getTitle());
        objNew.setDescription(point.getDescription());
        objNew.setImage(point.getImage());

        return repository.save(objNew);
    }

    private Point findExists(long id) throws ObjectNotFoundException {
        Optional<Point> pointExited = repository.findById(id);
        return pointExited.orElseThrow(() -> new ObjectNotFoundException(
                "Ponto não encontrado! Id:" + id
        ));
    }




}
