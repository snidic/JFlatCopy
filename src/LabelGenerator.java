
public class LabelGenerator {
	private static int labelNum;

	public static String nextLabel() {
		return "L" + labelNum++;
	}

	public static String[] nextLabel(int n) {
		if (n <= 0)
			return null;
		String[] labels = new String[n];
		for (int i = 0; i < n; i++) {
			labels[i] = nextLabel();
		}
		return labels;
	}
}
