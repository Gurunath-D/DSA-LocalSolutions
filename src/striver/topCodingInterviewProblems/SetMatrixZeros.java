package src.striver.topCodingInterviewProblems;

import java.util.ArrayList;
import java.util.List;

/**
 * Set all rows and columns to 0 for an element which is 0
 * Striver SDE sheet link : https://takeuforward.org/data-structure/set-matrix-zero/
 * Leetcode link : https://leetcode.com/problems/set-matrix-zeroes/description/
 */
public class SetMatrixZeros {
    public static void main(String[] args) {
        int arr[][] = new int[][] {{1,1,1},{1,0,1},{1,1,1}};
        setZeroes(arr);
        System.out.println("arr : " + arr);
        for(int i=0;i<arr.length;i++) {
            for(int j=0;j<arr[i].length;j++) {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }

        int arr2[][] = new int[][] {{0,1,1},{1,0,1},{1,1,1}};
        System.out.println("arr2 : " + arr2);
        setZeroesOptimized(arr2);
        for(int i=0;i<arr2.length;i++) {
            for(int j=0;j<arr2[i].length;j++) {
                System.out.print(arr2[i][j]+" ");
            }
            System.out.println();
        }
    }

    /**
     * Brute force approach by me
     * @param matrix
     */
    public static void setZeroes(int[][] matrix) {
        List<Integer> iZeros = new ArrayList<>();
        List<Integer> jZeros = new ArrayList<>();

        for(int i=0;i<matrix.length;i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (0 == matrix[i][j]) {
                    iZeros.add(i);
                    jZeros.add(j);
                }
                if (iZeros.contains(i) || jZeros.contains(j)) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    /**
     * Optimized approach by <i>Nikhil Lohia</i>
     * Video Link : https://youtu.be/dSxt3ZCbIqA?si=qcxRVWkW8SkPHYEL
     * @param matrix
     */
    public static void setZeroesOptimized(int[][] matrix) {
        boolean firstRowZero = false;
        boolean firstColumnZero = false;
        for(int i=0; i<matrix.length; i++) {
            if(0==matrix[0][i]) {
                firstRowZero = true;
                break;
            }
        }

        for(int i=0; i<matrix[0].length; i++){
            if(0==matrix[i][0]) {
                firstColumnZero = true;
                break;
            }
        }

        for(int i=1; i<matrix.length; i++) {
            for(int j=1; j<matrix[i].length; j++) {
                if(matrix[i][j]==0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for(int i=1; i<matrix.length; i++) {
            for(int j=1; j<matrix[i].length; j++) {
                if(matrix[i][0] == 0 || matrix[0][j] == 0){
                    matrix[i][j]=0;
                }
            }
        }

        if(firstRowZero){
            for(int i=0; i<matrix.length; i++) {
                matrix[0][i]=0;
            }
        }

        if(firstColumnZero){
            for(int i=0; i<matrix.length; i++) {
                matrix[i][0]=0;
            }
        }
    }
}
