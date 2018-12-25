import java.io.*;

public class Rentang {

    Rentang() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String par[] = br.readLine().split(" ");
            int N = Integer.parseInt(par[0]);
            int k = Integer.parseInt(par[1]);

            // inisialisasi program anda disini
            for (int i = 0; i < N; i++) {
                int x = Integer.parseInt(br.readLine());
                // perintah-perintah untuk pencarian rentang
            }
            // bagian mencetak k terbesar
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        new Rentang();
    }
}