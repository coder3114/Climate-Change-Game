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

TODO
- show carbon footprint score
- error message if any of the targets are not met
- set volume results into RED if not meet target
- finalise the default to make sense


TODO
initialization
 - set real values for each factor in enum
 - set target values for all factor types
 - work out how to calculate carbon footprint WITH the trigger of the bottom

TODO
initialization
- set the value of the sliders in it's own method
        According to the Energy Trends: UK electricity report by the Department for Business, Energy & Industrial Strategy1, the UK used different sources to generate electricity in 2020. The main sources were:
            Gas: 36.2%
            Renewables: 43.1%
            Nuclear: 16.1%
            Coal: 1.8%
            Other fuels: 2.8%
            Renewables include wind, solar, hydro and bioenergy. The share of renewables increased by 6.5 percentage points from 2019, mainly due to increased wind generation1.

- set each target
- set money

set logic for slider changes
- show the real time value
- implement an enum to store name, unit price, coefficient, type for each type of energy
- re-calculate total energy using a common method with enum as parameter

input
parameter, argument
variable
method
class, object, type
instance
*/

import javax.swing.*;

public class ClimateChangeGame {

    public static void main(String[] arg) {
        final GameScreenState gameScreen = new GameScreenState();
        final ClimateScenario scenario = new ClimateScenario(500, 700, 450, 1000,
                30, 30, 10, 40, 40, 60, 20, 10, 50, 30);
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
