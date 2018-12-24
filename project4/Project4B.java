package project4;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
public class Project4B 
{

       public static void main(String[] args)  throws ParseException
       { 
//    	   SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
//    	   Scanner s1 = new Scanner(System.in);
//    	   String s =s1.toString();
//    	   Date c1 =new Date();
    	   time t1 = new time();
       }
}
class time
{
	
	private Date beginTime;
	private Date currentTime;
	private long h;
	private long min;
	private long s;
	public time() throws ParseException
	{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
		
		  beginTime=sdf.parse("1970-01-01 00:00:00"); 
		  currentTime=new Date();  
		  long interval=(currentTime.getTime()-beginTime.getTime());
		  h = interval /3600000;
		  min = (interval-h*3600000)/60000;
		  s = (interval -h*3600000 - min*60000)/1000;
		  System.out.println(h+"h"+min+"min"+s+"s");
	}
	public time (Date cTime) throws ParseException
	{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
		 beginTime=sdf.parse("1970-01-01 00:00:00"); 
		 currentTime = cTime;
		  long interval=(currentTime.getTime()-beginTime.getTime());
		  h = interval /3600000;
		  min = (interval-h)/60000;
		  s = (interval -h - min)/1000;
		  
		  System.out.println(h+"h"+min+"min"+s+"s");
}
}
