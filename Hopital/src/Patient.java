import java.util.ArrayList;

/**
 * 
 */

/**
 * @author bailleulb
 *
 */
public class Patient {

	private String name;
	
	private String numSecu;
	
	private String adresse;
	
	private int age;
	
	private FicheSejour fiche;
	
	private ArrayList<FicheSuivi> ficheSuivi;
	
	public Patient(String name, String numSecu, String adresse, int age){
		this.setName(name);
		this.setNumSecu(numSecu);
		this.setAdresse(adresse);
		this.setAge(age);
		this.ficheSuivi = new ArrayList<FicheSuivi>();
		
	}

	/**
	 * @return the adresse
	 */
	public String getAdresse() {
		return adresse;
	}

	/**
	 * @param adresse the adresse to set
	 */
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	/**
	 * @return the numSecu
	 */
	public String getNumSecu() {
		return numSecu;
	}

	/**
	 * @param numSecu the numSecu to set
	 */
	public void setNumSecu(String numSecu) {
		this.numSecu = numSecu;
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
	 * @return the fiche
	 */
	public FicheSejour getFiche() {
		return fiche;
	}

	/**
	 * @param fiche the fiche to set
	 */
	public void setFiche(FicheSejour fiche) {
		this.fiche = fiche;
	}

	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}
}
