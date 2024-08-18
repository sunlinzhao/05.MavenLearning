package com.slz.app;

/**
 * @author : SunLZ
 * @project : MavenLearning
 * @date : 2024/8/17
 */
import java.util.Scanner;
import java.util.HashMap;

public class Test2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 读取球的数量
        int n = scanner.nextInt();
        HashMap<Long, Integer> colorCounts = new HashMap<>();

        // 读取每个球的颜色
        for (int i = 0; i < n; i++) {
            long color = scanner.nextLong();
            colorCounts.put(color, colorCounts.getOrDefault(color, 0) + 1);
        }

        // 计算最少需要添加多少个球
        int minAdditions = calculateMinAdditions(colorCounts);

        // 输出结果
        System.out.println(minAdditions);

        scanner.close();
    }

    private static int calculateMinAdditions(HashMap<Long, Integer> colorCounts) {
        int totalBalls = 0;
        for (Integer count : colorCounts.values()) {
            totalBalls += count;
        }

        int minAdditions = 0;
        for (Integer count : colorCounts.values()) {
            if (count % 3 == 0) {
                // 如果颜色的数量已经是3的倍数，不需要额外添加
                continue;
            } else {
                // 否则，需要添加到最接近的3的倍数
                minAdditions += 3 - (count % 3);
            }
        }

        // 如果总的球数是3的倍数，那么添加的数量正好等于缺失的数量
        // 如果不是3的倍数，那么还需要添加到最接近的3的倍数
        if (totalBalls % 3 != 0) {
            minAdditions += 3 - (totalBalls % 3);
        }

        return minAdditions;
    }
}


