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
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class ClimateChangeGame {

    //Create a map to store and retrieve factors (act as Keys) and their associated Volume/Cost
    private static final Map<Factor, Double> s_factorVolumeMap = new HashMap<>();
    private static final Map<Factor, Integer> s_factorCostMap = new HashMap<>();

    public static void main(String[] arg) {
        final GameScreenState gameScreen = new GameScreenState();
        final JFrame frame = new JFrame("Climate Change Game");
        frame.setContentPane(gameScreen.getMainPanel());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // add a change listener to the oil slider
        gameScreen.getOilSlider().addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                JSlider source = (JSlider) e.getSource();
                if (!source.getValueIsAdjusting()) {
                    int oilValue = source.getValue();
                    gameScreen.getOilLabel().setText(String.valueOf(oilValue));
                    // do something with the new value, e.g. update a variable or call a method
                    calculateTotals(Factor.OIL, oilValue, gameScreen);
                    calculateCost(Factor.OIL, oilValue, gameScreen);
//                    gameScreen.getTotalEnergyValue().setText(String.valueOf(sum));
                }
                //moneyCalculator(homeEnergyAmountOfElectricity);
            }
        });

        //add a change listener to the gas slider
        gameScreen.getGasSlider().addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                JSlider source = (JSlider) e.getSource();
                if (!source.getValueIsAdjusting()) {
                    int gasValue = source.getValue();
                    gameScreen.getGasLabel().setText(String.valueOf(gasValue));
                    calculateTotals(Factor.GAS, gasValue, gameScreen);
                    calculateCost(Factor.GAS, gasValue, gameScreen);

                }
            }
        });

        gameScreen.getNuclearSlider().addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                JSlider source = (JSlider) e.getSource();
                if (!source.getValueIsAdjusting()) {
                    int nuclearValue = source.getValue();
                    gameScreen.getNuclearLabel().setText(String.valueOf(nuclearValue));
                    calculateTotals(Factor.NUCLEAR, nuclearValue, gameScreen);
                    calculateCost(Factor.NUCLEAR, nuclearValue, gameScreen);
                }
            }
        });

        gameScreen.getWindSlider().addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                JSlider source = (JSlider) e.getSource();
                if (!source.getValueIsAdjusting()) {
                    int windValue = source.getValue();
                    gameScreen.getWindLabel().setText(String.valueOf(windValue));
                    calculateTotals(Factor.WIND, windValue, gameScreen);
                    calculateCost(Factor.WIND, windValue, gameScreen);
                }
            }
        });

        gameScreen.getTrainSlider().addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                JSlider source = (JSlider) e.getSource();
                if (!source.getValueIsAdjusting()) {
                    int trainValue = source.getValue();
                    gameScreen.getTrainLabel().setText(String.valueOf(trainValue));
                }
            }
        });

        gameScreen.getBoatSlider().addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                JSlider source = (JSlider) e.getSource();
                if (!source.getValueIsAdjusting()) {
                    int busValue = source.getValue();
                    gameScreen.getBoatLabel().setText(String.valueOf(busValue));
                }
            }
        });

        gameScreen.getCarSlider().addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                JSlider source = (JSlider) e.getSource();
                if (!source.getValueIsAdjusting()) {
                    int carValue = source.getValue();
                    gameScreen.getCarLabel().setText(String.valueOf(carValue));
                }
            }
        });

        gameScreen.getPlaneSlider().addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                JSlider source = (JSlider) e.getSource();
                if (!source.getValueIsAdjusting()) {
                    int planeValue = source.getValue();
                    gameScreen.getPlaneLabel().setText(String.valueOf(planeValue));
                }
            }
        });

        gameScreen.getMeatSlider().addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                JSlider source = (JSlider) e.getSource();
                if (!source.getValueIsAdjusting()) {
                    int meatValue = source.getValue();
                    gameScreen.getMeatLabel().setText(String.valueOf(meatValue));
                }
            }
        });

        gameScreen.getPlantSlider().addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                JSlider source = (JSlider) e.getSource();
                if (!source.getValueIsAdjusting()) {
                    int plantValue = source.getValue();
                    gameScreen.getPlantLabel().setText(String.valueOf(plantValue));
                }
            }
        });


        frame.pack();
        frame.setVisible(true);

        setDefault(gameScreen);
    }

    private static void setDefault(GameScreenState gameScreen) {
        gameScreen.getOilSlider().setValue(30);
        gameScreen.getGasSlider().setValue(30);
        gameScreen.getNuclearSlider().setValue(10);
        gameScreen.getWindSlider().setValue(40);

        gameScreen.getTargetEnergyLabel().setText("500");
    }

    public static void calculateTotals(Factor factor, int factorValue, GameScreenState gameScreen) {
        double factorVolume = factor.getVolume(factorValue);
        s_factorVolumeMap.put(factor, factorVolume);

        Set<Entry<Factor, Double>> entries = s_factorVolumeMap.entrySet();
        double sum = 0;
        for (Entry<Factor, Double> pair : entries) {
            if (factor.getFactorType() == pair.getKey().getFactorType()) {
                sum += pair.getValue();
            }
        }
        gameScreen.getTotalEnergyValue().setText(String.valueOf(sum));
        

    }

    public static void calculateCost(Factor factor, int factorValue, GameScreenState gameScreen) {
        int factorCost = factor.getCost(factorValue);
        s_factorCostMap.put(factor, factorCost);

        Set<Entry<Factor, Integer>> entries = s_factorCostMap.entrySet();
        int sumCost = 0;
        for (Entry<Factor, Integer> pair : entries) {
            if (factor.getFactorType() == pair.getKey().getFactorType()) {
                sumCost += pair.getValue();
            }
        }
        gameScreen.getTotalCostLabel().setText(String.valueOf(sumCost));
    }


    public void carbonCalculator() {

    }
/*
    public enum Energy {

    }

    public class EnergySupplyCalculator() {
        enum EnergyType {
            OIL("gallon", 2.5, 2, Energy),
            GAS("therm", 1.2, 3, Energy),
            NUCLEEAR("gallon", 3.0, )

        }

    }
*/

}
