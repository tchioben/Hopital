
/**
 * 
 */
package metier;

import java.util.Scanner;

import domaine.Specialite;
import fabrique.FabriquePatient;
import fabrique.FabriqueSpecialiste;
import fabrique.FabriqueSpecialite;

/**
 * @author Léa Vanelle, Benoît Bailleul
 *
 */
public class Main {
	public static Scanner sc = new Scanner(System.in);
	/**
	 * Saisie d'un objet
	 * @return le nom de l'objet recherché
	 */
	public static String Saisie(String objet){
		System.out.println("Veuillez entrer " + objet +" : ");
		String sObjet = sc.nextLine();
		return sObjet;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FabriqueSpecialiste fSpecialiste = FabriqueSpecialiste.getINSTANCE();
		FabriqueSpecialite fSpecialite = FabriqueSpecialite.getINSTANCE();
		fSpecialiste.createSpecialiste("Benoit", fSpecialite.createSpecialite("Ophtalmologie"));
		fSpecialiste.createSpecialiste("Lea", fSpecialite.createSpecialite("Odontologie"));
		fSpecialiste.createSpecialiste("Richard", fSpecialite.createSpecialite("Odontologie"));
		fSpecialiste.createSpecialiste("Laurence", fSpecialite.createSpecialite("Gastroenterologie"));
		fSpecialiste.createSpecialiste("Remy", fSpecialite.createSpecialite("Orthopedie"));
		fSpecialiste.createSpecialiste("Meyer", fSpecialite.createSpecialite("Orthopedie"));
		fSpecialiste.createSpecialiste("Mireille", fSpecialite.createSpecialite("Esthetique"));
		fSpecialiste.createSpecialiste("Jean-Edouard", fSpecialite.createSpecialite("Esthetique"));
		String choix = "";
		while (choix != "0"){ 
			System.out.println("Que voulez vous faire ?\n - Sortir : tapez 0\n - Réaliser l'entrée d'un patient : tapez 1\n "
					+ "\t- Ajouter une consultation à un patient: tapez 2\n"
					+ "\t- Visualiser la fiche séjour d'un patient: tapez 3\n"
					+ "\t- Réaliser la sortir d'un patient : taper 4"
			);
			choix = Main.Saisie("le numéro correspondant à votre choix");
			switch (choix) {
			case "1": try {
					EntreePatient.EntreeDunPatient();
				} catch (Exception e) {
					System.out.println("Ce patient est déjà présent dans l'hopital !");
				}
				break;
			case "2":
				String nomMedecin = Saisie("le nom du médecin");
				String nomPatient = Saisie("le nom du patient");
				Consultation.ajouteConsultation(nomMedecin, nomPatient);
				break;
			case "3":
				String nomPatient2 = Saisie("le nom du patient");
				VisualiserSejour.visualiserSejour(nomPatient2);
				break;
			case "4":
				SortiePatient.SortieDunPatient();
				break;
			case "6":
				FabriqueSpecialiste fp= FabriqueSpecialiste.getINSTANCE();
				fp.createSpecialiste("benoit", new Specialite("Ophtalmo"));
				FabriquePatient fp1= FabriquePatient.getINSTANCE();
				fp1.createPatient("lea", "1212121212121", "je ne sais plus ^^", 60);
				break;
			
			default: choix = "0";
				break;
			}
			
		}
		System.out.println("Au revoir et à bientôt");
	}

}