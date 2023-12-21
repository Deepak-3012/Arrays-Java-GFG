
class Solution {
    String removeDuplicates(String str) {
        // code here
  Set<Character> hs = new LinkedHashSet<>();
  for(char x : str.toCharArray()){
      hs.add(x);
  }
  char x[] = new char[hs.size()];
  int count =0;
    for(char c: hs){
      x[count] = c;
      count++;
  }
  String s = new String(x);
  return s;
    }
    }
