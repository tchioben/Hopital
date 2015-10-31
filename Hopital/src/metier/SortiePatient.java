/**
 * 
 */
package metier;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

import domaine.CompteRendu;
import domaine.FicheSejour;
import domaine.FicheSuivi;
import domaine.Patient;
import domaine.Specialite;
import fabrique.FabriqueFicheSuivi;
import fabrique.FabriquePatient;

/** Sortie d'un patient
 * 
 * Acteur : le médecin de garde
 * 1- saisie du nom du patient (si inconnu ou pas entré arrêt) 
 * 2- destruction de sa fiche de séjour
 * 
 * @author Léa Vanelle, Benoît Bailleul
 */

public class SortiePatient {
	/** Realise la sortie d'un patient */
	public static void SortieDunPatient(){
		FabriquePatient fp = FabriquePatient.getINSTANCE();
		String nomPatient = SortiePatient.SaisieNomPatient();
		Patient p = fp.searchPatient(nomPatient); // = ... + ArrayList<FicheSuivi>
		if (p == null){
			System.out.println("Ce patient n'est pas connu dans l'hopital");
			return ;
		}
		FicheSejour FSej = p.getFicheSejour(); // = HashMap<Specialite, ArrayList<CompteRendu>> + ArrayList<Specalite>
		HashMap<Specialite, ArrayList<CompteRendu>> HMSpeCpteRdus = FSej.getFichesSuivi();
		if (HMSpeCpteRdus.size()==0){
			System.out.println("Le patient " + p.getName() + " n'a pas de séjour en cours.\n"
					+ "Il est peut etre deja sorti ou il n'est pas encore entre.");
		}
		else {
			System.out.println("Transfert de la fiche de sejour vers la fiche de suivi en cours ...");
			for (Entry<Specialite, ArrayList<CompteRendu>> speCpteRdu : HMSpeCpteRdus.entrySet()){
				Specialite spe = speCpteRdu.getKey();
				ArrayList<CompteRendu> lCpteRdu = speCpteRdu.getValue();
				FicheSuivi ficheSuiviSpe = p.searchFicheSuivi(spe);
				if (ficheSuiviSpe == null){ // Le patient n'a pas encore de fiche de suivi pour cette specialite -> creation
					FabriqueFicheSuivi fFSuiv = FabriqueFicheSuivi.getINSTANCE();
					FicheSuivi newFSuivi = fFSuiv.createFicheSuivi(spe);
					newFSuivi.setComptesrendus(lCpteRdu);
					p.addFicheSuivi(newFSuivi);
				}
				else { // Ajout des comptes rendu à la fiche de suivi existante
					ficheSuiviSpe.setComptesrendus(lCpteRdu);
				}
				System.out.println("  - Le(s) compte(s) rendu(s) de la specialite " + spe.getName() + " a(ont) été tranfere(s) dans la fiche de suivi du patient " + p.getName() + ".");
				HMSpeCpteRdus.remove(spe);
			}
		}
	}
	
	/** Demande la saisie du nom du patient
	 * @return une chaine de caractère contenant le nom du patient.
	 */
	public static String SaisieNomPatient(){
		return Main.Saisie("le nom du patient");
	}
}

