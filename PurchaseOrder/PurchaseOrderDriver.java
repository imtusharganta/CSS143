//package PurchaseOrder;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Iterator;

/**
 * HW3.java: Simple driver to test Order, Date, and Order classes
 * 
 * @author Rob Nash, borrowed from cfolsen, revised by Lesley Kalmin
 */
public class PurchaseOrderDriver {

    /**
     * main driver function
     * pre: none
     * post: exercises the methods in Order, Money, and Date (not done)
     */
    public static void main(String[] args) {
        // Construct some money
        // Money money1 = new Money(10, 5);
        // Money money2 = new Money(money1);
        // money1.setMoney(30, 50);
        // System.out.println("money1: " + money1.getMoney());
        // // // TODO: do more functional exercises with the money class

        // Money m = null;
        // System.out.println("null check " + ((m instanceof Money) ? true : false));

        // System.out.println("Money objects output:");
        // System.out.println(money1);
        // System.out.println(money2);

        // Date date = new Date(11, 12, 2021);
        // System.out.println("date1: " + date);

        // // //Construct some orders
        // Money amount = new Money(20);

        // Date orderDate = new Date(4, 30, 2017);
        // Order order1 = new Order(amount, orderDate, "SysAdmin", "USB cable");
        // order1.setFulfilled(new Date(5, 1, 2017));
        // boolean result1 = order1.isFulfilled();
        // Order order2 = new Order(order1);
        // order2.setFulfilled(new Date(5, 1, 2017));
        // amount.setMoney(31, 99);
        // orderDate.setDay(29);
        // Order order3 = new Order(amount, orderDate, "Home Baker", "KitchenAid
        // Mixer");
        // order3.setFulfilled(new Date(4, 5, 2021));

        // // Try bad data with fulfilled date before order date
        // Order order4 = new Order(amount, new Date(1, 1, 2021), "Fitness Buff",
        // "Exercise Bike");
        // boolean result = order4.setFulfilled(new Date(1, 1, 2020));
        // System.out.println("result of bad fulfilled date is " + result);
        // System.out.println();

        // System.out.println("Order objects output:");
        // System.out.println(order1);
        // System.out.println(result1);
        // System.out.println(order1.equals(order2));
        // System.out.println(order2);
        // System.out.println(order3);

        System.out.println("----------- MY TESTS -----------");
        System.out.println();
        System.out.println("          MONEY TESTS           ");
        Money test1 = new Money();
        test1.setMoney(5, 6);
        System.out.println("Expected: $5.06, returned value: " + test1);
        Money test2 = new Money(test1);
        System.out.println("Expected test 1 and test 2 are (TRUE), returned value: " + test1.equals(test2));
        test1.add(7);
        System.out.println("Expected $12.06, returned value: " + test1);
        System.out.println("Expected test 1 and test 2 are (FALSE), returned value: " + test1.equals(test2));
        test1.add(test2);
        System.out.println("Expected $17.12, returned value: " + test1);
        System.out.println("Expected test.getDollars is 17, returned value: " + test1.getDollars());
        Money test3 = new Money(5, 110);
        System.out.println("Expected $6.10, returned value: " + test3);
        test3.add(6, 790);
        System.out.println("Expected $20.00, returned value: " + test3);

        System.out.println("-------------------------------");
        System.out.println("          DATE TESTS           ");
        Date date1 = new Date(1, 21, 2020);
        // testing setting date to other date.
        Date date2 = new Date(date1);
        // testing equals
        System.out.println("Expected true for both dates equaling, returned value: " + date1.equals(date2));
        Date date3 = new Date(2, 3, 2017);
        System.out.println("Expected false for date3 after date1, returned value: " + date1.isAfter(date3));
        // testing getters
        System.out.println("Expected 2 for date3 month, returned value: " + date3.getMonth());
        System.out.println("Expected 3 for date3 day, returned value: " + date3.getDay());
        System.out.println("Expected 2017 for date3 year, returned value: " + date3.getYear());
        date2.setYear(2022);
        System.out.println("Expected date2 is after date1 (TRUE), returned value: " + date1.isAfter(date2));
        System.out.println("Expected date2 and date1 aren't equal (FALSE), returned value: " + date1.equals(date2));
        // testing setAll
        date3.setAll(1, 21, 2020);
        System.out.println("Expected date3 and date1 are equal (TRUE), returned value: " + date1.equals(date3));
        Date date4 = new Date(date2);
        // testing set methods.
        date4.setMonth(1);
        date4.setDay(26);
        date4.setYear(2020);
        System.out.println("Date 4 should print 01/26/2020, returned value: " + date4);

        System.out.println("-------------------------------");
        System.out.println("          ORDER TESTS          ");
        Money newMoney1 = new Money(20, 60);
        Date newDate1 = new Date(10, 31, 2024);
        Order newOrder1 = new Order(newMoney1, newDate1, "BOB", "phone charger");
        // testing isFulfilled null.
        System.out.println("Expected false for if newOrder1 is fulfilled, returned value: " + newOrder1.isFulfilled());
        System.out.println(newOrder1);
        // testing setFulfilled.
        newOrder1.setFulfilled(new Date(11, 24, 2024));
        System.out.println();
        System.out.println("ORDER 1 IS NOW FULFILLED CHECK");
        System.out.println(newOrder1);
        System.out.println("Expected true for if newOrder1 is fulfilled, returned value: " + newOrder1.isFulfilled());
        // testing setOrder date false;
        System.out.println("Expected false for newOrder1 setOrderDate, returned value: "
                + newOrder1.setOrderDate(new Date(1, 22, 2022)));
        // testing getters
        System.out.println("Expected BOB for customer, returned value: " + newOrder1.getCustomer());
        System.out.println("Expected phone charger, returned value: " + newOrder1.getItem());
        System.out.println("Expected $20.60 for price, returned value: " + newOrder1.getAmount());
        System.out.println("Expected 01/22/2022 for date ordered, returned value: " + newOrder1.getOrderDate());
        // testing orderCopy
        Order newOrder2 = new Order(newOrder1);
        System.out.println("Copied order 1");
        System.out.println(newOrder1);
        // we must set a date fulfilled because we never pass in sentDate as a copy.
        newOrder2.setFulfilled(new Date(12, 25, 2023));
        System.out.println(newOrder2);
        // testing settAmount and setCustomer
        newOrder2.setAmount(new Money(35));
        newOrder2.setCustomer("Joe");
        // testing getCustomer and getAmount.
        System.out.println("Expected Joe, returned value: " + newOrder2.getCustomer());
        System.out.println("Expected order amount $35.00, returned value: " + newOrder2.getAmount());
        // test equals
        System.out.println("Expecting false for equal dates, returned value: " + newOrder1.equals(newOrder2));
        System.out.println("-------------------------------");
        System.out.println("          INVALID TESTS        ");
        // fails the creation of test, will display invalid month and exit.
        Date newDateInvalid = new Date(0, 1, 2020);
        System.out.println(newDateInvalid.toString());

    }
}
