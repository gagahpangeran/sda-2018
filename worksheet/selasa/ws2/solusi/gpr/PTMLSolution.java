import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class PTMLSolution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<PTMLTag> tags = tokenize(reader.readLine());
        solve(tags);
    }

    public static void solve(ArrayList<PTMLTag> tags) {
        // Implementasikan solusi anda di sini
        Stack<String> tagStack = new Stack<String>();
        int res = 0;
        for (int i = 0; i < tags.size(); i++) {
            PTMLTag tag = tags.get(i);
            if (!tag.isClosingTag) {
                tagStack.push(tag.name);
                if (tagStack.size() > res)
                    res = tagStack.size();
            } else {
                if (tagStack.size() == 0) {
                    System.out.println("TIDAK");
                }

                String now = tagStack.pop();
                if (!tag.name.equals(now)) {
                    System.out.println("TIDAK");
                    return;
                }
            }
        }
        if (tagStack.size() == 0)
            System.out.println("YA " + (res - 1));
        else
            System.out.println("TIDAK");
    }

    public static ArrayList<PTMLTag> tokenize(String input) {
        StringBuilder tagNameBuilder = new StringBuilder();
        boolean isTag = false, isClosingTag = false;
        ArrayList<PTMLTag> tags = new ArrayList<PTMLTag>();
        for (char cur : input.toCharArray()) {
            if (cur == '<') {
                isTag = true;
                tagNameBuilder = new StringBuilder();
            } else if (cur == '>') {
                String tagName = tagNameBuilder.toString();
                tags.add(new PTMLTag(tagName, isClosingTag));
                isTag = false;
                isClosingTag = false;
            } else if (isTag) {
                if (cur == '/') {
                    isClosingTag = true;
                } else {
                    tagNameBuilder.append(cur);
                }
            }
        }
        return tags;
    }
}

class PTMLTag {
    public String name;
    public boolean isClosingTag;

    public PTMLTag(String name, boolean isClosingTag) {
        this.name = name;
        this.isClosingTag = isClosingTag;
    }
}