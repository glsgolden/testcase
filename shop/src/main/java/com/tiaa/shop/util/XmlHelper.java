package com.tiaa.shop.util;

import java.io.File;

import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

public class XmlHelper
{

	private XmlHelper() {
	}
	
	/**
	 * Get a object from XML file.
	 * 
	 * @param <T>
	 *            : serialized class type
	 * @param path
	 *            : XML file path
	 * @return: a instance
	 * @throws Exception
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static <T> T getFromFile(Class clazz, String path) throws Exception
	{
		try
		{
			Serializer serializer = new Persister();
			File file = new File(path);
			Object object = serializer.read(clazz, file);
			return (T) object;
		}
		catch (Exception e)
		{
			throw e;
		}
		
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static <T> T getFromFile(Class clazz, File file) throws Exception
	{
		try
		{
			Serializer serializer = new Persister();
			Object object = serializer.read(clazz, file);
			return (T) object;
		}
		catch (Exception e)
		{
			throw e;
		}
		
		
	}

	/**
	 * Get a object from XML string.
	 * 
	 * @param <T>
	 *            : serialized class type
	 * @param xmlString
	 *            :XML string
	 * @return: a instance
	 * @throws Exception
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static <T> T getFromString(Class clazz, String xmlString) throws Exception
	{
		if (isBlank(xmlString))
			return null;

		Serializer serializer = new Persister();
		return (T) serializer.read(clazz, xmlString);
	}
	
	
	public static boolean isBlank(String input)
	{
		return input == null || input.trim().length() == 0;
	}



}
