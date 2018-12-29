import java.io.*;

public class SDA1819T3 {
    static TreeAbyss Abyss = new TreeAbyss();

    public static void main(String[] args) {
        readAndSolve();
    }

    public static void readAndSolve() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            int query = Integer.parseInt(reader.readLine());

            for (int i = 0; i < query; i++) {
                String[] command = reader.readLine().split(" ");
                execute(command);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void execute(String[] command) {
        if (command[0].equals("GABUNG")) {
            Abyss.gabung(command);
        } else if (command[0].equals("PARTNER")) {
            Abyss.partner(command[1]);
        } else if (command[0].equals("MENYERAH")) {
            Abyss.menyerah(command[1]);
        } else if (command[0].equals("CEDERA")) {
            Abyss.cedera(command[1]);
        } else if (command[0].equals("PRINT")) {
            Abyss.print();
        } else if (command[0].equals("MUSIBAH")) {
            Abyss.musibah();
        } else if (command[0].equals("PANJANG-TALI")) {
            Abyss.panjangTali(command[1], command[2]);
        } else if (command[0].equals("GANTUNGAN")) {
            Abyss.gantungan(command);
        }
    }
}

class BlackWhistles {
    String name;
    BlackWhistles left, right;
    int height, size;

    BlackWhistles(String name) {
        this.name = name;
        left = right = null;
        height = size = 1;
    }
}

class TreeAbyss {
    BlackWhistles root;

    TreeAbyss() {
        this.root = null;
    }

    void gabung(String[] command) {
        if (command.length == 2) {
            this.root = gabung(root, command[1]);
            return;
        }

        gabung(root, command[1], Integer.parseInt(command[2]));
    }

    BlackWhistles gabung(BlackWhistles node, String name) {
        if (node == null)
            return new BlackWhistles(name);

        if (name.compareTo(node.name) < 0)
            node.left = gabung(node.left, name);

        else if (name.compareTo(node.name) > 0)
            node.right = gabung(node.right, name);

        return balance(node);
    }

    void gabung(BlackWhistles node, String name, int pos) {
        if (canJoin(name, pos)) {
            this.root = gabung(root, name);
        }
    }

    void partner(String name) {
        BlackWhistles node = partner(root, name);
        System.out.println(node == null ? "TIDAK ADA" : node.name);
    }

    BlackWhistles partner(BlackWhistles node, String name) {
        if (node.left != null && name.equals(node.left.name))
            return node.right;

        if (node.right != null && name.equals(node.right.name))
            return node.left;

        if (name.compareTo(node.name) < 0)
            return partner(node.left, name);

        if (name.compareTo(node.name) > 0)
            return partner(node.right, name);

        return null;
    }

    void menyerah(String name) {
        this.root = deletePredecessor(root, name);
    }

    void cedera(String name) {
        BlackWhistles node = find(name);
        int leftDepth = node.left == null ? 0 : findMaxDepth(node.left);
        int rightDepth = node.right == null ? 0 : findMinDepth(node.right);
        this.root = leftDepth > rightDepth ? deletePredecessor(root, name) : deleteSuccessor(root, name);
    }

    void print() {
        this.helperPreOrder(this.root);
        System.out.println();
        this.helperPostOrder(this.root);
        System.out.println();
    }

    void musibah() {
        this.root = musibah(this.root);
        System.out.println();
    }

    BlackWhistles musibah(BlackWhistles node) {
        if (node == null)
            return null;

        if (node.left == null && node.right == null) {
            System.out.print(node.name + ";");
            node = null;
            return null;
        }

        node.left = musibah(node.left);
        node.right = musibah(node.right);

        fixHeight(node);

        return node;
    }

    void panjangTali(String name1, String name2) {
        if (name1.compareTo(name2) > 0) {
            System.out.println(disBetween(root, name2, name1));
            return;
        }

        System.out.println(disBetween(root, name1, name2));
    }

    void gantungan(String[] command) {
        int n = Integer.parseInt(command[1]);
        String name1 = command[2];
        String name2 = command[3];

        BlackWhistles node = lca(root, name1, name2);

        for (int i = 4; i < n + 2; i++) {
            node = lca(root, node.name, command[i]);
        }

        System.out.println(node.name);
    }

    int height(BlackWhistles node) {
        return node == null ? 0 : node.height;
    }

    int size(BlackWhistles node) {
        return node == null ? 0 : node.size;
    }

    boolean canJoin(String name, int pos) {
        if (this.root == null)
            return true;

        int rootPos = size(this.root.left);
        int nowPos = getPos(this.root, name);

        if (name.compareTo(this.root.name) < 0)
            rootPos++;

        if (Math.abs(rootPos - nowPos) <= pos)
            return true;
        return false;
    }

    int getPos(BlackWhistles node, String name) {
        if (node == null)
            return 0;

        if (name.compareTo(node.name) > 0)
            return 1 + size(node.left) + getPos(node.right, name);

        if (name.compareTo(node.name) < 0)
            return getPos(node.left, name);

        return 0;
    }

    int disFromRoot(BlackWhistles node, String name) {
        if (name.compareTo(node.name) < 0)
            return 1 + disFromRoot(node.left, name);
        if (name.compareTo(node.name) > 0)
            return 1 + disFromRoot(node.right, name);
        return 0;
    }

