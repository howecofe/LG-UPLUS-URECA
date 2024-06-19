package adapter;

public class LegacyFuncImpl implements LegacyFunc {

	@Override
	public int calc(int num) {
		// Legacy 는 x 10 해서 리턴
		return num * 10;
	}

}
