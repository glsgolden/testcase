package com.tiaa.shop.launcher;
import com.tiaa.shop.service.AccountProcessor;

public class Launcher {

	public static void main(String[] args) {
		String ftpPath = "C:\\ftp\\";
		
		if(args.length > 0){
			ftpPath = args[0];
		}
		
		AccountProcessor processor = new AccountProcessor();
		try {
			processor.startProcess(ftpPath);
		} catch (Exception e) {
		}
		
	}
}
