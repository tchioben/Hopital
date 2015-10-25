/**
 * 
 */

/**
 * @author Léa Vanelle, Benoît Bailleul
 *
 */
public class CompteRendu {

	private String date;
	
	private String corps;
	
	private Specialiste specialiste;

	public CompteRendu(Specialiste spec, String date){
		this.specialiste= spec;
		this.date= date;
	}
	
	public Specialiste getSpecialiste() {
		return this.specialiste;
	}

	/**
	 * @return the corps
	 */
	public String getCorps() {
		return corps;
	}

	/**
	 * @param corps the corps to set
	 */
	public void setCorps(String corps) {
		this.corps = corps;
	}

	/**
	 * @return the date
	 */
	public String getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(String date) {
		this.date = date;
	}
	
	
	
	

}
