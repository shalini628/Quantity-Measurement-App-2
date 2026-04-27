// QualityMeasurementApp2Test.java

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class QualityMeasurementApp2Test {

    double EPSILON = 0.01;

    @Test
    void testEquality_KilogramToKilogram_SameValue() {
        assertTrue(
                new QuantityWeight(1, WeightUnit.KILOGRAM)
                        .equals(
                                new QuantityWeight(1, WeightUnit.KILOGRAM)
                        )
        );
    }

    @Test
    void testEquality_KilogramToGram_EquivalentValue() {
        assertTrue(
                new QuantityWeight(1, WeightUnit.KILOGRAM)
                        .equals(
                                new QuantityWeight(1000, WeightUnit.GRAM)
                        )
        );
    }

    @Test
    void testEquality_NullComparison() {
        assertFalse(
                new QuantityWeight(1, WeightUnit.KILOGRAM)
                        .equals(null)
        );
    }

    @Test
    void testConversion_PoundToKilogram() {
        assertEquals(1.0,
                new QuantityWeight(2.20462,
                        WeightUnit.POUND)
                        .convertTo(WeightUnit.KILOGRAM)
                        .getValue(),
                EPSILON);
    }

    @Test
    void testConversion_KilogramToPound() {
        assertEquals(2.20462,
                new QuantityWeight(1,
                        WeightUnit.KILOGRAM)
                        .convertTo(WeightUnit.POUND)
                        .getValue(),
                EPSILON);
    }

    @Test
    void testConversion_ZeroValue() {
        assertEquals(0.0,
                new QuantityWeight(0,
                        WeightUnit.KILOGRAM)
                        .convertTo(WeightUnit.GRAM)
                        .getValue(),
                EPSILON);
    }

    @Test
    void testAddition_SameUnit() {
        assertEquals(3.0,
                new QuantityWeight(1,
                        WeightUnit.KILOGRAM)
                        .add(
                                new QuantityWeight(2,
                                        WeightUnit.KILOGRAM)
                        )
                        .getValue(),
                EPSILON);
    }

    @Test
    void testAddition_CrossUnit() {
        assertEquals(2.0,
                new QuantityWeight(1,
                        WeightUnit.KILOGRAM)
                        .add(
                                new QuantityWeight(1000,
                                        WeightUnit.GRAM)
                        )
                        .getValue(),
                EPSILON);
    }

    @Test
    void testAddition_ExplicitTargetUnit() {
        assertEquals(2000.0,
                new QuantityWeight(1,
                        WeightUnit.KILOGRAM)
                        .add(
                                new QuantityWeight(1000,
                                        WeightUnit.GRAM),
                                WeightUnit.GRAM
                        )
                        .getValue(),
                EPSILON);
    }

    @Test
    void testAddition_WithZero() {
        assertEquals(5.0,
                new QuantityWeight(5,
                        WeightUnit.KILOGRAM)
                        .add(
                                new QuantityWeight(0,
                                        WeightUnit.GRAM)
                        )
                        .getValue(),
                EPSILON);
    }

    @Test
    void testAddition_NegativeValues() {
        assertEquals(3.0,
                new QuantityWeight(5,
                        WeightUnit.KILOGRAM)
                        .add(
                                new QuantityWeight(-2000,
                                        WeightUnit.GRAM)
                        )
                        .getValue(),
                EPSILON);
    }

    @Test
    void testLargeValues() {
        assertEquals(2000000.0,
                new QuantityWeight(1e6,
                        WeightUnit.KILOGRAM)
                        .add(
                                new QuantityWeight(1e6,
                                        WeightUnit.KILOGRAM)
                        )
                        .getValue(),
                EPSILON);
    }

    @Test
    void testWeightVsLengthIncompatible() {
        assertFalse(
                new QuantityWeight(1,
                        WeightUnit.KILOGRAM)
                        .equals(
                                new QuantityLength(1,
                                        LengthUnit.FEET)
                        )
        );
    }

    @Test
    void testNullUnit() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new QuantityWeight(1, null)
        );
    }

    @Test
    void testRoundTripConversion() {
        assertEquals(1.5,
                new QuantityWeight(1.5,
                        WeightUnit.KILOGRAM)
                        .convertTo(WeightUnit.GRAM)
                        .convertTo(WeightUnit.KILOGRAM)
                        .getValue(),
                EPSILON);
    }
}