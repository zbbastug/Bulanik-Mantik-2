package pkt;

import java.io.File;
import java.net.URISyntaxException;

import net.sourceforge.jFuzzyLogic.FIS;

public class Ekran {
	private FIS fis;
	private double acikrenkyogunlugu;
	private double koyurenkyogunlugu;
	private double ortamisikyogunlugu;
	
	public Ekran(double acikrenkyogunlugu, double koyurenkyogunlugu, double ortamisikyogunlugu) throws URISyntaxException
	{
		this.acikrenkyogunlugu = acikrenkyogunlugu;
		this.koyurenkyogunlugu = koyurenkyogunlugu;
		this.ortamisikyogunlugu = ortamisikyogunlugu;
		File dosya = new File(getClass().getResource("Model.fcl").toURI());
		fis = FIS.load(dosya.getPath(),true);
		fis.setVariable("acikrenkyogunlugu", acikrenkyogunlugu);
		fis.setVariable("koyurenkyogunlugu", koyurenkyogunlugu);
		fis.setVariable("ortamisikyogunlugu", ortamisikyogunlugu);
		fis.evaluate();
	}
	
	public Ekran() throws URISyntaxException 
	{
		File dosya = new File(getClass().getResource("Model.fcl").toURI());
		fis = FIS.load(dosya.getPath(),true);
	}
	
	public FIS getModel()
	{
		return fis;
	}
	
	@Override
	public String toString()
	{
		String cikti ="Acik Renk Yogunlugu: "+acikrenkyogunlugu+"\nKoyu Renk Yogunlugu:"+koyurenkyogunlugu+"\nOrtam Isik Yogunlugu:"+ortamisikyogunlugu+"\nEkran Parlakligi:"+fis.getVariable("ekranparlakligi").getValue();
		return cikti;
	}
	
	public double ekranparlakligi() 
	{
		return fis.getVariable("ekranparlakligi").getValue();
	}

}
