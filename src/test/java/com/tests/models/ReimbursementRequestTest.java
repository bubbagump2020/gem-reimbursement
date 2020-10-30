package com.tests.models;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.sql.Date;

import org.junit.Before;
import org.junit.Test;

import com.gem.models.ReimbursementRequest;

public class ReimbursementRequestTest {
	private ReimbursementRequest rr;
	
	@Before
	public void setup() {
		rr = new ReimbursementRequest();
	}
	
	@Test
	public void noArgConstructorTest() {
		ReimbursementRequest rr2 = null;
		rr2 = new ReimbursementRequest();
		assertNotNull(rr2);
		
	}
	
	@Test
	public void twoArgConstructorTest() {
		ReimbursementRequest rr2 =  null;
		rr2 = new ReimbursementRequest(3, "String");
		assertNotNull(rr2);
		
	}
	
	@Test
	public void threeArgConstructorTest() {
		ReimbursementRequest rr2 = null;
		rr2 = new ReimbursementRequest(4, "String", "string");
		assertNotNull(rr2);
	}
	
	@Test
	public void eightArgConstructorTest() {
		Date date1 = new Date(System.currentTimeMillis());
		Date date2 = new Date(System.currentTimeMillis());
		ReimbursementRequest rr2 = null;
		rr2 = new ReimbursementRequest(5, 4, date1, date2, "String", 3, 2, 1);
		assertNotNull(rr2);
	}
	
	@Test
	public void toStringTest() {
		Date date1 = new Date(System.currentTimeMillis());
		Date date2 = new Date(System.currentTimeMillis());
		ReimbursementRequest rr2 = new ReimbursementRequest(5, 4, date1, date2, "String", 3, 2, 1);
		rr= new ReimbursementRequest(5, 4, date1, date2, "String", 3, 2, 1);
		assertEquals(rr.toString(), rr2.toString());
	}
	
	@Test
	public void setTypeTest() {
		ReimbursementRequest rr2 = new ReimbursementRequest();
		rr2.setType("GEMSTONES");
		assertEquals("GEMSTONES", rr2.getType());
	}
	
	@Test
	public void setStatusTest() {
		ReimbursementRequest rr2 = new ReimbursementRequest();
		rr2.setStatus("ACCEPTED");
		assertEquals("ACCEPTED", rr2.getStatus());
	}
	
	@Test
	public void setIdTest() {
		ReimbursementRequest rr2 = new ReimbursementRequest();
		rr2.setId(3);
		assertEquals(3, rr2.getId());
	}
	
	@Test
	public void setAmountTest() {
		ReimbursementRequest rr2 = new ReimbursementRequest();
		rr2.setAmount(100);
		assertEquals(100, rr2.getAmount());
	}
	
	@Test
	public void setSubmittedTest() {
		Date date = new Date(System.currentTimeMillis());
		ReimbursementRequest rr2 = new ReimbursementRequest();
		rr2.setSubmitted(date);
		assertEquals(date, rr2.getSubmitted());
	}
	
	@Test
	public void setResolvedTest() {
		Date date = new Date(System.currentTimeMillis());
		ReimbursementRequest rr2 = new ReimbursementRequest();
		rr2.setResolved(date);
		assertEquals(date, rr2.getResolved());
	}
	
	@Test
	public void setDescriptionTest() {
		ReimbursementRequest rr2 = new ReimbursementRequest();
		rr2.setDescription("Hi");
		assertEquals("Hi", rr2.getDescription());
	}
	
	@Test
	public void setDwarfMinerIdTest() {
		ReimbursementRequest rr2 = new ReimbursementRequest();
		rr2.setDwarfMinerId(5);
		assertEquals(5, rr2.getDwarfMinerId());
	}
	
	@Test
	public void setDwarfOverseerIdTest() {
		ReimbursementRequest rr2 = new ReimbursementRequest();
		rr2.setDwarfOverseerId(22);
		assertEquals(22, rr2.getDwarfOverseerId());
	}
	
}
