// QualityMeasurementApp2Test.java
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class QualityMeasurementApp2Test {

    private static final double EPSILON = 0.01;

    // -------- ENUM TESTS --------

    @Test
    void testLengthUnitEnum_FeetConstant() {
        assertEquals(1.0,
                LengthUnit.FEET.getConversionFactor(),
                EPSILON);
    }

    @Test
    void testLengthUnitEnum_InchesConstant() {
        assertEquals(1.0 / 12.0,
                LengthUnit.INCHES.getConversionFactor(),
                EPSILON);
    }

    @Test
    void testLengthUnitEnum_YardsConstant() {
        assertEquals(3.0,
                LengthUnit.YARDS.getConversionFactor(),
                EPSILON);
    }

    @Test
    void testLengthUnitEnum_CentimetersConstant() {
        assertEquals(1.0 / 30.48,
                LengthUnit.CENTIMETERS.getConversionFactor(),
                EPSILON);
    }

    // -------- BASE CONVERSION TESTS --------

    @Test
    void testConvertToBaseUnit_InchesToFeet() {
        assertEquals(1.0,
                LengthUnit.INCHES.convertToBaseUnit(12.0),
                EPSILON);
    }

    @Test
    void testConvertFromBaseUnit_FeetToInches() {
        assertEquals(12.0,
                LengthUnit.INCHES.convertFromBaseUnit(1.0),
                EPSILON);
    }

    @Test
    void testConvertToBaseUnit_YardsToFeet() {
        assertEquals(3.0,
                LengthUnit.YARDS.convertToBaseUnit(1.0),
                EPSILON);
    }

    @Test
    void testConvertFromBaseUnit_FeetToCentimeters() {
        assertEquals(30.48,
                LengthUnit.CENTIMETERS.convertFromBaseUnit(1.0),
                EPSILON);
    }

    // -------- EQUALITY TESTS --------

    @Test
    void testQuantityLengthRefactored_Equality() {
        QuantityLength a =
                new QuantityLength(1.0, LengthUnit.FEET);

        QuantityLength b =
                new QuantityLength(12.0, LengthUnit.INCHES);

        assertTrue(a.equals(b));
    }

    // -------- CONVERSION TESTS --------

    @Test
    void testQuantityLengthRefactored_ConvertTo() {
        QuantityLength a =
                new QuantityLength(1.0, LengthUnit.FEET);

        assertEquals(12.0,
                a.convertTo(LengthUnit.INCHES).getValue(),
                EPSILON);
    }

    @Test
    void testRoundTripConversion_RefactoredDesign() {
        QuantityLength a =
                new QuantityLength(1.0, LengthUnit.FEET);

        QuantityLength b =
                a.convertTo(LengthUnit.INCHES)
                        .convertTo(LengthUnit.FEET);

        assertEquals(1.0,
                b.getValue(),
                EPSILON);
    }

    // -------- ADDITION TESTS --------

    @Test
    void testQuantityLengthRefactored_Add() {
        QuantityLength a =
                new QuantityLength(1.0, LengthUnit.FEET);

        QuantityLength b =
                new QuantityLength(12.0, LengthUnit.INCHES);

        assertEquals(2.0,
                a.add(b, LengthUnit.FEET).getValue(),
                EPSILON);
    }

    @Test
    void testQuantityLengthRefactored_AddWithTargetUnit() {
        QuantityLength a =
                new QuantityLength(1.0, LengthUnit.FEET);

        QuantityLength b =
                new QuantityLength(12.0, LengthUnit.INCHES);

        assertEquals(0.67,
                a.add(b, LengthUnit.YARDS).getValue(),
                EPSILON);
    }

    @Test
    void testAddition_WithZero() {
        QuantityLength a =
                new QuantityLength(5.0, LengthUnit.FEET);

        QuantityLength b =
                new QuantityLength(0.0, LengthUnit.INCHES);

        assertEquals(5.0,
                a.add(b).getValue(),
                EPSILON);
    }

    @Test
    void testAddition_NegativeValues() {
        QuantityLength a =
                new QuantityLength(5.0, LengthUnit.FEET);

        QuantityLength b =
                new QuantityLength(-2.0, LengthUnit.FEET);

        assertEquals(3.0,
                a.add(b).getValue(),
                EPSILON);
    }

    // -------- VALIDATION TESTS --------

    @Test
    void testQuantityLengthRefactored_NullUnit() {
        assertThrows(IllegalArgumentException.class,
                () -> new QuantityLength(1.0, null));
    }

    @Test
    void testQuantityLengthRefactored_InvalidValue() {
        assertThrows(IllegalArgumentException.class,
                () -> new QuantityLength(Double.NaN,
                        LengthUnit.FEET));
    }

    @Test
    void testAddition_ExplicitTargetUnit_NullTargetUnit() {
        QuantityLength a =
                new QuantityLength(1.0, LengthUnit.FEET);

        QuantityLength b =
                new QuantityLength(12.0, LengthUnit.INCHES);

        assertThrows(IllegalArgumentException.class,
                () -> a.add(b, null));
    }
}