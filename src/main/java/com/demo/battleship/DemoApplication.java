package com.demo.battleship;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
public class DemoApplication {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(DemoApplication.class);

//        BattleshipGame game = context.getBean(BattleshipGame.class);
//
//        game.fire(Integer.valueOf(args[0]), Integer.valueOf(args[1]));
    }
}


