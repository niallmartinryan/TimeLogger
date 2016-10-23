
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.*;
import java.util.Date;
import java.util.Calendar;

import java.awt.event.*;

import javax.swing.text.DefaultCaret;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import java.util.ArrayList;
import java.util.Arrays;
import java.awt.GridBagLayout;


/*
    
    @author : Niall Martin Ryan

    
    Panel 1 will be a panel in which the user can select what type of way they wish to add tags/ a tag.. depending
    on their personal preference.. Ill give 2/3 options.. which will be connected to panels 2/3/5/6 if needed..



    Panel 4 will be a panel in which the user can select a process from a menu and all of the sessions
    that match that process will come up in a box, hopefully the user will be able to select these 
    matches and see tags that are available to that session.

*/
public class GUI
{
    private static String ENTER = "Tag";
    private static String START_TIME = "Start time";
    private static String END_TIME = "End time";

    public static JPanel inputpanel;

    public static JFrame currentFrame;
    // Main
    public static JButton enterButton;

    public static JButton panel1Button;
    public static JButton panel2Button;
    public static JButton panel3Button;
    public static JButton panel4Button;
    public static JButton panel5Button;

    // panelSwitching variables
    public static JButton switchPanel1;
    public static JButton switchPanel2;
    public static JButton switchPanel3;
    public static JButton switchPanel4;
    public static JButton switchPanel5;


    public static JTextArea output;
    public static JTextArea startTimeBox;
    public static JTextArea endTimeBox;

    public static JTextField input;
    public static JTextField inputStartTime;
    public static JTextField inputEndTime;
    public static JFrame frame;
    public static JFrame frame1;
    public static JFrame frame2;
    public static JFrame frame3;
    public static JFrame frame4;
    public static JFrame frame5;


    


    public static JPanel panelControl;
    public static JPanel panel1;
    public static JPanel panel2;
    public static JPanel panel3;
    public static JPanel panel4;
    public static JPanel panel5;

    //panel1

    public static JTextField p1Input;

    //panel2 adding tags
    public static JButton tagButton;
    public static JCheckBox p2CheckBox;
    public static JCheckBox p2CheckBox2;
    public static JLabel p2TagByProcess;
    public static JLabel p2TagByTime;
    public static JLabel p2TagByTitle;
    public static JLabel p2PreviousComments;
    public static JCheckBox p2CheckBoxHidden;

    public static JComboBox p2PrevComsCombo;

    public static JLabel p2StartDate;
    public static JLabel p2StartTime;
    public static JLabel p2EndDate;
    public static JLabel p2EndTime;

    public static JComboBox p2ProcessCombo;
    public static JComboBox p2Date1, p2Date2, p2Date3, p2Time1, p2Time2, p2Date4, p2Date5, p2Date6, p2Time3, p2Time4;
    public static JComboBox p2TitleCombo;


    public static JTextField p2InputComment;

    //panel3



    //panel4
    public static JTextArea p4Output;
    public static JComboBox p4SelectionBox;
    public static JTextField p4ProcessCount;
    public static JTextField p4ProcessSelect;


    //panel5
    public static JLabel p5OutLabel;
    public static JComboBox p5Combo;
    public static JTextArea p5Output;


    //

    public static ArrayList<JFrame> frames;
    public static ArrayList<JPanel> panels;
    public static ArrayList<GridBagConstraints> grids; 
    public static String testString = "test";

