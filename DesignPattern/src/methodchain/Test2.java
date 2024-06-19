package methodchain;

public class Test2 {

	public static void main(String[] args) {
		Person p = new Person();
		
		// method chain
		p.setName("이지윤").setAge(20).setHeight(180)
		.setWeight(70).setAddress("경기도").showInfo();
	}

}
