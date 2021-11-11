package com.measurements;

public enum Units {
    KILO_METERS(100000, TYPE.DISTANCE), CENTI_METERS(1, TYPE.DISTANCE), METERS(100, TYPE.DISTANCE),
    MILLI_GRAMS(10000, TYPE.WEIGHT);

    private final TYPE type;

    public TYPE getType() {
        return type;
    }

    public double getBaseMetric() {
        return baseMetric;
    }

    public double toConvertToCMs(double val) {
        return baseMetric * val;
    }

    Units(double i, TYPE type) {
        this.baseMetric = i;
        this.type = type;
    }

    enum TYPE {
        DISTANCE,
        WEIGHT
    }


    private final double baseMetric;

}
