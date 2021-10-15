package learn.javed.algorithms.nums;

public class ReverseNumber {

	public static void main(String[] args) {
		System.out.println( 321 == reverse(123));
		System.out.println( -321 == reverse(-123));
		System.out.println(0 == reverse(1056389759));
		System.out.println( 0 == reverse(-1056389759));
		System.out.println( 0 == reverse(0));

	}
	
	private static int reverse(int x) {
        Long output = 0L;

        boolean isNegative = false;
        if (x < 0) {
            x = -1 * x;
            isNegative = true;
        }
        
        while (x>0) {
            output = output * 10 + x % 10;
                x = x / 10;
        }
        if (output < Integer.MIN_VALUE || output > Integer.MAX_VALUE) {
            return 0;
        }
        return isNegative ? -1 * output.intValue() : output.intValue();
    }

}
