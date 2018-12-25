import java.io.*;
import java.util.*;

public class Rentang {
    Rentang() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String par[] = br.readLine().split(" ");
            int N = Integer.parseInt(par[0]);
            int k = Integer.parseInt(par[1]);
            int l = 0, r = 0;

            long thisSum = 0, maxSum = 0;
            ArrayList<RentangData> res = new ArrayList<RentangData>();

            for (int i = 0; i < N; i++) {
                int x = Integer.parseInt(br.readLine());

                thisSum += x;
                if (thisSum > maxSum) {
                    r = i;
                    maxSum = thisSum;
                } else if (thisSum <= 0) {
                    res.add(new RentangData(l, r, maxSum));
                    l = i + 1;
                    r = l;
                    thisSum = 0;
                    maxSum = 0;
                }
            }
            res.add(new RentangData(l, r, maxSum));

            Collections.sort(res);
            for (int i = 0; i < Math.min(k, res.size()); i++) {
                RentangData data = res.get(i);
                if (data.v > 0)
                    System.out.printf("%d %d %d\n", data.l, data.r, data.v);
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        new Rentang();
    }
}

class RentangData implements Comparable<RentangData> {
    int l, r;
    long v;

    RentangData(int l, int r, long v) {
        this.l = l;
        this.r = r;
        this.v = v;
    }

    @Override
    public int compareTo(RentangData x) {
        if (v == x.v) {
            return l - x.l;
        } else {
            return (x.v - v) > 0 ? 1 : -1;
        }
    }
}