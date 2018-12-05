package services.interview.myrepublic.domain;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import services.interview.myrepublic.domain.mapper.PhoneNumberMapper;
import services.interview.myrepublic.entities.PhoneNumber;
import services.interview.myrepublic.repository.PhoneNumberRepository;
import services.interview.myrepublic.repository.PhoneNumberStatusRepository;

@RunWith(SpringRunner.class)
public class PhoneNumberServiceTest {

	@TestConfiguration
	static class PhoneNumberServiceTestConfig {

		@Bean
		public PhoneNumberServiceImpl phoneNumberAddonServiceImpl() {
			return new PhoneNumberServiceImpl();
		}
	}

	@Before
	public void setUp() {

		String phoneNumber = "93372133";
		PhoneNumber phoneNumber1 = new PhoneNumber();

		Mockito.when(phoneNumberRepository.findById(phoneNumber)).thenReturn(Optional.of(phoneNumber1));
	}

	@Autowired
	private PhoneNumberService phoneNumberService;
	@MockBean
	private PhoneNumberRepository phoneNumberRepository;
	@MockBean
	private PhoneNumberMapper phoneNumberMapper;
	@MockBean
	private PhoneNumberStatusRepository phoneNumberStatusRepository;

	@Test
	public void deregister() {

	}

	@Test
	public void register() {

	}

	@Test
	public void getStatus() {

	}

	@Test
	public void searchHistory() {

	}

	@Test
	public void findAvailableNumber() {

	}

	@Test
	public void search() {

	}
}