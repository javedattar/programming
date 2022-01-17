package learn.javed.algorithms.nums;

public class SquareRoot {

	public static void main(String[] args) {
		System.out.println(mySqrt(2147395599));
//		System.out.println(mySqrtLogN(2147395599));
//		System.out.println(mySqrtLogN(2));
		System.out.println(mySqrtLogN(4));
//		System.out.println(mySqrtLogN(8));
//		System.out.println(mySqrtLogN(24));

	}

	public static int mySqrt(int x) {

		int prevSqrt = 0;
		int i = 1;
		int numOfIterations = Math.min(x / 2, 65536);
		numOfIterations = numOfIterations == 0 ? 1 : numOfIterations;
		while (i <= numOfIterations && (i * i) > 0) {
			// System.out.println(i+" sqrt of=> "+(i*i));
			if ((i * i) <= x) {
				prevSqrt = i;
			} else {
				break;
			}
			i++;
		}
		return prevSqrt;

	}

	public static int mySqrtLogN(int x) {
		if(x==1 || x==0) {
			return x;
		}
		int prevSqrt = 0;
		int numOfIterations = Math.min(x / 2, 65536);
		numOfIterations = numOfIterations == 0 ? 1 : numOfIterations;
		int left=0, right=numOfIterations+1, middle = right/2;
		while(left < right) {
			if (middle*middle < 0) {
				right = middle;
				middle = (left+right)/2;
				continue;
				
			}
			System.out.println(middle + " << middle  "+prevSqrt+" sqrt of=> "+(prevSqrt*prevSqrt));
			if(middle*middle <= x) {
				left = middle;
				if(prevSqrt == middle) {
					break;
				}
				prevSqrt = middle;
				
			} else {
				right = middle;
			}
			middle = (left+right)/2;
		}
		return prevSqrt;

	}
}
