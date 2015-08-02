package test;
import static org.junit.Assert.*;

import org.junit.Test;

import propertyBuilder.proposition.Atomic;
import propertyBuilder.proposition.ConsecutiveC;
import propertyBuilder.proposition.EventualC;
import propertyBuilder.scopes.AfterL;
import propertyBuilder.scopes.AfterLuntilR;
import propertyBuilder.scopes.BeforeR;
import propertyBuilder.scopes.BetweenLandR;
import propertyBuilder.scopes.Global;

public class Test_CreateScope {
	Atomic propL = new Atomic("L");
	Atomic propR = new Atomic("R");
	
	EventualC compositePropL = new EventualC("L", 3);
	ConsecutiveC compositePropR = new ConsecutiveC("R", 3);
	
	@Test
	public void Global(){
		Global globalScope = new Global();
		assertEquals(globalScope.getScopeType(), "Global");
	}
	
	@Test
	public void AfterL(){
		AfterL afterLScope = new AfterL(propL);
		assertEquals(afterLScope.getScopeType(), "AfterL");
	}
	
	@Test
	public void BeforeR(){
		BeforeR beforeRScope = new BeforeR(propR);
		assertEquals(beforeRScope.getScopeType(), "BeforeR");
	}
	
	@Test
	public void AfterLuntilR(){
		AfterLuntilR afterLuntilRScope = new AfterLuntilR(propL, propR);
		assertEquals(afterLuntilRScope.getScopeType(), "AfterLuntilR");
	}
	
	@Test
	public void BetweenLandR(){
		BetweenLandR betweenLandRScope = new BetweenLandR(propL, propR);
		assertEquals(betweenLandRScope.getScopeType(), "BetweenLandR");
	}

	
	@Test
	public void compositeAfterL(){
		AfterL afterLScope = new AfterL(compositePropL);
		assertEquals(afterLScope.getScopeType(), "AfterL");
	}
	
	@Test
	public void compositeBeforeR(){
		BeforeR beforeRScope = new BeforeR(compositePropR);
		assertEquals(beforeRScope.getScopeType(), "BeforeR");
	}
	
	@Test
	public void compositeAfterLuntilR(){
		AfterLuntilR afterLuntilRScope = new AfterLuntilR(compositePropL, compositePropR);
		assertEquals(afterLuntilRScope.getScopeType(), "AfterLuntilR");
	}
	
	@Test
	public void compositeBetweenLandR(){
		BetweenLandR betweenLandRScope = new BetweenLandR(compositePropL, compositePropR);
		System.out.println(betweenLandRScope.getScopeType());
	}
}