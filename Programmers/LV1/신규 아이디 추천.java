import java.util.*;

class Solution {
    public String solution(String new_id) {
        // 아이디: 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.) -> 3자~15자
        StringBuilder sb = new StringBuilder();   

        for(char c: new_id.toCharArray()) {

             // 1단계: 대문자 -> 소문자
            if(c >= 'A' &&  c <= 'Z') {
                char newC = Character.toLowerCase(c);
                sb.append(newC);
                continue;
            }
            // 2단계: 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거
            if((c < 'A' || c > 'Z') && (c < 'a' || c > 'z') && c!='-' && c!='_' && c!='.' && !Character.isDigit(c)) {
                System.out.println("2단계 실패");
                continue;
            }
            // 3단계: 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환
            if((c == '.') && (sb.length() > 0) && (sb.charAt(sb.length() - 1) == '.')) {
                System.out.println("3단계 실패");
                continue;
            }
            // 4단계: new_id에서 마침표(.)가 처음이나 끝에 위치한다면 제거합니다. (처음일때만 일단 제거)
            if(c == '.' && sb.length() == 0) {
                System.out.println("4단계 실패");
                continue;
            }
            
            sb.append(c);
        }
                
        // 6단계: new_id의 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거
        while(sb.length() > 15) {
            sb.deleteCharAt(sb.length() - 1);
            
        }
        // 4단계: new_id에서 마침표(.)가 처음이나 끝에 위치한다면 제거합니다. (마지막일때만 일단 제거)
        while(sb.length() > 0 && sb.charAt(sb.length() - 1) == '.') {
            sb.deleteCharAt(sb.length() - 1);
        }
        
        // 5단계: 빈문자열이면 "aaa" 반환
        if(sb.length() == 0) return "aaa";
        // 7단계: new_id의 길이가 3이 될 때까지 반복해서 끝에 붙입니다.
        else if(sb.length() < 3) {
            char last = sb.charAt(sb.length()-1);
            while(sb.length() < 3) sb.append(last);
        }
        
        return sb.toString();
    }
}
