/**
 * 
 */
package fabrique;

import java.util.HashMap;

import domaine.CompteRendu;
import domaine.Specialiste;

/**
 * @author Léa Vanelle, Benoît Bailleul
 *
 */
public class FabriqueCompteRendu {
	/** Les CompteRendus de l'hopital */
	private HashMap<String,CompteRendu> lesCompteRendus;
	
	private FabriqueCompteRendu(){
		this.lesCompteRendus = new HashMap<String,CompteRendu>();
	}
	
	/** Une instance de la fabrique */
	static private FabriqueCompteRendu INSTANCE = null;
	
	/** Renvoie une instance de la classe FabriqueCompteRendu */
	static public FabriqueCompteRendu getINSTANCE() {
		if (INSTANCE == null){
			INSTANCE = new FabriqueCompteRendu();
		}
		return INSTANCE;
	}
	
	/** @return La liste des CompteRendus de l'hopital	 */
	public HashMap<String, CompteRendu> getLesCompteRendus() {return lesCompteRendus;}

	/** @param p un CompteRendu de l'hopital */
	public void setCompteRendu(CompteRendu p) {
		this.lesCompteRendus.put(p.getSpecialiste().getName(), p);
	}

	/** Crée un CompteRendu */
	public CompteRendu createCompteRendu(Specialiste spec){
		CompteRendu p = new CompteRendu(spec);
		this.setCompteRendu(p);
		return p;
	}
	
	/**
	 * renvoie la liste des compte rendu pour un specialiste(medecin)
	 * @param name le nom du specialiste
	 * @return
	 */
	public CompteRendu searchCompteRendu(String name){
		return this.getLesCompteRendus().get(name); //get renvoie la valeur correspondant à la clé précisée OU Null si pas de clé/valeur
	}
}
