import java.util.*;

class Solution {
    public int[] solution(String msg) {
        
        List<Integer> answer = new ArrayList<>();
        int msgLength = msg.length();
        
        int index = 1;
        Map<String, Integer> dictionary = new HashMap<>();
        for (char c = 'A'; c <= 'Z'; c++, index++) 
            dictionary.put(Character.toString(c), index);
        
        int n = 1;
        int matchedIndex = 0;
        for (int i = 0; i < msgLength; i++) {
            if (i + n > msgLength) {
                answer.add(matchedIndex);
                break;
            }
            int tempIndex = dictionary.getOrDefault(msg.substring(i, i + n), 0);
            
            if (tempIndex != 0) {
                matchedIndex = tempIndex;
                n++;
                i--;
            } else {
                dictionary.put(msg.substring(i, i + n), index++);
                answer.add(matchedIndex);
                i += n - 2;
                n = 1;
                matchedIndex = 0;
            }
        }
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
