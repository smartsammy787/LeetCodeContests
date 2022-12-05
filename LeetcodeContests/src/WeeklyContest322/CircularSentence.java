package WeeklyContest322;

public class CircularSentence {

	 public boolean isCircularSentence(String sent) {
	        
	       int i=0;
	        String arr[]=sent.split(" ");
	       char firstChar=arr[i].charAt(0);
	        
	        
	        for( i=0;i<arr.length-1;i++){
	            
	            char lastChar=arr[i].charAt(arr[i].length()-1);
	            if(lastChar!=arr[i+1].charAt(0)){
	                return false;
	            }
	        }
	        if(arr[i].charAt(arr[i].length()-1)!=firstChar){
	            return false;
	        }
	        
	        return true;
	    }
}
