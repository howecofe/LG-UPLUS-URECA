package iterator.generic;

public class Test {

	public static void main(String[] args) {
		ContainerImpl<Integer> container = new ContainerImpl<>();
		Integer[] intArray = {1, 3, 4, 6, 7};
		container.setArray(intArray);
		
		Iterator<Integer> iter = container.getIterator();
		
		while (iter.hasNext()) {
			System.out.println(iter.next());
		}
		
		System.out.println("--------------");
		
		ContainerImpl<String> container2 = new ContainerImpl<>();
		String[] strArr = {"Hello", "Iterator", "Pattern"};
		container2.setArray(strArr);
		
		Iterator<String> iter2 = container2.getIterator();
		
		while (iter2.hasNext()) {
			System.out.println(iter2.next());
		}

	}

}
