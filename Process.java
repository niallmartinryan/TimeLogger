

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/*

@author : Niall Martin Ryan


*/

public class Process{

	public final int id;
	public String title;
	public String processName;
	public String elapsedTime;
	public Date startDate;
	public Date endDate;
	public ArrayList<Tag> tags;
	public ArrayList<hiddenTag> hiddenTagsOnly;

	public Process(int id, String title, String process, Date startDate, Date endDate, String lengthOfTime){
		this.id = id;
		this.title = title;
		this.processName = process;
		this.startDate = startDate;
		this.endDate = endDate;
		this.elapsedTime = lengthOfTime;
		tags = new ArrayList<Tag>();
		hiddenTagsOnly = new ArrayList<hiddenTag>();
	}

	public void addTag(Tag tagToAdd){
		tags.add(tagToAdd);
	}
	public void addHiddenTag(){

		return;
	}
	public ArrayList<Tag> getTags(){
		ArrayList<Tag> ret =  new ArrayList<Tag>();

		return ret;
	}
	// This will take in a String or a date/time
	public ArrayList<Tag> getTags(Date date){
		ArrayList<Tag> ret = new ArrayList<Tag>();

		return ret;
	}
	public ArrayList<Tag> getTags(String process){
		ArrayList<Tag> ret = new ArrayList<Tag>();

		return ret;
	}



}