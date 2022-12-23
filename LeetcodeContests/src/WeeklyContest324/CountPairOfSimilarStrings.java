package WeeklyContest324;

import java.util.HashSet;
import java.util.Set;

public class CountPairOfSimilarStrings {

	
	
	 public int similarPairs(String[] words) {
	        int ans=0;
	        for(int i=0;i<words.length;i++){
	            for(int j=i+1;j<words.length;j++){
	                Set<Character> temp=calc(words[i]);
	                if(temp.equals(calc(words[j]))){
	                    ans++;
	                }
	            }
	        }
	        
	        return ans;
	    }
	    
	    Set<Character> calc(String word){
	        HashSet<Character> set=new HashSet();
	        
	        for(int i=0;i<word.length();i++){
	            set.add(word.charAt(i));
	        }
	        
	        return set;
	    }

}
