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

/** Entr�e d'un patient
 * 
 * acteur : le m�decin de garde
 * 1- saisie du nom du patient (si d�j� entr� arr�t) 
 *	 	� si inconnu, possibilit� de cr�er le patient (num�ro S�cu, nom, adresse, age) 
 *  2- cr�ation de sa fiche de s�jour  
 *  	� saisie des sp�cialit�s n�cessitant une consultation
 *  
 * @author L�a Vanelle, Beno�t Bailleul
 */
public class EntreePatient {
	//public EntreePatient(){}
	
	/** R�alise l'entree d'un patient */
	public static void EntreeDunPatient() {
		FabriquePatient fp = FabriquePatient.getINSTANCE();
		String NomPatient = EntreePatient.SaisieNomPatient();
		Patient p = fp.searchPatient(NomPatient);
		if (p == null){ // Le patient n'est pas encore connu
			// Creation d'un nouveau patient
			System.out.println("C'est un nouveau patient, il faut lui cr�er une fiche !");
			String NumSecu = EntreePatient.SaisieNumSecuPatient();
			String Adresse = EntreePatient.SaisieAdressePatient();
			int Age = EntreePatient.SaisieAgePatient();
			p = fp.createPatient(NomPatient, NumSecu, Adresse, Age);
			System.out.println("Le nouveau patient ("+ p.getName()+") a �t� cr��e.");
		}
		FicheSejour fs = p.getFicheSejour();
		if (fs == null){ // Si le patient a d�j� une fiche de s�jour c'est qu'il est d�j� entr� � l'hopital
			// Il faut creer une fiche de sejour pour le patient
			System.out.println("Creation d'une fiche de sejour pour le patient " + p.getName());
			FabriqueFicheSejour ffs = FabriqueFicheSejour.getINSTANCE();
			fs = ffs.createFicheSejour(p);
			ArrayList<String> spes = EntreePatient.SaisieSpecialites();
			FabriqueSpecialite fspe = FabriqueSpecialite.getINSTANCE();
			// Ajout des sp�cialit�s � la fiche de sejour
			for (String spe : spes) {
				Specialite s = fspe.searchSpecialite(spe);
				 if (s==null) { fs.addSpecialite(fspe.createSpecialite(spe)); }
				 else { fs.addSpecialite(s);}
			}
			System.out.println("Ce patient devra consulter les specialistes en " + p.getFicheSejour().SpeToString());
		} else {
			System.out.println("Ce patient est d�j� entr� dans l'hopital !");
		}
	}
	
	/** Demande la saisie du nom du patient
	 * @return une chaine de caract�re contenant le nom du patient.
	 */
	public static String SaisieNomPatient(){
		return Main.Saisie("le nom du patient");
	}
	/** Demande la saisie du numero de securite sociale du patient
	 * @return une chaine de caractere contenant le num�ro de secu du patient
	 */
	public static String SaisieNumSecuPatient(){
		return Main.Saisie("le num�ro de Secu du nouveau patient");
	}
	/** Demande la saisie de l'adresse du patient 
	 * @return l'adresse du patient sous forme de chaine de caract�res
	 */
	public static String SaisieAdressePatient(){
		return Main.Saisie("l'adresse du nouveau patient");
	}
	/** Demande la saisie de l'age d'un patient 
	 * @return retourne un entier repr�sentant l'age du patient
	 */
	public static int SaisieAgePatient(){
		return Integer.parseInt(Main.Saisie("l'age du nouveau patient"));
	}
	
	/** Demande la saisie d'une liste de specialite, et renvoie cette liste 
	 * @return la liste des specialit�s qui ont �taient saisies
	 */
	public static ArrayList<String> SaisieSpecialites(){
		String Spes = Main.Saisie("les specialites que doit consulter le patient\n"
				+ "(s�parez les diff�rentes sp�cialit�s par des point-virgules)\n"
				+ "Les specialites : " + FabriqueSpecialite.getINSTANCE().imprimeSpecialites());
		ArrayList<String> SpeList = new ArrayList<String>(Arrays.asList(Spes.split(";")));
		return SpeList;
	}
}
