/**
 * 
 */
package metier;

import java.util.ArrayList;

import domaine.CompteRendu;
import domaine.FicheSejour;
import domaine.FicheSuivi;
import domaine.Patient;
import domaine.Specialiste;
import fabrique.FabriqueCompteRendu;
import fabrique.FabriqueFicheSejour;
import fabrique.FabriquePatient;
import fabrique.FabriqueSpecialiste;

/** Consultation
 * 
 * acteur : le sp�cialiste
 * 1- saisie du nom de sp�cialiste (si inconnu arr�t) 
 * 2- saisie du nom du patient (si inconnu, pas entr� ou si sp�cialit� absente de sa liste de s�jour arr�t) 
 * 3- affichage des comptes-rendus de la sp�cialit� pr�sents dans la fiche de suivi 
 * 4- saisie d�un nouveau compte-rendu pour ce s�jour
 * 
 * @author L�a Vanelle, Beno�t Bailleul
 */
public class Consultation {
	/**
	 * ajoute une consultation
	 * associe le medecin au patient
	 * @param nomMedecin
	 * @param nomPatient
	 */
	public static void ajouteConsultation(String nomMedecin, String nomPatient){
		FabriqueSpecialiste fs = FabriqueSpecialiste.getINSTANCE();
		Specialiste specialiste= fs.searchSpecialiste(nomMedecin);
		FabriquePatient fp = FabriquePatient.getINSTANCE();
		Patient patient = fp.searchPatient(nomPatient);
		if (specialiste== null){
			System.out.println("Le medecin n'existe pas");
		}
		else {
			if(patient==null){
				System.out.println("Le Patient n'existe pas");
			}
			else {
				ArrayList<FicheSuivi> listeFicheSuivi = patient.getFicheSuivi();
				ArrayList<CompteRendu> listeCompteRendu = new ArrayList<CompteRendu>();
				for (FicheSuivi fiche : listeFicheSuivi){
					if (fiche.getSpec().equals(specialiste.getSpecialite())){
						listeCompteRendu = fiche.getComptesrendus();
					}
				}
				for (CompteRendu compte : listeCompteRendu){
					System.out.println(compte.getCorps());
				}
				 FabriqueFicheSejour ffs = FabriqueFicheSejour.getINSTANCE();
				 FabriqueCompteRendu fcr = FabriqueCompteRendu.getINSTANCE();
				 CompteRendu nouveauCompteRendu = fcr.createCompteRendu(specialiste);
				 FicheSejour nouvelleFicheSejour = ffs.createFicheSejour(patient);
				 nouvelleFicheSejour.addCompteRendu(nouveauCompteRendu);
			}
		}
	}
		
}
