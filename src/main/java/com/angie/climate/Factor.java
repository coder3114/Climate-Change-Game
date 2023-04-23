package com.angie.climate;

public enum Factor {
    OIL(2, 2, 5, FactorType.ENERGY),
    GAS(1, 3, 6, FactorType.ENERGY),
    NUCLEAR(3, 4, 3, FactorType.ENERGY),
    WIND(2, 3, 2, FactorType.ENERGY),

    TRAIN(1, 5, 3, FactorType.TRANSPORT),
    BOAT(3, 2, 2, FactorType.TRANSPORT),
    CAR(2, 4, 4, FactorType.TRANSPORT),
    FLIGHT(5, 1, 2, FactorType.TRANSPORT),

    MEAT(5, 5, 5, FactorType.FOOD),
    PLANT(3, 2, 1, FactorType.FOOD);

    private final int m_unitPrice;

    private final double m_multiplier;

    private final FactorType m_factorType;

    private final int m_emission;

    Factor(int unitPrice, double multiplier, int emission, FactorType type) {
        m_unitPrice = unitPrice;
        m_multiplier = multiplier;
        m_emission = emission;
        m_factorType = type;
    }

    public FactorType getFactorType() {
        return m_factorType;
    }

    public double getVolume(int value) {
        return value * m_multiplier;
    }

    public int getCost(int value) {
        return value * m_unitPrice;
    }

    public int getEmission(int value) {
        return value * m_emission;
    }
}
