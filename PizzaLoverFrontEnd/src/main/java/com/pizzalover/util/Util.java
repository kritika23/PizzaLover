package com.pizzalover.util;

public class Util {
	
	
	
	public static String removeComman(String field)
	{
		return field.replace(",", "");
	}
	
	
	public static void main(String[] args) {
		
		String cid = "dgfrg,gdfth";
		
		System.out.println("cid before remove commaa" +cid);
	
	System.out.println("cid after remove commaa" +removeComman(cid));
	
	
}

}
