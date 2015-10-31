import static org.junit.Assert.assertTrue;

import org.junit.Test;

import domaine.CompteRendu;
import domaine.Specialiste;
import domaine.Specialite;


public class TestCompteRendu {
	@Test
	public void testCompteRendu(){
		
		CompteRendu spec= new CompteRendu(new Specialiste("benoit",new Specialite("Dentiste")));
		CompteRendu spec2= new CompteRendu(new Specialiste("benoit",new Specialite("Dentiste")));

		assertTrue("equals true?",spec.equals(spec2));

		assertTrue("hashcode ok?",spec.hashCode()==spec2.hashCode());
		
	}
	
}
