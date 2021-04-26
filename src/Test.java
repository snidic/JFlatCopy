
public class Test {
	public static int i, b = 2;
	public static int c = i = b;
	public static int d;

	public int add(int a, int b) {
		return a + b;
	}

	public static void main(String[] args) {
		d = c = i = b;
		System.out.println(i + " " + b + " " + c + " " + (d = 3));
		Test t1 = new Test();
		int e = t1.add(z, b);
		e = t1.sub(c, d);
		e = t1.negate(e);
		e = t1.addn(e, e);
		e = t1.addn(e, e);
	}

	public int a1 = 2;
	public static int z = -1;

	public int sub(int a, int b) {
		return a + negate(b);
	}

	public int negate(int a) {
		return -a;
	}

	public int addn(int a, int b) {
		return negate(a) - negate(b);
	}
}
