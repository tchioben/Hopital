import java.util.ArrayList;

/**
 * 
 */

/**
 * @author bailleulb
 *
 */
public class FicheSejour {

	private ArrayList<Specialite> compteRendu;
	
	public FicheSejour(){
		this.setCompteRendu(new ArrayList<Specialite>());
	}

	/**
	 * @return the compteRendu
	 */
	public ArrayList<Specialite> getCompteRendu() {
		return compteRendu;
	}

	/**
	 * @param compteRendu the compteRendu to set
	 */
	public void setCompteRendu(ArrayList<Specialite> compteRendu) {
		this.compteRendu = compteRendu;
	}
	
	
}
