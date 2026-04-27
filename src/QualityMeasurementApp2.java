// QualityMeasurementApp2.java

enum LengthUnit {
    FEET(1.0),
    INCHES(1.0 / 12.0),
    YARDS(3.0),
    CENTIMETERS(1.0 / 30.48);

    private final double factor;

    LengthUnit(double factor) {
        this.factor = factor;
    }

    public double convertToBaseUnit(double value) {
        return value * factor;
    }

    public double convertFromBaseUnit(double baseValue) {
        return baseValue / factor;
    }
}

enum WeightUnit {
    KILOGRAM(1.0),
    GRAM(0.001),
    POUND(0.453592);

    private final double factor;

    WeightUnit(double factor) {
        this.factor = factor;
    }

    public double convertToBaseUnit(double value) {
        return value * factor;
    }

    public double convertFromBaseUnit(double baseValue) {
        return baseValue / factor;
    }
}

class QuantityLength {

    private final double value;
    private final LengthUnit unit;
    private static final double EPSILON = 0.01;

    public QuantityLength(double value, LengthUnit unit) {
        if (unit == null || Double.isNaN(value) || Double.isInfinite(value))
            throw new IllegalArgumentException();

        this.value = value;
        this.unit = unit;
    }

    public double getValue() {
        return value;
    }

    public QuantityLength convertTo(LengthUnit target) {
        double base = unit.convertToBaseUnit(value);
        return new QuantityLength(
                target.convertFromBaseUnit(base), target);
    }

    public QuantityLength add(QuantityLength other) {
        return add(other, this.unit);
    }

    public QuantityLength add(QuantityLength other,
                              LengthUnit target) {

        double sum =
                unit.convertToBaseUnit(value) +
                        other.unit.convertToBaseUnit(other.value);

        return new QuantityLength(
                target.convertFromBaseUnit(sum), target);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof QuantityLength))
            return false;

        QuantityLength other = (QuantityLength) obj;

        double a = unit.convertToBaseUnit(value);
        double b = other.unit.convertToBaseUnit(other.value);

        return Math.abs(a - b) < EPSILON;
    }
}

class QuantityWeight {

    private final double value;
    private final WeightUnit unit;
    private static final double EPSILON = 0.01;

    public QuantityWeight(double value, WeightUnit unit) {
        if (unit == null || Double.isNaN(value) || Double.isInfinite(value))
            throw new IllegalArgumentException();

        this.value = value;
        this.unit = unit;
    }

    public double getValue() {
        return value;
    }

    public QuantityWeight convertTo(WeightUnit target) {
        double base = unit.convertToBaseUnit(value);

        return new QuantityWeight(
                target.convertFromBaseUnit(base), target);
    }

    public QuantityWeight add(QuantityWeight other) {
        return add(other, this.unit);
    }

    public QuantityWeight add(QuantityWeight other,
                              WeightUnit target) {

        double sum =
                unit.convertToBaseUnit(value) +
                        other.unit.convertToBaseUnit(other.value);

        return new QuantityWeight(
                target.convertFromBaseUnit(sum), target);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof QuantityWeight))
            return false;

        QuantityWeight other = (QuantityWeight) obj;

        double a = unit.convertToBaseUnit(value);
        double b = other.unit.convertToBaseUnit(other.value);

        return Math.abs(a - b) < EPSILON;
    }
}

public class QualityMeasurementApp2 {

    public static void main(String[] args) {

        QuantityWeight q1 =
                new QuantityWeight(1.0, WeightUnit.KILOGRAM);

        QuantityWeight q2 =
                new QuantityWeight(1000.0, WeightUnit.GRAM);

        System.out.println(q1.equals(q2));
    }
}