class Solution {
    public int[] solution(String[] wallpaper) {
        int[] answer = new int[] { 50, 50, 0, 0 };
        
        for (int i = 0; i < wallpaper.length; i++) {
            char[] files = wallpaper[i].toCharArray();
            
            for (int j = 0; j < files.length; j++) {
                if (files[j] == '#') {
                    
                    answer[0] = answer[0] > i? i : answer[0];
                    answer[1] = answer[1] > j? j : answer[1];
                    answer[2] = answer[2] < i + 1? i + 1 : answer[2];
                    answer[3] = answer[3] < j + 1? j + 1 : answer[3];
                }
            }
        }
        
        return answer;
    }
}
