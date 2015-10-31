import static org.junit.Assert.assertTrue;

import org.junit.Test;

import domaine.Specialiste;
import domaine.Specialite;


public class TestSpecialiste {
	@Test
	public void testSpecialiste(){
		Specialiste spec= new Specialiste("benoit",new Specialite("Dentiste"));
		Specialiste spec2= new Specialiste("benoit",new Specialite("Dentiste"));
		assertTrue("equals true?",spec.equals(spec2));
		assertTrue("hashcode ok?",spec.hashCode()==spec2.hashCode());
		
	}
	
	
}
