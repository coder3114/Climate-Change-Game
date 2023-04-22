package com.angie.climate;

public enum Factor {
    OIL(2, 2, FactorType.ENERGY),
    GAS(1, 3, FactorType.ENERGY),
    NUCLEAR(3, 4, FactorType.ENERGY),
    WIND(2, 3, FactorType.ENERGY),

    TRAIN(1, 1, FactorType.TRANSPORT),
    BOAT(1, 1, FactorType.TRANSPORT),
    CAR(1, 1, FactorType.TRANSPORT),
    FLIGHT(1, 1, FactorType.TRANSPORT),

    MEAT(1, 1, FactorType.FOOD),
    PLANT(1, 1, FactorType.FOOD);

    private final int m_unitPrice;

    private final double m_multiplier;

    private final FactorType m_factorType;

    Factor(int unitPrice, double multiplier, FactorType type) {
        m_unitPrice = unitPrice;
        m_multiplier = multiplier;
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
}
