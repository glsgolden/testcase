package com.tiaa.shop.parser;

import java.io.File;

import com.tiaa.shop.model.FoodChain;
import com.tiaa.shop.util.XmlHelper;

public class XMlFileParser implements FileParser {

	public FoodChain getFoodChain(File file) throws Exception {
		
		return XmlHelper.getFromFile(FoodChain.class, file);
	}

}
