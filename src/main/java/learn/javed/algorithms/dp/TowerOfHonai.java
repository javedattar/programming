/**
* author: Javed Attar
*/
package learn.javed.algorithms.dp;

public class TowerOfHonai {
	private int steps = 0;

	public static void main(String[] args) {
		TowerOfHonai t = new TowerOfHonai();
		t.hanoi(1, "A", "C", "B");
		System.out.println("Steps for 1 disc ==> expected "+ ((int)Math.pow(2, 1) - 1) + " actual " + t.steps + "\n");
		t.steps = 0;
		t.hanoi(2, "A", "C", "B");
		System.out.println("Steps for 2 discs ==> expected " + ((int)Math.pow(2, 2) - 1) + " actual " + t.steps + "\n");
		
		t.steps = 0;
		t.hanoi(3, "A", "C", "B");
		System.out.println("Steps for 3 discs ==> expected "+ ((int)Math.pow(2, 3) - 1) + " actual "  + t.steps + "\n");
		t.steps = 0;
		t.hanoi(4, "A", "C", "B");
		System.out.println("Steps for 4 discs ==> expected " + ((int)Math.pow(2, 4) - 1) + " actual " + t.steps+ "\n");
		t.steps = 0;
		t.hanoi(5, "A", "C", "B");
		System.out.println("Steps for 5 discs ==> expected " + ((int)Math.pow(2, 5) - 1) + " actual " + t.steps+ "\n");
	}
	
	public void hanoi(int n, String from, String to, String aux) {
		if ( n==1 ) {
			System.out.println("Move disc 1 from " + from + " to " + to);
			steps++;
			return;
		}
		hanoi(n-1, from, aux, to);
		System.out.println("Move disc " + n + " from " + from + " to " + to);
		steps++;
		hanoi(n-1, aux, to, from);
	}

}
