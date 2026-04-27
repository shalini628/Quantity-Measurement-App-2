// QualityMeasurementApp2Test.java

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class QualityMeasurementApp2Test {

    private static final double EPSILON = 1e-6;

    @Test
    void testAddition_SameUnit_FeetPlusFeet() {
        QuantityLength a = new QuantityLength(1.0, LengthUnit.FEET);
        QuantityLength b = new QuantityLength(2.0, LengthUnit.FEET);

        assertEquals(3.0, a.add(b).value, EPSILON);
    }

    @Test
    void testAddition_SameUnit_InchPlusInch() {
        QuantityLength a = new QuantityLength(6.0, LengthUnit.INCHES);
        QuantityLength b = new QuantityLength(6.0, LengthUnit.INCHES);

        assertEquals(12.0, a.add(b).value, EPSILON);
    }

    @Test
    void testAddition_CrossUnit_FeetPlusInches() {
        QuantityLength a = new QuantityLength(1.0, LengthUnit.FEET);
        QuantityLength b = new QuantityLength(12.0, LengthUnit.INCHES);

        assertEquals(2.0, a.add(b).value, EPSILON);
    }

    @Test
    void testAddition_CrossUnit_InchPlusFeet() {
        QuantityLength a = new QuantityLength(12.0, LengthUnit.INCHES);
        QuantityLength b = new QuantityLength(1.0, LengthUnit.FEET);

        assertEquals(24.0, a.add(b).value, EPSILON);
    }

    @Test
    void testAddition_CrossUnit_YardPlusFeet() {
        QuantityLength a = new QuantityLength(1.0, LengthUnit.YARDS);
        QuantityLength b = new QuantityLength(3.0, LengthUnit.FEET);

        assertEquals(2.0, a.add(b).value, EPSILON);
    }

    @Test
    void testAddition_CrossUnit_CentimeterPlusInch() {
        QuantityLength a = new QuantityLength(2.54, LengthUnit.CENTIMETERS);
        QuantityLength b = new QuantityLength(1.0, LengthUnit.INCHES);

        assertEquals(5.08, a.add(b).value, 0.01);
    }

    @Test
    void testAddition_WithZero() {
        QuantityLength a = new QuantityLength(5.0, LengthUnit.FEET);
        QuantityLength b = new QuantityLength(0.0, LengthUnit.INCHES);

        assertEquals(5.0, a.add(b).value, EPSILON);
    }

    @Test
    void testAddition_NegativeValues() {
        QuantityLength a = new QuantityLength(5.0, LengthUnit.FEET);
        QuantityLength b = new QuantityLength(-2.0, LengthUnit.FEET);

        assertEquals(3.0, a.add(b).value, EPSILON);
    }

    @Test
    void testAddition_NullSecondOperand() {
        QuantityLength a = new QuantityLength(1.0, LengthUnit.FEET);

        assertThrows(IllegalArgumentException.class, () -> a.add(null));
    }

    @Test
    void testAddition_LargeValues() {
        QuantityLength a = new QuantityLength(1e6, LengthUnit.FEET);
        QuantityLength b = new QuantityLength(1e6, LengthUnit.FEET);

        assertEquals(2e6, a.add(b).value, EPSILON);
    }

    @Test
    void testAddition_SmallValues() {
        QuantityLength a = new QuantityLength(0.001, LengthUnit.FEET);
        QuantityLength b = new QuantityLength(0.002, LengthUnit.FEET);

        assertEquals(0.003, a.add(b).value, EPSILON);
    }
}