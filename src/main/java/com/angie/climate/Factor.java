package com.angie.climate;

public enum Factor {
    OIL(2, 3, 5, FactorType.ENERGY),
    GAS(2, 2, 4, FactorType.ENERGY),
    NUCLEAR(3, 5, 2, FactorType.ENERGY),
    WIND(2, 2.5, 1, FactorType.ENERGY),

    TRAIN(3, 5, 1, FactorType.TRANSPORT),
    BOAT(3, 4, 2, FactorType.TRANSPORT),
    CAR(1, 2, 3, FactorType.TRANSPORT),
    FLIGHT(4, 4, 4, FactorType.TRANSPORT),

    MEAT(5, 4, 5, FactorType.FOOD),
    PLANT(2, 3, 1, FactorType.FOOD);

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
