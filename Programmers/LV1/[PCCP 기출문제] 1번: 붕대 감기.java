import java.util.*;

class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {        
        // bandage: 붕대 감기 기술의 시전 시간, 1초당 회복량, 추가 회복량
        int initialHealth = health;
        
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<attacks.length; i++) {
            map.put(attacks[i][0], attacks[i][1]);  // 공격시간과 피해량을 map에 넣음
        }
        
        int continueSec = 0;  // 연속 성공 시간
        int sec = attacks[attacks.length-1][0];  // 0초에서 sec초까지 for문 돌림
        for(int i=1; i<=sec; i++) {
            // 몬스터의 공격을 받음
            if(map.containsKey(i)) {
                health -= map.get(i);
                continueSec = 0;
                if(health <= 0) return -1;
            }
            else {
                continueSec++;
                health += bandage[1];  // 1초당 회복량
                if(continueSec == bandage[0]) {
                    health+= bandage[2];
                    continueSec = 0;
                }
                
                if(health > initialHealth)  health = initialHealth;
            }
        }
        
        return health;
    }
}
