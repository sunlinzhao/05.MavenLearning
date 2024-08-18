package com.slz.app;

/**
 * @author : SunLZ
 * @project : MavenLearning
 * @date : 2024/8/18
 */
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Test3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] magic = new int[n];

        for (int i = 0; i < n; i++) {
            magic[i] = scanner.nextInt();
        }
        scanner.close();

        // dp[i] 表示以第 i 个小动物结尾的最大魔法数字和
        int[] dp = new int[n];
        dp[0] = magic[0];

        // 双端队列存储 dp 的最大值索引
        Deque<Integer> deque = new LinkedList<>();
        deque.offer(0);

        int result = dp[0];

        for (int i = 1; i < n; i++) {
            // 移除队列中不符合距离条件的索引
            while (!deque.isEmpty() && deque.peekFirst() < i - k) {
                deque.pollFirst();
            }

            // 更新 dp[i]，选择 deque 中的最大 dp 值加上当前魔法数字
            dp[i] = magic[i] + (deque.isEmpty() ? 0 : dp[deque.peekFirst()]);

            // 更新结果
            result = Math.max(result, dp[i]);

            // 保持 deque 单调递减
            while (!deque.isEmpty() && dp[deque.peekLast()] <= dp[i]) {
                deque.pollLast();
            }
            deque.offer(i);
        }

        System.out.println(result);
    }
}
