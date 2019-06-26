package ru.example.demoserver.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.example.demoserver.domain.Cell;
import ru.example.demoserver.repository.CellRepository;

import java.util.List;

@RestController
public class CellController
{
    private final Logger logger = LoggerFactory.getLogger(CellController.class);

    private final CellRepository repository;

    public CellController(CellRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/life-cells")
    public List<Cell> getCells() {
        logger.info("Request has been performed");
        return repository.findAll();
    }


}
