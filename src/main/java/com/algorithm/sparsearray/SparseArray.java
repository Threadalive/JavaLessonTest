package com.algorithm.sparsearray;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @Description 二维数组与稀疏数组间操作
 * @Author zhenxing.dong
 * @Date 2019/12/7 14:26
 */
public class SparseArray {
    public static void main(String args[]) {

        //创建原始数组11*11
        //0：无棋子  1:黑子  2：蓝子
        int[][] chessArray = new int[11][11];

        chessArray[1][2] = 1;
        chessArray[2][3] = 2;

        //打印原始二维数组
        for (int[] row : chessArray) {
            for (int item : row) {
                System.out.print(item + " ");
            }
            System.out.println();
        }

        int sum = 0;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (chessArray[i][j] != 0) {
                    sum++;
                }
            }
        }
//        System.out.println(count);

        //创建稀疏数组
        int[][] sparseArray = new int[sum + 1][3];

        sparseArray[0][0] = 11;
        sparseArray[0][1] = 11;
        sparseArray[0][2] = sum;

        //记录第几个非0值
        int count = 0;
        //将非0值记录到稀疏数组
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (chessArray[i][j] != 0) {
                    count++;
                    sparseArray[count][0] = i;
                    sparseArray[count][1] = j;
                    sparseArray[count][2] = chessArray[i][j];
                }
            }
        }

        //打印稀疏数组
        for (int i = 0; i < sparseArray.length; i++) {
            System.out.println(sparseArray[i][0] + "\t" + sparseArray[i][1] + "\t" + sparseArray[i][2]);
        }

        //将稀疏数组存盘
        FileWriter writer = null;

        try {
            writer = new FileWriter("chessSave.data");

            for (int i = 0; i < sparseArray.length; i++) {
                for (int j = 0; j < 3; j++) {
                    writer.write(sparseArray[i][j]);
                }
            }

            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        //读取稀疏数组文件装入sparseArray2
        FileReader reader = null;
        int[][] sparseArray2 = new int[sum + 1][3];

        try {
            reader = new FileReader("chessSave.data");


            for (int i = 0; i < sparseArray2.length; i++) {
                for (int j = 0; j < 3; j++) {
                    sparseArray2[i][j] = reader.read();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        //将稀疏数组转回二维数组

        int[][] chessArray2 = new int[sparseArray2[0][0]][sparseArray2[0][1]];


        for (int i = 1; i < sparseArray2.length; i++) {
            chessArray2[sparseArray2[i][0]][sparseArray2[i][1]] = sparseArray2[i][2];
        }

        //打印转回的二维数组
        for (int[] row : chessArray2) {
            for (int item : row) {
                System.out.print(item + " ");
            }
            System.out.println();
        }

    }

}
