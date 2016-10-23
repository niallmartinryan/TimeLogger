import com.sun.jna.Native;
import com.sun.jna.Pointer;

import com.sun.jna.platform.win32.WinDef.HWND;
import com.sun.jna.ptr.PointerByReference;
import java.util.ArrayList;

// global variable title name of the app.. reaction is to output to the database..
import java.sql.*;
import java.sql.Driver;
import java.sql.DriverManager;

// hashtable
import java.util.Hashtable;

// date imports
import java.util.Date;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.text.DateFormat;


// for printing to the file

import java.io.PrintWriter;
import java.io.File;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.*;
import java.awt.GridBagLayout;

/*
    @author : Niall Martin Ryan

*/
// The app should probably also check that the user isnt idle for a period of time..
 
public class getActiveWindow 
{


  public static final String CONST_NONE = "none";
  public static final String CONST_EMPTY = "";
  public static final String NONE_REPLACE ="Start up";
  public static final String EMPTY_REPLACE = "System" ;
  private static final int MAX_TITLE_LENGTH = 1024;
  private static final int NUMBER_OF_DATA_COLUMNS = 6;

  private static int PACK_COUNT = 0;
  public static int tag_count = 0;

  public static final int MAX_UPPER_STRING_LIMIT = 70;  // So the names dont go off the screen/ get to long

   // WILL NEED A STRING VARIABLE FOR THE PROGRAM RUNNING ITSELF AND ITS PROCESS NAME---

  private static int process_count = 0;
   // date variables
  private static final int DATE_START = 0;
  private static final int DATE_END = 10;
   private static final int TIME_START = 11;
   private static final int TIME_END = 19;
   private static final DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

   public static Hashtable<String, ArrayList<Process>> processHash;
   public static  ArrayList<Tag> tags;         // how do I want to organise this datastructure.. Tag Name?Processes affected?


   // processes -- 
   public static ArrayList<Process> processes;    // this will be in order of how the processes are logged by the system.
   // variable for finding, the process title when the current process is empty.. due to windows 8
   private static final String processTitlePrefix = " - "; 
   
   
   
   // database stuff
   private static final String URL = "jdbc:mysql://localhost:3306/timelogger";
   private static final String USERNAME = "user";
   private static final String PASSWORD = "user";
   public static String lastTitle;
   public static String lastProcess;
   public static String currentTitle;
   public static String currentProcess;

   public static boolean endProgram;

   // printing to a file

  private static PrintWriter writer ;
  private static ArrayList<Process> sessionProcesses;
  public static ArrayList<String> processNames;


