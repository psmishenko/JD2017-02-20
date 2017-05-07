package by.it.prigozhanov.jd03_03.dao.tests;

import by.it.prigozhanov.jd03_03.beans.Car;
import by.it.prigozhanov.jd03_03.dao.CarDAO;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by v-omf on 5/2/2017.
 *
 * @author v-omf
 */
public class CarDAOTest {
    private static CarDAO carDAO = new CarDAO();

    @Test
    public void testUser() throws Exception {
        Car car = new Car(1,"MarkTest", "ModelTest", 60, "LicationTest", 6);
        assertTrue(carDAO.create(car));
        assertNotNull(carDAO.read(1));
        assertTrue(carDAO.update(car));
        assertTrue(carDAO.delete(car));
    }
}