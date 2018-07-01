package cmcc.hz.dao;


public class StringTest {
	static int runnum=100000;
	
	public static void main(String[] args) {
		
		String str1=new String("");

		
		StringBuffer strB1=new StringBuffer("");
		
		
		StringTest strtest=new StringTest();
		
		strtest.StringAdd(str1);
		

		
		strtest.StringBufferAppend(strB1);


		
	}
	
	private void StringAdd(String str1) {
		long sttime=System.currentTimeMillis();
		String str3="";
		for (int i = 0; i < runnum; i++) {
			str3+=i;
		}
		long endtime=System.currentTimeMillis()-sttime;
		System.out.println("str1+i:"+endtime);
		System.out.println(str3.length());
	}
	
	private void StringBufferAppend(StringBuffer strB1) {
		long sttime=System.currentTimeMillis();
		//StringBuffer strB3=new StringBuffer("");
		for (int i = 0; i < runnum; i++) {
			strB1.append(i);
		}
		long endtime=System.currentTimeMillis()-sttime;
		System.out.println("strB1.append（i）:"+endtime);
		System.out.println(strB1.length());
	}
	
	
}
