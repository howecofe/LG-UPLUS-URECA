package iterator;

public class Test {

	public static void main(String[] args) {
		StringContainer container = new StringContainer();
		
		Iterator iter = container.getIterator();
		
		while (iter.hasNext()) {
			System.out.println(iter.next());
		}

	}

}
