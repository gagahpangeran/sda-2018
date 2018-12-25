import java.io.*;
import java.util.*;

public class SDA18191T {
    static int distance, totalTrans, milyaSpeed, speed[], dp[], nextStep[];
    static String question;
    final static int MOD = 1000000007;
    final static int MAX = Integer.MAX_VALUE;

    public static void main(String[] args) {
        read();
        solve();
    }

    static void read() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            String data[] = reader.readLine().split(" ");
            distance = Integer.parseInt(data[0]);
            totalTrans = Integer.parseInt(data[1]);
            milyaSpeed = Integer.parseInt(data[2]);

            speed = new int[totalTrans];
            String v[] = reader.readLine().split(" ");
            for (int i = 0; i < totalTrans; i++)
                speed[i] = Integer.parseInt(v[i]);

            question = reader.readLine();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    static void solve() {
        dp = new int[distance + 1];
        nextStep = new int[distance + 1];

        dp[0] = 1;
        for (int i = 1; i <= distance; i++)
            dp[i] = -1;

        if (question.equals("A")) {
            System.out.println(count(distance));
        } else if (question.equals("B")) {
            System.out.println(minimum(distance) == MAX ? "NA" : minimum(distance));
            backtrack(distance);
        }
    }

    static int count(int distance) {
        if (distance < 0)
            return 0;

        if (dp[distance] >= 0)
            return dp[distance];

        int cnt = 0;

        for (int i = 0; i < speed.length; i++) {
            cnt += count(distance - speed[i] - milyaSpeed);
            cnt %= MOD;
        }

        dp[distance] = cnt;
        return cnt;
    }

    static int minimum(int distance) {
        int res = MAX;

        if (distance == 0)
            return 0;

        if (distance < 0)
            return res;

        if (dp[distance] >= 0)
            return dp[distance];

        for (int i = 0; i < speed.length; i++) {
            if (speed[i] + milyaSpeed <= distance) {

                int resNow = minimum(distance - speed[i] - milyaSpeed);
                if (resNow != MAX && resNow + 1 < res) {
                    res = resNow + 1;
                    nextStep[distance] = speed[i];
                }
            }
        }

        dp[distance] = res;
        return res;
    }

    static void backtrack(int distance) {
        if (nextStep[distance] == 0)
            return;

        System.out.print(nextStep[distance] + " ");
        backtrack(distance - nextStep[distance] - milyaSpeed);
    }
}