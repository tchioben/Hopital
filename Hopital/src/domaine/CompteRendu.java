package domaine;

import java.util.Calendar;
import java.util.Date;

/**
 * 
 */

/**
 * @author L�a Vanelle, Beno�t Bailleul
 *
 */
public class CompteRendu {

	/** La date de cr�ation du compte rendu */
	private Date date;
	
	/** Le contenu du compte rendu */
	private String corps;
	
	/** Le specialiste ayant r�dig� le compte rendu */
	private Specialiste specialiste;

	public CompteRendu(Specialiste spec){
		this.specialiste= spec;
		this.date= Calendar.getInstance().getTime();
	}
	
	public CompteRendu(Specialiste spec, Date date){
		this.specialiste= spec;
		this.date= date;
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
	
	
	
	

}
