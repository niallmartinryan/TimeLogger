

import java.util.Date;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.text.DateFormat;

/*


@author : Niall Martin Ryan

*/


public class hiddenTag extends Tag {
	
	public final String hiddenComment;

	public final String hiddenProcess;

	public final String hiddenTitle;

	
	public hiddenTag(int id,Date date, Date startTime,Date endTime, String tagContent){
		super(id, date,startTime,endTime,tagContent);
		hiddenComment = null;
		hiddenProcess = null;
		hiddenTitle = null;

	}







}