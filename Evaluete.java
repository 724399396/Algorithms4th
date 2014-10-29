import java.util.*;
public class Evaluete {
	public static void main(String[] args) {
		Stack<String> ops = new Stack<String>();
		Stack<Double> vals = new Stack<Double>();
		while (!StdIn.isEmpty()) {
			//读取字符，如果是运算符则压入栈
			String s = StdIn.readString();
			if	(s.equals("("))		   ;
			else if (s.equals("+"))	ops.push(s);
			else if (s.equals("-"))	ops.push(s);
			else if (s.equals("*"))	ops.push(s);
			else if (s.equals("/"))	ops.push(s);
			else if (s.equals("sqrt"))ops.push(s);
			else if (s.equals(")"))
			{	// 如果字符为"}",弹出运算符和操作数，
				// 计算结果入栈
				String op = ops.pop();
				double v = vals.pop();
				if	(op.equals("+")) v= vals.pop() + v;
				if	(op.equals("-")) v= vals.pop() - v;
				if	(op.equals("*")) v= vals.pop() * v;
				if	(op.equals("/")) v= vals.pop() / v;
				if	(op.equals("sqrt")) v= Math.sqrt(v);
				vals.push(v);
			}
			else vals.push(Double.parseDouble(s));
		}
		StdOut.println(vals.pop());
	}
}
