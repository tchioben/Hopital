package domaine;

import java.util.Calendar;
import java.util.Date;

/**
 * 
 */

/**
 * @author Léa Vanelle, Benoît Bailleul
 *
 */
public class CompteRendu {

	/** La date de création du compte rendu */
	private Date date;
	
	/** Le contenu du compte rendu */
	private String corps;
	
	/** Le specialiste ayant rédigé le compte rendu */
	private Specialiste specialiste;

	public CompteRendu(Specialiste spec){
		this.specialiste= spec;
		this.date= Calendar.getInstance().getTime();
		this.corps="";
	}
	
	public CompteRendu(Specialiste spec, Date date){
		this.specialiste= spec;
		this.date= date;
		this.corps="";
	}
	
	/** @return le specialiste */
	public Specialiste getSpecialiste() { return this.specialiste; }

	/** @return the corps */
	public String getCorps() { return corps; }

	/** @param corps the corps to set */
	public void setCorps(String corps) { this.corps = corps; }

	/** @return the date */
	public Date getDate() { return date; }

	/** @param date the date to set */
	public void setDate(Date date) { this.date = date; }
	
	public boolean equals(Object o){
		 return ((this.corps == ((CompteRendu) o).getCorps()) && this.specialiste.equals(((CompteRendu) o).getSpecialiste())) ;
	}
	
	public int hashCode(){
		int hash= 1;
		hash += hash *23 + this.specialiste.hashCode();
		return hash;
	}
	
	
	
	

}
