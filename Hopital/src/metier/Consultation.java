/**
 * 
 */
package metier;

import java.util.ArrayList;

import domaine.CompteRendu;
import domaine.FicheSejour;
import domaine.Patient;
import domaine.Specialiste;
import domaine.Specialite;
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
	public static void consultation(String nomPatient){
		FabriquePatient fp = FabriquePatient.getINSTANCE();
		Patient patient = fp.searchPatient(nomPatient);
		FicheSejour fichePatient = patient.getFicheSejour();
		
		if (patient == null){System.out.println("le patient n'existe pas.\n");}
		else {
			FabriqueSpecialiste fs = FabriqueSpecialiste.getINSTANCE();
			System.out.println("Voici les noms des differents specialistes de "+nomPatient);
			ArrayList<Specialiste> liste = fs.getNomSpecialistes();
			for (Specialite spec: fichePatient.getListeSpecialite()){
					System.out.println(spec.getName()+"\n");
			}
			for (Specialiste spec: liste){
				if (fichePatient.getListeSpecialite().contains(spec.getSpecialite())){
					System.out.println(spec.getName()+" : "+spec.getSpecialite().getName()+"\n");
				}  
			}
			String nomMedecin = Main.Saisie("Indiquez celui qui vous interesse");
			if (fs.searchSpecialiste(nomMedecin)==null){
				System.out.println("le medecin n'existe pas");
			}
			else {
				Specialiste specialiste= fs.searchSpecialiste(nomMedecin);
				if (fichePatient.getListeSpecialite().contains(specialiste.getSpecialite())){
					if (fichePatient.prochainCompteRenduPrevu()){
						System.out.println("Ce patient doit d'abord voir le medecin : "+fichePatient.getProchainCompteRendu().getSpecialiste().getName());
					}
					else {
							fichePatient.setProchainCompteRendu( new CompteRendu(specialiste));
							remplirCompteRendu(nomPatient);
					}
					
				}
				else {System.out.println(nomPatient+" n'a pas cette specialite dans son séjour.");
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
		cr.setCorps(corps+suite);
		String fini = Main.Saisie("La consultation est-elle terminée? Tapez \"O\" pour Oui et \"N\" pour Non");
		if (fini.equals(new String("O"))){
			patient.getFicheSejour().addCompteRendu(cr);
			patient.getFicheSejour().setProchainCompteRendu(null);
			boolean rt = patient.getFicheSejour().getListeSpecialite().remove(cr.getSpecialiste().getSpecialite());
			System.out.println(rt+"putain");
		}
	}
}
		

