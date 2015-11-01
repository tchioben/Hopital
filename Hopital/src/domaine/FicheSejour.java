
package domaine;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

/**
 * @author Léa Vanelle, Benoît Bailleul
 */
public class FicheSejour {
	
	private HashMap<Specialite,ArrayList<CompteRendu>> lesComptesRendus;
	
	private ArrayList<Specialite> listeSpecialite;

	private CompteRendu prochainCompteRendu;
	
	public FicheSejour(){
		this.lesComptesRendus=new HashMap<Specialite,ArrayList<CompteRendu>>();
		this.listeSpecialite = new ArrayList<Specialite>();
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
	
	/** Supprime la specialite et les comptes rendu de cette specialite
	 * @param spe la specialite pour laquelle on veut l'entree dans la hashmap
	 */
	public void removeSpeEtComptesRendus(Specialite spe){
		this.lesComptesRendus.remove(spe);
		this.listeSpecialite.remove(this.listeSpecialite.indexOf(spe));
	}
	
	/**
	 * Est-ce que la specialite existe deja?
	 * @param spec
	 * @return true si la specialité existe false sinon
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
	/**
	 * Ajoute le compte rendu concernant une specialite
	 * @param cr le compte rendu
	 */
	public void addCompteRendu(CompteRendu cr){
		Specialiste medecin = cr.getSpecialiste();
		Specialite spec= medecin.getSpecialite();
		this.addSpecialite(spec);
		this.lesComptesRendus.get(spec).add(cr);
	}
	
	public String SpeToString(){
		String sSpes = "";
		Set<Specialite> lesSpes = lesComptesRendus.keySet();
		for (Specialite specialite : lesSpes) {
			sSpes = sSpes + specialite.getName() + ", ";
		}
		return sSpes.substring(0, sSpes.length()-2);
	}

	/**
	 * @return the listeSpecialite
	 */
	public ArrayList<Specialite> getListeSpecialite() {
		return listeSpecialite;
	}

	/**
	 * @param listeSpecialite the listeSpecialite to set
	 */
	public void setListeSpecialite(ArrayList<Specialite> listeSpecialite) {
		this.listeSpecialite = listeSpecialite;
	}
	
	public ArrayList<CompteRendu> listeCompteRendu(){
		ArrayList<CompteRendu> lcr = new ArrayList<CompteRendu>();
		for (Specialite spec:listeSpecialite){
			ArrayList<CompteRendu> lcr2 = this.lesComptesRendus.get(spec);
			for ( CompteRendu cr: lcr2){
				lcr.add(cr);
			}
		}
		return lcr;
	}
	
	public void imprimeCompteRendu(){
		ArrayList<CompteRendu> lcr = this.listeCompteRendu();
		int i = 0;
		for (CompteRendu cr:lcr){
			System.out.println("\nCompte Rendu numéro "+i+":");
			System.out.println("\nSpécialite : "+cr.getSpecialiste().getSpecialite().getName());
			System.out.println("\nMédecin : "+cr.getSpecialiste().getName());
			System.out.println("\n"+cr.getCorps()+"\n");
			i += 1;
		}
	}
	
	/**
	 * @return the prochainCompteRendu
	 */
	public CompteRendu getProchainCompteRendu() {
		return prochainCompteRendu;
	}

	/**
	 * @param prochainCompteRendu the prochainCompteRendu to set
	 */
	public void setProchainCompteRendu(CompteRendu prochainCompteRendu) {
		this.prochainCompteRendu = prochainCompteRendu;
	}
}

