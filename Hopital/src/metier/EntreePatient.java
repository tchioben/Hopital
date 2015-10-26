/**
 * 
 */
package metier;

import java.util.Scanner;

import domaine.Patient;
import fabrique.FabriquePatient;

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
	
	public static void EntreeDunPatient(){
		FabriquePatient fp = FabriquePatient.getINSTANCE();
		String NomPatient = EntreePatient.SaisieNomPatient();
		Patient p = fp.searchPatient(NomPatient);
		if (p == null){ // Le patient n'est pas encore connu
			// Creation d'un nouveau patient
			String NumSecu = EntreePatient.SaisieNumSecuPatient();
			String Adresse = EntreePatient.SaisieAdressePatient();
			int Age = EntreePatient.SaisieAgePatient();
		}
	}
	
	public static String SaisieNomPatient(){
		System.out.println("Veuillez entrer le nom du patient : ");
		Scanner sc = new Scanner(System.in);
		String NamePatient = sc.nextLine();
		sc.close();
		return NamePatient;
	}
	
	public static String SaisieNumSecuPatient(){
		System.out.println("Veuillez entrer le num�ro de Secu du nouveau patient : ");
		Scanner sc = new Scanner(System.in);
		String NumSecuPatient = sc.nextLine();
		sc.close();
		return NumSecuPatient;
	}
	
	public static String SaisieAdressePatient(){
		System.out.println("Veuillez entrer l'adresse du nouveau patient : ");
		Scanner sc = new Scanner(System.in);
		String AdressePatient = sc.nextLine();
		sc.close();
		return AdressePatient;
	}
	
	public static int SaisieAgePatient(){
		System.out.println("Veuillez entrer l'age du nouveau patient : ");
		Scanner sc = new Scanner(System.in);
		int AgePatient = sc.nextInt();
		sc.close();
		return AgePatient;
	}
}
