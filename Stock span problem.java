class Solution
{
    //Function to calculate the span of stockâ€™s price for all n days.
    static class Pair{
        int first;                                      // one way to do it ...can be done 
                                                        // without pair class 
        int second;
        
    Pair(int one, int two){
           first = one;// ind
           second = two;// value
        }
    }
    public static int[] calculateSpan(int arr[], int n)
    {
        // Your code here
        int [] ans = new int[n];
        Stack <Pair> st = new Stack<>();
    for(int i=0; i<n; i++){
        
        if(st.isEmpty()){
            ans[i] = -1;
        }
        else if(!st.isEmpty() && st.peek().second > arr[i]){
            ans[i] = st.peek().first;
        }
        else if(!st.isEmpty() && st.peek().second <= arr[i]){
            while(!st.isEmpty() && st.peek().second <= arr[i]){
                st.pop();
            }
            if(st.isEmpty()){
                ans[i] = -1;
            }
            else if(arr[st.peek().first]>arr[i]){
                ans[i] = st.peek().first;
            }
        }
        
        st.push(new Pair(i,arr[i]));
    }    
    for(int i=0; i<n; i++){
        ans[i] = i - ans[i];
    }
    return ans;
    }
    
}