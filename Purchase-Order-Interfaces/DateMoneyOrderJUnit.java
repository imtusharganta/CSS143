
/*
 * JUnit tests for Date, Money, and Bill classes
 * @author Lesley Kalmin
 *  CSS143
 */

//import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

//import org.junit.Test;
import org.junit.jupiter.api.Test;

public class DateMoneyOrderJUnit {

	@Test
	public void ConstructMoneyTest() {
		Money money1 = new Money(10);

		assertEquals(10, money1.getDollars());
	}

	@Test
	public void SetMoneyTest() {
		Money money1 = new Money();

		money1.setMoney(30, 50);
		assertEquals(30, money1.getDollars());
		assertEquals(50, money1.getCents());
	}

	@Test
	public void ConstructMoneyCopyTest() {
		Money money1 = new Money();
		money1.setMoney(10, 40);

		Money money2 = new Money(money1);

		assertEquals(10, money1.getDollars());
		assertEquals(40, money2.getCents());
	}

	@Test
	public void PrintMoneyTest() {
		Money money1 = new Money(10);

		money1.setMoney(30, 50);
		assertEquals("$30.50", money1.toString());

	}

	/**
	 * This changes the year and checks
	 */
	@Test
	public void DateYearSetCheck() {
		Date newYears = new Date(1, 1, 2020);

		newYears.setYear(2021);
		assertEquals("01/01/2021", newYears.toString());
	}

	/**
	 * This changes the money by adding
	 */
	@Test
	public void MoneyAddCheck() {
		Money money = new Money(13, 69);
		money.add(20);
		assertEquals("$33.69", money.toString());
	}

	/**
	 * This checks to change the customer
	 */
	@Test
	public void orderChangeCustomerCheck() {
		Order newOrder = new Order(new Money(16), new Date(2, 23, 2023), "joe", "airpods");
		newOrder.setCustomer("Charlie");
		assertEquals("Charlie", newOrder.getCustomer());
	}




}
