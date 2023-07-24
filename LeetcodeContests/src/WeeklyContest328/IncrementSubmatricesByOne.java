package WeeklyContest328;

public class IncrementSubmatricesByOne {
//2536
public int[][] rangeAddQueries(int n, int[][] queries) {
        
        int [][]aux=new int[n][n];
        
        for(int[]query: queries){
            int row1=query[0];
            int col1=query[1];
            int row2=query[2];
            int col2=query[3];
            
            aux[row1][col1]+=1;
            
            if(row2+1<n){
                aux[row2+1][col1]-=1;
            }
            if (row2+1<n && col2+1 < n){
                  aux[row2 + 1][col2+1] += 1;
              }

        if (col2+1<n){
                 aux[row1][col2+1]-=1;
            }
   
        }
        
        for(int i=0;i<n;i++){
            for(int j=1;j<n;j++){
                aux[i][j]+=aux[i][j-1]; //col pre
            }
        }
        
        for(int i=0;i<n;i++){
            for(int j=1;j<n;j++){
                aux[j][i]+=aux[j-1][i]; //row pre
            }
        }
        
       return aux;
    }
}
