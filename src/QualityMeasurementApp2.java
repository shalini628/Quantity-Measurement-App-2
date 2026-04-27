enum LengthUnit {
    FEET(1.0),
    INCHES(1.0 / 12.0),
    YARDS(3.0),
    CENTIMETERS(0.0328084);

    private final double factorToFeet;

    LengthUnit(double factorToFeet) {
        this.factorToFeet = factorToFeet;
    }

    public double toFeet(double value) {
        return value * factorToFeet;
    }

    public double fromFeet(double feetValue) {
        return feetValue / factorToFeet;
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

    public QuantityLength add(QuantityLength other) {
        if (other == null) {
            throw new IllegalArgumentException("Second operand cannot be null");
        }

        double feet1 = this.unit.toFeet(this.value);
        double feet2 = other.unit.toFeet(other.value);

        double sumFeet = feet1 + feet2;

        double result = this.unit.fromFeet(sumFeet);

        return new QuantityLength(result, this.unit);
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

        QuantityLength result = q1.add(q2);

        System.out.println(result);
    }
}