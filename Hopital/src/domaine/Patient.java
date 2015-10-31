package domaine;
import java.util.ArrayList;


public class Patient {

	private String name;
	
	private String numSecu;
	
	private String adresse;
	
	private int age;
	
	private FicheSejour ficheSejour;
	
	private ArrayList<FicheSuivi> ficheSuivi;
	
	public Patient(String name, String numSecu, String adresse, int age){
		this.setName(name);
		this.setNumSecu(numSecu);
		this.setAdresse(adresse);
		this.setAge(age);
		this.ficheSuivi = new ArrayList<FicheSuivi>();
		this.ficheSejour = new FicheSejour();
	}

	/**
	 * @return l'adresse du patient
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
	public FicheSejour getFicheSejour() {
		return this.ficheSejour;
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

	public void add(FicheSuivi fs) {
		this.ficheSuivi.add(fs);		
	}
	
	public ArrayList<FicheSuivi> getFicheSuivi(){
		return this.ficheSuivi;
	}
	
	public void setFicheSejour(FicheSejour fs){
		if(this.ficheSejour == null){
			this.ficheSejour = fs;
		}
	}
}
