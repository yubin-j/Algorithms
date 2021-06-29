/*
  문제 링크 : https://programmers.co.kr/learn/courses/30/lessons/77484
*/

import java.util.*;

class Solution {
  public int[] solution(int[] lottos, int[] win_nums) {
    //HashSet 자료형을 이용.
    HashSet<Integer> winNums = new HashSet<>();
    int cnt = 0, zCnt= 0;

    for(int number: win_nums){
      winNums.add(number);
    }

    for(int pick: lottos){
      if(pick == 0){
        zCnt++; //값이 0인 경우 최고 순위 번호에 적용을 해야 한다.
      }
      else if(winNums.contains(pick)) {
        cnt++; //현재 번호가 로또 번호와 일치하면 기록
      }
    }

    //7에서 맞은 값을 빼면 5등까지는 등수가 나오지만 하나도 맞추지 못한 경우에는 7이 나오므로 Math.min을 이용해 6으로 출력하도록 함.
    return new int[]{Math.min(6, 7 - (cnt + zCnt)), Math.min(6, 7 - cnt)};
  }
}
