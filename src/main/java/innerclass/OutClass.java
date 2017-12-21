package innerclass;

public class OutClass {

	public static void main(String[] args) {
		OutClass out = new OutClass();

		Bird inner_1 = out.getBird(201, "chenssy");
		System.out.println(inner_1.getName());

		Bird inner_2 = out.getBird(23, "chenssy");
		System.out.println(inner_2.getName());
	}

	public Bird getBird(final int mile, final String name) {
		return new Bird(name) {

			String name_ = name;
			//构造代码块完成初始化工作  
			{
				System.out.println(mile);
			}

			@Override
			public String getName() {
				return name_;
			}

			@Override
			public int fly() {
				return mile;
			}
		};
	}
}