    int disBetween(BlackWhistles node, String name1, String name2) {
        if (node == null)
            return 0;
        if (name1.compareTo(node.name) < 0 && name2.compareTo(node.name) < 0)
            return disBetween(node.left, name1, name2);
        if (name1.compareTo(node.name) > 0 && name2.compareTo(node.name) > 0)
            return disBetween(node.right, name1, name2);

        return disFromRoot(node, name1) + disFromRoot(node, name2);
    }

    BlackWhistles lca(BlackWhistles node, String name1, String name2) {
        if (name1.compareTo(node.name) < 0 && name2.compareTo(node.name) < 0)
            return lca(node.left, name1, name2);
        if (name1.compareTo(node.name) > 0 && name2.compareTo(node.name) > 0)
            return lca(node.right, name1, name2);

        return node;
    }

    int balanceFactor(BlackWhistles node) {
        return height(node.right) - height(node.left);
    }

    void fixHeight(BlackWhistles node) {
        int heightLeft = height(node.left);
        int heightRight = height(node.right);

        node.height = (heightLeft > heightRight ? heightLeft : heightRight) + 1;
        node.size = size(node.left) + size(node.right) + 1;
    }

    BlackWhistles rotateRight(BlackWhistles node) {
        BlackWhistles tmp = node.left;
        node.left = tmp.right;
        tmp.right = node;
        fixHeight(node);
        fixHeight(tmp);
        return tmp;
    }

    BlackWhistles rotateLeft(BlackWhistles node) {
        BlackWhistles tmp = node.right;
        node.right = tmp.left;
        tmp.left = node;
        fixHeight(node);
        fixHeight(tmp);
        return tmp;
    }

    BlackWhistles balance(BlackWhistles node) {
        fixHeight(node);

        if (balanceFactor(node) == 2) {

            if (balanceFactor(node.right) < 0) {
                node.right = rotateRight(node.right);
            }

            return rotateLeft(node);
        }

        if (balanceFactor(node) == -2) {

            if (balanceFactor(node.left) > 0) {
                node.left = rotateLeft(node.left);
            }

            return rotateRight(node);
        }

        return node;
    }

    BlackWhistles find(String name) {
        return find(root, name);
    }

    BlackWhistles find(BlackWhistles node, String name) {
        if (name.equals(node.name))
            return node;

        if (name.compareTo(node.name) < 0)
            return find(node.left, name);

        if (name.compareTo(node.name) > 0)
            return find(node.right, name);

        return null;
    }

    int findMinDepth(BlackWhistles node) {
        return node.left == null ? 0 : 1 + findMinDepth(node.left);
    }

    int findMaxDepth(BlackWhistles node) {
        return node.right == null ? 0 : 1 + findMaxDepth(node.right);
    }

    BlackWhistles findMin(BlackWhistles node) {
        return node.left == null ? node : findMin(node.left);
    }

    BlackWhistles findMax(BlackWhistles node) {
        return node.right == null ? node : findMax(node.right);
    }

    BlackWhistles removeMin(BlackWhistles node) {
        if (node.left == null)
            return node.right;

        node.left = removeMin(node.left);
        return balance(node);
    }

    BlackWhistles removeMax(BlackWhistles node) {
        if (node.right == null)
            return node.left;

        node.right = removeMax(node.right);
        return balance(node);
    }

    BlackWhistles deleteSuccessor(BlackWhistles node, String name) {
        if (node == null)
            return null;

        if (name.compareTo(node.name) < 0) {
            node.left = deleteSuccessor(node.left, name);
        } else if (name.compareTo(node.name) > 0) {
            node.right = deleteSuccessor(node.right, name);
        } else {
            BlackWhistles tmp1 = node.left;
            BlackWhistles tmp2 = node.right;
            node = null;

            if (tmp2 == null)
                return tmp1;

            BlackWhistles min = findMin(tmp2);
            min.right = removeMin(tmp2);
            min.left = tmp1;
            return balance(min);
        }
        return balance(node);
    }

    BlackWhistles deletePredecessor(BlackWhistles node, String name) {
        if (node == null)
            return null;

        if (name.compareTo(node.name) > 0) {
            node.right = deletePredecessor(node.right, name);
        } else if (name.compareTo(node.name) < 0) {
            node.left = deletePredecessor(node.left, name);
        } else {
            BlackWhistles tmp1 = node.right;
            BlackWhistles tmp2 = node.left;
            node = null;

            if (tmp2 == null)
                return tmp1;

            BlackWhistles max = findMax(tmp2);
            max.left = removeMax(tmp2);
            max.right = tmp1;
            return balance(max);
        }
        return balance(node);
    }

    void helperPreOrder(BlackWhistles current) {
        if (current == null)
            return;

        System.out.print(current.name + ";");
        helperPreOrder(current.left);
        helperPreOrder(current.right);
    }

    void helperPostOrder(BlackWhistles current) {
        if (current == null)
            return;

        helperPostOrder(current.left);
        helperPostOrder(current.right);
        System.out.print(current.name + ";");
    }
}