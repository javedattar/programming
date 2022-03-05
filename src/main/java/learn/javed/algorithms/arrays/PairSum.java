package learn.javed.algorithms.arrays;

import java.util.HashMap;
import java.util.Map;

public class PairSum {

	public void run() {
	    int k_1 = 6;
	    int[] arr_1 = {1, 2, 3, 4, 3};
	    int expected_1 = 2;
	    int output_1 = numberOfWays(arr_1, k_1);
	    System.out.println(output_1);

	    int k_2 = 6;
	    int[] arr_2 = {1, 5, 3, 3, 3};
	    int expected_2 = 4;
	    int output_2 = numberOfWays(arr_2, k_2);
	    System.out.println(output_2);

	    // Add your own test cases here
	    
	  }
	  public static void main(String[] args) {
	    new PairSum().run();
	  }
	
	int numberOfWays(int[] arr, int k) {
	    int pairCounter = 0;
	    Map<Integer, Integer> pairRequired = new HashMap<>();

	    for(int i=0; i< arr.length; i++) {
	      pairRequired.put(arr[i], pairRequired.getOrDefault(arr[i], 0)+1);
	    }
	    for(int i=0; i< arr.length; i++) {
	      int v = k - arr[i];
	      if(pairRequired.containsKey(v) && pairRequired.get(v) != 0) {
	        int freq = pairRequired.get(v);
	        int freqK = pairRequired.get(arr[i]);
	        if(v == arr[i]) {
	        	int poss = 0;
	        	while(freq > 0) {
	        		poss += (freq-1);
	        		freq--;
	        	}
	        	pairCounter += poss;
	        } else {
	        	pairCounter += freq*freqK;
	        	
	        }
	        pairRequired.put(v, 0);
	        pairRequired.put(arr[i], 0);
	      }
	      
	    }
	    return pairCounter;
	  }

}
