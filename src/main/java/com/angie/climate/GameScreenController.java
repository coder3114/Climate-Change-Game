package com.angie.climate;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameScreenController {

    private final GameScreenState m_gameScreen;

    private final GameScreenModel m_gameModel;

    private final ClimateScenario m_scenario;

    GameScreenController(GameScreenState gameScreen, ClimateScenario scenario) {
        m_gameScreen = gameScreen;
        m_scenario = scenario;
        m_gameModel = new GameScreenModel();
    }

    public void initListeners() {
        // add a change listener to the oil slider
        m_gameScreen.getOilSlider().addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                JSlider source = (JSlider) e.getSource();
                if (!source.getValueIsAdjusting()) {
                    int oilValue = source.getValue();
                    m_gameScreen.getOilLabel().setText(String.valueOf(oilValue));
                    // do something with the new value, e.g. update a variable or call a method
                    m_gameModel.calculateTotals(Factor.OIL, oilValue, m_gameScreen, m_scenario.getBudget());
                }
            }
        });

        //add a change listener to the gas slider
        m_gameScreen.getGasSlider().addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                JSlider source = (JSlider) e.getSource();
                if (!source.getValueIsAdjusting()) {
                    int gasValue = source.getValue();
                    m_gameScreen.getGasLabel().setText(String.valueOf(gasValue));
                    m_gameModel.calculateTotals(Factor.GAS, gasValue, m_gameScreen, m_scenario.getBudget());
                }
            }
        });

        m_gameScreen.getNuclearSlider().addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                JSlider source = (JSlider) e.getSource();
                if (!source.getValueIsAdjusting()) {
                    int nuclearValue = source.getValue();
                    m_gameScreen.getNuclearLabel().setText(String.valueOf(nuclearValue));
                    m_gameModel.calculateTotals(Factor.NUCLEAR, nuclearValue, m_gameScreen, m_scenario.getBudget());
                }
            }
        });

        m_gameScreen.getWindSlider().addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                JSlider source = (JSlider) e.getSource();
                if (!source.getValueIsAdjusting()) {
                    int windValue = source.getValue();
                    m_gameScreen.getWindLabel().setText(String.valueOf(windValue));
                    m_gameModel.calculateTotals(Factor.WIND, windValue, m_gameScreen, m_scenario.getBudget());
                }
            }
        });

        m_gameScreen.getTrainSlider().addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                JSlider source = (JSlider) e.getSource();
                if (!source.getValueIsAdjusting()) {
                    int trainValue = source.getValue();
                    m_gameScreen.getTrainLabel().setText(String.valueOf(trainValue));
                    m_gameModel.calculateTotals(Factor.TRAIN, trainValue, m_gameScreen, m_scenario.getBudget());
                }
            }
        });

        m_gameScreen.getBoatSlider().addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                JSlider source = (JSlider) e.getSource();
                if (!source.getValueIsAdjusting()) {
                    int busValue = source.getValue();
                    m_gameScreen.getBoatLabel().setText(String.valueOf(busValue));
                    m_gameModel.calculateTotals(Factor.BOAT, busValue, m_gameScreen, m_scenario.getBudget());
                }
            }
        });

        m_gameScreen.getCarSlider().addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                JSlider source = (JSlider) e.getSource();
                if (!source.getValueIsAdjusting()) {
                    int carValue = source.getValue();
                    m_gameScreen.getCarLabel().setText(String.valueOf(carValue));
                    m_gameModel.calculateTotals(Factor.CAR, carValue, m_gameScreen, m_scenario.getBudget());
                }
            }
        });

        m_gameScreen.getFlightSlider().addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                JSlider source = (JSlider) e.getSource();
                if (!source.getValueIsAdjusting()) {
                    int flightValue = source.getValue();
                    m_gameScreen.getFlightLabel().setText(String.valueOf(flightValue));
                    m_gameModel.calculateTotals(Factor.FLIGHT, flightValue, m_gameScreen, m_scenario.getBudget());
                }
            }
        });

        m_gameScreen.getMeatSlider().addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                JSlider source = (JSlider) e.getSource();
                if (!source.getValueIsAdjusting()) {
                    int meatValue = source.getValue();
                    m_gameScreen.getMeatLabel().setText(String.valueOf(meatValue));
                    m_gameModel.calculateTotals(Factor.MEAT, meatValue, m_gameScreen, m_scenario.getBudget());
                }
            }
        });

        m_gameScreen.getPlantSlider().addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                JSlider source = (JSlider) e.getSource();
                if (!source.getValueIsAdjusting()) {
                    int plantValue = source.getValue();
                    m_gameScreen.getPlantLabel().setText(String.valueOf(plantValue));
                    m_gameModel.calculateTotals(Factor.PLANT, plantValue, m_gameScreen, m_scenario.getBudget());
                }
            }
        });

        //click bottom to calculate carbon score and performance result
        m_gameScreen.getIAmReadyToButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                m_gameModel.carbonCalculator(m_gameScreen, m_scenario.getBudget());

            }
        });
    }

    public void setDefaults() {
        m_gameScreen.getOilSlider().setValue(m_scenario.getOilAmount());
        m_gameScreen.getGasSlider().setValue(m_scenario.getGasAmount());
        m_gameScreen.getNuclearSlider().setValue(m_scenario.getNuclearAmount());
        m_gameScreen.getWindSlider().setValue(m_scenario.getWindAmount());

        m_gameScreen.getTrainSlider().setValue(m_scenario.getTrainAmount());
        m_gameScreen.getCarSlider().setValue(m_scenario.getCarAmount());
        m_gameScreen.getBoatSlider().setValue(m_scenario.getBoatAmount());
        m_gameScreen.getFlightSlider().setValue(m_scenario.getFlightAmount());

        m_gameScreen.getMeatSlider().setValue(m_scenario.getMeatAmount());
        m_gameScreen.getPlantSlider().setValue(m_scenario.getPlantAmount());

        m_gameScreen.getTargetEnergyLabel().setText(String.valueOf(m_scenario.getEnergyTarget()));
        m_gameScreen.getTargetTransportValue().setText(String.valueOf(m_scenario.getTransportTarget()));
        m_gameScreen.getTargetFoodValue().setText(String.valueOf(m_scenario.getFoodTarget()));

        m_gameScreen.getBudgetLabel().setText("Money (Budget " + String.valueOf(m_scenario.getBudget()) + ")");

        m_gameModel.calculateAndSetOriginalEmission();
    }
}
