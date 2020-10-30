package com.tests.daos;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import java.util.LinkedList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.gem.daos.ReimbursementDao;
import com.gem.models.ReimbursementRequest;
import com.github.javafaker.Faker;

public class ReimbursementRequestDaoTest {
	private ReimbursementDao rd;
	
	@Before
	public void setup() {
		rd = new ReimbursementDao();
	}
	
	@Test
	public void createTest() {
		int result = 0;
		int result2 = 0;
		int result3 = 0;
		int result4 = 0;
		int result5 = 0;
		Faker faker = new Faker();
		ReimbursementRequest rr = new ReimbursementRequest(100, faker.beer().malt(), "GEMSTONES",  1);
		ReimbursementRequest rr2 = new ReimbursementRequest(100, faker.beer().malt(), "METAL",  1);
		ReimbursementRequest rr3 = new ReimbursementRequest(100, faker.beer().malt(), "STONE",  1);
		ReimbursementRequest rr4 = new ReimbursementRequest(100, faker.beer().malt(), "TROPHY",  1);
		ReimbursementRequest rr5 = new ReimbursementRequest(100, faker.beer().malt(), "DIRT",  1);
		result = rd.create(rr);
		result2 = rd.create(rr2);
		result3 = rd.create(rr3);
		result4 = rd.create(rr4);
		result5 = rd.create(rr5);
		
		assertEquals(1, result);
		assertEquals(1, result2);
		assertEquals(1, result3);
		assertEquals(1, result4);
		assertEquals(1, result5);
	}
	
	@Test
	public void updateTest() {
		ReimbursementRequest rr = new ReimbursementRequest(23, "Approve", 22);
		ReimbursementRequest rr2 = new ReimbursementRequest(24, "Reject", 22);
		int result = rd.update(rr);
		int result2 = rd.update(rr2);
		assertEquals(0, result);
		assertEquals(0, result2);
	}
	
	@Test
	public void findAllTest() {
		List<ReimbursementRequest> allRr = new LinkedList<>();
		allRr = rd.findAll();
		assertNotNull(allRr);
	}
	
	@Test
	public void findByUserId() {
		int userId = 1;
		List<ReimbursementRequest> allRr = new LinkedList<>();
		allRr = rd.findByUserId(userId);
		assertNotEquals(0, allRr.size());
	}
}
