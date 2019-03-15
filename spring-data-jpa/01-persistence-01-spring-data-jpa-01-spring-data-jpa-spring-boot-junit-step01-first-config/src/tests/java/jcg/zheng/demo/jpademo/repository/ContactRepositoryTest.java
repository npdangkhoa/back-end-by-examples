package jcg.zheng.demo.jpademo.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.boraji.tutorial.spring00.config.AppConfig;
import com.boraji.tutorial.spring03.repository.ContactRepository;
// TODO: Fixed error when run with SpringRunner.class
// TODO: Add SpringBootTest to fix error Unable to find a @SpringBootConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@DataJpaTest
@SpringBootTest(classes = AppConfig.class)
public class ContactRepositoryTest {
	
	@Autowired
	private ContactRepository contactRepository;
	
	
	@Test
	public void FirstTest() {
		System.out.println("First Test");
	}

}
