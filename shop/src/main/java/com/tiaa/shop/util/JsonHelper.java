package com.tiaa.shop.util;

import java.io.File;
import java.io.IOException;

import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonHelper {

	private JsonHelper() {
	}



	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static <T> T getFromFile(Class clazz, File path) throws JsonParseException, JsonMappingException, IOException  {
			ObjectMapper mapper = new ObjectMapper();
			mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
//			mapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
			Object obj = mapper.readValue(path, clazz);
			return (T) obj;

	}

	public static void writeToFile(Object obj, File path) throws JsonGenerationException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		mapper.writeValue(path, obj);

	}

}
