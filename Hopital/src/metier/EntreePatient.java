/**
 * 
 */
package metier;

import java.util.Scanner;

import domaine.Patient;
import fabrique.FabriquePatient;

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
		System.out.println("Veuillez entrer le numéro de Secu du nouveau patient : ");
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
