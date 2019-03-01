package Encode;

import java.security.MessageDigest;

public class Md5Encode {

	public static void main(String[] args) {
		
		String str = Encrypt("123456");
		System.out.println(str);
		
	}
	
	
	public static String Encrypt(String str)
	{
		StringBuffer code = new StringBuffer();
		
		MessageDigest md5 = null;
		
		try {
			md5 = MessageDigest.getInstance("MD5");
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}		
		char[] charArr = str.toCharArray();		
		byte[] byteArr = new byte[charArr.length];		
		for(int i = 0;i < charArr.length; i++) {
			byteArr[i] = (byte)charArr[i];			
		}
		
		byte[] md5Arr = md5.digest(byteArr);
				
		for(int i = 0;i < md5Arr.length; i++) {
			int value = (int)md5Arr[i] & 0xff;
			if(value < 16)
			{
				code.append("0");
			}
			code.append(Integer.toHexString(value));
		}
		
		return code.toString();
	}
	

}
