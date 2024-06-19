
public class _02_Parameterize_Method {

	// Old
    static class EmployeeOld{
        public void raiseSalary10Percentage() {}        
        public void raiseSalary20Percentage() {}        
        public void raiseSalary50Percentage() {}
    }
    
    // New
    static class EmployeeNew{
        public void raiseSalaryPercentage(int percentage) {}        
    }
}

// 개선 방법 : 같은 기능을 하는 메서드를 여러 개 만들지 말고, 메서드를 하나로 만들고 파라미터를 통해 다르게 처리