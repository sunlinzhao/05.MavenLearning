package com.slz.app;

/**
 * @author : SunLZ
 * @project : MavenLearning
 * @date : 2024/8/17
 */
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 读取n和k
        int n = scanner.nextInt();
        int k = scanner.nextInt();

        // 创建数组
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        long sum = calculateSum(a, k);
        System.out.println(sum);

        scanner.close();
    }

    private static long calculateSum(int[] a, int k) {
        long sum = 0;
        boolean kIsOne = Math.abs(k) == 1;

        // 如果k的绝对值为1，则无需改变数组
        if (kIsOne) {
            for (int value : a) {
                sum += value;
            }
        } else {
            // 如果k的绝对值不是1，我们需要考虑乘以k^2的影响
            for (int value : a) {
                sum += Math.abs(value) * (value >= 0 ? 1 : -1) * Math.pow(k, 2);
            }
        }

        return sum;
    }
}

//input
//6 2
//-1 -2 -3 1 2 3

