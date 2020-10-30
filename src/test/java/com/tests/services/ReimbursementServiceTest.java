package com.tests.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.LinkedList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.gem.models.ReimbursementRequest;
import com.gem.services.ReimbursementService;
import com.github.javafaker.Faker;

public class ReimbursementServiceTest {
	private ReimbursementService rs;
	
	@Before
	public void setup() {
		rs = new ReimbursementService();
	}
	
	@Test
	public void findAllTest() {
		List<ReimbursementRequest> requests = new LinkedList<>();
		requests = rs.findAll();
		assertNotEquals(0, requests.size());
	}
	
	@Test
	public void findByUserIdTest() {
		List<ReimbursementRequest> requests = new LinkedList<>();
		requests = rs.findByUserId(1);
		assertNotEquals(0, requests);
	}
	
	@Test
	public void updateTest() {
		ReimbursementRequest rr = new ReimbursementRequest(23, "Approve", 22);
		ReimbursementRequest rr2 = new ReimbursementRequest(24, "Reject", 22);
		int result = rs.update(rr);
		int result2 = rs.update(rr2);
		assertEquals(0, result);
		assertEquals(0, result2);
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
		result = rs.create(rr);
		result2 = rs.create(rr2);
		result3 = rs.create(rr3);
		result4 = rs.create(rr4);
		result5 = rs.create(rr5);
		
		assertEquals(1, result);
		assertEquals(1, result2);
		assertEquals(1, result3);
		assertEquals(1, result4);
		assertEquals(1, result5);
	}
	
}
