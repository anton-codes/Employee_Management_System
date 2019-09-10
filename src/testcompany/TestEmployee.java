package testcompany;

import company.*;
import org.junit.jupiter.api.*;

import java.util.Calendar;

import static org.junit.jupiter.api.Assertions.*;


/**
 * This class is responsible for testing.
 * 
 * Course Name: CST8284 Object Oriented Programming (Computer Programmer).
 * Student name: Anton Hrytsyk.
 * Student number: 040938383
 *
 * Assignment title: Company Management Tool Prototype.
 * Assignment due date: Monday April 14, 2019 by 11:59.
 *
 * Assignment 3
 * package: test
 * EmployeeTest class.
 *
 * @author Anton Hrytsyk
 */


class TestEmployee {

	/**
	 * This block of code will be executed before all tests.
	 */
	@BeforeAll
	public static void setUpBeforeAllTests() {
		System.out.println("Starting tests");
	}


	/**
	 * This block of code will be executed before each test runs.
	 */
	@BeforeEach
	public void setUpBeforeEachTest() {
		System.out.println("Running test");
	}


	/**
	 * This block of code will be executed after all tests.
	 */
	@AfterAll
	public static void tearDownAfterAll() {
		System.out.println("test finished");
	}


	/**
	 * This block of code will be executed after each test is finished.
	 */
	@AfterEach
	public void tearDownAfterEach() {
		System.out.println("Finished testing");
	}


	/**
	 * This method checks that deleteEmployee() returns null
	 * if no employee was found.
	 */
	@Test
	public void testDeleteEmployeeReturnsNull() {
		Company company = new Company();
		assertNull(company.deleteEmployee(-55));
	}
//
//	/**
//	 * This method checks that deleteEmployee method only deletes the first employee with the specified parameter.
//	 *
//	 * Two objects of type Manager with same employee numbers are added to the list.
//	 * assertEquals checks whether second of the two objects is still present after deletion of the first one.
//	 */
//	@Test
//	public void testDeletesFirstEmployeeOnly() {
//
//
//		Company cp = new Company();
//
//		cp.getEmployees().add(cp.addEmployee("name", 2 , new OurDate(), 13000, GUICompanyConsole.MANAGER));
//		cp.getEmployees().add(cp.addEmployee("name2", 2 , new OurDate(), 13000, CompanyConsole.MANAGER));
//		cp.deleteEmployee(2);
//
//		assertEquals(cp.findEmployee(2), new Manager("name2", 2, new OurDate(), 1300));
//
//
//	}

	/**
	 * This method checks that no objects are deleted from the list if the object with the specified parameter wasn't found.
	 * Company default constructor preloads 3 employees into the list.
	 * employee numbers {14, 14, 23}.
	 *
	 * AssertEquals checks that size of the list before the deletion is the same as the size after the deletion.
	 */
	@Test
	public void testNoAccidentalDeleteEmployee() {
		Company cp = new Company();
		int sizeBefore = cp.getEmployees().size();
		cp.deleteEmployee(-11);
		int sizeAfter = cp.getEmployees().size();

		assertEquals(sizeAfter, sizeBefore);

	}

	/**
	 * This method checks correctness of the equals() method in the Temp class.
	 *
	 * Two Temp employee objects are created and compared using .equals
	 * AssertTrue is expected to return true here nice both objects were initialized with the same values.
	 *
	 * After the first equality check endOfContractDate of the second employee is changed.
	 * After the change .equals() is supposed to return false.
	 */
	@Test
	public void testTempEquals() {
		Temp tempEmployee1 = new Temp("George Michael", 1, new OurDate(1, 2, 2003), 100000);
		tempEmployee1.setEndContractDate(new OurDate(1, 2, 2023));

		Temp tempEmployee2 = new Temp("George Michael", 1, new OurDate(1, 2, 2003), 100000);
		tempEmployee2.setEndContractDate(new OurDate(1, 2, 2023));
		// First equality check
		assertTrue(tempEmployee1.equals(tempEmployee2));

		// Updating endContract value
		tempEmployee2.setEndContractDate(new OurDate(2, 3, 2010));
		assertFalse(tempEmployee1.equals(tempEmployee2));
	}



	/**
	 * This test checks correctness of overwritten equals method in Employee class.
	 * Two identical Employee instances were created and checked for equality,
	 * .equals is expected to return true here.
	 */
    @Test
    public void testEmployeeEquals() {

    	Manager emp1 = new Manager("Anton Hrytsyk", 2, new OurDate(1, 1, 2019), 40);
    	Manager emp2 = new Manager("Anton Hrytsyk", 2, new OurDate(1, 1, 2019), 40);

    	emp1.setTitle("CEO");
    	emp2.setTitle("CEO");

        assertEquals(emp1, emp2);

    }


	/**
	 * This test checks correctness of overwritten equals method in Employee class.
	 * Two different Employee instances were created and checked for equality,
	 * .equals is expected to return false here.
	 */
    @Test
    public void testEmployeeNotEquals() {

    	Staff emp1 = new Staff("Frank Sinatra", 1, new OurDate(1, 1, 2010), 20);
    	Staff emp2 = new Staff("Jim Morrison",  2, new OurDate(1, 1, 2019), 20);

    	emp1.setDepartment("Frnk Sinatr");
    	emp2.setDepartment("The Doors");											// The Doors - a truly awesome rock band from the 70s.

        assertFalse(emp1.equals(emp2));

    }

	/**
	 * This test checks whether default constructor of OurDate object works correctly
	 * by comparing values of testObject with the current date values.
	 *
	 * Default constructor of OurDate works properly if
	 * it's values are being initialized to current date values by default.
	 */
	@Test
	public void testDefaultOurDateConstructor() {

		OurDate testObject = new OurDate();

		Calendar calendar = Calendar.getInstance();

		assertTrue(testObject.getDay()      == calendar.get( Calendar.DAY_OF_MONTH)  &&
				testObject.getMonth()       == calendar.get( Calendar.MONTH)+1       &&
				testObject.getYear()        == calendar.get( Calendar.YEAR)            );
	}


	/**
	 * This test checks whether overloaded constructor of OurDate class works properly.
	 * Three test values are being created and assigned to the testObject through the overloaded constructor.
	 *
	 * Overloaded constructor of OurDate works properly if
	 * it assigns values specified in it's parameters
	 * to it's object variables.
	 */
	@Test
	public void testOverloadedOurDateConstructor() {

		int day   = 1;
		int month = 1;
		int year  = 2019;

		OurDate testObject = new OurDate(day, month ,year);
		assertTrue(testObject.getDay() == day       &&
				testObject.getMonth() == month   &&
				testObject.getYear()  == year     );

	}




}//END CLASS TestEmployee

