import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author bailleulb
 *
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
	public ArrayList<CompteRendu> getFicheSuivi(Specialite spec){
		return this.lesComptesRendus.get(spec);
	}	
	
	public void addCompteRendu(CompteRendu cr){
		Specialiste medecin = cr.getSpecialiste();
		Specialite spec= medecin.getSpecialite();
		this.lesComptesRendus.get(spec).add(cr);
	}
	
	
}