  public static void main(String[] args) throws Exception{
    endProgram = false;
    processHash = new Hashtable<>();
    processes = new ArrayList<Process>();
    processNames = new ArrayList<String>();

    // intialising tags
    
    tags = new ArrayList<Tag>();
    GUI.main(null);
    writer = new PrintWriter("TESTINGFILE.txt", "UTF-8");
    lastTitle = "none";
    lastProcess = "none";


    long lastChange = System.currentTimeMillis();

    // will need booleans here.. for whether a comment/ tag is being added to the timeline
    // front end will be dealing with some of this

    boolean panel2set = false;      // to due with updating the comboboxes
    // change this to a variable instead of infinite loop
    Date startDate =  new Date();
    JFrame prevFrame = null;
    Date endDate;
    GUI.frame1.add(new Chart().getChartPanel());
    GUI.frame1.setResizable(true);
    while (true)
    {     
      // EveryIteration check the currentWindow.. and accordingly update information..
      // perhaps a switch statement
      
      // Add Date and time for each process...
      GUI.updateComboBoxProcesses(GUI.p4SelectionBox);
      GUI.updateComboBoxProcesses(GUI.p2ProcessCombo);
     // GUI.currentFrame.pack();

      if(GUI.currentFrame == GUI.frame2){
        if(panel2set ==false){
          GUI.panel2Update();
          panel2set = true;
        }
        //update combo boxes panel 2 
      }
      else{
        panel2set = false;
      }
      // need to update another combobox
      currentTitle = getActiveWindowTitle();
      currentProcess = getActiveWindowProcess();
      // if(prevFrame != GUI.currentFrame ){
      //     if(PACK_COUNT<=3){
      //       GUI.currentFrame.pack();
      //     }
          

      //     PACK_COUNT = 0;
      // }
      prevFrame = GUI.currentFrame;
       if (!lastTitle.equals(currentTitle))
       {    


          // getting time difference
          long change = System.currentTimeMillis();
          long time = (change - lastChange) / 1000;  
          lastChange = change;
          // getting date and time

          endDate = new Date();
          String startDateString = dateFormat.format(startDate);
          
          String dateStart = startDateString.substring(DATE_START,DATE_END);
          String timeStart = startDateString.substring(TIME_START, TIME_END);


          String endDateString = dateFormat.format(endDate);

          String dateEnd = endDateString.substring(DATE_START,DATE_END);
          String timeEnd = endDateString.substring(TIME_START, TIME_END);

          if(lastProcess.equals(CONST_EMPTY) || lastProcess.equals(" ")){
            lastProcess = EMPTY_REPLACE;
          }
          if(lastProcess.equals(CONST_NONE)){
            lastTitle = NONE_REPLACE;
            lastProcess = NONE_REPLACE;
          }
          
          Process newProcess = new Process(process_count,lastTitle,lastProcess,
                      new Date(startDateString), new Date(endDateString), String.valueOf(time));


          processes.add(newProcess);        // these are added to the list in order of time logged
          processNames.add(lastProcess);
          addProcess(newProcess);
          


          // Need to find out the title given when the user is looking at desktop.. or no window in other words..

          //increment process counter
          process_count++;
          
          if(lastTitle.length() > MAX_UPPER_STRING_LIMIT){
            int findBackSlash = findBackSlashCentre(lastTitle);
            
            lastTitle = lastTitle.substring(0, findBackSlash+1) + "\n                 " + 
                                    lastTitle.substring(findBackSlash+1, lastTitle.length());

            lastTitle =  lastTitle + "\n";
          }
          else if(lastTitle.length() > MAX_UPPER_STRING_LIMIT*2){
           // lastTitle = lastTitle.substring(0, MAX_UPPER_STRING_LIMIT*2) + "\n" + 
           //                         lastTitle.substring(MAX_UPPER_STRING_LIMIT, lastTitle.length());
          }
          if(lastProcess.equals("")){

            System.out.println("No process title ...");
            
          }

          
           writer.println("Change! Last title: " + lastTitle + "____ lastProcess: "
            + lastProcess + "____ time: " + time + " seconds");
          // System.out.println("Change! Last title: " + lastTitle + "____ lastProcess: "
          //   + lastProcess + "____ time: " + time + " seconds");
          GUI.output.append("Last title: " + lastTitle + "-- lastProcess: "
            + lastProcess + "-- time: " + time + " seconds\n");
          lastTitle = currentTitle;
          lastProcess = currentProcess;
          Runtime.getRuntime().addShutdownHook(new Thread()
        {
            @Override 
            public void run()
            {   
              if(!endProgram){
                endProgram =true;
                printKeysHashTable();
                System.out.println("Shutting Down");
                writer.close();
                System.exit(1);

              }
                else{

                }

            }
        });
          startDate = new Date();
          PACK_COUNT ++;
     }
     try
     {
          Thread.sleep(1000);
     }
     catch (InterruptedException ex)
     {
          // ignore
     }
  }
      //  
}


  private static void addProcess(Process process){
    if(processHash.containsKey(process.processName)){
      ArrayList<Process> list =  processHash.get(process.processName);
      list.add(process);
    }
    else{
      processHash.put(process.processName, new ArrayList<Process>(Arrays.asList(process)));
    }

    return; // Dont need this
  }
  // public static ArrayList<Tag> getTags(String process){
  //   ArrayList<Tag> ret = new ArrayList<Tag>();
  //   for(int i=0; i<processes.size();i++){
  //     Process currentProcess = processes.get(i);
  //     if(currentProcess.processName.equals(process)){
  //       for(int i=0;i<currentProcess.tags.size();i++){
  //         ret.add(currentProcess.tags.get(i));
  //       }
  //     }
  //   }
  //   return ret;
  // }

  private static void printKeysHashTable(){
    ArrayList<String> arr = Collections.list(processHash.keys());

    Set<String> hs = new HashSet<>();
    hs.addAll(arr);
    arr.clear();
    arr.addAll(hs);
    for(int i=0;i<arr.size();i++){

      System.out.println("key : " + i + " - " + arr.get(i));
    }

    return;
  }
  public static ArrayList<String> getKeysHashTable(){
    ArrayList<String> arr = Collections.list(processHash.keys());

    // add elements to al, including duplicates
    Set<String> hs = new HashSet<>();
    hs.addAll(arr);
    arr.clear();
    arr.addAll(hs);


    return arr;

  }
   // returns all the values of the same process name
  
