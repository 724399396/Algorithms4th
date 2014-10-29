import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WebCrawler {
	public static void main(String[] args) {
		System.setProperty("sun.net.client.dufaultConnectTimeout", "500");
		System.setProperty("sun.net.client.defaultReadTimeout", "1000");
		
		String s = args[0];
		Queue<String> queue = new Queue<String>();
		queue.enqueue(s);
		
		SET<String> marked = new SET<String>();
		marked.add(s);
		
		while(!queue.isEmpty()) {
			String v = queue.dequeue();
			System.out.println(v);
			
			In in = new In(v);

			if (!in.exists()) continue;
			
			String input = in.readAll();
			if (input == null) continue;

			String regexp = "http://(\\w+\\.)+(\\w+)";
			Pattern pattern = Pattern.compile(regexp);
			Matcher matcher = pattern.matcher(input);
			
			while(matcher.find()) {
				String w = matcher.group();
				if (!marked.contains(w)) {
					queue.enqueue(w);
					marked.add(w);
				}
			}
		}	
	}
}
