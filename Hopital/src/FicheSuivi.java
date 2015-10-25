import java.util.ArrayList;

 /**
 * @author Léa Vanelle, Benoît Bailleul
 */
public class FicheSuivi {

	private Specialite spec;
	private ArrayList<CompteRendu> comptesrendus;
	
	
	public FicheSuivi(Specialite spec){
		this.setSpec(spec);
	}

	/**
	 * @return the spec
	 */
	public Specialite getSpec() {
		return spec;
	}

	/**
	 * @param spec the spec to set
	 */
	public void setSpec(Specialite spec) {
		this.spec = spec;
	}

	/**
	 * @return the comptesrendus
	 */
	public ArrayList<CompteRendu> getComptesrendus() {
		return comptesrendus;
	}

	/**
	 * @param comptesrendus the comptesrendus to set
	 */
	public void setComptesrendus(ArrayList<CompteRendu> comptesrendus) {
		this.comptesrendus = comptesrendus;
	}
	
}
