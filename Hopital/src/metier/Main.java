/**
 * 
 */
package metier;

import java.util.Scanner;

import fabrique.FabriqueSpecialiste;
import fabrique.FabriqueSpecialite;

/**
 * @author L�a Vanelle, Beno�t Bailleul
 *
 */
public class Main {
	public static Scanner sc = new Scanner(System.in);
	/**
	 * Saisie d'un objet
	 * @return le nom de l'objet recherch�
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
		interfaceMain();
		System.out.println("Au revoir et � bient�t");
	}

	public static void interfaceMain(){
		try{
			String choix = "";
			while (choix!="0"){ 
				System.out.println("Que voulez vous faire ?\n "
						+ "\t- Sortir : tapez 0\n"
						+ "\t- R�aliser l'entr�e d'un patient : tapez 1\n "
						+ "\t- Ajouter une consultation � un patient: tapez 2\n"
						+ "\t- Visualiser la fiche s�jour d'un patient: tapez 3\n"
						+ "\t- R�aliser la sortie d'un patient : taper 4"
				);
				choix = Main.Saisie("le num�ro correspondant � votre choix");
				switch (choix) {
				case "1": 
					EntreePatient.EntreeDunPatient();
					choix = "";
					break;
				case "2":
					String nomPatient = Saisie("le nom du patient");
					Consultation.consultation(nomPatient);
					choix = "";
					break;
				case "3":
					String nomPatient2 = Saisie("le nom du patient");
					VisualiserSejour.visualiserSejour(nomPatient2);
					choix = "";
					break;
				case "4":
					String nomPatient3 = Saisie("le nom du patient");
					VisualiserSejour.visualiserSejour(nomPatient3);
					break;
				case "5":
					SortiePatient.SortieDunPatient();
					choix = "";
					break;
	
				
				default: choix = "0";
					break;
				}
				
			}
		}
		catch(Exception e){
			System.out.println("une ou plusieurs informations ne sont pas correctes.");
			interfaceMain();}
	}
	
	
}