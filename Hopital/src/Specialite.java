/**
 * 
 */

/**
 * @author bailleulb
 *
 */
public class Specialite {

	private String name;
	
	private FicheSuivi ficheSuivi;
	
	public Specialite(String name){
		this.setName(name);
	}

	/**
	 * @return the compteRendu
	 */
	public FicheSuivi getCompteRendu() {
		return ficheSuivi;
	}

	/**
	 * @param compteRendu the compteRendu to set
	 */
	public void setCompteRendu(FicheSuivi ficheSuivi) {
		this.ficheSuivi = ficheSuivi;
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
	
	
}
