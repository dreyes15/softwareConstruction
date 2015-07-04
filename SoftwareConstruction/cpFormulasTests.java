import static org.junit.Assert.*;

import org.junit.Test;

public class cpFormulasTests {	
	
	@Test
	public void atomic_Test() {
		String baseFormula = "!P ^ PH X (!L)";
		Proposition p = new Atomic("P");
		
		assertEquals(CPSubstitutor.substituteCompositeProps(baseFormula, p), 
				"\n<Not a composite proposition, no cp formula can be generated>\n");
	}
	
	@Test
	public void parallelE_Test() {
		String baseFormula = "!Q ^ QH ^ L";
		Proposition q = new ParallelC("Q", 2);
		
		assertEquals(CPSubstitutor.substituteCompositeProps(baseFormula, q), 
				"!(Q1 ^ Q2) ^ QH ^ L");
	}
	
	@Test
	public void atLeastOneC_Test() {
		String baseFormula = "!P ^ PH ^ L";
		Proposition l = new AtLeastOneC("L", 3);
		
		assertEquals(CPSubstitutor.substituteCompositeProps(baseFormula, l), 
				"!P ^ PH ^ (L1 v L2 v L3)");
	}
}