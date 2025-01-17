import java.util.Arrays;

class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        Arrays.sort(targets, (o1, o2) -> {
            return o1[0] - o2[0] != 0? o1[0] - o2[0] : o2[1] - o1[1];
        });

        for (int i = 0; i < targets.length; i++) {
            if (targets[i][0] <= -1) {
                continue;
            }
            
            int targetX = targets[i][1];
            
            for (int j = i + 1; j < targets.length; j++) {
                if (targetX > targets[j][0] && targets[j][0] > -1) {
                    targetX = targetX > targets[j][1]? targets[j][1] : targetX;
                    targets[j][0] = -1;
                    targets[j][1] = -1;
                }
            }
            
            answer++;
        }
        
        return answer;
    }
}
