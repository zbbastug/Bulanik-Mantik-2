/*package pkt;

import java.net.URISyntaxException;
import java.util.Scanner;

import net.sourceforge.jFuzzyLogic.plot.JFuzzyChart;

public class Program {

	public static void main(String[] args) throws URISyntaxException {
		Scanner in = new Scanner(System.in);
		System.out.print("Acik Renk Yogunlugu (0-100):");
		double acikrenkyogunlugu=in.nextDouble();
		
		System.out.print("Koyu Renk Yogunlugu (0-100):");
		double koyurenkyogunlugu=in.nextDouble();
		
		System.out.print("Ortam Isik Yogunlugu (0-5000):");
		double ortamisikyogunlugu=in.nextDouble();
		
		Ekran ekranparlakligi = new Ekran (acikrenkyogunlugu,koyurenkyogunlugu,ortamisikyogunlugu);
		System.out.println(ekranparlakligi);
		
		if(ekranparlakligi.ekranparlakligi()<100)
		{
			System.out.println("Ekranýnýz parlak degil.");
		}
		
		if(ekranparlakligi.ekranparlakligi()>100 & ekranparlakligi.ekranparlakligi()<=151)
		{
			System.out.println("Ekranýnýzýn parlakligi orta degerdedir.");
		}
		
		if(ekranparlakligi.ekranparlakligi()>151 & ekranparlakligi.ekranparlakligi()<=300)
		{
			System.out.println("Ekranýnýzýn parlakligi yuksek degerdedir.");
		}

		JFuzzyChart.get().chart(ekranparlakligi.getModel());
		JFuzzyChart.get().chart(ekranparlakligi.getModel().getVariable("ekranparlakligi").getDefuzzifier(),"ekranparlakligi",true);
		
	}

}
*/


package pkt;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URISyntaxException;
import java.text.DecimalFormat;


public class Program {
	
	private static DecimalFormat df2 = new DecimalFormat("#.##");

    public static void main(String[] args) throws IOException {
       
    	BufferedWriter writer = new BufferedWriter(new FileWriter("input.txt"));
       
    	for (int i = 0; i < 1000; i++) {
    		
    		 
    		double acikrenkyogunlugu = getRandomNumber(0,100);
    		double koyurenkyogunlugu = getRandomNumber(0,100);
    		double ortamisikyogunlugu = getRandomNumber(0,5000);

    		String data = ""; 
    		
    	        try {
    	            Ekran e = new Ekran(acikrenkyogunlugu,koyurenkyogunlugu,ortamisikyogunlugu);
    	            
    	            data = df2.format(acikrenkyogunlugu) + "\t"+ df2.format(koyurenkyogunlugu)+ "\t"+df2.format(ortamisikyogunlugu) +"\t"+ "\t" + df2.format(e.ekranparlakligi())+"\n";
    	            
    	         
    	            
    	        } catch (URISyntaxException e) {
    	            // TODO Auto-generated catch block
    	            e.printStackTrace();
    	        }
    	        
    	        writer.write(data);
    	        System.out.println(i + ". satir");
    	        
			
		}
    	
    	writer.close();

    }
    
    public static double getRandomNumber(double min, double max) {
        return (double) ((Math.random() * (max - min)) + min);
    }

}