package WeeklyContest322;

import java.util.Arrays;

public class DividePlayersTeamsEqualSkills {

	 public long dividePlayers(int[] skill) {
	        Arrays.sort(skill);
	        
	        int len=skill.length;
	        
	        
	        long ans=0;
	        for(int i=0;i<len/2;i++){
	            if(skill[i]+skill[len-i-1] != (skill[0]+skill[len-1])){
	                return -1;
	            }
	            ans+=skill[i]*skill[len-i-1];
	        }
	        return ans;
	    }
}
