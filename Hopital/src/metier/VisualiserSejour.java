/**
 * 
 */
package metier;

import domaine.FicheSejour;
import domaine.Patient;
import fabrique.FabriquePatient;

/** Visualiser sejour
 * 
 *  acteur : le m�decin de garde
 *  1- saisie du nom du patient (si inconnu ou pas entr� erreur) 
 *  2- affichage de sa fiche de s�jour et des comptes-rendus d�j� effectu�s lors du s�jour
 *  
 * @author L�a Vanelle, Beno�t Bailleul
 */
public class VisualiserSejour {
	
	public static void visualiserSejour(String nomPatient){
		FabriquePatient fp = FabriquePatient.getINSTANCE();
		Patient patient = fp.searchPatient(nomPatient);
		if(patient==null){
			System.out.println("Le Patient n'existe pas");
		}
		else {
			FicheSejour fs = patient.getFicheSejour();
			fs.imprimeCompteRendu();
				
			}
		}
}
