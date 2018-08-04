package com.tiaa.shop.util;

import java.io.File;

import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

public class JsonHelper {
	
	private JsonHelper() {
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static <T> T getFromFile(Class clazz, String path) throws Exception
	{
		try
		{
			Serializer serializer = new Persister();
			File file = new File(path);
			Object object = (T) serializer.read(clazz, file);
			return (T) object;
		}
		catch (Exception e)
		{
			throw e;
		}
		
	}
	
}
