package com.tiaa.shop.parser;

import java.io.File;

import com.tiaa.shop.model.FoodChain;
import com.tiaa.shop.model.FoodChainHolder;
import com.tiaa.shop.util.JsonHelper;

public class JsonFileParser implements FileParser {

	public FoodChain getFoodChain(File file) throws Exception {
		FoodChainHolder foodChainHolder = JsonHelper.getFromFile(FoodChainHolder.class, file);
		
		FoodChain chain = foodChainHolder.getCmfoodchain();
		
		chain.setOrderList(chain.getOrders().getOrderdetail());
		
		return  foodChainHolder.getCmfoodchain();
	}

}
