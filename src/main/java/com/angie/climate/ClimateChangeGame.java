package com.angie.climate;

import javax.swing.*;

public class ClimateChangeGame {

    public static void main(String[] arg) {
        final GameScreenState gameScreen = new GameScreenState();
        final ClimateScenario scenario = new ClimateScenario(500, 690, 450, 1300,
                60, 60, 30, 20, 50, 80, 30, 40, 90, 30);
        final GameScreenController gameController = new GameScreenController(gameScreen, scenario);

        gameController.initListeners();
        gameController.setDefaults();

        final JFrame frame = new JFrame("Climate Change Game");
        frame.setContentPane(gameScreen.getMainPanel());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
