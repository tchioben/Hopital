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
		sc.close();
		return sObjet;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
