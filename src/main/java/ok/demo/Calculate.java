package ok.demo;

import java.util.Stack;

public class Calculate {

	public static void main(String[] args) {
		Calculate c = new Calculate();
		System.out.println(c.calculate("(3-(5-(8)-(2+(9-(0-(8-(2))))-(4))-(4)))"));
	}

	public int calculate(String s) {
		s = s.replace(" ", "");
		Stack<String> p = new Stack<String>();
		String all = "";
		int count = 0;
		for (int i = 0; i < s.length(); i++) {
			String o = "" + s.charAt(i);
			if (o.equals(")") || o.equals("(") || o.equals("+") || o.equals("-")) {
					if(!all.isEmpty()) {
						if(!p.isEmpty() && p.peek().equals("(") && o.equals(")") && count==1) {
							p.pop();
							p.push(all);
							all="";
							count=0;
							continue;
						}
						p.push(all);
						all="";
						count=0;
					}
					p.push(o);
			} else {
				count++;
				all = all + o;
			}
		}
		
		if(!all.isEmpty()) {
			p.push(all);
			all="";
		}

		int c = 0;
		int pre = 0;
		while (!p.isEmpty()) {
			if (p.size() == 1 && !p.peek().equals("(")) {
				break;
			}
			String i = p.pop();
			if (i.equals(")")) {

			} else if (i.equals("(")) {
				c = c + pre;
				pre = 0;
				p.push("" + c);
				c = 0;
			} else if (i.equals("+")) {
				c = c + pre;
				pre = 0;
			} else if (i.equals("-")) {
				c = c - pre;
				pre = 0;
			} else {
				pre = Integer.parseInt(i);
			}

		}

		if (!p.isEmpty() && p.peek().equals("-")) {
			c = c * (-1);
		} else {
			try {
				c = c + Integer.parseInt(p.pop());
			} catch (Exception e) {
			}

		}

		return c;
	}
}
