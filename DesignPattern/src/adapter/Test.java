package adapter;

public class Test {

	public static void main(String[] args) {
		// Legacy system : LegacyFuncImpl()
		LegacyFunc legacyFunc = new LegacyFuncImpl();
		System.out.println(legacyFunc.calc(10));
		
		// New system : LegacyFuncAdapterImpl()
		LegacyFunc legacyFuncAdapter = new LegacyFuncAdapterImpl(legacyFunc); // 매개변수를 통해 old 객체 주입
		System.out.println(legacyFuncAdapter.calc(10));
		
	}

}
