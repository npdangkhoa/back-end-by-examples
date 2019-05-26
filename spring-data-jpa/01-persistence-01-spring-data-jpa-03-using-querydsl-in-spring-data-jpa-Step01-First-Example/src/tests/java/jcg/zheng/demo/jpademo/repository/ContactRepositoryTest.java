package jcg.zheng.demo.jpademo.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Matchers.contains;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.domain.Specifications;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.spring00.config.AppConfig;
import com.spring01.entities.Contact;


// TODO: Fixed error when run with SpringRunner.class
// TODO: Add SpringBootTest to fix error Unable to find a @SpringBootConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@DataJpaTest
@SpringBootTest(classes = AppConfig.class)
@Transactional
public class ContactRepositoryTest {



	@Test
	public void FirstTest() {
		System.out.println("First Test");
	}

}
