import java.io.*;

public class SDA18192T {
    static int numBall, maxBall, event;

    public static void main(String[] args) {
        readAndSolve();
    }

    public static void readAndSolve() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            String data[] = reader.readLine().split(" ");
            numBall = Integer.parseInt(data[0]);
            maxBall = Integer.parseInt(data[1]);

            ZumaList zuma = new ZumaList();

            String initZuma[] = reader.readLine().split(" ");
            for (int i = 0; i < numBall; i++) {
                zuma.add(Integer.parseInt(initZuma[i]));
            }

            ZumaBall current = zuma.header.next;

            for (int i = 0; i < numBall; i++) {
                if (zuma.check(current)) {
                    zuma.loss(current);
                    break;
                }
                current = current.next;
            }

            if (zuma.size < 4) {
                System.out.println("MENANG");
                return;
            } else if (zuma.size > maxBall) {
                System.out.println("KALAH");
                return;
            }

            event = Integer.parseInt(reader.readLine());

            for (int i = 0; i < event; i++) {
                String cmd[] = reader.readLine().split(" ");
                ZumaBall newBall = zuma.add(Integer.parseInt(cmd[0]), Integer.parseInt(cmd[1]));

                if (zuma.check(newBall)) {
                    zuma.loss(newBall);
                }

                if (zuma.size < 4) {
                    System.out.println("MENANG");
                    return;
                } else if (zuma.size > maxBall) {
                    System.out.println("KALAH");
                    return;
                }
            }

            System.out.println(zuma.size);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

class ZumaBall {
    int val;
    ZumaBall next, prev;

    public ZumaBall(int val, ZumaBall prev, ZumaBall next) {
        this.val = val;
        this.prev = prev;
        this.next = next;
    }
}

class ZumaList {
    int size;
    ZumaBall header;

    public ZumaList() {
        header = new ZumaBall(0, null, null);
        size = 0;
    }

    public void add(int val) {
        this.size++;
        ZumaBall newNode;

        if (this.header.next == null) {
            newNode = new ZumaBall(val, null, null);
            newNode.next = newNode;
            newNode.prev = newNode;
            this.header.next = newNode;
            return;
        }

        newNode = new ZumaBall(val, this.header.next.prev, this.header.next);
        newNode.prev.next = newNode;
        newNode.next.prev = newNode;
    }

    public ZumaBall add(int pos, int val) {
        this.size++;
        int position = pos;
        ZumaBall current = this.header.next.prev;

        while (position > 0) {
            current = current.next;
            position--;
        }

        ZumaBall newBall = new ZumaBall(val, current, current.next);
        newBall.prev.next = newBall;
        newBall.next.prev = newBall;

        if (pos == 0) {
            this.header.next = newBall;
        }

        return newBall;
    }

    public boolean check(ZumaBall current) {
        return (current.val == current.next.val && current.val == current.prev.val)
                || (current.val == current.next.val && current.val == current.next.next.val)
                || (current.val == current.prev.val && current.val == current.prev.prev.val);
    }

    public void loss(ZumaBall current) {
        ZumaBall now = current;
        boolean headLoss = current.equals(this.header.next);
        int sizeLoss = 1;

        while (now.val == now.prev.val) {
            now = now.prev;
            headLoss = !headLoss ? now.equals(this.header.next) : true;
            sizeLoss++;
        }

        ZumaBall left = now.prev;
        now = current;

        while (now.val == now.next.val) {
            now = now.next;
            headLoss = !headLoss ? now.equals(this.header.next) : true;
            sizeLoss++;
        }

        ZumaBall right = now.next;

        this.size -= sizeLoss;
        left.next = right;
        right.prev = left;

        if (headLoss) {
            this.header.next = right;
        }

        if (this.size < 3)
            return;

        if (this.check(right)) {
            this.loss(right);
        }
    }

    public void printZuma() {
        ZumaBall current = this.header.next;
        String res = "";

        do {
            res += current.val + " ";
            current = current.next;
        } while (!current.equals(this.header.next));

        System.out.println(res);
        System.out.println("size: " + this.size);
    }
}
