package com.angie.climate;

/* brainstorm ideas
Games can help inspire curiosity, optimism, and problem-solving, which are crucial in the collective impact to address
 climate change.

Our game engages players in exploring and creating scenarios of how climate change can impact different aspect of life,
including CO2 emission, rainwater/precipitation, temperature/heatwaves. Through the game, players can explore potential climate
changed futures. More importantly, how players can reduce carbon footprint by making informed choices and taking actions.

factors:
cars, trains, bikes
factories/industries plants, offices


Final improving ideas: Collaborate with climate change organizations: Partner with climate change organizations and
experts to ensure the accuracy and relevance of the information presented in the game. This could also help to
increase the reach and impact of the game by leveraging the networks of these organizations.
*/

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class ClimateChangeGame {

    public static void main(String[] arg) {
        final GameScreenState gameScreen = new GameScreenState();
        final JFrame frame = new JFrame("Climate Change Game");
        frame.setContentPane(gameScreen.getMainPanel());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // add a change listener to the slider about home energy - electricity usage
        gameScreen.getOilSlider().addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                JSlider source = (JSlider) e.getSource();
                if (!source.getValueIsAdjusting()) {
                    int oilValue = source.getValue();
                    gameScreen.getOilLabel().setText(String.valueOf(oilValue));
                    // do something with the new value, e.g. update a variable or call a method
                }
                //moneyCalculator(homeEnergyAmountOfElectricity);
            }
        });

        frame.pack();
        frame.setVisible(true);
    }

    public void moneyCalculator() {
        double money = 1000;
    }

    public void carbonCalculator() {

    }
}
