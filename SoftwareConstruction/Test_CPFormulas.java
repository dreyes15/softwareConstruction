/* Course: Software Construction / CS5374
 * Team: Victoria Bravo, Florencia Larsen, Jorge Martinez, Troy McGarity, 
 * 		 Lucia Rodriguez, and David Torres 
 * Project: LTL Generator
 * Sprint: CP Generation
 * Due Date: July 3, 2015
 * Purpose: This class tests the integration and functionalities of the CP generation classes
 * name <CP class>Sub. 
 */

import static org.junit.Assert.*;
import org.junit.Test;

public class Test_CPFormulas {
	
	//	Atomic class Tests
	@Test
	public void atomic_Test() {
		String baseFormula = "!P ^ pH X (!L)";
		Proposition p = new Atomic("P");
		
		assertEquals(CPSubstitutor.substituteCompositeProps(baseFormula, p), 
				"!P ^ P X (!L)");
	}
	
	@Test
	public void atomicH_Test() {
		String baseFormula = "!P ^ pH X (!L)";
		Proposition p = new Atomic("P");
		
		assertEquals(CPSubstitutor.substituteCompositeProps(baseFormula, p), 
				"!P ^ P X (!L)");
	}
	
	//	AtLeastOne Tests
	@Test
	public void atLeastOneC_Test() {
		String baseFormula = "!P ^ pH ^ L";
		Proposition l = new AtLeastOneC("L", 3);
		
		assertEquals(CPSubstitutor.substituteCompositeProps(baseFormula, l),
				"!P ^ pH ^ L1 V L2 V L3");
	}
	
	@Test
	public void atLeastOneE_Test() {
		String baseFormula = "!P ^ pH ^ L";
		Proposition l = new AtLeastOneC("L", 3);
		
		assertEquals(CPSubstitutor.substituteCompositeProps(baseFormula, l),
				"!P ^ pH ^ L1 V L2 V L3");
	}
	
	@Test
	public void atLeastOneH_Test() {
		String baseFormula = "!P ^ lH ^ L";
		Proposition l = new AtLeastOneC("L", 3);
		
		assertEquals(CPSubstitutor.substituteCompositeProps(baseFormula, l),
				"!P ^ L1 V L2 V L3 ^ L1 V L2 V L3");
	}
	
	//	Parallel Tests
	@Test
	public void parallelE_Test() {
		String baseFormula = "!Q ^ qH ^ L";
		Proposition q = new ParallelC("Q", 2);
		
		assertEquals(CPSubstitutor.substituteCompositeProps(baseFormula, q), 
				"!Q1 ^ Q2 ^ Q1^Q2 ^ L");
	}
	
	@Test
	public void parallelH_Test() {
		String baseFormula = "!Q ^ qH ^ L";
		Proposition q = new ParallelC("Q", 2);
		
		assertEquals(CPSubstitutor.substituteCompositeProps(baseFormula, q), 
				"!Q1 ^ Q2 ^ Q1^Q2 ^ L");
	}
	
	//Combination Tests
	@Test
	public void combinePQ_Test() {
		String baseFormula = "!L ^ lH ^ P X (Q)";
		Proposition p = new AtLeastOneC("P", 3);
		Proposition q = new ParallelC("Q", 2);
		
		String replaceP = CPSubstitutor.substituteCompositeProps(baseFormula, p);
		String replaceQ = CPSubstitutor.substituteCompositeProps(replaceP, q);
				
		assertEquals(replaceQ, "!L ^ lH ^ P1 V P2 V P3 X (Q1 ^ Q2)");
	}
	
	@Test
	public void combinePQL_Test() {
		String baseFormula = "!L ^ lH ^ P X (Q)";
		Proposition p = new AtLeastOneC("P", 3);
		Proposition q = new ParallelC("Q", 2);
		Proposition l = new Atomic("L");
		
		String replaceP = CPSubstitutor.substituteCompositeProps(baseFormula, p);
		String replaceQ = CPSubstitutor.substituteCompositeProps(replaceP, q);
		String replaceL = CPSubstitutor.substituteCompositeProps(replaceQ, l);
		
		assertEquals(replaceL, "!L ^ L ^ P1 V P2 V P3 X (Q1 ^ Q2)");
	}
	
	@Test
	public void combinePQLR_Test() {
		String baseFormula = "!(R) ^ lH ^ P X (Q)";
		Proposition p = new AtLeastOneC("P", 3);
		Proposition q = new ParallelC("Q", 2);
		Proposition l = new Atomic("L");
		Proposition r = new AtLeastOneC("R", 2);
		
		String replaceP = CPSubstitutor.substituteCompositeProps(baseFormula, p);
		String replaceQ = CPSubstitutor.substituteCompositeProps(replaceP, q);
		String replaceL = CPSubstitutor.substituteCompositeProps(replaceQ, l);
		String replaceR = CPSubstitutor.substituteCompositeProps(replaceL, r);
		
		assertEquals(replaceR, "!(R1 V R2) ^ L ^ P1 V P2 V P3 X (Q1 ^ Q2)");
	}
}