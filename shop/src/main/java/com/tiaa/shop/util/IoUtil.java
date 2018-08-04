package com.tiaa.shop.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class IoUtil {
	
	public static boolean writeFile(String content, String filePath) throws IOException
	{
		File f = new File(filePath);
		BufferedWriter output = new BufferedWriter(new FileWriter(f));
		output.write(content);
		output.close();
		return true;
	}

}
