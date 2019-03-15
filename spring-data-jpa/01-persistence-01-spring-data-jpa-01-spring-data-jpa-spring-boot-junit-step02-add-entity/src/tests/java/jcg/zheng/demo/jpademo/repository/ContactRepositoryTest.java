package jcg.zheng.demo.jpademo.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.List;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.boraji.tutorial.spring00.config.AppConfig;
import com.boraji.tutorial.spring01.entities.Contact;
import com.boraji.tutorial.spring01.entities.PhoneType;
import com.boraji.tutorial.spring03.repository.ContactRepository;

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
	public void it_can_find_the_contact_after_save_it() {
		System.out.println("Execute it_can_find_the_contact_after_save_it");
		Contact contact = new Contact();
		contact.setFirstName("Mary");
		contact.setLastName("Zheng");
		contact.setPhoneNumber("6365272943");
		contact.setPhoneType(PhoneType.HOME);
		contact.setEmail("test@test.com");

		contactRepository.save(contact);

		List<Contact> contacts = contactRepository.findAll();

		assertEquals(1, contacts.size());
		assertEquals("Mary", contacts.get(0).getFirstName());
		assertEquals("Zheng", contacts.get(0).getLastName());
		assertEquals("test@test.com", contacts.get(0).getEmail());
		assertEquals(PhoneType.HOME, contacts.get(0).getPhoneType());
		assertEquals("6365272943", contacts.get(0).getPhoneNumber());

	}

	@Test
	public void it_can_delete_the_contact_after_save_it() {
		System.out.println("Execute it_can_delete_the_contact_after_save_it");
		Contact contact = new Contact();
		contact.setFirstName("Mary");
		contact.setLastName("Zheng");
		contact.setPhoneNumber("6365272943");
		contact.setPhoneType(PhoneType.HOME);
		contact.setEmail("test@test.com");

		contactRepository.save(contact);

		List<Contact> contacts = contactRepository.findAll();
		contactRepository.delete(contacts.get(0));

		contacts = contactRepository.findAll();
		assertEquals(0, contacts.size());
	}

	@Test
	public void it_can_update_the_contact_after_save_it() {
		System.out.println("Execute it_can_update_the_contact_after_save_it");
		Contact contact = new Contact();
		contact.setFirstName("Mary");
		contact.setLastName("Zheng");
		contact.setPhoneNumber("6365272943");
		contact.setPhoneType(PhoneType.HOME);
		contact.setEmail("test@test.com");

		contactRepository.save(contact);

		contact.setEmail("mary.zheng@test.com");
		contactRepository.save(contact);

		List<Contact> contacts = contactRepository.findAll();
		assertEquals(1, contacts.size());
		assertEquals("mary.zheng@test.com", contacts.get(0).getEmail());

	}

	@Test
	public void it_can_find_contacts_by_name_and_type() {
		contactRepository.save(new Contact("Mary", "Zheng", "mary.zheng@jcg.org", PhoneType.HOME, "6368168164"));
		contactRepository.save(new Contact("Tom", "Smith", "tom.smith@jcg.org", PhoneType.MOBILE, "(636) 527-2943"));
		contactRepository.save(new Contact("John", "Joe", "john.joe@jcg.org", PhoneType.OFFICE, "(314) 527 2943"));
		contactRepository.save(new Contact("Cindy", "Chang", "cindy.change@jcg.org", PhoneType.OTHER, "404-789-1456"));

		List<Contact> contacts = contactRepository.findByLastNameAndPhoneType("Zheng", PhoneType.HOME);

		assertEquals(1, contacts.size());
		Contact foundContact = contacts.get(0);
		assertEquals("Mary", foundContact.getFirstName());
		assertEquals("Zheng", foundContact.getLastName());
		assertEquals("mary.zheng@jcg.org", foundContact.getEmail());
		assertEquals(PhoneType.HOME, foundContact.getPhoneType());
		assertEquals("6368168164", foundContact.getPhoneNumber());
	}

	@Test
	public void it_return_null_when_not_found() {
		Contact found = contactRepository.findOne(2L);
		assertNull(found);
	}

}
