class Solution {
    public int solution(int[] nums) {
        int answer = 0;

        for(int i=0; i< nums.length; i++) {
            for(int j=i+1; j< nums.length; j++) {
                for(int k=j+1; k< nums.length; k++) {
                    int num = nums[i] + nums[j] + nums[k];
                    int count = 0;
                    for(int l=1; l * l <=num; l++) {
                        if(num % l == 0) {
                            if(l * l == num) count++;
                            else count += 2;
                        }
                    }
                    if(count == 2) answer++;
                }
            }
        }

        return answer;
    }
}
