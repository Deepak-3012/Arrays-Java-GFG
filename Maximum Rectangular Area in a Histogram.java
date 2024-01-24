//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    
    
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
		    long n = Long.parseLong(br.readLine().trim());
		    String inputLine[] = br.readLine().trim().split(" ");
		    long[] arr = new long[(int)n];
		    for(int i=0; i<n; i++)arr[i]=Long.parseLong(inputLine[i]);
		    System.out.println(new Solution().getMaxArea(arr, n));
		}
	}
}




// } Driver Code Ends

// TC - O(n)
// SC - O(n)
class Solution
{
    
    
    // NOTE !!! ARRAY SIZE AND LOOP COUNTER SHOULD BE A INT IN JAVA(ALWAYS)
    
    
  static class Pair{
        long Value;
        long Index;
        Pair(long Value, long Index){
            this.Value = Value;
            this.Index = Index;
        }
    }
    public static long getMaxArea(long arr[], long n) 
    {
        // your code here
      long [] nsl = Nsl(arr,n);
      long []  nsr = Nsr(arr,n);
    long [] width = new long[(int)n];
    for(int i=0; i<n; i++){
        width[i] = nsr[i] - nsl[i] -1;
    }
        long [] area = new long[(int)n];
        for(int i=0 ; i<n; i++){
            area[i] = arr[i] * width[i];
        }
        long max;
        max = area[0];
        for(int i=1 ; i<n ; i++){
            if(area[i] > max)
            max = area[i];
        }
        return max;
       
    }
    public static long[] Nsl(long arr[] , long n ){
        Stack<Pair> st = new Stack<>();
        long[] left = new long[arr.length];
        for(int i=0 ; i<n; i++){
            if(st.isEmpty())
            left[i] = -1L;
            else if(!st.isEmpty() && st.peek().Value < arr[i]){
                left[i] = st.peek().Index;
            }
            else if(!st.isEmpty() && st.peek().Value >= arr[i]){
                while(!st.isEmpty() && st.peek().Value >= arr[i]){
                    st.pop();
                }
                if(st.isEmpty()){
                    left[i] = -1L;
                }
                else if(st.peek().Value < arr[i]){
                    left[i] = st.peek().Index;
                }
            }
            st.push(new Pair(arr[i] , i));
            
            
        }
        return left;
    }
    public static long[] Nsr(long arr[] , long n ){
        Stack<Pair> st = new Stack<>();
        long[] right = new long[arr.length];
        for(int i=(int)n-1 ; i>=0; i--){
            if(st.isEmpty())
            right[i] = arr.length;
            else if(!st.isEmpty() && st.peek().Value < arr[i]){
                right[i] = st.peek().Index;
            }
            else if(!st.isEmpty() && st.peek().Value >= arr[i]){
                while(!st.isEmpty() && st.peek().Value >= arr[i]){
                    st.pop();
                }
                if(st.isEmpty()){
                    right[i] = arr.length;
                }
                else if(st.peek().Value < arr[i]){
                    right[i] = st.peek().Index;
                }
            }
            st.push(new Pair(arr[i] , i));
            
            
        }
        return right;
    }
        
}



