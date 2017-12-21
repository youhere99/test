package innerclass;

public class OutClass2 {

	public static class innerClass {

		private String name;

		public innerClass(String name) {
			this.name = name;
		}

		public void print() {
			System.out.println(this.name);
		}
	}

	public class innerClass2 {

		private final String name;

		public innerClass2(String name) {
			this.name = name;
		}

		public void print() {
			System.out.println(this.name);
		}
	}

	public static void main(String[] args) {
		//OutClass2 a = new OutClass2();
		innerClass b = new innerClass("1");
		innerClass c = new innerClass("2");
		b.name = "3";
		b.print();
		c.name = "4";
		c.print();

		OutClass2 a = new OutClass2();
		innerClass2 b2 = a.new innerClass2("5");
		innerClass2 c2 = a.new innerClass2("6");
		b2.print();
		c2.print();
	}
}