package net.shines.kitbox.scanner;

import java.io.File;
import java.util.List;

public interface IFileScanner 
{
	public void scanFiles(List<File> fileList);
	
	public void scanFile(File aFile, IScannerContext context);
	
	public IScannerContext getContext();
}
