/*
  문제 링크 : https://programmers.co.kr/learn/courses/30/lessons/1845
*/

class Solution {
  public int solution(int[] nums) {
    /*
      폰켓몬의 종류별로 나온 녀석을 기록하기 위해 boolean 배열을 선언하였다.
      다른 사람의 풀이를 보니 HashSet이라는 자료형을 사용하는데 아직 모르고 있던 부분이어서 적용을 하지 못했었다.
      자바의 정석 2권을 얼른 보도록 해야겠다.
      boolean타입의 기본값은 false이다. 200000길이로 한 이유는 종류가 200000가지이기 때문이다.
    */
    boolean[] type = new boolean[200000];
    int typeCnt = 0;
    
    for(int num: nums){
      num--;

      /*
        아래 조건문은 폰켓몬의 종류가 한번이라도 등장했는지 확인할 수 있는 조건문이다.
        처음 등장한 폰켓몬이면 아래 조건문에 의해 내부 코드를 실행할 것이고 이로 인해 값이 true로 변경된다.
        그러면 두번째 부터는 조건문의 판별식이 false로 해당 구문을 실행하지 않게 되므로 중복 타입에 의한 처리가 된다.
      */
      if(!type[num]){
        type[num] = true;
        //타입에 대한 수를 확인하기 위해 typeCnt를 이용해 체크한다.
        typeCnt++;
      }
    }
    
    return typeCnt > nums.length / 2 ? nums.length / 2 : typeCnt;
  }
}