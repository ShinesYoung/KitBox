package net.shines.kitbox.digest;

import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class DigestUtils 
{
	public static String encodeByMD5(String plainText)
	{
		byte[] bInput = plainText.getBytes(Charset.forName("UTF-8"));
		byte[] bOutput = DigestUtils.encodeByMD5(bInput);
		
		StringBuffer buff = new StringBuffer("");  
        for (int offset = 0; offset < bOutput.length; offset++) 
        {  
            int i = bOutput[offset];  
            if (i < 0) {  
            	i += 256;  
            }
            if (i < 16) {
            	buff.append("0");  
            }
            buff.append(Integer.toHexString(i));
        }
		return buff.toString();
	}
	
	public static byte[] encodeByMD5(byte[] bInput) 
	{
        //确定计算方法
        MessageDigest md5 = null;
        byte[] output = null;
		try {
			md5 = MessageDigest.getInstance("MD5");
			md5.update(bInput);
			output = md5.digest();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
        return output;
    }
}
