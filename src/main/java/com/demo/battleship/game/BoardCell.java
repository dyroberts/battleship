package com.demo.battleship.game;

import java.util.Optional;

public class BoardCell {
    private Optional<Ship> ship = Optional.empty();

    public BoardCell() {}

    public BoardCell(Ship ship) {
        this.ship = Optional.ofNullable(ship);
    }

    public Boolean hasShip() {
        return ship.isPresent();
    }

    public Optional<Ship> getShip() {
        return ship;
    }
}
