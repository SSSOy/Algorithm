import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        Map<Integer, Integer> tangerineMap = new HashMap<>();
        
        for (int size : tangerine) {
            tangerineMap.put(size, tangerineMap.getOrDefault(size, 0) + 1);
        }
        
        List<Integer> keySet = new ArrayList<>(tangerineMap.keySet());
        keySet.sort((o1, o2) -> tangerineMap.get(o2).compareTo(tangerineMap.get(o1)));
        
        while (k > 0) {
            answer++;
            k -= tangerineMap.get(keySet.get(0));
            keySet.remove(0);
        }
        
        
        return answer;
    }
}
