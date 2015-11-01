package domaine;
import java.util.ArrayList;

import fabrique.FabriqueFicheSejour;


public class Patient {
	/** Le nom du patient */
	private String name;
	/** Le numero de securite sociale du patient */
	private String numSecu;
	/** L'adresse du patient */
	private String adresse;
	/** L'age du patien */
	private int age;
	/** La fiche de sejour du patient qui contient les specialites et les comptes rendus de ces specialite pour le sejour en cours du patient */
	private FicheSejour ficheSejour;
	/** La fiche de suivi du patient contenant les comptes rendus de chaque specialite pour chaque sejour du patient */
	private ArrayList<FicheSuivi> ficheSuivi;
	
	/** Construction du patient
	 * @param name son nom
	 * @param numSecu son numéro de securite sociale
	 * @param adresse son adresse
	 * @param age son age
	 */
	public Patient(String name, String numSecu, String adresse, int age){
		this.setName(name);
		this.setNumSecu(numSecu);
		this.setAdresse(adresse);
		this.setAge(age);
		this.ficheSuivi = new ArrayList<FicheSuivi>();
		this.ficheSejour = FabriqueFicheSejour.getINSTANCE().createFicheSejour(this);
	}

	/** Permet de connaitre l'adresse du patient
	 * @return l'adresse du patient
	 */
	public String getAdresse() {
		return adresse;
	}

	/** Permet de renseigner l'adresse du patient
	 * @param adresse l'adresse a attribuer au patient
	 */
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	/** Renvoie le numero de securite sociale du patient
	 * @return le numéro securite sociale du patient
	 */
	public String getNumSecu() {
		return numSecu;
	}

	/** Permet de renseigner le numero de securite sociale du patient
	 * @param numSecu le numero de securite sociale a attribuer au patient
	 */
	public void setNumSecu(String numSecu) {
		this.numSecu = numSecu;
	}

	/** Permet de connaitre le nom du patient
	 * @return le nom du patient
	 */
	public String getName() {
		return name;
	}

	/** Permet l'attribution d nom du patient
	 * @param name le nom a attribuer au patient
	 */
	public void setName(String name) {
		this.name = name;
	}

	/** Permet de récupérer la fiche de séjouor du patient
	 * @return la fiche de sejour du patient
	 */
	public FicheSejour getFicheSejour() {
		return this.ficheSejour;
	}


	/** Permet de connaitre l'age du patient
	 * @return l'age du patient
	 */
	public int getAge() {
		return age;
	}

	/** Permet de renseigner l'age du patient
	 * @param age l'age a attribuer au patient
	 */
	public void setAge(int age) {
		this.age = age;
	}
	
	/** Ajoute une fiche de suivi au patient
	 * @param fs la fiche de suivi a attribuer au patient
	 */
	public void addFicheSuivi(FicheSuivi fs) {
		this.ficheSuivi.add(fs);		
	}
	
	/** Permet de recuperer les fiches de suivi du patient
	 * @return la liste des fiches de suivi d'un patient
	 */
	public ArrayList<FicheSuivi> getFicheSuivi(){
		return this.ficheSuivi;
	}
	
	/** Ajoute une fiche de sejour au patient
	 * @param fs la fiche de sejour a attribuer au patient
	 */
	public void setFicheSejour(FicheSejour fs){
		if(this.ficheSejour == null){
			this.ficheSejour = fs;
		}
	}
	public FicheSuivi searchFicheSuivi(Specialite spe) {
		for (FicheSuivi fs : this.getFicheSuivi()) {
			if(fs.getSpec() == spe){
				return fs;
			}
		}
		return null;
	}	
}
