package Studying;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Set;
import java.util.StringTokenizer;

public class B7785 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		HashMap<String, String> map = new HashMap<>();
		ArrayList<String> arr = new ArrayList<>();
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String str1 = st.nextToken();
			String str2 = st.nextToken();
			map.put(str1, str2);
		}
		Set<String> keySet = map.keySet();
		for (String key : keySet) {
			if (map.get(key).equals("enter")) {
				arr.add(key);
			}
		}
		Collections.sort(arr, (o1, o2) -> {
			return o2.compareTo(o1);
		});
		
		for (String str : arr) {
			System.out.println(str);
		}
	}
}
