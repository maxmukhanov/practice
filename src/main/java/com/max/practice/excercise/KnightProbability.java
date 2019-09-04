package com.max.practice.excercise;

import java.util.Arrays;

public class KnightProbability {
  public double knightProbability(int N, int K, int r, int c) {
    double[][] board = new double[N][N];
    for (int i = 0; i < N; i++) Arrays.fill(board[i], 1);

    while (K-- > 0) {
      double[][] kBoard = new double[N][N];
      for (int i = 0; i < Math.ceil((double) N / 2); i++) {
        for (int j = i;  j < N ; j++) {
          double prob = 0;

          prob += prob(board, i - 1, j - 2, N);
          prob += prob(board, i - 2, j - 1, N);
          prob += prob(board, i - 2, j + 1, N);
          prob += prob(board, i - 1, j + 2, N);
          prob += prob(board, i + 1, j + 2, N);
          prob += prob(board, i + 2, j + 1, N);
          prob += prob(board, i + 2, j - 1, N);
          prob += prob(board, i + 1, j - 2, N);

          prob /= 8;


          kBoard[i][j] = prob;
          kBoard[i][N - j - 1] =prob;
          kBoard[N - i - 1][j] =prob;
          kBoard[N - i - 1][N - j - 1] =prob;
        }
      }
      board = kBoard;
    }

    return board[r][c];
  }


  private double prob(double[][] board, int i, int j, int N) {
    if (i < 0 || j < 0 || i >= N || j >= N) return 0;
    return board[i][j];
  }
}
