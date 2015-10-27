/**
 * 
 */
package metier;

import java.util.Scanner;

/**
 * @author L�a Vanelle, Beno�t Bailleul
 *
 */
public class Main {

	/**
	 * Saisie d'un objet
	 * @return le nom de l'objet recherch�
	 */
	public static String Saisie(String objet){
		System.out.println("Veuillez entrer " + objet +" : ");
		Scanner sc = new Scanner(System.in);
		String sObjet = sc.nextLine();
		// sc.nextLine();
		//sc.close();
		return sObjet;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Autre cas
		String choix = "";
		while (choix != "0"){ 
			System.out.println("Que voulez vous faire ?\n - Sortir : tapez 0\n - R�aliser l'entr�e d'un patient : tapez 1");
			choix = Main.Saisie("le num�ro correspondant � votre choix");
			switch (choix) {
			case "1": try {
					EntreePatient.EntreeDunPatient();
				} catch (Exception e) {
					System.out.println("Ce patient est d�j� pr�sent dans l'hopital !");
				}
				break;
			default: choix = "0";
				break;
			}
		}
		System.out.println("Au revoir et � bient�t");
	}

}
