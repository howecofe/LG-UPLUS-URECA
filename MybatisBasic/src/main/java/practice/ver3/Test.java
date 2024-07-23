package practice.ver3;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import practice.ver3.config.MybatisConfig;
import practice.ver3.dao.CustomerDao;
import practice.ver3.dto.CustomerDto;

public class Test {

	// ver.3
	// config: java & sql(mapper): java
	public static void main(String[] args) throws Exception {
		// java 설정 파일 읽기
		SqlSessionFactory sqlSessionFactory = new MybatisConfig().getSqlSessionFactory();
		SqlSession session = sqlSessionFactory.openSession();
		
		// sql
		CustomerDao customerDao = session.getMapper(CustomerDao.class);
		
		// 목록
		{
			List<CustomerDto> customerList = customerDao.listCustomer();
			for (CustomerDto customerDto : customerList) {
				System.out.println(customerDto);
			}
		}
		
		// 상세
		{
			CustomerDto customerDto = customerDao.detailCustomer(1);
			System.out.println(customerDto);
		}
		
		// 추가
		{
			CustomerDto customerDto = new CustomerDto(7, "이지윤", "대한민국 서울", "010-1234-0000");
			int ret = customerDao.insertCustomer(customerDto);
			System.out.println(ret);
			session.commit();
		}
		
		// 수정
		{
			CustomerDto customerDto = new CustomerDto(7, "이지윤 수정", "대한민국 서울 수정", "010-1234-1111");
			int ret = customerDao.updateCustomer(customerDto);
			System.out.println(ret);
			session.commit();
		}
		
		// 삭제
		{
			int ret = customerDao.deleteCustomer(7);
			System.out.println(ret);
			session.commit();
		}
		
		session.close();
	}
}
