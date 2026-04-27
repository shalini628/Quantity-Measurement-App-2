// QualityMeasurementApp2Test.java

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class QualityMeasurementApp2Test {

    double EPSILON = 0.01;

    @Test
    void testAddition_ExplicitTargetUnit_Feet() {
        QuantityLength a = new QuantityLength(1.0, LengthUnit.FEET);
        QuantityLength b = new QuantityLength(12.0, LengthUnit.INCHES);

        assertEquals(2.0, a.add(b, LengthUnit.FEET).value, EPSILON);
    }

    @Test
    void testAddition_ExplicitTargetUnit_Inches() {
        QuantityLength a = new QuantityLength(1.0, LengthUnit.FEET);
        QuantityLength b = new QuantityLength(12.0, LengthUnit.INCHES);

        assertEquals(24.0, a.add(b, LengthUnit.INCHES).value, EPSILON);
    }

    @Test
    void testAddition_ExplicitTargetUnit_Yards() {
        QuantityLength a = new QuantityLength(1.0, LengthUnit.FEET);
        QuantityLength b = new QuantityLength(12.0, LengthUnit.INCHES);

        assertEquals(0.667, a.add(b, LengthUnit.YARDS).value, EPSILON);
    }

    @Test
    void testAddition_ExplicitTargetUnit_Centimeters() {
        QuantityLength a = new QuantityLength(1.0, LengthUnit.INCHES);
        QuantityLength b = new QuantityLength(1.0, LengthUnit.INCHES);

        assertEquals(5.08, a.add(b, LengthUnit.CENTIMETERS).value, EPSILON);
    }

    @Test
    void testAddition_Commutativity() {
        QuantityLength a = new QuantityLength(1.0, LengthUnit.FEET);
        QuantityLength b = new QuantityLength(12.0, LengthUnit.INCHES);

        double r1 = a.add(b, LengthUnit.YARDS).value;
        double r2 = b.add(a, LengthUnit.YARDS).value;

        assertEquals(r1, r2, EPSILON);
    }

    @Test
    void testAddition_WithZero() {
        QuantityLength a = new QuantityLength(5.0, LengthUnit.FEET);
        QuantityLength b = new QuantityLength(0.0, LengthUnit.INCHES);

        assertEquals(1.667, a.add(b, LengthUnit.YARDS).value, EPSILON);
    }

    @Test
    void testAddition_NegativeValues() {
        QuantityLength a = new QuantityLength(5.0, LengthUnit.FEET);
        QuantityLength b = new QuantityLength(-2.0, LengthUnit.FEET);

        assertEquals(36.0, a.add(b, LengthUnit.INCHES).value, EPSILON);
    }

    @Test
    void testAddition_NullTargetUnit() {
        QuantityLength a = new QuantityLength(1.0, LengthUnit.FEET);
        QuantityLength b = new QuantityLength(12.0, LengthUnit.INCHES);

        assertThrows(IllegalArgumentException.class,
                () -> a.add(b, null));
    }

    @Test
    void testAddition_LargeToSmallScale() {
        QuantityLength a = new QuantityLength(1000.0, LengthUnit.FEET);
        QuantityLength b = new QuantityLength(500.0, LengthUnit.FEET);

        assertEquals(18000.0, a.add(b, LengthUnit.INCHES).value, EPSILON);
    }

    @Test
    void testAddition_SmallToLargeScale() {
        QuantityLength a = new QuantityLength(12.0, LengthUnit.INCHES);
        QuantityLength b = new QuantityLength(12.0, LengthUnit.INCHES);

        assertEquals(0.667, a.add(b, LengthUnit.YARDS).value, EPSILON);
    }
}