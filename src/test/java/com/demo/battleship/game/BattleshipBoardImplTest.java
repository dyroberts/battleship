package com.demo.battleship.game;

import com.demo.battleship.DemoApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;
import java.util.Set;

import static java.util.stream.Collectors.toSet;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = DemoApplication.class)
public class BattleshipBoardImplTest {

    @Autowired
    private BattleshipBoard playerBoard;

    @Test
    public void shouldStartGameWithFiveShips() {

        assertThat(playerBoard.getShips()).containsExactlyInAnyOrder(
                new Ship("carrier", 5),
                new Ship("battleship", 4),
                new Ship("submarine", 3),
                new Ship("destroyer", 3),
                new Ship("cruiser", 2));
        assertThat(playerBoard.getShips().stream().noneMatch(ship -> ship.getDamage() > 0)).isTrue();
    }

    @Test
    public void shouldStartGameWithAllShipsOnTheBoard() {

        assertThat(playerBoard.getBoard()).hasSize(10);
        assertThat(playerBoard.getBoard()).hasSize(10);
        assertThat(getAllShipsOnBoard(playerBoard)).containsExactlyInAnyOrder(
                new Ship("carrier", 5),
                new Ship("battleship", 4),
                new Ship("submarine", 3),
                new Ship("destroyer", 3),
                new Ship("cruiser", 2));
    }

    private Set<Ship> getAllShipsOnBoard(BattleshipBoard board) {
        return board.getBoard().stream()
                .flatMap(row -> row.stream())
                .map(BoardCell::getShip)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(toSet());
    }
}
