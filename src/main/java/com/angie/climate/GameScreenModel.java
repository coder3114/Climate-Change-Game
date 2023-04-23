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

    public void calculateAndSetOriginalEmission() {
        // save original emission figure after calculating
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

    public void calculateTotals(Factor factor, int factorValue, GameScreenState gameScreen, int availableMoney) {
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
                break;
            case TRANSPORT:
                gameScreen.getTotalTransportValue().setText(String.valueOf(sum));
                break;
            default:
                gameScreen.getTotalFoodValue().setText(String.valueOf(sum));
                break;
        }


        //calculate total costs
        int factorCost = factor.getCost(factorValue);
        m_factorCostMap.put(factor, factorCost);

        Collection<Integer> costCollection = m_factorCostMap.values();
        int sumCost = 0;
        for (Integer cost : costCollection) {
            sumCost += cost;
        }
        gameScreen.getTotalCostLabel().setText(String.valueOf(sumCost));
        if (sumCost > availableMoney) {
            gameScreen.getTotalCostLabel().setForeground(Color.RED);
        } else {
            gameScreen.getTotalCostLabel().setForeground(Color.BLACK);
        }

        //calculate total emission but not display yet
        int factorEmission = factor.getEmission(factorValue);
        m_factorEmissionMap.put(factor, factorEmission);
    }

    public void carbonCalculator(GameScreenState gameScreen, int availableMoney) {
        int sumCost = Integer.parseInt(gameScreen.getTotalCostLabel().getText());
        if (sumCost > availableMoney) {
            infoBox("You don't have enough money :(\n\nPlease lower you cost until it's under the target", "");
            return;
        }

        //check targets too

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
