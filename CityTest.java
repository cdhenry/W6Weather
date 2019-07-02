import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CityTest {
	City city;

	@BeforeEach
	void setUp() throws Exception {
		city = new City("Dallas");
	}

	@Test
	void testAddTempForDate() {
		assertEquals(true, city.addTempForDate("February", 14, 55));
		assertEquals(true, city.addTempForDate("FEBRUARY", 14, 77));
		assertEquals(77, city.maxTemps.get("february")[13]);	
	}
	
	@Test
	void testMonthInAddTempForDate() {
		assertEquals(false, city.addTempForDate("2", 14, 77));
		assertEquals(false, city.addTempForDate("Feb", 14, 77));
		assertEquals(false, city.addTempForDate("...", 14, 77));
		assertEquals(0.0, city.maxTemps.get("february")[13]);
	}
	
	@Test
	void testDayInAddTempForDate() {
		assertEquals(false, city.addTempForDate("February", 300, 77));
		assertEquals(false, city.addTempForDate("February", -1, 77));
		assertEquals(0.0, city.maxTemps.get("february")[13]);
	}
}
