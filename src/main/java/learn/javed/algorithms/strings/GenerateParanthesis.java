package learn.javed.algorithms.strings;

import java.util.ArrayList;
import java.util.List;

public class GenerateParanthesis {

	public static void main(String[] args) {
		GenerateParanthesis gp = new GenerateParanthesis();
		gp.generateParenthesis(3);
	}

	
	public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        StringBuilder sbr = new StringBuilder();
        _generateParanthesis(0, n, result, sbr);
        return result;
        
    }
    private void _generateParanthesis(int index, int n, List<String> result, StringBuilder sbr) {
        if(n*2 == sbr.length()) 
            if(!result.contains(sbr.toString()))
                result.add(sbr.toString());
            sbr = new StringBuilder();
        if(index >= n) {
            return;
        }
        
        int i = 0;

        while(i<n) {
            if(sbr.length() > index)
                sbr.insert(index, "()");
            else 
                sbr.append("()");
            _generateParanthesis(index+1,n,result,sbr);
            i++;
        }
        
        
    
        
    }
}
