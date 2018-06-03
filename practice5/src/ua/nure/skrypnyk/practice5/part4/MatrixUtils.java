package ua.nure.skrypnyk.practice5.part4;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MatrixUtils {

    public static int[][] fillMatrix(int[][] matrx){
        Random rnd = new Random();
        for (int i = 0; i < matrx.length; i++) {
            for (int j = 0; j < matrx[0].length; j++) {
                matrx[i][j] = rnd.nextInt(100001);
            }
        }
        return matrx;
    }

    public static int foundMaxMatrxValue(int[][] matrx){
        int maxValue = 0;
        for (int i = 0; i < matrx.length; i++) {
            for (int j = 0; j < matrx[0].length; j++) {
                if(matrx[i][j] > maxValue){
                    maxValue = matrx[i][j];
                }
            }
        }
        return maxValue;
    }

    public static int foundMaxMatrixValueViaThreads(int[][] matrx){
        int max = 0;
        List<MyThread> threadList = new ArrayList<>();
        for (int i = 0; i < matrx.length; i++) {
            threadList.add(new MyThread(matrx[i]));
            threadList.get(i).run();
            if(max < threadList.get(i).getMax()){
                max = threadList.get(i).getMax();
            }
        }
        return max;
    }
}
