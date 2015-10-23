/**
 * 
 */

/**
 * @author bailleulb
 *
 */
public class Specialiste {

	private String name;

	private Specialite specialite;

	public Specialiste(String name){
		this.setName(name);
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the specialite
	 */
	public Specialite getSpecialite() {
		return specialite;
	}

	/**
	 * @param specialite the specialite to set
	 */
	public void setSpecialite(Specialite specialite) {
		this.specialite = specialite;
	}
	
	
	
}
