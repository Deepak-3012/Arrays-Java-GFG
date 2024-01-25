//{ Driver Code Starts
import java.io.*;
import java.util.*;
import java.lang.*;


class Array {

	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
		while(t-->0){
		  
		    //size of array
		    int n = Integer.parseInt(br.readLine().trim());
		    int arr[] = new int[n];
		    String inputLine[] = br.readLine().trim().split(" ");
		    
		    //adding elements to the array
		    for(int i=0; i<n; i++){
		        arr[i] = Integer.parseInt(inputLine[i]);
		    }
		    
		    Solution obj = new Solution();
		    
		    //calling trappingWater() function
		    System.out.println(obj.trappingWater(arr, n));
		}
	}
}


// } Driver Code Ends

// TC - O(n)
// SC - O(n)
class Solution{
    
    // arr: input array
    // n: size of array
    // Function to find the trapped water between the blocks.
    static long trappingWater(int arr[], int n) { 
        // Your code here
        long [] lg = new long[n];
        lg[0] = (long)arr[0];
        for(int i=1; i<n; i++){
            lg[i] = Math.max((long)arr[i],lg[i-1]);
        }
        long [] rg = new long[n];
        rg[n-1] = (long)arr[n-1];
        for(int i=n-2; i>=0; i--){
            rg[i] = Math.max((long)arr[i],rg[i+1]);
        }
        long [] water = new long[n];
        for(int i=0 ; i<n ;i++){
            water[i] = Math.min(lg[i],rg[i])-arr[i];
        }
        long sum =0; 
        for(int i=0; i<n; i++){
            sum+=water[i];
        }
      
      
   
         return sum;
    } 
}


