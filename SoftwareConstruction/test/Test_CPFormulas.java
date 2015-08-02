package test;
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

import CPSubstitutor;
import ltlGenerator.formulaBuilder.specialOperator.AndL;
import ltlGenerator.formulaBuilder.specialOperator.AndNotL;
import ltlGenerator.formulaBuilder.specialOperator.AndR;
import ltlGenerator.propertyBuilder.proposition.AtLeastOneC;
import ltlGenerator.propertyBuilder.proposition.Atomic;
import ltlGenerator.propertyBuilder.proposition.ConsecutiveC;
import ltlGenerator.propertyBuilder.proposition.EventualE;
import ltlGenerator.propertyBuilder.proposition.ParallelC;
import ltlGenerator.propertyBuilder.proposition.Proposition;

public class Test_CPFormulas {
	
	//	Atomic class Tests
	@Test
	public void atomic_Test() {
		String baseFormula = "!P^pH^X!L";
		Proposition p = new Atomic("P");
		
		assertEquals(CPSubstitutor.substituteCompositeProps(baseFormula, p), 
				"!(P)^(P)^X!L");
	}
	
	@Test
	public void atomicH_Test() {
		String baseFormula = "!P^pH^X!L";
		Proposition p = new Atomic("P");
		
		assertEquals(CPSubstitutor.substituteCompositeProps(baseFormula, p), 
				"!(P)^(P)^X!L");
	}
	
	//	AtLeastOne Tests
	@Test
	public void atLeastOneC_Test() {
		String baseFormula = "!(P)^pH^L";
		Proposition l = new AtLeastOneC("L", 3);
		
		assertEquals(CPSubstitutor.substituteCompositeProps(baseFormula, l),
				"!(P)^pH^(L1VL2VL3)");
	}
	
	@Test
	public void atLeastOneE_Test() {
		String baseFormula = "!(P)^pH^L";
		Proposition l = new AtLeastOneC("L", 3);
		
		assertEquals(CPSubstitutor.substituteCompositeProps(baseFormula, l),
				"!(P)^pH^(L1VL2VL3)");
	}
	
	@Test
	public void atLeastOneH_Test() {
		String baseFormula = "!(P)^lH^L";
		Proposition l = new AtLeastOneC("L", 3);
		
		assertEquals(CPSubstitutor.substituteCompositeProps(baseFormula, l),
				"!(P)^(L1VL2VL3)^(L1VL2VL3)");
	}
	
	//	Parallel Tests
	@Test
	public void parallelE_Test() {
		String baseFormula = "!Q^qH^L";
		Proposition q = new ParallelC("Q", 2);
		
		assertEquals(CPSubstitutor.substituteCompositeProps(baseFormula, q), 
				"!(Q1^Q2)^(Q1^Q2)^L");
	}
	
	@Test
	public void parallelH_Test() {
		String baseFormula = "!Q^qH^L";
		Proposition q = new ParallelC("Q", 2);
		
		assertEquals(CPSubstitutor.substituteCompositeProps(baseFormula, q), 
				"!(Q1^Q2)^(Q1^Q2)^L");
	}
	
	//Combination Tests
	@Test
	public void combinePQ_Test() {
		String baseFormula = "!L^lH^P^XQ";
		Proposition p = new AtLeastOneC("P", 3);
		Proposition q = new ParallelC("Q", 2);
		
		String replaceP = CPSubstitutor.substituteCompositeProps(baseFormula, p);
		String replaceQ = CPSubstitutor.substituteCompositeProps(replaceP, q);
				
		assertEquals(replaceQ, "!L^lH^(P1VP2VP3)^X(Q1^Q2)");
	}
	
	@Test
	public void combinePQL_Test() {
		String baseFormula = "!L^lH^P^XQ";
		Proposition p = new AtLeastOneC("P", 3);
		Proposition q = new ParallelC("Q", 2);
		Proposition l = new Atomic("L");
		
		String replaceP = CPSubstitutor.substituteCompositeProps(baseFormula, p);
		String replaceQ = CPSubstitutor.substituteCompositeProps(replaceP, q);
		String replaceL = CPSubstitutor.substituteCompositeProps(replaceQ, l);
		
		assertEquals(replaceL, "!(L)^(L)^(P1VP2VP3)^X(Q1^Q2)");
	}
	
