package Utils;

import java.util.ArrayList;
import java.util.Random;

public class VerifyingCodeUtil{
    public static String generateCode(int digit) {
    // Create an ArrayList with all letters
    ArrayList<Character> letterList = new ArrayList<>();
    for (int i = 0; i < 26; i++) {
        letterList.add((char)('a' + i));
        letterList.add((char)('A' + i));
    }

    // Get digit random letters
    StringBuilder sb = new StringBuilder();
    Random r = new Random();
    for (int i = 0; i < digit; i++) {
        int index = r.nextInt(letterList.size());
        char ch = letterList.get(index);
        sb.append(ch);
    }

    // Generate a random number
    int randomNo = r.nextInt(10);
    sb.append(randomNo);

    // Generate Random order
    char[] Arr = sb.toString().toCharArray();
    int randomIndex = r.nextInt(Arr.length);
    char temp = Arr[randomIndex];
    Arr[randomIndex] = Arr[Arr.length - 1];
    Arr[Arr.length - 1] = temp;

    return new String(Arr);
}
}
