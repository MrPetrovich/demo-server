package ru.example.demoserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.example.demoserver.domain.Cell;

@Repository
public interface CellRepository extends JpaRepository<Cell, Integer> {
}
