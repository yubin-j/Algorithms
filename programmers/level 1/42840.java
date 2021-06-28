/*
  문제 링크 : https://programmers.co.kr/learn/courses/30/lessons/42840
*/

class Solution {
  public int[] solution(int[] answers) {
    //각 수포자들의 문제 풀이 패턴 정의
    int[] p1 = {1,2,3,4,5};
    int[] p2 = {2,1,2,3,2,4,2,5};
    int[] p3 = {3,3,1,1,2,2,4,4,5,5};
    
    //각 수포자들이 맞춘 횟수를 기록할 변수.
    int p1Cnt = 0, p2Cnt = 0, p3Cnt = 0;
    
    for(int i = 0; i < answers.length; i++){
      //각 배열의 길이로 나눈 값의 나머지를 이용해 인덱싱.
      if(p1[i % p1.length] == answers[i]){
        p1Cnt++;
      }
      if(p2[i % p2.length] == answers[i]){
        p2Cnt++;
      }
      if(p3[i % p3.length] == answers[i]){
        p3Cnt++;
      }
    }
    
    //모두가 같은 갯수를 맞히는 경우를 대비하여 길이가 3인 배열을 선언
    int[] answer = new int[3];
    int max = p1Cnt > p2Cnt ? 
              (p1Cnt > p3Cnt ? p1Cnt : p3Cnt):
              (p2Cnt > p3Cnt ? p2Cnt : p3Cnt);
    int i = 0;
    
    if(max == p1Cnt){
      answer[i++] = 1;
    }
    if(max == p2Cnt){
      answer[i++] = 2;
    }
    if(max == p3Cnt){
      answer[i++] = 3;
    }

    //최대 문제수만 맞힌 수포자들의 값만 출력한다.
    return java.util.Arrays.copyOf(answer, i);
  }
}