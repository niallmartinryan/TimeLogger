
import java.util.ArrayList;
import org.jfree.chart.ChartFactory;  
import org.jfree.chart.ChartPanel;  
import org.jfree.chart.JFreeChart;    
import org.jfree.chart.plot.PlotOrientation;  
import org.jfree.data.category.CategoryDataset;  
import org.jfree.data.category.DefaultCategoryDataset;  
  
public class Chart {  
    ChartPanel frame1;  
    public Chart(){
        CategoryDataset dataset = getDataSet();  
        JFreeChart chart = ChartFactory.createBarChart3D("Useage for Application","Name of Application","Useage(Second)", dataset, 
                            PlotOrientation.VERTICAL, false,false,false);  
            
         frame1=new ChartPanel(chart,true);        
    }  
       private static CategoryDataset getDataSet() {  
           DefaultCategoryDataset dataset = new DefaultCategoryDataset();
           ArrayList<Process> processes = getActiveWindow.getProcesses();
           String [] elements = {"Google Chrome", "Starcraft", "Sublime Text 3", "System", "Eclipse"}; 


           
           int[] array2 = {14,24,123,145,12};
           for(int i=0;i<elements.length;i++){
        	   dataset.addValue(array2[i],"", elements[i]);
           }
           //dataset.addValue(100, "", "Google Chrome");  
           //dataset.addValue(50, "", "Eclipse"); 
           return dataset;  
}  
public ChartPanel getChartPanel(){  
    return frame1;  
      
}  
}