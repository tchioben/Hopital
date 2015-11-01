/**
 * 
 */
package fabrique;

import domaine.FicheSuivi;
import domaine.Specialite;

/**
 * @author Léa Vanelle, Benoît Bailleul
 *
 */
public class FabriqueFicheSuivi {
	private FabriqueFicheSuivi(){	}
	
	/** Une instance de la fabrique */
	static private FabriqueFicheSuivi INSTANCE = null;
	
	/** Renvoie une instance de la classe FabriqueFicheSejour */
	static public FabriqueFicheSuivi getINSTANCE() {
		if (INSTANCE == null){
			INSTANCE = new FabriqueFicheSuivi();
		}
		return INSTANCE;
	}
	
	/** cree une fiche de sejour*/
	public FicheSuivi createFicheSuivi(Specialite spe){
		FicheSuivi fs = new FicheSuivi(spe);
		return fs;
	}
}
