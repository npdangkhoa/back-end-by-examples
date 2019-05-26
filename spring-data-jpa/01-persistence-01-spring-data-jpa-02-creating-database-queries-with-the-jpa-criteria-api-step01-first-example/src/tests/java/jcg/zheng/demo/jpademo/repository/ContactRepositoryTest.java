package jcg.zheng.demo.jpademo.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Matchers.contains;

import java.util.List;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.boraji.tutorial.spring00.config.AppConfig;
import com.boraji.tutorial.spring01.entities.Contact;
import com.boraji.tutorial.spring01.entities.PhoneType;
import com.boraji.tutorial.spring03.repository.ContactRepository;
import com.boraji.tutorial.spring04.domain.ContactSpecifications;

// TODO: Fixed error when run with SpringRunner.class
// TODO: Add SpringBootTest to fix error Unable to find a @SpringBootConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@DataJpaTest
@SpringBootTest(classes = AppConfig.class)
@Transactional
public class ContactRepositoryTest {

	@Autowired
	private ContactRepository contactRepository;

	@Test
	public void FirstTest() {
		System.out.println("First Test");
	}
	
	@Test
	public void count_number_record() {
		Contact contactTom = new Contact("Tom", "Zheng", "6365272943", PhoneType.HOME, "test@test.com");
		Contact contactMary = new Contact("Mary", "Zheng", "6365272943", PhoneType.HOME, "test@test.com");

		contactRepository.save(contactMary);
		contactRepository.save(contactTom);

		List<Contact> contacts = contactRepository.findAll();			
		assertEquals(2, contacts.size());
	}

	@Test
	public void has_name_is_Mary() {
		Contact contactTom = new Contact("Tom", "Zheng", "6365272943", PhoneType.HOME, "test@test.com");
		Contact contactMary = new Contact("Mary", "Zheng", "6365272943", PhoneType.HOME, "test@test.com");

		contactRepository.save(contactMary);
		contactRepository.save(contactTom);

		Specification<Contact> name = ContactSpecifications.hasFirstName("mary");
		
		List<Contact> contacts = contactRepository.findAll(name);	
		assertEquals(1, contacts.size());
		assertEquals("Mary", contacts.get(0).getFirstName());


	}

}
