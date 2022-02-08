package learn.javed.algorithms.strings;

public class OneEditDistance {

	public static void main(String[] args) {
		System.out.println(isOneDistanceApart("a", "b"));
		System.out.println(isOneDistanceApart("", ""));
		System.out.println(isOneDistanceApart("a", "ab"));
		System.out.println(isOneDistanceApart("ab", "acb"));
		System.out.println(isOneDistanceApart2("abc", "abx"));
		System.out.println(isOneDistanceApart2("abc", "abcx"));
		System.out.println(isOneDistanceApart2("ab", "acb"));
		System.out.println(isOneDistanceApart2("", ""));
	}

	private static boolean isOneDistanceApart(String s, String t) {
		
		int[][] dp = new int[s.length()+1][t.length()+1];
		
		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j < dp[0].length; j++) {
				if(s.charAt(i-1) == t.charAt(j-1) ) {
					dp[i][j] = dp[i-1][j-1];
				} else {
					dp[i][j] = 1+ Math.min(dp[i][j-1], Math.min(dp[i-1][j-1], dp[i-1][j]));
				}
			}
		}
		return dp[dp.length-1][dp[0].length-1] == 1;
	}
	
	private static boolean isOneDistanceApart2(String s, String t) {
		if (s == null && t == null) return true;

        int len1 = s.length();
        int len2 = t.length();

        if (s.equals(t)) return false;

        if (len1 > len2)
            return isOneDistanceApart2(t, s);

        for (int i = 0; i < len1; i++) {
            // if current chars not same, for same len string, we can exclude these chars and rest of the string should match
            // Otherwise, as first string is smaller than second one, we just need to skip char from second string
            // and match with current remaining string
            if (s.charAt(i) != t.charAt(i)) {
                if (len1 == len2)
                    return s.substring(i + 1).equals(t.substring(i + 1));
                else
                    return s.substring(i).equals(t.substring(i + 1));
            }
        }

        return true;
	}

}
