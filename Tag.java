

// date imports
import java.util.Date;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.text.DateFormat;



public class Tag{
	
	// checks whether the tag is hidden or not..
	public boolean hidden;	

	public final int id;
	// This will be a date datatype not String
	public final Date dateAdded;

	// This will describe the title of the tag
	// This will be the users description within the tag
	public final String tagContent;

	// This will be the id of a process that might connect 
	// the tag to processes that were active during that session
//	public final String tagConnection;

	// start time the tag is associated with
	public final Date startTime;

	// end time the tag is associated with
	public final Date endTime;



	// Shoould this be private
	public Tag(int id,Date date, Date startTime,Date endTime, String tagContent){
		this.hidden = false;
		this.id = id;
		this.dateAdded = date;
		this.startTime = startTime;
		this.endTime = endTime;
		this.tagContent = tagContent;


	}
	public Tag(int id, Date date, String tagContent){
		this.hidden = false;
		this.id = id;
		this.dateAdded = date;
		this.tagContent= tagContent;
		startTime = null;
		endTime = null;
	}

}