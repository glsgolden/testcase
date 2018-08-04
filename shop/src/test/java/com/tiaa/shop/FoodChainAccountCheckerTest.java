package com.tiaa.shop;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.tiaa.shop.service.AccountProcessor;

import junit.framework.Assert;

public class FoodChainAccountCheckerTest {

	@Rule
	public final ExpectedException thrown = ExpectedException.none();
	
	
	
	@Test
	public void testMissMatch() {
		String folderPath = "";
		AccountProcessor accountProcessor = new AccountProcessor();
		try {
			accountProcessor.startProcess(folderPath);
			Assert.assertEquals(2, accountProcessor.getTotalMissMatch());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void testMatch() {
		String folderPath = "";
		AccountProcessor accountProcessor = new AccountProcessor();
		try {
			accountProcessor.startProcess(folderPath);
			Assert.assertEquals(2, accountProcessor.getTotalMatch());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testMatchAndMissMatc() {
		String folderPath = "";
		AccountProcessor accountProcessor = new AccountProcessor();
		try {
			accountProcessor.startProcess(folderPath);
			Assert.assertEquals(2, accountProcessor.getTotalMissMatch());
			Assert.assertEquals(2, accountProcessor.getTotalMatch());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
}
