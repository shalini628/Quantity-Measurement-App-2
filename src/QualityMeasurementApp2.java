// QualityMeasurementApp2.java

enum LengthUnit {
    FEET(1.0),
    INCHES(1.0 / 12.0),
    YARDS(3.0),
    CENTIMETERS(0.0328084);

    private final double factor;

    LengthUnit(double factor) {
        this.factor = factor;
    }

    public double toFeet(double value) {
        return value * factor;
    }

    public double fromFeet(double feet) {
        return feet / factor;
    }
}

class QuantityLength {
    double value;
    LengthUnit unit;

    public QuantityLength(double value, LengthUnit unit) {
        if (unit == null || !Double.isFinite(value)) {
            throw new IllegalArgumentException("Invalid input");
        }
        this.value = value;
        this.unit = unit;
    }

    // UC6 - default first operand unit
    public QuantityLength add(QuantityLength other) {
        return add(other, this.unit);
    }

    // UC7 - explicit target unit
    public QuantityLength add(QuantityLength other, LengthUnit targetUnit) {
        if (other == null || targetUnit == null) {
            throw new IllegalArgumentException("Invalid input");
        }

        double feet1 = this.unit.toFeet(this.value);
        double feet2 = other.unit.toFeet(other.value);

        double sumFeet = feet1 + feet2;

        double result = targetUnit.fromFeet(sumFeet);

        return new QuantityLength(result, targetUnit);
    }

    @Override
    public String toString() {
        return "Quantity(" + value + ", " + unit + ")";
    }
}

public class QualityMeasurementApp2 {

    public static void main(String[] args) {

        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.FEET);
        QuantityLength q2 = new QuantityLength(12.0, LengthUnit.INCHES);

        System.out.println(q1.add(q2, LengthUnit.YARDS));
    }
}