import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Test {
    public static void main(String[] args) {
        System.out.println(generateCode());
    }

    public static String generateCode() {
        // Create an ArrayList with all letters
        ArrayList<Character> letterList = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            letterList.add((char)('a' + i));
            letterList.add((char)('A' + i));
        }

        // Get 4 random letters
        StringBuilder sb = new StringBuilder();
        Random r = new Random();
        for (int i = 0; i < 4; i++) {
            int index = r.nextInt(letterList.size());
            char ch = letterList.get(index);
            sb.append(ch);
        }

        // Generate a random number
        int randomNo = r.nextInt(10);
        sb.append(randomNo);

        System.out.println(sb);

        // Generate Random order
        char[] Arr = sb.toString().toCharArray();
        int randomIndex = r.nextInt(Arr.length);
        char temp = Arr[randomIndex];
        Arr[randomIndex] = Arr[Arr.length - 1];
        Arr[Arr.length - 1] = temp;

        return new String(Arr);
    }
}
