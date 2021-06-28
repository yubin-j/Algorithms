/*
  문제 링크 : https://programmers.co.kr/learn/courses/30/lessons/42748
*/

class Solution {
  public int[] solution(int[] array, int[][] commands) {
    int[] answer = new int[commands.length];
    int i = 0;
    
    for(int[] command : commands){
      //변할 일이 없는 값들이므로 상수로 적용.
      final int start = command[0] - 1;
      final int end = command[1];
      final int target = command[2] - 1;
      
      int[] dataArr = new int[end - start];
      System.arraycopy(array, start, dataArr, 0, end - start);

      //기본 정렬 메서드 사용. 
      //원시 타입의 값이 인자로 들어오는 경우 Dual-Pivot Quick Sort를 사용한다고 한다.
      //Dual-Pivot Quick Sort? 직접 구현을 해보도록 해야 할듯 하다.
      Arrays.sort(dataArr);

      answer[i++] = dataArr[target];
    }
    
    return answer;
  }
}