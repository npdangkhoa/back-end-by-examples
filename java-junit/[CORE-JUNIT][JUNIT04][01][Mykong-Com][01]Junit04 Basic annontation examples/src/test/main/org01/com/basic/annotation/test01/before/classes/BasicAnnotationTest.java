package org01.com.basic.annotation.test01.before.classes;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class BasicAnnotationTest {
	@BeforeClass
	public static void testBeforeAll() {
		System.out.println("Run once BEFORE any of the test methods in the class");
	}

	@AfterClass
	public static void testAfterAll() {
		System.out.println("Run once AFTER all the tests in the class have been run");
	}
	
	@Before
	public void testBefore() {
		System.out.println("Run BEFORE @Test");
	}
	
	@After
	public void testAfter() {
		System.out.println("Run AFTER @Test");
	}
	
	@Test
	public void test_method_1() {
		System.out.println("@Test: This is the test method to run");
	}
	
	@Test
	public void test_method_2() {
		System.out.println("@Test: This is the test method to run");
	}
}
