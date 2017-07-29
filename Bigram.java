import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;

public class Bigram {

	public static String readFile(String file)
	{
		BufferedReader br = null;
		String everything = "";
		try {
			br = new BufferedReader(new FileReader(file));

			StringBuilder sb = new StringBuilder();
			String line = br.readLine();

			while (line != null) {
				sb.append(line);
				line = br.readLine();
			}
			everything = sb.toString();
		} catch (Exception e) {
			System.out.println("encountered error reading file!");
		}
		finally {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return everything;
	}

    public static LinkedHashMap<String, Integer> populateHashMap(String given) {
		LinkedHashMap<String, Integer> lMap = new LinkedHashMap<String, Integer>();
		String[] arr = given.split(" ");
		if(arr.length<2)return null;

		for(int i=0; i<arr.length-1;i++) {
			String sTemp =arr[i]+" "+ arr[i+1];
			sTemp = sTemp.toLowerCase();
			if(lMap.get(sTemp) != null) {
				int j = lMap.get(sTemp);
				lMap.replace(sTemp, j+1);
			}
			else {
				lMap.put(sTemp, 1);
			}

		}
		return lMap;
	}

    public static void printMap(LinkedHashMap<String, Integer> lMap) {
		if(lMap!=null)
			for(String key:lMap.keySet()){
				String value = lMap.get(key).toString();
				System.out.println(key+","+value);
			}
	}

	public static void main(String[] args) {
		String given = readFile("file.txt");
		LinkedHashMap<String, Integer> lMap = populateHashMap(given);
		printMap(lMap);
	}
}
