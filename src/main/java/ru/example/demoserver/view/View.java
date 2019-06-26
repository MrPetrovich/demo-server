package ru.example.demoserver.view;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import ru.example.demoserver.domain.Cell;
import ru.example.demoserver.DemoServerApplication;
import ru.example.demoserver.logic.Life;
import ru.example.demoserver.repository.CellRepository;

import java.util.HashSet;


public class View {

    HashSet<Cell> listOfCells;
    Life life = new Life();
    private CellRepository cellRepository;

    public View() {
        ApplicationContext ctx = SpringApplication.run(DemoServerApplication.class);
        cellRepository = ctx.getBean(CellRepository.class);

    }

    public void start(){
        life.setInitialState();
        while(true) {
            life.runProcess();
            listOfCells = life.getListOfCells();
            cellRepository.deleteAll();
            cellRepository.saveAll(listOfCells);
        }
    }


}
