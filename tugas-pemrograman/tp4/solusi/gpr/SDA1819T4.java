import java.io.*;
import java.util.*;

public class SDA1819T4 {
    static String hieroglyph;
    static int MOD = 98317;
    static HashHash iniHash[] = new HashHash[98317];
    static int pangkat[] = new int[1001];
    static Queue<Integer> simpan = new LinkedList<Integer>();

    public static void main(String[] args) {
        readAndSolve();
    }

    public static void readAndSolve() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            hieroglyph = reader.readLine();
            preComp();

            int query = Integer.parseInt(reader.readLine());

            for (int i = 0; i < query; i++) {
                String cmd[] = reader.readLine().split(" ");

                if (cmd[0].equals("0")) {
                    solveZero(cmd[1]);
                } else {
                    solveOne();
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void solveZero(String subStr) {
        int lenStr = hieroglyph.length();
        int lenSubStr = subStr.length();

        int hashStr = hashing(subStr);

        int hashNow = hashing(hieroglyph.substring(0, lenSubStr));

        int hasil = 0;

        if (hashStr == hashNow)
            hasil++;

        for (int i = lenSubStr; i < lenStr; i++) {
            hashNow = (hashNow - ((int) hieroglyph.charAt(i - lenSubStr)) * pangkat[lenSubStr - 1]) * pangkat[1]
                    + ((int) hieroglyph.charAt(i));

            if (hashNow == hashStr)
                hasil++;
        }
        System.out.println(hasil);
    }

    public static void solveOne() {
        int lenStr = hieroglyph.length();

        for (int lenSubStr = 1; lenSubStr <= lenStr; lenSubStr++) {
            String subStr = hieroglyph.substring(0, lenSubStr);

            int hashNow = hashing(subStr);
            int hashMod = Math.floorMod(hashNow, MOD);

            iniHash[hashMod] = new HashHash(subStr);
            simpan.add(hashMod);

            for (int i = lenSubStr; i < lenStr; i++) {
                hashNow = (hashNow - ((int) hieroglyph.charAt(i - lenSubStr)) * pangkat[lenSubStr - 1]) * pangkat[1]
                        + ((int) hieroglyph.charAt(i));
                hashMod = Math.floorMod(hashNow, MOD);
                int idx = i - lenSubStr + 1;

                if (iniHash[hashMod] != null) {
                    subStr = hieroglyph.substring(idx, idx + lenSubStr);

                    if (iniHash[hashMod].word.equals(subStr)) {
                        iniHash[hashMod].count += 1;
                    } else {
                        while (iniHash[hashMod] != null && !iniHash[hashMod].word.equals(subStr)) {
                            hashMod = Math.floorMod(hashMod + 1, MOD);
                        }

                        if (iniHash[hashMod] != null)
                            iniHash[hashMod].count += 1;
                        else {
                            iniHash[hashMod] = new HashHash(subStr);
                            simpan.add(hashMod);
                        }
                    }
                } else {
                    subStr = hieroglyph.substring(idx, idx + lenSubStr);
                    iniHash[hashMod] = new HashHash(subStr);
                    simpan.add(hashMod);
                }
            }

            String hasil = "";
            int maks = 0;

            while (!simpan.isEmpty()) {
                int idx = simpan.remove();
                if (iniHash[idx].count > maks) {
                    maks = iniHash[idx].count;
                    hasil = iniHash[idx].word;
                }
                iniHash[idx] = null;
            }
            System.out.println(hasil + " " + maks);
        }
    }

    public static int hashing(String word) {
        int n = word.length();
        int hasil = 0;
        for (int i = 0; i < n; i++) {
            hasil += ((int) word.charAt(i)) * pangkat[n - i - 1];
        }
        return hasil;
    }

    public static void preComp() {
        pangkat[0] = 1;
        for (int i = 1; i <= 1000; i++) {
            pangkat[i] = pangkat[i - 1] * 31;
        }
    }
}

class HashHash {
    public String word;
    public int count;

    public HashHash(String word) {
        this.word = word;
        this.count = 1;
    }
}