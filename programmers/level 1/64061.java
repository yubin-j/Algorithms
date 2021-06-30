/*
  문제 링크 : https://programmers.co.kr/learn/courses/30/lessons/64061
*/

class Solution {
  public int solution(int[][] board, int[] moves) {
    int sameCnt = 0, bucketCnt = 0;
    int[] bucket = new int[moves.length];
    int[] topDollIdx = new int[board[0].length];

    //topDollIdx 배열에 좌우의 최상단 위치를 기록한다.
    for(int col = 0; col < board[0].length; col++){
      for(int row = 0; row < board.length; row++){
        if(board[row][col] != 0 && topDollIdx[col] == 0){
          topDollIdx[col] = row;
          break;
        }
      }
    }

    for(int move: moves){
      move--;

      //최상단 위치를 증가하면서 낮춰주기 때문에 범위 안에서 동작하도록 조건을 걸어준다.
      if(topDollIdx[move] < board.length){
        //bucket에 처음 채우는 경우이거나 지금 채우는 값이 기존에 있는 마지막 값과 일치하지 않을 때 bucket에 채워준다.
        if (bucketCnt == 0 || !(bucket[bucketCnt - 1] == board[topDollIdx[move]][move])){
          bucket[bucketCnt++] = board[topDollIdx[move]][move];
        }
        else {
          //bucket에 있는 마지막 값과 지금 값이 같은 경우 인형이 터지므로
          //기존 인형과 지금 들어가는 인형 2개를 증가시켜준다.
          sameCnt+=2;
          //bucket의 마지막 값을 0으로 변경해주면서 bucketCnt값도 낮춰준다.
          //bucketCnt값만 낮춰도 프로그램 동작에는 이상이 없지만 그래도 깔끔하게 마지막 값도 0으로 변경해준다.
          bucket[bucketCnt--] = 0;
        }

        //최상단 위치를 증가시켜 수정해준다.
        topDollIdx[move]++;
      }
    }

    return sameCnt;
  }
}