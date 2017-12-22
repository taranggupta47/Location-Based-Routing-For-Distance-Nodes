class Pack
{
	static String subs1;
	static String sub="";
	public static String Pack1(String g1)
	{
		int len=g1.length();
		System.out.println("Length:"+len);
		int len1=len/16;
		System.out.println("Length1:"+len1);
		int len2=len%16;
		int k=16;
		System.out.println("Length2:"+len2);
		int c=0;
		for(int l=0;l<len;l+=16)
		{
			if(k<=len-len2)
			{
				
			String subs = g1.substring(l,k);
			subs1 = subs + "\n";
			sub+=subs1;
			c++;
			k+=16;
			}
		}

		if(len2>0)
		{
			System.out.println("inside ");
			int g =(len- c*16);
			System.out.println("Value:"+g);
			subs1 = g1.substring(c*16,len);
			sub+=subs1;
		}
		System.out.println("Packets:"+sub);
		return sub;
	}
}