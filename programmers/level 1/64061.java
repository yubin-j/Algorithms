/*
  문제 링크 : https://programmers.co.kr/learn/courses/30/lessons/64061
*/

class Solution {
  public int solution(int[][] board, int[] moves) {
    int sameCnt = 0, bucketCnt = 0;
    int[] bucket = new int[moves.length];
    int[] topDollIdx = new int[board[0].length];

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

      if(topDollIdx[move] < board.length){
        if (bucketCnt == 0 || !(bucket[bucketCnt - 1] == board[topDollIdx[move]][move])){
          bucket[bucketCnt++] = board[topDollIdx[move]][move];
        }
        else {
          sameCnt+=2;
          bucket[bucketCnt--] = 0;
        }

        topDollIdx[move]++;
      }
    }

    return sameCnt;
  }
}