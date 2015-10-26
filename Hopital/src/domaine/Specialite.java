package domaine;
/**
 * 
 */

/**
 * @author Léa Vanelle, Benoît Bailleul
 *
 */
public class Specialite {

	private String name;
	
	public Specialite(String name){
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
	
	public boolean equals(Object o){
		 return ((this.name == ((Specialite) o).getName())) ;
	}
	
	public int hashCode(){
		int hash= 1;
		hash += hash *17 + this.name.hashCode();
		return hash;
	}
	
}
