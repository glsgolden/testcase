package com.tiaa.shop.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.tiaa.shop.model.BranchSummary;
import com.tiaa.shop.model.FoodChain;
import com.tiaa.shop.model.FoodChainSummary;
import com.tiaa.shop.model.FoodChainSummaryHolder;
import com.tiaa.shop.parser.FileParser;
import com.tiaa.shop.parser.FileParserFactory;
import com.tiaa.shop.util.IoUtil;
import com.tiaa.shop.util.JsonHelper;

public class AccountProcessor {
	
	
	private FoodChainSummary missMatch;
	private FoodChainSummary match;
	
	public AccountProcessor() {
		missMatch = new FoodChainSummary();
		match = new FoodChainSummary();
	}

	public void startProcess(String ftpPath) throws Exception {
		
		
		List<File> files = getAllFiles(ftpPath);
		List<FoodChain> foodChains = parseAllFiles(files);
		tallyShopCollections(foodChains);
		printMissMatchDetails();
		printMatchDetails();
	}
	
	
	private void printMatchDetails() throws IOException {
		FoodChainSummaryHolder summaryHolder = new FoodChainSummaryHolder();
		summaryHolder.setCmfoodchain(missMatch);
		JsonHelper.writeToFile(summaryHolder, new File("D:\\reports\\missmatch.json"));
		
	}

	private void printMissMatchDetails() throws IOException {
		FoodChainSummaryHolder summaryHolder = new FoodChainSummaryHolder();
		summaryHolder.setCmfoodchain(match);
		JsonHelper.writeToFile(summaryHolder, new File("D:\\reports\\match.json"));
	}


	private void tallyShopCollections(List<FoodChain> foodChains) {
		TotalCollectionChecker checker = new TotalCollectionChecker();
		for(FoodChain chain : foodChains) {
			BranchSummary summary = checker.getBranchSummary(chain);
			if(summary.isTotalMatch()){
				match.addBranchSummary(summary);
			}else {
				missMatch.addBranchSummary(summary);
			}
		}
	}


	private List<FoodChain> parseAllFiles(List<File> files) throws Exception {
		
		List<FoodChain> foodChains = new ArrayList<>();
		
		for(File file : files) {
			String fileName =  file.getName();
			String extension = fileName.substring(fileName.lastIndexOf('.') + 1, fileName.length());
			
			FileParser parser = FileParserFactory.getFileParser(extension);
			
			FoodChain chain = parser.getFoodChain(file);
			foodChains.add(chain);
			
		}
		
		return foodChains;
	}


	private List<File> getAllFiles(String ftpPath)
	{
		File ftppath = new File(ftpPath);
		File []files = ftppath.listFiles();
		
		return Arrays.stream(files)
				.filter(f -> f.isFile() && (f.getName().endsWith(".xml") || f.getName().endsWith(".json")))
				.collect(Collectors.toList());
		
	}
	
	public int getTotalMissMatch() {
		return missMatch.getTotalBranchSummary();
	}
	
	public int getTotalMatch() {
		return match.getTotalBranchSummary();
	}
	
	
}
