import static org.junit.Assert.*;

import org.junit.Test;


public class CanThePropositionsBeCreated {
	
	@Test
	public void canAtomicBeCreated() {
		Proposition P = new Atomic("P");
		assertEquals(P.getName(), "P");
		assertEquals(P.getType(), "Atomic");
	}

	@Test
	public void canAtLeastOneCBeCreated() {
		Proposition L = new AtLeastOneC("L",6);
		assertEquals(L.getName(), "L");
		assertEquals(L.getType(), "AtLeastOneC");
		assertEquals(((AtLeastOneC)L).getNumber(), 6);
	}
	
	@Test
	public void canAtLeastOneEBeCreated() {
		Proposition Q = new AtLeastOneE("Q",5);
		assertEquals(Q.getName(), "Q");
		assertEquals(Q.getType(), "AtLeastOneE");
		assertEquals(((AtLeastOneE)Q).getNumber(), 5);
	}
	
	@Test
	public void canConsecutiveCBeCreated() {
		Proposition R = new ConsecutiveC("R",4);
		assertEquals(R.getName(), "R");
		assertEquals(R.getType(), "ConsecutiveC");
		assertEquals(((ConsecutiveC)R).getNumber(), 4);
	}
	
	@Test
	public void canConsecutiveEBeCreated() {
		Proposition P = new ConsecutiveE("P",3);
		assertEquals(P.getName(), "P");
		assertEquals(P.getType(), "ConsecutiveE");
		assertEquals(((ConsecutiveE)P).getNumber(), 3);
	}
	
	@Test
	public void canEventualCBeCreated() {
		Proposition Q = new EventualC("Q",2);
		assertEquals(Q.getName(), "Q");
		assertEquals(Q.getType(), "EventualC");
		assertEquals(((EventualC)Q).getNumber(), 2);
	}
	
	@Test
	public void canEventualEBeCreated() {
		Proposition L = new EventualE("L",3);
		assertEquals(L.getName(), "L");
		assertEquals(L.getType(), "EventualE");
		assertEquals(((EventualE)L).getNumber(), 3);
	}
	
	@Test
	public void canParallelCBeCreated() {
		Proposition R = new ParallelC("R",4);
		assertEquals(R.getName(), "R");
		assertEquals(R.getType(), "ParallelC");
		assertEquals(((ParallelC)R).getNumber(), 4);
	}
	
	@Test
	public void canParallelEBeCreated() {
		Proposition P = new ParallelE("P",5);
		assertEquals(P.getName(), "P");
		assertEquals(P.getType(), "ParallelE");
		assertEquals(((ParallelE)P).getNumber(), 5);
	}

}
