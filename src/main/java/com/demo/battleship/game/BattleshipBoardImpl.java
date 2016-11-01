package com.demo.battleship.game;

import java.util.ArrayList;
import java.util.List;

public class BattleshipBoardImpl implements BattleshipBoard {
    private final List<Ship> ships;
    private final List<List<BoardCell>> board;

    public BattleshipBoardImpl(List<Ship> ships, Integer boardSize) {
        this.ships = ships;
        this.board = buildBoard(boardSize, ships);
    }

    private List<List<BoardCell>> buildBoard(Integer boardSize, List<Ship> ships) {
        List<List<BoardCell>> newBoard = emptyBoard(boardSize);

        addShipsToBoard(ships, newBoard);

        return newBoard;
    }

    private void addShipsToBoard(List<Ship> ships, List<List<BoardCell>> newBoard) {
        for (int i = 0; i < ships.size(); i++) {
            Ship ship = ships.get(i);

            for (int j = 0; j < ship.getSize(); j++) {
                newBoard.get(i).remove(j);
                newBoard.get(i).add(j, new BoardCell(ship));
            }
        }
    }

    private List<List<BoardCell>> emptyBoard(Integer boardSize) {
        List<List<BoardCell>> newBoard = new ArrayList<>();
        for (int i = 0; i < boardSize; i++) {
            newBoard.add(new ArrayList<>());
            for (int j = 0; j < boardSize; j++) {
                newBoard.get(i).add(new BoardCell());
            }
        }
        return newBoard;
    }

    @Override
    public List<Ship> getShips() {
        return ships;
    }

    @Override
    public List<List<BoardCell>> getBoard() {
        return board;
    }

}
