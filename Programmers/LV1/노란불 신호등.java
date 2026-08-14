class Solution {
    public int solution(int[][] signals) {
        
        int maxSec = 1;
        
        for(int[] signal: signals) {
            int cycle = signal[0] + signal[1] + signal[2];
            maxSec = lcm(cycle, maxSec);
        }
                
        for(int i=1; i<=maxSec; i++) {
            boolean allYellow = true;
            
            for(int[] signal: signals) {
                int num = i % (signal[0] + signal[1] + signal[2]);
                
                if(num < signal[0] + 1 || num > signal[0] + signal[1]) {
                    allYellow = false;
                    break;
                }
            }
            
            if(allYellow) return i;
        }
        
        return -1;
    }
    
    // 최대공약수(GCM) / 최소공배수 (LCM)
    // LCM(a, b) = a * b / GCM(a, b)
    
    int gcd(int a, int b) {
        while(b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
    
    int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }
}
