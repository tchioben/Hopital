/**
 * 
 */
package metier;

import java.util.ArrayList;
import java.util.Iterator;

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
	
	public static void SortieDunPatient(){
		FabriquePatient fp = FabriquePatient.getINSTANCE();
		String nomPatient = SortiePatient.SaisieNomPatient();
		Patient p = fp.searchPatient(nomPatient); // = ... + ArrayList<FicheSuivi>
		if (p == null){
			System.out.println("Ce patient n'est pas connu dans l'hopital");
			return ;
		}
		FicheSejour FSej = p.getFicheSejour(); // = HashMap<Specialite, ArrayList<CompteRendu>> + ArrayList<Specalite>
		if (FSej == null){
			System.out.println("Ce patient n'a pas de séjout en cours.\nIl est peut-etre deja sorti ou il n'est pas encore entre.");
			return;
		}
		// FicheSejour -> FicheSuivi
		System.out.println("Transfert de la fiche de sejour vers la fiche de suivi en cours ...");
		ArrayList<FicheSuivi> lFichSuiv = p.getFicheSuivi();
		ArrayList<Specialite> lSpes = FSej.getListeSpecialite();
		for (Specialite spe : lSpes) { // Pour toutes les specialites de la fiche de sejour
			Iterator<FicheSuivi> it = lFichSuiv.iterator();
			 while (it.hasNext()) {
				FicheSuivi FichSuiv = it.next();
				if (FichSuiv.getSpec() == spe){
					FichSuiv.setComptesrendus((FSej.getComptesRendus(spe)));
					System.out.println("\tLe(s) compte(s) rendu(s) de la specialite " + spe.getName() + " \n\ta(ont) été ajouté(s) à la fiche de suivi du patient " + p.getName() + ".");
					FSej.removeSpeEtComptesRendus(spe);
				}
			 }	 
		}
		if (! lSpes.isEmpty()){
			 FabriqueFicheSuivi ffsuiv = FabriqueFicheSuivi.getINSTANCE();
			 for (Specialite spe : lSpes) {
				 FicheSuivi fSuiv = ffsuiv.createFicheSuivi(spe);
				 fSuiv.setComptesrendus(FSej.getComptesRendus(spe));
				 System.out.println("\tLe(s) compte(s) rendu(s) de la specialite " + spe.getName() +" \n\ta(ont) été ajouté(s) à la fiche de suivi du patient " + p.getName() + ".");
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

