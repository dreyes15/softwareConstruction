package test;
import static org.junit.Assert.*;

import org.junit.Test;

import ltlGenerator.propertyBuilder.patterns.Absence;
import ltlGenerator.propertyBuilder.patterns.Existence;
import ltlGenerator.propertyBuilder.patterns.Precedence;
import ltlGenerator.propertyBuilder.patterns.Response;
import ltlGenerator.propertyBuilder.proposition.AtLeastOneC;
import ltlGenerator.propertyBuilder.proposition.Atomic;
import ltlGenerator.propertyBuilder.proposition.ParallelC;

public class Test_CreatePattern {
	Atomic propP = new Atomic("P");				
	AtLeastOneC propCP = new AtLeastOneC("P", 3);	
	
	Atomic propQ = new Atomic("Q");
	ParallelC propCQ = new ParallelC("Q", 3);
	
	@Test
	public void Existence() {
		Existence existence = new Existence(propP, propQ);
		assertEquals(existence.getPatternType(), "Existence");
	}
	
	@Test
	public void Absence() {
		Absence absence = new Absence(propP, propQ);
		assertEquals(absence.getPatternType(), "Absence");
	}
	
	@Test
	public void Precedence() {
		Precedence precedence = new Precedence(propP, propQ);
		assertEquals(precedence.getPatternType(), "Precedence");
	}	
	
	@Test
	public void Response() {
		Response response = new Response(propP, propQ);
		assertEquals(response.getPatternType(), "Response");
	}
	
	@Test
	public void ExistenceCP() {
		Existence existence = new Existence(propCP, propCQ);
		assertEquals(existence.getPatternType(), "Existence");
	}
	
	@Test
	public void AbsenceCP() {
		Absence absence = new Absence(propCP, propCQ);
		assertEquals(absence.getPatternType(), "Absence");
	}
	
	@Test
	public void PrecedenceCP() {
		Precedence precedence = new Precedence(propCP, propCQ);
		assertEquals(precedence.getPatternType(), "Precedence");
	}	
	
	@Test
	public void ResponseCP() {
		Response response = new Response(propCP, propCQ);
		assertEquals(response.getPatternType(), "Response");
	}
}