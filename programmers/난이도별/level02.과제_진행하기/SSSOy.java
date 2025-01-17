import java.util.*;

class Solution {
    public String[] solution(String[][] plans) {
        String[] answer = new String[plans.length];
        int answerIndex = 0;
        
        Arrays.sort(plans, (o1, o2) -> {
            return Integer.parseInt(o1[1].replace(":", ""))
                    -(Integer.parseInt(o2[1].replace(":", "")));
        });
        
        Stack<Object[]> inProgress = new Stack<>();

        for (int i = 0; i < plans.length; i++) {
            if (i == plans.length - 1) {
                answer[answerIndex++] = plans[i][0];
                break;
            }

            String[] plan = plans[i];

            int currentPlanStart = Integer.parseInt(plan[1].split(":")[0]) * 60 
                + Integer.parseInt(plan[1].split(":")[1]);
            int nextPlanStart = Integer.parseInt(plans[i+1][1].split(":")[0]) * 60 
                + Integer.parseInt(plans[i+1][1].split(":")[1]);
            int playtime = Integer.parseInt(plan[2]);

            if (nextPlanStart - currentPlanStart >= playtime) {
                answer[answerIndex++] = plan[0];

                int remainingTime = nextPlanStart - currentPlanStart - playtime;

                while (!inProgress.empty()) {
                    Object[] remainingPlan = inProgress.peek();
                    int remainingPlanPlaytime = (int) remainingPlan[1];
                    remainingPlan[1] = remainingPlanPlaytime - remainingTime;
                    remainingTime -= remainingPlanPlaytime;

                    if ((int) remainingPlan[1] <= 0) {
                        answer[answerIndex++] = (String) remainingPlan[0];
                        inProgress.pop();
                    }
                    if (remainingTime <= 0) {
                        break;
                    }
                }

            } else {
                inProgress.push(new Object[]{plan[0], playtime - (nextPlanStart - currentPlanStart)});
            }
        }

        while (!inProgress.empty()) {
            answer[answerIndex++] = (String) inProgress.pop()[0];
        }

        return answer;
    }
}
