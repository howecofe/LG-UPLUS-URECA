package ch13.sec02.ex03;

import java.util.Objects;

public class MyClass {
	String str;

	@Override
	public int hashCode() {
		return Objects.hash(str);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MyClass other = (MyClass) obj;
		return Objects.equals(str, other.str);
	}
	
	
}
