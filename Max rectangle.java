//{ Driver Code Starts
import java.util.*;

class FindMinCost
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t > 0)
		{
			int n = sc.nextInt();
			int m = sc.nextInt();
			int arr[][] = new int[n][m];
			for(int i=0; i<n; i++)
			{
				for(int j=0; j<m; j++ )
				{
					arr[i][j] = sc.nextInt();
				}
			}
			System.out.println(new Solution().maxArea(arr, n, m));
		t--;
		}
	}
}
// } Driver Code Ends


// TC - O(n*m)
// SC - O(m) Auxiliary space
class Solution {
    static class Custom{
        int Value; 
        int Index;
        Custom(int Value , int Index){
            this.Value = Value;
            this.Index = Index;
        }
    }
    public int maxArea(int arr[][], int n, int m) {
        // add code here.
        int [] res = new int [m];
        for(int i=0; i<m; i++){
            res[i] = arr[0][i];
        }
        int max = mah(res);
        for(int i=1; i<n; i++){
            for(int j=0; j<m; j++){
                if(arr[i][j] ==0)
                    res[j] = 0;
                
                else {
                    res[j] = res[j] + arr[i][j];
                }
            }
            max = Math.max(max, mah(res));
         
            }
            return max;
        }
        
    
    public int mah (int [] arr){
        int [] nsl = nsl(arr);
        int [] nsr = nsr(arr);
        int [] width = new int [arr.length];
        for(int i=0; i<arr.length; i++){
            width[i] = nsr[i] - nsl[i]-1; 
        }
        int [] area = new int [arr.length];
        for(int i=0; i<arr.length; i++){
            area[i] = width[i] * arr[i];
        }
        int maximum = 0; 
        for(int i = 0 ; i<arr.length; i++){
            if(area[i] > maximum){
             maximum = area[i];   
            }
        }
        return maximum;
    }
    
    public int [] nsl(int [] arr){
        int [] left = new int [arr.length];
        Stack<Custom> st = new Stack<>();
        for(int i=0; i<arr.length; i++){
            if(st.isEmpty())
            left[i] = -1;
            else if(!st.isEmpty() && st.peek().Value < arr[i]){
                left[i] = st.peek().Index;
            }
            else if(!st.isEmpty() && st.peek().Value >= arr[i]){
                while(!st.isEmpty() && st.peek().Value >= arr[i])
                {
                    st.pop();
                }
                if(st.isEmpty()){
                left[i] = -1;
                
            }
            else if(st.peek().Value < arr[i]){
                left[i] = st.peek().Index;
            }
        }
        st.push(new Custom(arr[i] , i));
    }
    return left;
    }
    
       public int [] nsr(int [] arr){
        int [] right = new int [arr.length];
        Stack<Custom> st = new Stack<>();
        for(int i=arr.length-1; i>=0; i--){
            if(st.isEmpty())
            right[i] = arr.length;
            else if(!st.isEmpty() && st.peek().Value < arr[i]){
                right[i] = st.peek().Index;
            }
            else if(!st.isEmpty() && st.peek().Value >= arr[i]){
                while(!st.isEmpty() && st.peek().Value >= arr[i])
                {
                    st.pop();
                }
                if(st.isEmpty()){
                right[i] = arr.length;
                
            }
            else if(st.peek().Value < arr[i]){
                right[i] = st.peek().Index;
            }
        }
        st.push(new Custom(arr[i] , i));
    }
    return right;
    }
}