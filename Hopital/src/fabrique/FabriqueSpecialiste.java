/**
 * 
 */
package fabrique;

import java.util.ArrayList;
import java.util.HashMap;

import domaine.Specialiste;
import domaine.Specialite;

/**
 * @author Léa Vanelle, Benoît Bailleul
 *
 */
public class FabriqueSpecialiste {
	/** Les specialistes de l'hopital */
	private HashMap<String,Specialiste> lesSpecialistes;
	
	private ArrayList<Specialiste> nomSpecialistes;
	
	private FabriqueSpecialiste(){
		this.lesSpecialistes = new HashMap<String,Specialiste>();
		this.setNomSpecialistes(new ArrayList<Specialiste>());
	}
	
	/** Une instance de la fabrique */
	static private FabriqueSpecialiste INSTANCE = null;
	
	/** Renvoie une instance de la classe FabriqueSpecialiste */
	static public FabriqueSpecialiste getINSTANCE() {
		if (INSTANCE == null){
			INSTANCE = new FabriqueSpecialiste();
		}
		return INSTANCE;
	}
	
	/** @return La liste des Specialistes de l'hopital	 */
	public HashMap<String, Specialiste> getLesSpecialistes() {return lesSpecialistes;}

	/** @param p un Specialiste de l'hopital */
	public void setSpecialiste(Specialiste p) {
		this.lesSpecialistes.put(p.getName(), p);
	}

	/** Crée un Specialiste */
	public Specialiste createSpecialiste(String name, Specialite specialite){
		Specialiste p = new Specialiste(name,specialite);
		this.setSpecialiste(p);
		this.nomSpecialistes.add(p);
		return p;
	}
	
	public Specialiste searchSpecialiste(String name){
		return this.getLesSpecialistes().get(name); //get renvoie la valeur correspondant à la clé précisée OU Null si pas de clé/valeur
	}

	/**
	 * @return the nomSpecialistes
	 */
	public ArrayList<Specialiste> getNomSpecialistes() {
		return nomSpecialistes;
	}

	/**
	 * @param arrayList the nomSpecialistes to set
	 */
	public void setNomSpecialistes(ArrayList<Specialiste> arrayList) {
		this.nomSpecialistes = arrayList;
	}
	
	

}
