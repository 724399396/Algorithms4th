public class Parentheses {
	public static void main(String[] args) {
		Stack<String> stack = new Stack<String>();
		while (!StdIn.isEmpty()) {
			String s = StdIn.readString();
			if (s.equals(")")) {
				if(!stack.pop().equals("(")) {
					StdOut.println("flase"+ 1);
					return;
				}
			}
			else if (s.equals("]")) { 
				if(!stack.pop().equals("[")) {
					StdOut.println("flase"+ 2);
					return;
				}
			}
			else if (s.equals("}")) { 
				if(!stack.pop().equals("{")) {
					StdOut.println("flase"+ 3);
					return;
				}
			}
			else stack.push(s);
		}
		StdOut.println("true");
	}
}
