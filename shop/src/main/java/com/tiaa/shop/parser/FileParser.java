package com.tiaa.shop.parser;

import java.io.File;

import com.tiaa.shop.model.FoodChain;

public interface FileParser {
	
	FoodChain getFoodChain(File file)  throws Exception;
	

}
