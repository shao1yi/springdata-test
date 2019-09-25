package com.hiema.test;

import com.heima.dao.CustomerDao;
import com.heima.domain.Customer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class CustomerDaoTest {
    @Autowired
    private CustomerDao customerDao;

    /**
     * 要求：
     *      定义repository接口的测试crud方法
     *      jpql语句=@Query(jpql语句)
     *      命名查询=借助idea提示
     */


    /**
     * 定义repository接口的测试crud方法
     */
    @Test
    public void findAll(){  //使用接口方法查询全部
        List<Customer> customerList = customerDao.findAll();
        customerList.forEach(System.out::println);
    }

    @Test
    public void findOne(){  //使用接口方法查询某个对象
        Customer customer = customerDao.findOne(3l);
        System.out.println("customer = " + customer);
    }

    @Test
    public void save(){     //使用接口方法插入值
        Customer customer = new Customer();
        customer.setCustAddress("FFF");
        customer.setCustLevel("fff");
        customer.setCustName("fff");
        customerDao.save(customer);
    }

    @Test
    public void saveByUpdate(){     //使用接口方法修改数据
        Customer customer = customerDao.findOne(6l);
        customer.setCustName("ffffff");
        customerDao.save(customer);
    }

    @Test
    public void delete(){       //使用接口方法删除数据
        customerDao.delete(6l);
    }


    /**
     * jpql语句=@Query(jpql语句)
     */
    @Test
    public void test01(){   //使用jpql语句查询全部
        List<Customer> customerList = customerDao.findAllCustomer();
        customerList.forEach(System.out::println);
    }

    @Test
    public void test02(){   //使用jpql语句查询单个
        Customer customer = customerDao.findOneCustomer(1l);
        System.out.println("customer = " + customer);
    }

    @Test
    public void test03(){   //使用jpql语句修改
        customerDao.updateCustomer("BB","BBB");
    }

    @Test
    public void test04(){     //使用sql语句查询
        List<Customer> customerList = customerDao.findSql();
        customerList.forEach(System.out::println);
    }


    /**
     * 命名查询=借助idea提示
     */

    @Test
    public void test05(){    //命名查询 查询全部
        List<Customer> customerList = customerDao.findAllBy();
        customerList.forEach(System.out::println);
    }

    @Test
    public void test06(){    //命名查询 查询某个
        Customer customer = customerDao.findByCustAddress("AAA");
        System.out.println("customer = " + customer);
    }

    @Test
    public void test07(){    //命名查询 模糊查询
        List<Customer> customerList = customerDao.findCustomerByCustLevelIsLike("cc%");
        customerList.forEach(System.out::println);
    }

}
