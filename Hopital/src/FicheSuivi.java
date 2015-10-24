 /**
 * @author bailleulb
 *
 */
public class FicheSuivi {

	private Specialite spec;
	
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
	
}
