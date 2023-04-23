package com.angie.climate;

public class ClimateScenario {

    private final int m_energyTarget;

    private final int m_transportTarget;

    private final int m_foodTarget;

    private final int m_budget;

    private final int m_oilAmount;

    private final int m_gasAmount;

    private final int m_nuclearAmount;

    private final int m_windAmount;

    private final int m_trainAmount;

    private final int m_carAmount;

    private final int m_boatAmount;

    private final int m_flightAmount;

    private final int m_meatAmount;

    private final int m_plantAmount;

    ClimateScenario(int energyTarget, int transportTarget, int foodTarget, int budget, int oil, int gas,
                    int nuclear, int wind, int train, int car, int boat, int flight, int meat, int plant) {
        m_energyTarget = energyTarget;
        m_transportTarget = transportTarget;
        m_foodTarget = foodTarget;
        m_budget = budget;
        m_oilAmount = oil;
        m_gasAmount = gas;
        m_nuclearAmount = nuclear;
        m_windAmount = wind;
        m_trainAmount = train;
        m_carAmount = car;
        m_boatAmount = boat;
        m_flightAmount = flight;
        m_meatAmount = meat;
        m_plantAmount = plant;
    }

    public int getOilAmount() {
        return m_oilAmount;
    }

    public int getGasAmount() {
        return m_gasAmount;
    }

    public int getNuclearAmount() {
        return m_nuclearAmount;
    }

    public int getWindAmount() {
        return m_windAmount;
    }

    public int getTrainAmount() {
        return m_trainAmount;
    }

    public int getCarAmount() {
        return m_carAmount;
    }

    public int getBoatAmount() {
        return m_boatAmount;
    }

    public int getFlightAmount() {
        return m_flightAmount;
    }

    public int getMeatAmount() {
        return m_meatAmount;
    }

    public int getPlantAmount() {
        return m_plantAmount;
    }

    public int getEnergyTarget() {
        return m_energyTarget;
    }

    public int getTransportTarget() {
        return m_transportTarget;
    }

    public int getFoodTarget() {
        return m_foodTarget;
    }

    public int getBudget() {
        return m_budget;
    }
}
