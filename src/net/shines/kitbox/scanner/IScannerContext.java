package net.shines.kitbox.scanner;

import java.util.List;

public interface IScannerContext 
{
	public void put(String key, Object value);
	public Object get(String key);
	public void clear();
	public List<String> getKeys();
}
