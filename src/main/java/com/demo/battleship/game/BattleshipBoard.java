package com.demo.battleship.game;

import java.util.List;

public interface BattleshipBoard {
    List<Ship> getShips();

    List<List<BoardCell>> getBoard();
}
