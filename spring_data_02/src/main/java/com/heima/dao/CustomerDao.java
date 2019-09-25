package com.heima.dao;

import com.heima.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerDao  extends JpaRepository<Customer,Long> , JpaSpecificationExecutor<Customer> {
    /**
     * 通过jpql语句查询
     * @return
     */
    @Query(value = "from Customer ")
    public List<Customer> findAllCustomer();

    @Query(value = "from Customer where custId=?1")
    public Customer findOneCustomer(Long custId);

    @Query(value = "UPDATE Customer  set custName=?1 where custAddress=?2")
    @Modifying
    public void updateCustomer(String custName,String custAddress);

    /**
     * 通过sql语句查询
     * @return
     */
    @Query(value = "select * from cst_customer",nativeQuery = true)
    public List<Customer> findSql();


    /**
     * 命名查询
     */
    public List<Customer> findAllBy();
    public Customer findByCustAddress(String custAddress);
    public List<Customer> findCustomerByCustLevelIsLike(String custLevel);





}
