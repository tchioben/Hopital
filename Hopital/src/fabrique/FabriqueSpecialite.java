/**
 * 
 */
package fabrique;

import java.util.HashMap;

import domaine.Specialite;

/**
 * @author Léa Vanelle, Benoît Bailleul
 *
 */
public class FabriqueSpecialite {
	/** Les Specialites de l'hopital */
	private HashMap<String,Specialite> lesSpecialites;
	
	private FabriqueSpecialite(){
		this.lesSpecialites = new HashMap<String,Specialite>();
	}
	
	/** Une instance de la fabrique */
	static private FabriqueSpecialite INSTANCE = null;
	
	/** Renvoie une instance de la classe FabriqueSpecialite */
	static public FabriqueSpecialite getINSTANCE() {
		if (INSTANCE == null){
			INSTANCE = new FabriqueSpecialite();
		}
		return INSTANCE;
	}
	
	/** @return La liste des Specialites de l'hopital */
	public HashMap<String, Specialite> getLesSpecialites() {return lesSpecialites;}

	/** @param p une Specialite de l'hopital */
	public void setSpecialite(Specialite p) {
		this.lesSpecialites.put(p.getName(), p);
	}

	/** Crée une Specialite */
	public Specialite createSpecialite(String name){
		Specialite p = this.searchSpecialite(name);
		if (p==null){
			p = new Specialite(name);
			this.setSpecialite(p);
		}
		return p;
	}
	
	public Specialite searchSpecialite(String name){
		return this.getLesSpecialites().get(name); //get renvoie la valeur correspondant à la clé précisée OU Null si pas de clé/valeur
	}
}
