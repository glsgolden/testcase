package com.tiaa.shop.parser;

import java.io.File;
import java.io.FileNotFoundException;

import com.tiaa.shop.model.FoodChain;

public class JsonFileParser implements FileParser {

	public FoodChain getFoodChain(File file) throws FileNotFoundException {
		return  new FoodChain();
	}

}
