class Solution {
    public int solution(int[] arr) {
        int answer = lcm(arr[0], arr[1]);
        
        for (int i = 2; i < arr.length; i++) {
            answer = lcm(answer, arr[i]);
        }
        
        return answer;
    }
    
    private int lcm(int a, int b) {
        return (a * b) / gcd(a, b);
    }

    private int gcd(int a, int b) {
      int r = 0;
        
      while (b != 0) {
        r = a % b;
        a = b;
        b = r;
      }
        
      return a;
    }
}
