package greedy;
import java.io.*;

public class B9241 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] input1 = br.readLine().toCharArray();
        char[] input2 = br.readLine().toCharArray();

        int left = 0;

        while (left < input1.length && left < input2.length
                && input1[left] == input2[left]) {
            left++;
        }

        int right = 0;

        while (right < input1.length - left && right < input2.length - left
                && input1[input1.length - 1 - right] == input2[input2.length - 1 - right]) {
            right++;
        }

        System.out.println(input2.length - left - right);
    }
}