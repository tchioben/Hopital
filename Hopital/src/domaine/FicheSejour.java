package domaine;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author Léa Vanelle, Benoît Bailleul
 */
public class FicheSejour {
	
	private HashMap<Specialite,ArrayList<CompteRendu>> lesComptesRendus;
	
	public FicheSejour(){
		this.lesComptesRendus=new HashMap<Specialite,ArrayList<CompteRendu>>();
	}

	/**
	 * @return la hashmap contenant la liste des comptes-rendu par specialite
	 */
	public HashMap<Specialite, ArrayList<CompteRendu>> getFichesSuivi() {
		return lesComptesRendus;
	}

	/**
	 * permet de recuperer la liste des comptes rendus pour une specialite
	 * @param Specialite, la specialite que l'on cherche
	 * @return la liste des comptes rendus pour cette specialite
	 */
	public ArrayList<CompteRendu> getComptesRendus(Specialite spec){
		return this.lesComptesRendus.get(spec);
	}	
	
	/**
	 * specialite existe deja?
	 * @param spec
	 * @return
	 */
	public boolean specialiteExiste(Specialite spec){
		return (this.lesComptesRendus.get(spec)!=null);
	}
	
	/**
	 * ajoute une specialite si elle n'existe pas
	 * @param spec la specialite
	 */
	public void addSpecialite(Specialite spec){
		if (!this.specialiteExiste(spec)){
			this.lesComptesRendus.put(spec, new ArrayList<CompteRendu>());
		}
	}
	
	public void addCompteRendu(CompteRendu cr){
		Specialiste medecin = cr.getSpecialiste();
		Specialite spec= medecin.getSpecialite();
		this.addSpecialite(spec);
		this.lesComptesRendus.get(spec).add(cr);
	}
	
	
}
