package com.tiaa.shop.service;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.tiaa.shop.model.FoodChain;
import com.tiaa.shop.parser.FileParser;
import com.tiaa.shop.parser.FileParserFactory;

public class AccountProcessor {
	
	private List<FoodChain> missmatch;
	private List<FoodChain> match;

	public void startProcess(String ftpPath) throws Exception {
		
		
		List<File> files = getAllFiles(ftpPath);
		List<FoodChain> foodChains = parseAllFiles(files);
		tallyShopCollections(foodChains);
		printMissMatchDetails();
		printMatchDetails();
	}
	
	
	private void printMatchDetails() {
		throw new UnsupportedOperationException();
	}

	private void printMissMatchDetails() {
		throw new UnsupportedOperationException();
	}


	private void tallyShopCollections(List<FoodChain> foodChains) {
		TotalCollectionChecker checker = new TotalCollectionChecker();
		for(FoodChain chain : foodChains) {
			if(checker.checkTotalCollection(chain)){
				match.add(chain);
			}else {
				missmatch.add(chain);
			}
		}
	}


	private List<FoodChain> parseAllFiles(List<File> files) throws Exception {
		
		List<FoodChain> foodChains = new ArrayList<>();
		
		for(File file : files) {
			String fileName =  file.getName();
			String extension = fileName.substring(fileName.lastIndexOf('.'), fileName.length());
			
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
		return missmatch == null ? 0 : missmatch.size();
	}
	
	public int getTotalMatch() {
		return match == null ? 0 : match.size();
	}
	
	
}
