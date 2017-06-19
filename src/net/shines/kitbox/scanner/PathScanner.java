package net.shines.kitbox.scanner;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.List;

public class PathScanner implements IPathScanner
{
	public void scanPath(File targetPath, List<File> aPathList, FileFilter filter)
	{
		if (targetPath == null || aPathList == null) { 
			return; 
		}
		
		List<File> stack = new ArrayList<File>();
		stack.add(targetPath);
		
		while (stack.size() > 0)
		{
			File aPath = stack.remove(stack.size() -1);
			
			if (aPath.isHidden()) // it's a leaf
			{
				continue;
			}
			else if (aPath.isDirectory())
			{
				if (aPath.getName().endsWith(".bundle")) {
					continue;
				}
				
				File[] children = aPath.listFiles(filter);
				for (File aChild : children) 
				{
					stack.add(aChild) ;
				}
			}
			else if (aPath.isFile()) 
			{
				aPathList.add(aPath);
			}
		}
	}
	
}
