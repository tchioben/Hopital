/**
 * 
 */
package metier;

import domaine.FicheSejour;
import domaine.Patient;
import fabrique.FabriquePatient;

/** Visualiser sejour
 * 
 *  acteur : le médecin de garde
 *  1- saisie du nom du patient (si inconnu ou pas entré erreur) 
 *  2- affichage de sa fiche de séjour et des comptes-rendus déjà effectués lors du séjour
 *  
 * @author Léa Vanelle, Benoît Bailleul
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
