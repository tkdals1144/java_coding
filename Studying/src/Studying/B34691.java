package Studying;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class B34691 {
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			String input = br.readLine();
			if (input.equals("animal")) sb.append("Panthera tigris").append('\n');
			else if (input.equals("flower")) sb.append("Forsythia koreana").append('\n');
			else if (input.equals("tree")) sb.append("Pinus densiflora").append('\n');
			else if (input.equals("end")) break;
		}
		System.out.println(sb.toString());
	}
}
