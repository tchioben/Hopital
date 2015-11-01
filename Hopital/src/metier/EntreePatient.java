/**
 * 
 */
package metier;

import java.util.ArrayList;
import java.util.Arrays;

import domaine.FicheSejour;
import domaine.Patient;
import domaine.Specialite;
import fabrique.FabriqueFicheSejour;
import fabrique.FabriquePatient;
import fabrique.FabriqueSpecialite;

/** Entrée d'un patient
 * 
 * acteur : le médecin de garde
 * 1- saisie du nom du patient (si déjà entré arrêt) 
 *	 	• si inconnu, possibilité de créer le patient (numéro Sécu, nom, adresse, age) 
 *  2- création de sa fiche de séjour  
 *  	• saisie des spécialités nécessitant une consultation
 *  
 * @author Léa Vanelle, Benoît Bailleul
 */
public class EntreePatient {
	//public EntreePatient(){}
	
	/** Réalise l'entree d'un patient */
	public static void EntreeDunPatient() {
		FabriquePatient fp = FabriquePatient.getINSTANCE();
		String NomPatient = EntreePatient.SaisieNomPatient();
		Patient p = fp.searchPatient(NomPatient);
		if (p == null){ // Le patient n'est pas encore connu
			// Creation d'un nouveau patient
			System.out.println("C'est un nouveau patient, il faut lui créer une fiche !");
			String NumSecu = EntreePatient.SaisieNumSecuPatient();
			String Adresse = EntreePatient.SaisieAdressePatient();
			int Age = EntreePatient.SaisieAgePatient();
			p = fp.createPatient(NomPatient, NumSecu, Adresse, Age);
			System.out.println("Le nouveau patient ("+ p.getName()+") a été créée.");
		}
		FicheSejour fs = p.getFicheSejour();
		if (fs == null){ // Si le patient a déjà une fiche de séjour c'est qu'il est déjà entré à l'hopital
			// Il faut creer une fiche de sejour pour le patient
			System.out.println("Creation d'une fiche de sejour pour le patient " + p.getName());
			FabriqueFicheSejour ffs = FabriqueFicheSejour.getINSTANCE();
			fs = ffs.createFicheSejour(p);
			ArrayList<String> spes = EntreePatient.SaisieSpecialites();
			FabriqueSpecialite fspe = FabriqueSpecialite.getINSTANCE();
			// Ajout des spécialités à la fiche de sejour
			for (String spe : spes) {
				Specialite s = fspe.searchSpecialite(spe);
				 if (s==null) { fs.addSpecialite(fspe.createSpecialite(spe)); }
				 else { fs.addSpecialite(s);}
			}
			System.out.println("Ce patient devra consulter les specialistes en " + p.getFicheSejour().SpeToString());
		} else {
			System.out.println("Ce patient est déjà entré dans l'hopital !");
		}
	}
	
	/** Demande la saisie du nom du patient
	 * @return une chaine de caractère contenant le nom du patient.
	 */
	public static String SaisieNomPatient(){
		return Main.Saisie("le nom du patient");
	}
	/** Demande la saisie du numero de securite sociale du patient
	 * @return une chaine de caractere contenant le numéro de secu du patient
	 */
	public static String SaisieNumSecuPatient(){
		return Main.Saisie("le numéro de Secu du nouveau patient");
	}
	/** Demande la saisie de l'adresse du patient 
	 * @return l'adresse du patient sous forme de chaine de caractères
	 */
	public static String SaisieAdressePatient(){
		return Main.Saisie("l'adresse du nouveau patient");
	}
	/** Demande la saisie de l'age d'un patient 
	 * @return retourne un entier représentant l'age du patient
	 */
	public static int SaisieAgePatient(){
		return Integer.parseInt(Main.Saisie("l'age du nouveau patient"));
	}
	
	/** Demande la saisie d'une liste de specialite, et renvoie cette liste 
	 * @return la liste des specialités qui ont étaient saisies
	 */
	public static ArrayList<String> SaisieSpecialites(){
		String Spes = Main.Saisie("les specialites que doit consulter le patient\n"
				+ "(séparez les différentes spécialités par des point-virgules)\n"
				+ "Les specialites : " + FabriqueSpecialite.getINSTANCE().imprimeSpecialites());
		ArrayList<String> SpeList = new ArrayList<String>(Arrays.asList(Spes.split(";")));
		return SpeList;
	}
}
