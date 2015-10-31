import java.util.ArrayList;

import org.junit.*;

import domaine.FicheSuivi;
import domaine.Patient;
import domaine.Specialite;

import static org.junit.Assert.*;

/**
 * @author Léa Vanelle, Benoît Bailleul
 *
 */
public class TestPatient {

		@Test
		public void testAddFiche(){
			Patient p = new Patient("benoit","123","6 rue pierre mendes france",26);
			FicheSuivi fs= new FicheSuivi(new Specialite("Cardio"));
			p.addFicheSuivi(fs);
			ArrayList<FicheSuivi> fiche = p.getFicheSuivi();
			assertTrue("test d'ajout de fiche Suivi",fiche.get(0).getSpec().getName()=="Cardio");
		}

		
		
}
