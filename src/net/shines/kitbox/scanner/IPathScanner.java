package net.shines.kitbox.scanner;

import java.io.File;
import java.io.FileFilter;
import java.util.List;

public interface IPathScanner 
{
	public void scanPath(File targetPath, List<File> aPathList, FileFilter filter);
}
