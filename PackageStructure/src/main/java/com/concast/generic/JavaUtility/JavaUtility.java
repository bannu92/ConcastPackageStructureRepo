package com.concast.generic.JavaUtility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class JavaUtility {
	public int getRandomNumber()
	{
		Random r=new Random();
		int rint=r.nextInt(5000);
	return rint;
	}

	public String getSystemDateYYYYDDMM()
	{
		Date dt=new Date();
	SimpleDateFormat sdf=new SimpleDateFormat("YYYY-MM-dd");
	String date=sdf.format(dt);
	return date;
	}
	public String getRequiredDateYYYYDDMM(int days)
	{
	Date dt=new Date();
		SimpleDateFormat sim=new SimpleDateFormat("YYYY-MM-dd");
	 String date= sim.format(dt);
		 Calendar c=sim.getCalendar();
		  c.add(Calendar.DAY_OF_MONTH,days);
		  String reqdate=sim.format(c.getTime());
		  return reqdate;
	        
	}
	
}
