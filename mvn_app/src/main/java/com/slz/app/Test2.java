package com.slz.app;

/**
 * @author : SunLZ
 * @project : MavenLearning
 * @date : 2024/8/17
 */
import java.util.Scanner;

public class Test2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 读取数组长度
        int n = scanner.nextInt();

        long sum = 0;
        long[] array = new long[n];

        // 读取数组并计算总和
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextLong();
            sum += array[i];
        }

        // 计算目标值（平均值向下取整）
        long target = sum / n;

        // 计算总的操作次数
        long operations = 0;
        for (int i = 0; i < n; i++) {
            operations += Math.abs(array[i] - target);
        }

        // 因为每次操作可以抵消+1和-1，所以结果除以2
        // 注意这里我们使用Math.ceil来确保得到正确的向上取整的结果
        System.out.println((int)Math.ceil(operations / 2.0));

        scanner.close();
    }
}