  public static ArrayList<Process> getProcesses(){

    Collection<ArrayList> collection = new HashSet<ArrayList>(processHash.values());

    ArrayList<ArrayList> arrayArray = new ArrayList<ArrayList>(collection );
    ArrayList<Process> ret = new ArrayList<Process>();
    for(int i=0 ;i< arrayArray.size();i++){
      ArrayList<Process> current = arrayArray.get(i);
      for(int j=0 ;j<current.size();j++){
        ret.add(current.get(j));
      }
    }
    return ret;
  }
  //maybe instead of a String the parameter should be a process..
  public static ArrayList<Process> getProcesses(String processName){
    if(processHash.containsKey(processName)){
      ArrayList<Process> list =  processHash.get(processName);
      return list;
    }
    else{
      return null;
    } 
  }


   // This will return a String of all processes that have been active during the session
  private static ArrayList<Process> getProcessesInSession(){
    ArrayList<Process> ret = new ArrayList<Process>();


      return ret  ;
   }

   private static String getActiveWindowTitle()
   {
        char[] buff = new char[MAX_TITLE_LENGTH * 2];
        HWND foreground = User32DLL.GetForegroundWindow();
        User32DLL.GetWindowTextW(foreground, buff, MAX_TITLE_LENGTH);
        String title = Native.toString(buff);
        return title;
   }

   private static String getActiveWindowProcess()
   {
        char[] buff = new char[MAX_TITLE_LENGTH * 2];
        PointerByReference p = new PointerByReference();
        HWND foreground = User32DLL.GetForegroundWindow();
        User32DLL.GetWindowThreadProcessId(foreground, p);
        Pointer process = Kernel32.OpenProcess(Kernel32.PROCESS_QUERY_INFORMATION | Kernel32.PROCESS_VM_READ, false, p.getValue());
        Psapi.GetModuleBaseNameW(process, null, buff, MAX_TITLE_LENGTH);
        String processName = Native.toString(buff);
        return processName;
   }
   public static String findProcessNameWithinTitle(String title){
    String ret;
    char [] array = title.toCharArray();
    for(int i=0;i<array.length-2;i++){
      if(array[i] == ' ' && array[i+1]== '-' && array[i+2]== ' '){
        System.out.println("---" + array[i] + array[i+1] + array[i+2]);
        ret = title.substring(i, title.length());
        return ret;
      }
    }
    return title;
   }
    
    public static int findBackSlashCentre(String title){
      char backSlash = '\\';
      int offset = 15;
      char [] array = title.toCharArray();
      for(int i=((title.length()/2)-offset); i< ((title.length()/2)+offset); i++){
        if(array[i] == backSlash){
          return i;
        }
      }
      return title.length()-1;
    }
    // returns the Position after immediately after finding the match
    private static int getMatch(String search, String match){
      String check;
      char [] currentCheck = new char[match.length()];
      char [] array = search.toCharArray();
      for(int i=match.length(); i<search.length(); i++ ){
        // probably a faster way of doing this..
        currentCheck[0] = array[i-2];
        currentCheck[1] = array[i-1];
        currentCheck[3] = array[i];
        check = new String(currentCheck, 0 ,currentCheck.length);
        // found match?
        if(check.equals(match)){
          return i+1;
        }

      }

      return -1;      // didnt find...
    } 

 static class Psapi
 {
      static
      {
           Native.register("psapi");
      }

      public static native int GetModuleBaseNameW(Pointer hProcess, Pointer hmodule, char[] lpBaseName, int size);
  }
 
  static class Kernel32{
      static
      {
           Native.register("kernel32");
      }

      public static int PROCESS_QUERY_INFORMATION = 0x0400;
      public static int PROCESS_VM_READ = 0x0010;

      public static native Pointer OpenProcess(int dwDesiredAccess, boolean bInheritHandle, Pointer pointer);
  }

 static class User32DLL{
      static
      {
           Native.register("user32");
      }

      public static native int GetWindowThreadProcessId(HWND hWnd, PointerByReference pref);
      public static native HWND GetForegroundWindow();
      public static native int GetWindowTextW(HWND hWnd, char[] lpString, int nMaxCount);
 }

}
