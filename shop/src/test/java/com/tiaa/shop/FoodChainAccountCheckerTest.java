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
		String folderPath = "D:\\Ganesh\\Workspace\\GIT\\tiaa_foodchain\\Testing\\missmatch\\";
		AccountProcessor accountProcessor = new AccountProcessor();
		try {
			accountProcessor.startProcess(folderPath);
			Assert.assertEquals(4, accountProcessor.getTotalMissMatch());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void testMatch() {
		String folderPath = "D:\\Ganesh\\Workspace\\GIT\\tiaa_foodchain\\Testing\\match\\";
		AccountProcessor accountProcessor = new AccountProcessor();
		try {
			accountProcessor.startProcess(folderPath);
			Assert.assertEquals(4, accountProcessor.getTotalMatch());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testMatchAndMissMatc() {
		String folderPath = "D:\\Ganesh\\Workspace\\GIT\\tiaa_foodchain\\Testing\\mix\\";
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
