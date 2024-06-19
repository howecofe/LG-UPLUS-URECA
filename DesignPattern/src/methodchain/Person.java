package methodchain;

//method chain pattern
public class Person {

	private int height;
	private int weight;
	private String name;
	private String address;
	private int age;
	
	public Person setHeight(int height) {
		this.height = height;
		return this;
	}
	public Person setWeight(int weight) {
		this.weight = weight;
		return this;
	}
	public Person setName(String name) {
		this.name = name;
		return this;
	}
	public Person setAddress(String address) {
		this.address = address;
		return this;
	}
	public Person setAge(int age) {
		this.age = age;
		return this;
	}
	
	public Person showInfo() {
		System.out.printf("이름 : %s\n나이: %d\n주소: %s\n키: %dcm\n몸무게: %dkg",
				this.name, this.age, this.address, this.height, this.weight);
		
		return this;
	}
}
