import static org.junit.Assert.assertTrue;

import org.junit.Test;

import domaine.Specialite;


public class TestSpecialite {
	@Test
	public void testSpecialite(){
		Specialite spec= new Specialite("Dentiste");
		Specialite spec2= new Specialite("Dentiste");
		assertTrue("equals true?",spec.equals(spec2));
		assertTrue("hashcode ok?",spec.hashCode()==spec2.hashCode());
		
	}
}