    public static void main(String[] args)
    {
        try
        {   
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
        createFrame();
    }

    public static void createFrame()
    {   
              // will have to continuously update this comboBox when currentFrame is 4..
        grids = new ArrayList<GridBagConstraints>();
        panels = new ArrayList<JPanel>();
        frame = new JFrame("Time Logger - Main Menu");
        currentFrame = frame;
        frame.setSize(1100,400);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);


        panelControl = new JPanel();
        panelControl.setLayout(new BoxLayout(panelControl, BoxLayout.Y_AXIS));
        panelControl.setOpaque(true);
        ButtonListener buttonListener = new ButtonListener();
        frames = new ArrayList<JFrame>();

        frames.addAll(Arrays.asList(frame,frame1 = new JFrame("Frame 1"), frame2 = new JFrame("Frame 2"), frame3 = new JFrame("Frame 3"),
             frame4 = new JFrame("Frame 4"), frame5 = new JFrame("Frame 5")));
        panels.addAll(Arrays.asList(panel1 = new JPanel(),panel2 = new JPanel(), 
                panel3 = new JPanel(), panel4 = new JPanel(), panel5 = new JPanel()));
        panel1.setLayout(new GridBagLayout());
        for(int i=0; i<5;i++){
            grids.add(new GridBagConstraints());
        }

        
        //
        //intialisePanels() was here..

        output = new JTextArea(15, 100);
        output.setWrapStyleWord(true);
        output.setEditable(false);
        JScrollPane scroller = new JScrollPane(output);
        scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        inputpanel = new JPanel();
        inputpanel.setLayout(new FlowLayout());
     //   input = new JTextField(20);
        p1Input = new JTextField(30);
//        inputStartTime = new JTextField(20);
//        inputEndTime = new JTextField(20);
//        enterButton = new JButton("Tag");           // should be enter
//        enterButton.setActionCommand(ENTER);
//        enterButton.addActionListener(buttonListener);



        // enterButton.setEnabled(false);

 //       input.setActionCommand(ENTER);
 //       input.addActionListener(buttonListener);

//        inputStartTime.setActionCommand(ENTER);
//        inputStartTime.addActionListener(buttonListener);

//        inputEndTime.setActionCommand(ENTER);
//        inputEndTime.addActionListener(buttonListener);

        DefaultCaret caret = (DefaultCaret) output.getCaret();
        caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
        panelControl.add(scroller);

        // add buttons to all panels   

        // UNCOMMENT THIS WHEN NEEDED.... ADDS BUTTIONS

//        inputpanel.add(input);
//        inputpanel.add(enterButton);

//        inputpanel.add(inputStartTime);
//        inputpanel.add(inputEndTime);

        panelControl.add(inputpanel);
   //     frame.getContentPane().add(BorderLayout.CENTER, panelControl);
        for(int i=0,j=1;i<panels.size();i++, j++){
            JFrame curFrame = frames.get(j);
            JPanel curPanel = panels.get(i);
            curFrame.setContentPane(curPanel);
            curPanel.setLayout(new GridBagLayout());
            curFrame.setSize(900, 400);
            curFrame.setLocationByPlatform(true);
            curFrame.setLocationRelativeTo(null);
            curFrame.setResizable(true);       
            curFrame.setVisible(false);
//            curFrame.pack();
        }

        intialisePanelButtons(panels, frames, grids);
        intialiseMainButtons(panels, grids);
        intialisePanels(panels, frames, grids);
        for(int i=0;i<frames.size();i++){
            frames.get(i).setSize(900,400);
        }
        frame1.setContentPane(panel1);
        frame1.setLocationByPlatform(true);
        frame1.setResizable(false);
        frame.setContentPane(panelControl);

        frame.setLocationByPlatform(true);
        // Center of screen
        // frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setResizable(true);

   //     input.requestFocus();
//        inputStartTime.requestFocus();
    }
    //
    public static class ButtonListener implements ActionListener
    {
        // This is called when the button is pressed...
        public void actionPerformed(final ActionEvent ev)
        {
            frame.setVisible(false);
            frame1.setVisible(true);
            //CardLayout cardLayout = (CardLayout) panel1.getLayout();
            //    cardLayout.next(panel1);
//            System.out.println(inputStartTime.getText()+"\n");
 //           System.out.println(inputEndTime.getText()+ "\n");



 /*           if (!input.getText().trim().equals("")&& !inputStartTime.getText().trim().equals("")){
                String cmd = ev.getActionCommand();
                if (ENTER.equals(cmd)){

                    
                    output.append("Tag added - " + "\"" +input.getText()+"\""+ " - Start time : "+
                             inputStartTime.getText()+ " - End Time : "+inputEndTime.getText()+"\n");

                }
                // String cmd = ev.getActionCommand();
                // if (ENTER.equals(cmd))
                // {
                //     output.append(input.getText());
                //     if (input.getText().trim().equals(testString)) output.append(" = " + testString);
                //     else output.append(" != " + testString);
                //     output.append("\n");
                // }
            }
            else{

                output.append("Please fill in criteria for tag\n");
          }
 */ 
            input.setText("");
//            inputStartTime.setText("");
            input.requestFocus();
//            inputEndTime.setText("");
        }
    }
    // intialising frames  
    public static void intialiseFrame(JFrame frame){

    }
    // This will switch between the different frames available making one visible at a time
    public static void switchFrames(JFrame off, JFrame on){



    }



