package fr.demos;

import java.io.Serializable;

public class Climatisation implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Static parameters
	//--------------------------------------------------------
	static double tempFerenheitMult =1.8;
	static int tempFerenheitAdd =40;
	static double pressPoucesMercurrMulti = 0.0295299831; 
	//----------------------------
	
	
	double temperature;
	double pression;
	int humidite;
	String nomAppareil;
	long datation=System.currentTimeMillis();
	
	public Climatisation(){
		nomAppareil="anonyme par defaut";
		temperature= 30;
	    humidite=30;
		pression=1013;
	}
	
	public Climatisation(double temperature, double pression, int humidite, String nomAppareil, long date){
		this.datation = date;
		this.nomAppareil=nomAppareil;
		this.temperature= temperature;
	    this.humidite=humidite;
		this.pression=pression;
	}

	public Climatisation(String nom){
		this.nomAppareil=nom;
		temperature= 25;
	    humidite=30;
		pression=1013;
	}
	
	public double getTemperatureFerenheit(){
		return ((temperature +tempFerenheitAdd)*tempFerenheitMult)-tempFerenheitAdd;
		
	}
	
	public double getPressionPoucesMercures(){
		return (java.lang.Math.rint((pression*pressPoucesMercurrMulti)*100))/100;
		
	}

	@Override
	public String toString() {
		return "Climatisation [temperature=" + temperature + ", pression=" + pression + ", humidite=" + humidite
				+ ", nomAppareil=" + nomAppareil + ", datation=" + new  java.util.Date(datation)+ "]";
	}

//	public static double getTempFerenheitMult() {
//		return tempFerenheitMult;
//	}
//
//	public static void setTempFerenheitMult(double tempFerenheitMult) {
//		Climatisation.tempFerenheitMult = tempFerenheitMult;
//	}
//
//	public static int getTempFerenheitAdd() {
//		return tempFerenheitAdd;
//	}
//
//	public static void setTempFerenheitAdd(int tempFerenheitAdd) {
//		Climatisation.tempFerenheitAdd = tempFerenheitAdd;
//	}
//
//	public static double getPressPoucesMercurrMulti() {
//		return pressPoucesMercurrMulti;
//	}
//
//	public static void setPressPoucesMercurrMulti(double pressPoucesMercurrMulti) {
//		Climatisation.pressPoucesMercurrMulti = pressPoucesMercurrMulti;
//	}

public double getTemperature() {
		return temperature;
	}

	public void setTemperature(double temperature) {
		this.temperature = temperature;
	}
	public double getPression() {
		return pression;
}
//
//	public void setPression(double pression) {
//		this.pression = pression;
//	}
//
//	public int getHumidite() {
//		return humidite;
//	}
//
//	public void setHumidite(int humidite) {
//		this.humidite = humidite;
//	}
//
//	public String getNomAppareil() {
//		return nomAppareil;
//	}
//
//	public void setNomAppareil(String nomAppareil) {
//		this.nomAppareil = nomAppareil;
//	}
//
//	public long getDatation() {
//		return datation;
//	}
//
//	public void setDatation(long datation) {
//		this.datation = datation;
//	}
//
//	public static long getSerialversionuid() {
//		return serialVersionUID;
//	}



}
