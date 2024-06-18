package ch16.sec01;

public class CalculableImplPlus implements Calculable {

	@Override
	public void calculate(int x, int y) {
		System.out.println(x + y);
	}

}
