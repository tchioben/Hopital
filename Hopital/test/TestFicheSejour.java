import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author Benoît
 *
 */
public class TestFicheSejour {

	@Test
	public void TestAjoutFiche(){
		FicheSejour fs = new FicheSejour();
		assertTrue("hashmap ne contient pas \"Cardio\"", fs.getFicheSuivi("Cardio") ==  null);
		
		FicheSuivi fsuivi= new FicheSuivi(new Specialite("Cardio"));
		fs.addFicheSuivi(fsuivi.getSpec().getName(),fsuivi);
		assertFalse("hashmap ne contient pas \"Cardio\"", fs.getFicheSuivi("Cardio") ==  null);
		assertFalse("hashmap ne contient pas \"Cardio\"", fs.getFicheSuivi("Cardio") ==  null);
	}
	
}
