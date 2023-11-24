class Solution {
    // Function to return the count of the number of elements in
    // the intersection of two arrays.
    public static int NumberofElementsInIntersection(int a[], int b[], int n, int m) {
        // Your code here
        Arrays.sort(a);
        Arrays.sort(b);
        int i=0;int j =0;
            Set<Integer> hs = new HashSet<>(); // hashset does not allow duplicates
                                            //  while arraylist allows duplicates
        while(i<n && j<m){
            if(a[i]<b[j])
            i++;
            else if(b[j]<a[i])
            j++;
            else
            {                                               
                hs.add(b[j]);
                i++;
                j++;
                
            }
        }
        int count = hs.size();
        return count;
    }
}
