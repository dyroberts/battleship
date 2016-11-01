package com.demo.battleship;

import com.demo.battleship.game.BattleshipBoard;
import com.demo.battleship.game.BattleshipBoardImpl;
import com.demo.battleship.game.Ship;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.util.List;

import static java.util.Arrays.asList;

@Configuration
public class DemoConfiguration {

    private static final Integer BOARD_SIZE = 10;

    @Bean
    @Scope("prototype")
    public BattleshipBoard playerBoard() {
        return new BattleshipBoardImpl(ships(), BOARD_SIZE);
    }

    @Bean
    @Scope("prototype")
    public BattleshipBoard enemyBoard() {
        return new BattleshipBoardImpl(ships(), BOARD_SIZE);
    }

    @Bean
    @Scope("prototype")
    public List<Ship> ships() {
        return asList(
                new Ship("carrier", 5),
                new Ship("battleship", 4),
                new Ship("submarine", 3),
                new Ship("destroyer", 3),
                new Ship("cruiser", 2));
    }
}
