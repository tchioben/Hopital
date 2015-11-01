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
 * acteur : le spécialiste
 * 1- saisie du nom de spécialiste (si inconnu arrêt) 
 * 2- saisie du nom du patient (si inconnu, pas entré ou si spécialité absente de sa liste de séjour arrêt) 
 * 3- affichage des comptes-rendus de la spécialité présents dans la fiche de suivi 
 * 4- saisie d’un nouveau compte-rendu pour ce séjour
 * 
 * @author Léa Vanelle, Benoît Bailleul
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
		
		/*on regarde si il y a deja une consultation en attente */
	if(patient==null){
				System.out.println("Le patient n'existe pas");
			} 
	else {
		if (patient.getFicheSejour().getProchainCompteRendu()!= null){
			String nomMedecin2 = patient.getFicheSejour().getProchainCompteRendu().getSpecialiste().getName();
			System.out.println("Le patient doit d'abord aller voir le medecin "+nomMedecin2);
		}
		else{
			if (specialiste== null){
				System.out.println("Le medecin n'existe pas");
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
					 FabriqueCompteRendu fcr = FabriqueCompteRendu.getINSTANCE();
					 CompteRendu nouveauCompteRendu = fcr.createCompteRendu(specialiste);
					 FicheSejour ficheSejour = patient.getFicheSejour();
					 ficheSejour.setProchainCompteRendu(nouveauCompteRendu);
					 System.out.println("La prochain rendez-vous a été créé.\n");
					
				}
			}
		}
	}
	
	public static void remplirCompteRendu(String nomPatient){
		FabriquePatient fp = FabriquePatient.getINSTANCE();
		Patient patient = fp.searchPatient(nomPatient);
		CompteRendu cr = patient.getFicheSejour().getProchainCompteRendu();
		String corps = cr.getCorps() + "\n\n";
		String suite = Main.Saisie("Tapez votre commentaire:");
		cr.setCorps(suite);
		String fini = Main.Saisie("La consultation est-elle terminée? Tapez \"O\" pour Oui et \"N\" pour Non");
		if (fini=="O"){
			patient.getFicheSejour().addCompteRendu(cr);
			patient.getFicheSejour().setProchainCompteRendu(null);
		}
	}
		
}
