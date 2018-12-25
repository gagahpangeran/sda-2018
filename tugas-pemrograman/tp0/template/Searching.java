import java.io.*;

public class Searching {
    long X[];
    int N;

    Searching() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            N = Integer.parseInt(br.readLine());
            X = new long[N + 1];
            X[0] = 0;
            for (int i = 1; i <= N; i++)
                X[i] = X[i - 1] + Integer.parseInt(br.readLine());
            int M = Integer.parseInt(br.readLine());
            for (int i = 0; i < M; i++) {
                String v[] = br.readLine().split(" ");
                cari(Integer.parseInt(v[0]), Integer.parseInt(v[1]));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        new Searching();
    }

    // -----------------------------------------------
    // isi method ini dengan algoritma pencarian yang sesuai
    // anda boleh menambahkan method tambahan untuk membantunya
    // tetapi tidak boleh mengubah satu barispun bagian template
    // di luar ini.

    void cari(int l, long V) {

    }

    // ---------------------------------------------------------------
}
