/**
 * 
 */
package fabrique;

import domaine.FicheSejour;


/** 
 * Crée les fiches de sejour pour les patients
 * @author Léa Vanelle, Benoît Bailleul
 */
public class FabriqueFicheSejour {
	
	private FabriqueFicheSejour(){	}
	
	/** Une instance de la fabrique */
	static private FabriqueFicheSejour INSTANCE = null;
	
	/** Renvoie une instance de la classe FabriqueFicheSejour */
	static public FabriqueFicheSejour getINSTANCE() {
		if (INSTANCE == null){
			INSTANCE = new FabriqueFicheSejour();
		}
		return INSTANCE;
	}
	
	/** cree une fiche de sejour*/
	public FicheSejour createFicheSejour(){
		return new FicheSejour();
	}
}
