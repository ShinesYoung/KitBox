package net.shines.kitbox.scanner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BaseScannerContext implements IScannerContext
{
	private HashMap<String, Object> dataMap;
	
	public BaseScannerContext() 
	{
		this.dataMap = new HashMap<String, Object>();
	}
	
	
	@Override
	public void put(String key, Object value) 
	{
		this.dataMap.put(key, value);
	}

	@Override
	public Object get(String key) 
	{
		return this.dataMap.get(key);
	}

	@Override
	public void clear() 
	{
		this.dataMap.clear();
	}

	@Override
	public List<String> getKeys() 
	{
		List<String> keyList = new ArrayList<String>();
		keyList.addAll(this.dataMap.keySet());
		return keyList;
	}
	
	
}
