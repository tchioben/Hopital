import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import domaine.CompteRendu;
import domaine.FicheSejour;
import domaine.Specialiste;
import domaine.Specialite;

/**
 * @author Léa Vanelle, Benoît Bailleul
 *
 */
public class TestFicheSejour {

	@Test
	public void TestAjoutFiche(){
		FicheSejour fs = new FicheSejour();
		assertTrue("hashmap ne contient pas \"Cardio\"", fs.getComptesRendus(new Specialite("Cardio")) ==  null);
		
		CompteRendu cr = new CompteRendu(new Specialiste("Benoit", new Specialite("Cardio")));
		fs.addCompteRendu(cr);
		assertFalse("hashmap contient \"Cardio\"", fs.getComptesRendus(new Specialite("Cardio")) == null);		

	}
	
	
	@Test
	public void TestAjoutFiche2(){
		FicheSejour fs = new FicheSejour();
		assertTrue("hashmap ne contient pas \"Cardio\"", fs.getComptesRendus(new Specialite("Cardio")) ==  null);
		
		CompteRendu cr = new CompteRendu(new Specialiste("Benoit", new Specialite("Cardio")));
		fs.addCompteRendu(cr);
		assertFalse("hashmap contient \"Cardio\"", fs.getComptesRendus(new Specialite("Cardio")) == null);
		

	}
	
	@Test
	public void TestProchainRDV(){
		FicheSejour fs = new FicheSejour();
		assertFalse(fs.prochainCompteRenduPrevu());
		

	}
	
}
