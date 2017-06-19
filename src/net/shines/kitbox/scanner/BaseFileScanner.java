package net.shines.kitbox.scanner;

import java.io.File;
import java.util.List;

public abstract class BaseFileScanner implements IFileScanner 
{
	
	protected IScannerContext context;
	
	
	@Override
	public void scanFiles(List<File> fileList) 
	{
		if (fileList == null) {
			System.out.println("FileScanner : fileList or context is null.");
			return;
		}
		
		for (File aFile : fileList) 
		{
			if (aFile.exists() == false || aFile.isHidden() || aFile.isDirectory()) {
				continue;
			}
			this.scanFile(aFile, this.context);
		}
	}
	
	public IScannerContext getContext()
	{
		return this.context;
	}

}
