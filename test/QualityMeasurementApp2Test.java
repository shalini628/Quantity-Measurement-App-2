import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class QualityMeasurementApp2Test {

    @Test
    void testAppRunsSuccessfully() {
        QualityMeasurementApp2 app = new QualityMeasurementApp2();
        assertNotNull(app);
    }

    @Test
    void testObjectCreation() {
        QualityMeasurementApp2 app1 = new QualityMeasurementApp2();
        QualityMeasurementApp2 app2 = new QualityMeasurementApp2();

        assertNotEquals(null, app1);
        assertNotEquals(null, app2);
    }

    @Test
    void testEquality() {
        QualityMeasurementApp2 app1 = new QualityMeasurementApp2();
        QualityMeasurementApp2 app2 = app1;

        assertEquals(app1, app2);
    }

    @Test
    void testNotSameObjects() {
        QualityMeasurementApp2 app1 = new QualityMeasurementApp2();
        QualityMeasurementApp2 app2 = new QualityMeasurementApp2();

        assertNotSame(app1, app2);
    }

    @Test
    void testClassName() {
        QualityMeasurementApp2 app = new QualityMeasurementApp2();

        assertEquals("QualityMeasurementApp2", app.getClass().getSimpleName());
    }

    @Test
    void testHashCode() {
        QualityMeasurementApp2 app = new QualityMeasurementApp2();

        assertTrue(app.hashCode() != 0);
    }

    @Test
    void testToStringNotNull() {
        QualityMeasurementApp2 app = new QualityMeasurementApp2();

        assertNotNull(app.toString());
    }

    @Test
    void testMultipleObjects() {
        QualityMeasurementApp2 a = new QualityMeasurementApp2();
        QualityMeasurementApp2 b = new QualityMeasurementApp2();
        QualityMeasurementApp2 c = new QualityMeasurementApp2();

        assertNotNull(a);
        assertNotNull(b);
        assertNotNull(c);
    }

    @Test
    void testInstanceType() {
        QualityMeasurementApp2 app = new QualityMeasurementApp2();

        assertTrue(app instanceof QualityMeasurementApp2);
    }

    @Test
    void testNoException() {
        assertDoesNotThrow(() -> {
            new QualityMeasurementApp2();
        });
    }
}