    public static void intialisePanels(ArrayList<JPanel> panels, ArrayList<JFrame> frames, ArrayList<GridBagConstraints> grids){
        intialisePanel1(panels.get(0));
        intialisePanel2(panels.get(1), frames.get(2), grids.get(1));
        intialisePanel3(panels.get(2));
        intialisePanel4(panels.get(3), frames.get(4), grids.get(3));
        intialisePanel5(panels.get(4));
    }
    // 
    public static void intialisePanel1(JPanel panel){
        frame3.add(new Chart().getChartPanel());
    }
    //    public static JTextField p2Input;
    //    public static JComboBox p2ProcessBox;
    //    public static JTextField p2InputTime;
    //    public static JTextField p2InputDate;



    // TAGS adding/removing tags.. Make this the main screen at the end...
    public static void intialisePanel2(JPanel panel , JFrame frame ,  GridBagConstraints gbc){
        // ADD SOMETHING WHERE THE USER CAN ADD A TAG QUICKLY
    // public static JTextField p2TagByProcess;
    // public static JTextField p2TagByTime;
    // public static JTextField p2TagByTitle;

    // public static JTextField p2StartDate;
    // public static JTextField p2StartTime;
    // public static JTextField p2EndDate;
    // public static JTextField p2EndTime;

    // public static JComboBox p2ProcessCombo;
    // public static JComboBox p2Date1, p2Date2, p2Date3, p2Time1, p2Time2, p2Date4, p2Date5, p2Date6, p2Time3, p2Time4;
    // public static JComboBox p2TitleComob;



    // public static JTextField p2InputComment;
        // panel.setLayout(new GridBagLayout());

        p2CheckBox = new JCheckBox("Enable title filter", true);
        p2CheckBox2 =  new JCheckBox("Enable process filter", false);
        p2CheckBoxHidden =  new JCheckBox("Enable Hidden Tag", false);
//        p2CheckBox3 =  new JCheckBox("Enable time filter");

        tagButton = new JButton("TAG!");
        tagButton.addActionListener( new ActionListener()
        {
             public void actionPerformed(ActionEvent e)
            {   
                Date date1 = getDateFromComboBoxes(new ArrayList<JComboBox>(Arrays.asList(p2Date1,p2Date2,p2Date3,p2Time1,p2Time2)));
                Date date2 = getDateFromComboBoxes(new ArrayList<JComboBox>(Arrays.asList(p2Date4,p2Date5,p2Date6,p2Time3,p2Time4)));
                String dateString1 = DateClass.dateToString(date1);
                String dateString2 = DateClass.dateToString(date2);
                if(p2CheckBox2.isSelected()&& p2CheckBox.isSelected()){
                    
                    if(dateString1.equals(dateString2)){
                        // tag all the titles that are selected
                       String process = (String) p2ProcessCombo.getSelectedItem();
                       String title = (String) p2TitleCombo.getSelectedItem();
                       Tag tagToAdd = new Tag(getActiveWindow.tag_count,new Date(),new Date(dateString1),new Date (dateString2), p2InputComment.getText() );
                       ArrayList<Process> processes = getActiveWindow.getProcesses(process);
                       for(int i=0;i< processes.size();i++){
                        Process currentProcess = processes.get(i);
                        if(title.equals(currentProcess.title)){
                            currentProcess.tags.add(tagToAdd);
                            getActiveWindow.tags.add(tagToAdd);
                        }
                       }
                    }

                    else{
                        String process = (String) p2ProcessCombo.getSelectedItem();
                        String title = (String) p2TitleCombo.getSelectedItem();
                       Tag tagToAdd = new Tag(getActiveWindow.tag_count,new Date(),new Date(dateString1), new Date(dateString2), p2InputComment.getText() );
                       ArrayList<Process> processes = getActiveWindow.getProcesses(process);
                       for(int i=0;i< processes.size();i++){
                        Process currentProcess = processes.get(i);
                        if(title.equals(currentProcess.title)){
                            if(DateClass.dateInbetween(currentProcess.startDate, date1, date2)
                             || DateClass.dateInbetween(currentProcess.endDate, date1,date2)){
                            processes.get(i).tags.add(tagToAdd);
                            getActiveWindow.tags.add(tagToAdd);
                            }
                        }
                        
                       }

                        //tag all titles that are selected within the time frame..
                    }
              }
              else if(p2CheckBox.isSelected()){

                if(dateString1.equals(dateString2)){
                    String process = (String) p2ProcessCombo.getSelectedItem();
                    ArrayList<Process> processes = getActiveWindow.getProcesses(process);
                    Tag tagToAdd =  new Tag(getActiveWindow.tag_count, new Date(), p2InputComment.getText());
                    for(int i=0 ;i< processes.size(); i++){
                        processes.get(i).tags.add(tagToAdd);
                        getActiveWindow.tags.add(tagToAdd);
                    }
                        // tag all the processes that are selected
                    
                }
                else{
                    String process = (String) p2ProcessCombo.getSelectedItem();
                    ArrayList<Process> processes = getActiveWindow.getProcesses(process);
                    Tag tagToAdd = new Tag(getActiveWindow.tag_count, new Date(), new Date(dateString1), new Date( dateString2), p2InputComment.getText());
                    for(int i=0; i< processes.size(); i++){
                        Process currentProcess = processes.get(i);
                        if(DateClass.dateInbetween(currentProcess.startDate, date1, date2)
                             || DateClass.dateInbetween(currentProcess.endDate, date1,date2)){
                            currentProcess.tags.add(tagToAdd);
                        getActiveWindow.tags.add(tagToAdd);
                        }
                    }
                        // tag all the processes within the timeframe.
                }
              }
            
              else if(dateString1.equals(dateString2)==false){
                ArrayList<Process> processes = getActiveWindow.getProcesses();
                Tag tagToAdd = new Tag(getActiveWindow.tag_count, new Date(), new Date(dateString1), new Date(dateString2), p2InputComment.getText());
                for(int i=0 ;i<processes.size();i++){
                    Process currentProcess = processes.get(i);
                    if(DateClass.dateInbetween(currentProcess.startDate, date1, date2)
                             || DateClass.dateInbetween(currentProcess.endDate, date1,date2)){
                        currentProcess.tags.add(tagToAdd);
                        getActiveWindow.tags.add(tagToAdd);
                    }
                }
                    // tag all the processes within the timeframe only..
                }
                p2InputComment.setText("Tag Added");
          
        }
        });

        p2TagByTitle = new JLabel("Tag by Title", JLabel.CENTER);
        p2TagByTime = new JLabel("Tag by Time",  JLabel.CENTER);
        p2TagByProcess =  new JLabel("Tag by Process",  JLabel.CENTER);

        p2ProcessCombo = new JComboBox();
        p2TitleCombo =  new JComboBox();

        // TEXT FIELDS SHOULD BE LABELS..
        p2StartTime = new JLabel("Start Time",JLabel.CENTER );
        p2StartDate = new JLabel("Start Date" ,JLabel.CENTER);
        p2EndDate = new JLabel("End Date",JLabel.CENTER);
        p2EndTime = new JLabel("End Time",JLabel.CENTER);
        p2InputComment = new JTextField(15);
        Date currentDate = Calendar.getInstance().getTime();
        String currentDateString = DateClass.dateToString(currentDate);
        System.out.println(currentDateString);
        ArrayList dateArray = DateClass.StringDateToElements(currentDateString);



        // this is not going to be pretty..
        p2Date4 = new JComboBox();
        p2Date5 = new JComboBox();
        p2Date6 = new JComboBox();
        p2Date1 = new JComboBox();
        for(int i=1; i<32; i++){
            p2Date1.addItem(i);
            p2Date4.addItem(i);
        }
        p2Date1.setSelectedItem(p2Date1.getItemAt(( (Integer)dateArray.get(2)-1) ));
        p2Date4.setSelectedItem(p2Date4.getItemAt(( (Integer)dateArray.get(2)-1) ));
        p2Date2 = new JComboBox();
        for(int i=1;i<13;i++){
            p2Date2.addItem(i);
            p2Date5.addItem(i);
        }
        p2Date2.setSelectedItem(p2Date2.getItemAt(( (Integer)dateArray.get(1)-1) ));     // dont have to do this twice.
        p2Date5.setSelectedItem(p2Date5.getItemAt(( (Integer)dateArray.get(1)-1) ));
        p2Date3 = new JComboBox();
        for(int i=0; i<2018;i++){
            p2Date3.addItem(i);
            p2Date6.addItem(i);
        }
        p2Date3.setSelectedItem(p2Date3.getItemAt(( (Integer)dateArray.get(0))));
        p2Date6.setSelectedItem(p2Date6.getItemAt(( (Integer)dateArray.get(0))));
        p2Time1 = new JComboBox();
        p2Time2 = new JComboBox();
        p2Time3 = new JComboBox();
        p2Time4 = new JComboBox();
        for(int i=0;i<25;i++){
            p2Time1.addItem(i);
            p2Time3.addItem(i);
        }
        p2Time1.setSelectedItem(p2Time1.getItemAt(( (Integer)dateArray.get(3))));
        p2Time3.setSelectedItem(p2Time3.getItemAt(( (Integer)dateArray.get(3))));
        for(int i=0;i<60;i++){
            p2Time2.addItem(i);
            p2Time4.addItem(i);
        } 
        p2Time2.setSelectedItem(p2Time2.getItemAt(( (Integer)dateArray.get(4))));
        p2Time4.setSelectedItem(p2Time4.getItemAt(( (Integer)dateArray.get(4))));

        // Comboboxes should be set to the current Date
        //       
        p2InputComment.setEditable(true);
        p2InputComment.setText("Comment");
        // edit labels


        p2ProcessCombo.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
            //ArrayList<String> processNames = getActiveWindow.getKeysHashTable();

            ArrayList<Process> processTitles =  getActiveWindow.getProcesses((String)((JComboBox) e.getSource()).getSelectedItem());
            updateComboBoxTitlesP2(p2TitleCombo);

            //p4Output.setText("");
            // for(int i=0 ;i<processTitles.size();i++ ){
            //     Process current = processTitles.get(i);
            //     p4Output.append(current.title+ ": " + DateClass.dateToString(current.startDate) +" - " + DateClass.dateToString(current.endDate) + "\n");
            // }
            //p4ProcessCount.setText("Number of processes : "+ processTitles.size());
            frames.get(2).pack();
          }
        });

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(20,20,1,1);
        panel.add(p2TagByProcess, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(p2ProcessCombo, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(p2TagByTime, gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        panel.add(p2StartDate, gbc);

        gbc.gridx = 4;
        gbc.gridy = 3;
        panel.add(p2StartTime, gbc);

        gbc.gridx = 7;
        gbc.gridy = 3;
        panel.add(p2EndDate, gbc);

        gbc.gridx = 10;
        gbc.gridy = 3;
        panel.add(p2EndTime, gbc);

        gbc.gridx = 1;
        gbc.gridy = 4;
        panel.add(p2Date1, gbc);
        gbc.gridx = 2;
        gbc.gridy = 4;
        panel.add(p2Date2, gbc);
        gbc.gridx = 3;
        gbc.gridy = 4;
        panel.add(p2Date3, gbc);
        gbc.gridx = 4;
        gbc.gridy = 4;
        panel.add(p2Time1, gbc);
        gbc.gridx = 6;
        gbc.gridy = 4;
        panel.add(p2Time2, gbc);
        gbc.gridx = 7;
        gbc.gridy = 4;
        panel.add(p2Date4, gbc);
        gbc.gridx = 8;
        gbc.gridy = 4;
        panel.add(p2Date5, gbc);
        gbc.gridx = 9;
        gbc.gridy = 4;
        panel.add(p2Date6, gbc);
        gbc.gridx = 10;
        gbc.gridy = 4;
        panel.add(p2Time3, gbc);
        gbc.gridx = 11;
        gbc.gridy = 4;
        panel.add(p2Time4, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        panel.add(p2TagByTitle, gbc);

        gbc.gridx = 1;
        gbc.gridy = 5;
        panel.add(p2CheckBox, gbc);
        gbc.gridx = 0;
        gbc.gridy = 6;
        panel.add(p2TitleCombo, gbc);

        gbc.gridx = 1;
        gbc.gridy = 8;
        panel.add(p2InputComment, gbc);

        gbc.gridx = 8;
        gbc.gridy = 8;
        panel.add(tagButton, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;

        panel.add(p2CheckBox2,gbc);

        gbc.gridx =8 ;
        gbc.gridy =7 ;
        panel.add(p2CheckBoxHidden, gbc);


  //      panel.add();


        // panel.add(p2TagByProcess);
        // panel.add(p2ProcessCombo);
        // panel.add(p2TagByTime);
        // panel.add(p2Date1);
        // panel.add(p2Date2);
        // panel.add(p2Date3);
        // panel.add(p2Time1);
        // panel.add(p2Time2);




    }
    // Statistics on most used process, maybe a graph..
    public static void intialisePanel3(JPanel panel){




    }
    public static void intialisePanel4(JPanel panel, JFrame frame, GridBagConstraints gbc){


    p4Output =  new JTextArea(15,100);
    p4Output.setWrapStyleWord(true);
    p4Output.setEditable(false);
    JScrollPane p4Scroller = new JScrollPane(p4Output);
    p4Scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
    p4Scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);

    p4ProcessCount = new JTextField(30);
    p4ProcessCount.setEditable(false);
    
    p4SelectionBox = new JComboBox();
    p4ProcessSelect = new JTextField(5);
    p4ProcessSelect.setEditable(false);
    p4ProcessCount.setEditable(false);

    p4SelectionBox.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        //ArrayList<String> processNames = getActiveWindow.getKeysHashTable();

        ArrayList<Process> processTitles =  getActiveWindow.getProcesses((String)((JComboBox) e.getSource()).getSelectedItem());

        p4Output.setText("");
        for(int i=0 ;i<processTitles.size();i++ ){
            Process current = processTitles.get(i);
            p4Output.append(current.title+ ": " + DateClass.dateToString(current.startDate) +" - " + DateClass.dateToString(current.endDate) + "\n");
        }
        p4ProcessCount.setText("Number of processes : "+ processTitles.size());
        frames.get(4).pack();
      }
    });

    DefaultCaret caret = (DefaultCaret) p4Output.getCaret();
    caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
    gbc.insets = new Insets(10,10 ,1,1);
    gbc.gridx = 0;
    gbc.gridy = 0;
    panel.add(p4SelectionBox, gbc);
    gbc.gridx = 0;
    gbc.gridy = 1;
    panel.add(p4ProcessCount, gbc);
    gbc.gridx = 1;
    gbc.gridy = 2;
    panel.add(p4Scroller, gbc);
    
    }

    // filtering tags...

    public static void updateComboBox5(){







    }

    public static void intialisePanel5(JPanel panel){
    // public static JTextArea p5Output;
    // public static JComboBox p5Combo;
        // p5Output = new JTextArea(15, 100);
        // p5Combo =  new JComboBox();
        // p5OutLabel = new JLabel("Tags");

        // p5Combo.addActionListener(new ActionListener() {
        // public void actionPerformed(ActionEvent e) {
        // //ArrayList<String> processNames = getActiveWindow.getKeysHashTable();

        // ArrayList<Tag> tags = getActiveWindow.getTags();



        // ArrayList<Process> processTitles =  getActiveWindow.getProcesses((String)((JComboBox) e.getSource()).getSelectedItem());

        // p4Output.setText("");
        // for(int i=0 ;i<processTitles.size();i++ ){
        //     Process current = processTitles.get(i);
        //     p4Output.append(current.title+ ": " + DateClass.dateToString(current.startDate) +" - " + DateClass.dateToString(current.endDate) + "\n");
        // }
        // p4ProcessCount.setText("Number of processes : "+ processTitles.size());
        //     frames.get(4).pack();
        // }
        // });

        // gbc.gridx = 0;
        // gbc.gridy = 0; 
        // panel.add(p5OutLabel, gbc);
        // gbc.gridx = 0;
        // gbc.gridy = 1;
        // panel.add(p5Combo, gbc);
        // gbc.gridx = 1;
        // gbc.gridy = 1;
        // panel.add(p5Output, gbc);

    }

    public static void panel2Update(){
        Date currentDate = Calendar.getInstance().getTime();
        String currentDateString = DateClass.dateToString(currentDate);
        System.out.println(currentDateString);
        ArrayList dateArray = DateClass.StringDateToElements(currentDateString);

        p2Date1.setSelectedItem(p2Date1.getItemAt(( (Integer)dateArray.get(2)-1) ));
        p2Date4.setSelectedItem(p2Date4.getItemAt(( (Integer)dateArray.get(2)-1) ));

        p2Date2.setSelectedItem(p2Date2.getItemAt(( (Integer)dateArray.get(1)-1) ));     // dont have to do this twice.
        p2Date5.setSelectedItem(p2Date5.getItemAt(( (Integer)dateArray.get(1)-1) ));
        
        p2Date3.setSelectedItem(p2Date3.getItemAt(( (Integer)dateArray.get(0))));
        p2Date6.setSelectedItem(p2Date6.getItemAt(( (Integer)dateArray.get(0))));

        p2Time1.setSelectedItem(p2Time1.getItemAt(( (Integer)dateArray.get(3))));
        p2Time3.setSelectedItem(p2Time3.getItemAt(( (Integer)dateArray.get(3))));

        p2Time2.setSelectedItem(p2Time2.getItemAt(( (Integer)dateArray.get(4))));
        p2Time4.setSelectedItem(p2Time4.getItemAt(( (Integer)dateArray.get(4))));



    }

    // continuously get the current process Names in the session and add to the combo box.
    public static void updateComboBoxProcesses(JComboBox c){
        // change the way this works...
        ArrayList<String> processNames = getActiveWindow.getKeysHashTable();
        for(int j=0;j< processNames.size(); j++){
            // HAVE TO CHECK IF THE PROCESS IS ALREADY THERE.. SO MIGHT JUST CLEAR IT EVERYTIME..

            // COULD CHECK THE DIFFERENCE BETWEEN THE COUNT ON THE COMBO BOX AND THE COUNT ON THE PROCESSNAMES..
            // THEN JUST ADD ELEMENTS FROM THE TOP-DIFFERENCE INDEX??
            String current = processNames.get(j);
            boolean found = false;
            for(int i=0; i<c.getItemCount() && found == false;i++){
                if(current.equals(c.getItemAt(i)))
                    found =true;
            }
            if(found == true){

            }
            else{
                String titleToAdd = processNames.get(j);
                if(titleToAdd.equals(getActiveWindow.CONST_EMPTY) || titleToAdd.equals(" ")){
                    titleToAdd= getActiveWindow.EMPTY_REPLACE;
                  }
                  if(titleToAdd.equals(getActiveWindow.CONST_NONE)){
                    
                    titleToAdd= getActiveWindow.NONE_REPLACE;
                  }
                c.addItem(titleToAdd);
            }
            
        }
    }
    public static void updateComboBoxTitlesP2(JComboBox c){

        String lastTitle;
        ArrayList<Process> processTitles = getActiveWindow.getProcesses(String.valueOf(p2ProcessCombo.getSelectedItem()));
        c.removeAllItems();
        for(int i=0;i<processTitles.size();i++){
            lastTitle = processTitles.get(i).title;
            lastTitle = getActiveWindow.findProcessNameWithinTitle(lastTitle);
            c.addItem(lastTitle);
        }

    }
    //Should really do this with a for loop.....
    public static void intialisePanelButtons(ArrayList<JPanel> panels , ArrayList<JFrame> frames, ArrayList<GridBagConstraints> grids){
        panel1Button = new JButton("Main menu");
        panel2Button = new JButton("Main menu");
        panel3Button = new JButton("Main menu");
        panel4Button = new JButton("Main menu");
        panel5Button = new JButton("Main menu");

        JButton [] tempButtons = {panel1Button,panel2Button,panel3Button,panel4Button,panel5Button};

         panel1Button.addActionListener( new ActionListener()
        {
             public void actionPerformed(ActionEvent e)
            {   
                currentFrame.setVisible(false);
                frames.get(0).setVisible(true);
                currentFrame = (JFrame) frames.get(0);
            }
        });
          panel2Button.addActionListener( new ActionListener()
        {
             public void actionPerformed(ActionEvent e)
            {   
                currentFrame.setVisible(false);
                frames.get(0).setVisible(true);
                currentFrame = (JFrame) frames.get(0);
            }
        });
           panel3Button.addActionListener( new ActionListener()
        {
             public void actionPerformed(ActionEvent e)
            {   
                currentFrame.setVisible(false);
                frames.get(0).setVisible(true);
                currentFrame = (JFrame) frames.get(0);
            }
        });
            panel4Button.addActionListener( new ActionListener()
        {
             public void actionPerformed(ActionEvent e)
            {   
                currentFrame.setVisible(false);
                frames.get(0).setVisible(true);
                currentFrame = (JFrame) frames.get(0);
            }
        });
             panel5Button.addActionListener( new ActionListener()
        {
             public void actionPerformed(ActionEvent e)
            {   
                currentFrame.setVisible(false);
                frames.get(0).setVisible(true);
                currentFrame = (JFrame) frames.get(0);
            }
        });
        GridBagConstraints gbc = grids.get(1);

        for(int i=0;i< panels.size();i++){
            if(i ==1){
                gbc.gridx = 6;
                gbc.gridy = 0;
                panels.get(i).add(tempButtons[i], gbc);
            }
            else{
                gbc.gridx = 1;
                gbc.gridy = 0;
                panels.get(i).add(tempButtons[i], gbc);
            }
        }



    }
    public static Date getDateFromComboBoxes(ArrayList<JComboBox> boxes){
        int[] elements = new int[5]; 
        for(int i=0;i<elements.length;i++){
            JComboBox current = boxes.get(i);
            elements[i] = (int)current.getSelectedItem();
        }
        return new Date(new String(elements[0]+"/" + elements[1] + "/" + elements[2] + " " + elements[3] + ":" + elements[4] + ":" + "00"));

    }
    // might just change this to intialise all of the Main
    public static void intialiseMainButtons(ArrayList<JPanel> panels , ArrayList<GridBagConstraints> grids){
        switchPanel1 =  new JButton("Titles");
        switchPanel2 =  new JButton("Add Tag");
        switchPanel3 =  new JButton("Stats");
        switchPanel4 =  new JButton("Process Filter");
        switchPanel5 =  new JButton("Tag Filter");

        switchPanel1.addActionListener( new ActionListener()
        {
             public void actionPerformed(ActionEvent e)
            {   
                currentFrame.setVisible(false);
                frames.get(1).setVisible(true);
                currentFrame = (JFrame) frames.get(1);
            }
        });
        switchPanel2.addActionListener( new ActionListener()
        {
             public void actionPerformed(ActionEvent e)
            {
                currentFrame.setVisible(false);
                frames.get(2).setVisible(true);
                currentFrame = frames.get(2);
            }
        });
        switchPanel3.addActionListener( new ActionListener()
        {
             public void actionPerformed(ActionEvent e)
            {
                currentFrame.setVisible(false);
                frames.get(3).setVisible(true);
                currentFrame = frames.get(3);
            }
        });
        switchPanel4.addActionListener( new ActionListener()
        {
             public void actionPerformed(ActionEvent e)
            {
                currentFrame.setVisible(false);
                frames.get(4).setVisible(true);
                currentFrame = frames.get(4);
            }
        });
        switchPanel5.addActionListener( new ActionListener()
        {
             public void actionPerformed(ActionEvent e)
            {
                currentFrame.setVisible(false);
                frames.get(5).setVisible(true);
                currentFrame = frames.get(5);
            }
        });


        inputpanel.add(switchPanel1);
        inputpanel.add(switchPanel2);
        inputpanel.add(switchPanel3);
        inputpanel.add(switchPanel4);
        inputpanel.add(switchPanel5);

    }
}