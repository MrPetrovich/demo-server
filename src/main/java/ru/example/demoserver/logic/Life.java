package ru.example.demoserver.logic;

import org.springframework.stereotype.Component;
import ru.example.demoserver.domain.Cell;

import java.util.HashSet;


public class Life {

    private static final int CELL_SIZE = 10;
    private static final int LIFE_AREA = 500;
    private HashSet<Cell> listOfCells = new HashSet<Cell>();
    private HashSet<Cell> bufferedListOfCells = new HashSet<Cell>();

    //Создаем множество, состоящее из живых клеток
    public void setInitialState() {
        for(int x = 0; x < LIFE_AREA; x += CELL_SIZE) {
            for(int y = 0; y < LIFE_AREA; y += CELL_SIZE) {
                int temp = (int) (Math.random() * 4);
                if (temp == 0) {
                    listOfCells.add(new Cell(x, y));
                }
            }
        }
    }

    public void runProcess() {
            runLife();
    }

    public HashSet<Cell> getListOfCells(){
        return listOfCells;
    }


    //Запускаем жизнь
    private void runLife() {
        for(Cell tempCell: listOfCells) {
            buildListOfAliveCells(tempCell, listOfCells);
        }
        listOfCells.clear();
        listOfCells.addAll(bufferedListOfCells);
        bufferedListOfCells.clear();
        try {
            Thread.sleep(100);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    //Создаем новое множество живых клеток, на основе старого
    private void buildListOfAliveCells(Cell aCell, HashSet<Cell> cellSet) {
        int x = aCell.getX();
        int y = aCell.getY();
        for(int i = x - CELL_SIZE; i < x + 2 * CELL_SIZE; i+= CELL_SIZE) {
            for(int j = y - CELL_SIZE; j < y + 2 * CELL_SIZE; j+= CELL_SIZE) {
                Cell blankCell= new Cell(i, j);
                if (!(cellSet.contains(blankCell)) && (numberOfNeighbors(blankCell) == 3)) {
                    bufferedListOfCells.add(blankCell);
                } else if ((i == x && j == y) && (numberOfNeighbors(blankCell) == 2 || numberOfNeighbors(blankCell) ==3)) {
                    bufferedListOfCells.add(blankCell);
                }

            }
        }
    }

    //Считаем количество живых клеток вокруг данной клетки
    private int numberOfNeighbors(Cell aCell) {
        int x = aCell.getX();
        int y = aCell.getY();
        int counter = 0;
        for(int i = x - CELL_SIZE; i < x + 2 * CELL_SIZE; i += CELL_SIZE) {
            for(int j = y- CELL_SIZE; j < y + 2 * CELL_SIZE; j += CELL_SIZE) {
                Cell tempCell = new Cell(i, j);
                if (listOfCells.contains(tempCell)) {
                    if (!(i == x && j == y)) { counter++; }
                }
            }
        }
        return counter;
    }


}