

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/*

@author : Niall Martin Ryan

*/

public class DateClass{
	

	public static void main(String [] args){

		Date date = new Date();						// test all the methods in this class
		Date date1 = new Date("2016/06/03 22:10:01");
		Date date2 = new Date("2016/05/01 22:11:59");
		Date test = new  Date("2016/05/02 23:11:59");
		System.out.println("date1 to String : " + dateToString(date1));
		System.out.println("Date test is between date1 and date2 : " + dateInbetween(test,date1,date2));

		String testString = "1994/06/02 10:06:09";
		ArrayList ret = StringDateToElements(testString);
		System.out.println("ELEMENTS SON..");
		for(int i=0;i< ret.size();i++){

			System.out.println(ret.get(i));
		}
		Date testDate = new Date(testString);

		System.out.println("test String to date : " + dateToString(new Date(testString)));
	}

	public static boolean dateInbetween(Date check, Date min, Date max){
		// this works in reverse order apparently....
		return check.before(min) && check.after(max);
	}
	// String format has to be "2015/03/22 24:10:05
	// might not have to implement this one
	public static String dateToString(Date date){
		// might make this a public variable (dateFormat)
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        //to convert Date to String, use format method of SimpleDateFormat class.
        String strDate = dateFormat.format(date);

		return strDate;
	}
	public static ArrayList StringDateToElements(String para){
		ArrayList ret = new ArrayList();
		String [] strings  = para.split(" ");
		String date = strings[0];
		String time = strings[1];
		String [] dateElements = date.split("/");
		String [] timeElements = time.split(":");
		for(int i=0; i<dateElements.length; i++){
			ret.add(Integer.parseInt(dateElements[i]));
		}
		for(int i=0; i<timeElements.length; i++){
			ret.add(Integer.parseInt(timeElements[i]));
		}
		return ret;
	}


}