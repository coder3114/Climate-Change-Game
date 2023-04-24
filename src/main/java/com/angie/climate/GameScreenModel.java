package com.angie.climate;

import javax.swing.*;
import java.awt.*;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class GameScreenModel {
    //Create a map to store and retrieve factors (act as Keys) and their associated Volume/Cost
    private final Map<Factor, Double> m_factorVolumeMap = new HashMap<>();

    private final Map<Factor, Integer> m_factorCostMap = new HashMap<>();

    private final Map<Factor, Integer> m_factorEmissionMap = new HashMap<>();

    private int m_originalEmission = 0;

    public void calculateTotals(Factor factor, int factorValue, GameScreenState gameScreen, int budget, int energyTarget, int transportTarget, int foodTarget) {
        //generic method to calculate each factor volume
        double factorVolume = factor.getVolume(factorValue);
        m_factorVolumeMap.put(factor, factorVolume);

        Set<Map.Entry<Factor, Double>> entries = m_factorVolumeMap.entrySet();
        double sum = 0;
        for (Map.Entry<Factor, Double> pair : entries) {
            if (factor.getFactorType() == pair.getKey().getFactorType()) {
                sum += pair.getValue();
            }
        }
        switch (factor.getFactorType()) {
            case ENERGY:
                gameScreen.getTotalEnergyValue().setText(String.valueOf(sum));
                if (sum < energyTarget) {
                    gameScreen.getTotalEnergyValue().setForeground(Color.RED);
                } else if (sum > energyTarget) {
                    gameScreen.getTotalEnergyValue().setForeground(Color.GREEN);
                } else {
                    gameScreen.getTotalEnergyValue().setForeground(Color.BLACK);
                }
//initial try:                if (sum < Integer.parseInt(gameScreen.getTargetEnergyLabel().getText())) {
                break;
            case TRANSPORT:
                gameScreen.getTotalTransportValue().setText(String.valueOf(sum));
                if (sum < transportTarget) {
                    gameScreen.getTotalTransportValue().setForeground(Color.RED);
                } else if (sum > transportTarget) {
                    gameScreen.getTotalTransportValue().setForeground(Color.GREEN);
                } else {
                    gameScreen.getTotalTransportValue().setForeground(Color.BLACK);
                }
                break;
            default:
                gameScreen.getTotalFoodValue().setText(String.valueOf(sum));
                if (sum < foodTarget) {
                    gameScreen.getTotalFoodValue().setForeground(Color.RED);
                } else if (sum > foodTarget) {
                    gameScreen.getTotalFoodValue().setForeground(Color.GREEN);
                } else {
                    gameScreen.getTotalFoodValue().setForeground(Color.BLACK);
                }
                break;
        }

        //calculate total costs for all factors and show it on label
        int factorCost = factor.getCost(factorValue);
        m_factorCostMap.put(factor, factorCost);

        Collection<Integer> costCollection = m_factorCostMap.values();
        int sumCost = 0;
        for (Integer cost : costCollection) {
            sumCost += cost;
        }
        gameScreen.getTotalCostLabel().setText(String.valueOf(sumCost));
        if (sumCost > budget) {
            gameScreen.getTotalCostLabel().setForeground(Color.RED);
        } else {
            gameScreen.getTotalCostLabel().setForeground(Color.BLACK);
        }

        //create emission map too
        int factorEmission = factor.getEmission(factorValue);
        m_factorEmissionMap.put(factor, factorEmission);
    }

    // save original emission figure after calculating
    public void calculateAndSetOriginalEmission() {
        m_originalEmission = calculateEmission();
        System.out.println(m_originalEmission);
    }

    public int calculateEmission() {
        Collection<Integer> emissionCollection = m_factorEmissionMap.values();
        int totalEmission = 0;
        for (Integer emission : emissionCollection) {
            totalEmission += emission;
        }
        return totalEmission;
    }

    public void carbonCalculator(GameScreenState gameScreen, int budget) {
        int sumCost = Integer.parseInt(gameScreen.getTotalCostLabel().getText());
        if (sumCost > budget) {
            infoBox("You don't have enough money :(\n\nPlease lower you cost until it's under the target", "");
            return;
        }

        //check factor target too
        int totalEnergyValue = Integer.parseInt(gameScreen.getTotalEnergyValue().getText());
        int totalTransportValue = Integer.parseInt(gameScreen.getTotalTransportValue().getText());
        int totalFoodValue = Integer.parseInt(gameScreen.getTotalFoodValue().getText());
        if (totalEnergyValue < Integer.parseInt(gameScreen.getTargetEnergyLabel().getText()) || totalTransportValue <
                Integer.parseInt(gameScreen.getTargetTransportValue().getText()) || totalFoodValue <
                Integer.parseInt(gameScreen.getTargetFoodValue().getText())) {
            infoBox("You don't meet all the target requirement :(\n\nPlease lower you cost until it's under the target", "");
            return;
        }

        //check carbon emission too
        int sumEmission = calculateEmission();
        int score = sumEmission - m_originalEmission;
        gameScreen.getFinalScoreLabel().setText(String.valueOf(score));

        if (score > 0) {
            infoBox("Well done!\n\nYou've improved the situation", "");
        } else {
            infoBox("Not yet!\n\nPlease try your other strategy to achieve better result", "");
        }
    }

    public void infoBox(String infoMessage, String titleBar) {
        JOptionPane.showMessageDialog(null, infoMessage, "Error Message" + titleBar, JOptionPane.INFORMATION_MESSAGE);
    }
}