	@Test
	public void combinePQLR_Test() {
		String baseFormula = "!R^lH^P^XQ";
		Proposition p = new AtLeastOneC("P", 3);
		Proposition q = new ParallelC("Q", 2);
		Proposition l = new Atomic("L");
		Proposition r = new AtLeastOneC("R", 2);
		
		String replaceP = CPSubstitutor.substituteCompositeProps(baseFormula, p);
		String replaceQ = CPSubstitutor.substituteCompositeProps(replaceP, q);
		String replaceL = CPSubstitutor.substituteCompositeProps(replaceQ, l);
		String replaceR = CPSubstitutor.substituteCompositeProps(replaceL, r);
		
		assertEquals(replaceR, "!(R1VR2)^(L)^(P1VP2VP3)^X(Q1^Q2)");
	}
	
	@Test
	//Q Precedes Pc After L Until Rc 
	public void newCombinePQLR_Test1() {
		String baseFormula = "[](L->(L&l((<>R->((!(P&r!R))U((Q&-lPVR))^((!<>R)->!((!Q)U(P^!Q)))))))";
		Proposition p = new AtLeastOneC("P", 3);
		Proposition q = new ParallelC("Q", 2);
		Proposition l = new Atomic("L");
		Proposition r = new AtLeastOneC("R", 2);
		
		String replaceP = CPSubstitutor.substituteCompositeProps(baseFormula, p);
		String replaceQ = CPSubstitutor.substituteCompositeProps(replaceP, q);
		String replaceL = CPSubstitutor.substituteCompositeProps(replaceQ, l);
		String replaceR = CPSubstitutor.substituteCompositeProps(replaceL, r);
		
		//System.out.println(replaceR);
		
		assertEquals(replaceR, "[]((L)->((L)&l((<>(R1VR2)->((!((P1VP2VP3)&r!(R1VR2)))U(((Q1^Q2)&-l(P1VP2VP3)V(R1VR2)))^((!<>(R1VR2))->!((!(Q1^Q2))U((P1VP2VP3)^!(Q1^Q2))))))))");
	}
	
	@Test
	//Q Precedes Pc After L Until Rc 
	public void newCombinePQLR_Test2() {
		
		AndL andL = new AndL();
		AndR andR = new AndR();
		AndNotL andNotL = new AndNotL();
		//String baseFormula = "[](L->(L&l((<>R->((!(P&r!R))U((Q&-lPVR))^((!<>R)->!((!Q)U(P^!Q)))))))";
		String baseFormula = "Q&rP";
		Proposition p = new Atomic("P");//EventualE 3
		Proposition q = new EventualE("Q", 3);//ParallelC 5
		Proposition l = new ConsecutiveC("L", 4);//ConsecutiveC 4
		Proposition r = new AtLeastOneC("R", 2);//AtLeastOneC 2
		
		String replaceP = CPSubstitutor.substituteCompositeProps(baseFormula, p);
		String replaceQ = CPSubstitutor.substituteCompositeProps(replaceP, q);
		String replaceL = CPSubstitutor.substituteCompositeProps(replaceQ, l);
		String replaceR = CPSubstitutor.substituteCompositeProps(replaceL, r);
		String andLFormula = andL.replaceAndL(replaceR);
		String andRFormula = andR.replaceAndR(andLFormula);
		String andNotLFormula = andNotL.replaceAndNotL(andRFormula, q);
		
		System.out.println(replaceR);
		System.out.println();
		System.out.println(andLFormula);
		System.out.println();
		System.out.println(andRFormula);
		System.out.println();
		System.out.println(andNotLFormula);
		
		//assertEquals(andLFormula, "[]((L1^X(L2^X(L3^X(L4))))->((L1^X(L2^X(L3^X(L4&((<>(R1VR2)->((!((!(P1)^!(P2)^!(P3))^((!(P1)^!(P2)^!(P3))U((P1^!(P2)^!(P3)^((!(P2)^!(P3))U(P2^!(P3)^((!(P3)U(P3))))))))&r!(R1VR2)))U(((Q1^Q2^Q3^Q4^Q5)&-l(!(P1)^!(P2)^!(P3))^((!(P1)^!(P2)^!(P3))U((P1^!(P2)^!(P3)^((!(P2)^!(P3))U(P2^!(P3)^((!(P3)U(P3))))))))V(R1VR2)))^((!<>(R1VR2))->!((!(Q1^Q2^Q3^Q4^Q5))U((!(P1)^!(P2)^!(P3))^((!(P1)^!(P2)^!(P3))U((P1^!(P2)^!(P3)^((!(P2)^!(P3))U(P2^!(P3)^((!(P3)U(P3))))))))^!(Q1^Q2^Q3^Q4^Q5))))))))))))");
	}
}