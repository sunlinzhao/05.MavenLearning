package com.slz.app;

/**
 * @author : SunLZ
 * @project : MavenLearning
 * @date : 2024/8/18
 */
import java.util.Scanner;

public class Test4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 读取数组长度
        int n = scanner.nextInt();
        int[] a = new int[n];

        // 读取数组元素
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        System.out.println(countSpecialSubarrays(a));
    }

    private static long countSpecialSubarrays(int[] a) {
        int n = a.length;
        long count = 0;
        for (int start = 0; start < n; start++) {
            int[] freq = new int[100001]; // 假设数值范围不超过100000
            int uniqueCount = 0; // 不同数字的计数
            int singleCount = 0; // 只出现一次的数字的计数

            for (int end = start; end < n; end++) {
                if (freq[a[end]] == 0) {
                    uniqueCount++;
                }
                freq[a[end]]++;

                if (freq[a[end]] == 1) {
                    singleCount++;
                } else if (freq[a[end]] == 2) {
                    singleCount--;
                }

                if (uniqueCount == 2 && singleCount == 1 && (end - start + 1) >= 3) {
                    count++;
                }
            }
        }
        return count;
    }
}