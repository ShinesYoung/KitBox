package net.shines.kitbox.parser;

import java.io.File;
import java.util.Map;

public interface IFileParser 
{
	public Map<String, Object> parse(File aFile, String fileContent);
}
