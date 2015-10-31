package domaine;
/**
 * 
 */

/**
 * @author Léa Vanelle, Benoît Bailleul
 *
 */
public class Specialiste {

	private String name;

	private Specialite specialite;

	public Specialiste(String name, Specialite spec){
		this.setName(name);
		this.specialite= spec;
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
	
	public boolean equals(Object o){
		 return ((this.name == ((Specialiste) o).getName()) && this.specialite.equals(((Specialiste) o).getSpecialite())) ;
	}
	
	public int hashCode(){
		int hash= 1;
		hash += hash *17 + this.name.hashCode()+this.specialite.hashCode();
		return hash;
	}
	
}
