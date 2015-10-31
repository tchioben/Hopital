/**
 * 
 */
package fabrique;

import java.util.HashMap;

import domaine.Patient;

/**
 * @author Léa Vanelle, Benoît Bailleul
 *
 */
public class FabriquePatient {
	
	/** Les patients de l'hopital */
	private HashMap<String,Patient> lesPatients;
	
	private FabriquePatient(){
		this.lesPatients = new HashMap<String,Patient>();
	}
	
	/** Une instance de la fabrique */
	static private FabriquePatient INSTANCE = null;
	
	/** Renvoie une instance de la classe FabriquePatient */
	static public FabriquePatient getINSTANCE() {
		if (INSTANCE == null){
			INSTANCE = new FabriquePatient();
		}
		return INSTANCE;
	}
	
	/** @return La liste des patients de l'hopital	 */
	public HashMap<String, Patient> getLesPatients() {return lesPatients;}

	/** @param p un patient de l'hopital */
	public void setPatient(Patient p) {
		this.lesPatients.put(p.getName(), p);
	}

	/** Crée un patient */
	public Patient createPatient(String name, String numSecu, String adresse, int age){
		Patient p = new Patient(name, numSecu, adresse, age);
		this.setPatient(p);
		System.out.println("ajout patient ok");
		return p;
	}
	
	public Patient searchPatient(String name){
		return this.getLesPatients().get(name); //get renvoie la valeur correspondant à la clé précisée OU Null si pas de clé/valeur
	}
}
