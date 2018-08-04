package com.tiaa.shop.parser;

public class FileParserFactory {
	
	private FileParserFactory()
	{
		
	}

	public static FileParser getFileParser(String fileExtension)
	{
		FileParser parser = null;
		
		switch(fileExtension.toLowerCase())
		{
		case "xml" :
				parser = new XMlFileParser();
				break;
		case "json" :
				parser = new JsonFileParser();
				break;
		default:
				parser = new XMlFileParser();
				break;
		}
		
		return parser;
	}
	
}
