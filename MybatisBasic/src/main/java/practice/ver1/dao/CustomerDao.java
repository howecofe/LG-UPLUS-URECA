package practice.ver1.dao;

import java.util.List;

import practice.ver1.dto.CustomerDto;

public interface CustomerDao {
	List<CustomerDto> listCustomer();
	CustomerDto detailCustomer(int custId);
	int insertCustomer(CustomerDto customerDto);
	int updateCustomer(CustomerDto customerDto);
	int deleteCustomer(int custId);
}
