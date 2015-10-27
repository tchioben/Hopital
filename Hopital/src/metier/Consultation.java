/**
 * 
 */
package metier;

import domaine.Patient;
import domaine.Specialiste;
import fabrique.FabriqueCompteRendu;
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
	public void ajouteConsultation(String nomMedecin, String nomPatient){
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
				FabriqueCompteRendu fcr = FabriqueCompteRendu.getINSTANCE();
				/**
				 * faire la liste des comptes rendu, on regarge les medecin qui ont une cette specialite et pour chaque medecin on recuperere sa liste de compte rendu)
				 * 
				 */
			}
		}
	}
		
}
