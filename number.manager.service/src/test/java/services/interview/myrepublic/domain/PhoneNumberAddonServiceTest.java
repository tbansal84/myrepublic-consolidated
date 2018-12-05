package services.interview.myrepublic.domain;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import services.interview.myrepublic.domain.mapper.PhoneNumberAddonMapper;
import services.interview.myrepublic.repository.PhoneNumberAddonRepository;

@RunWith(SpringRunner.class)
public class PhoneNumberAddonServiceTest {

	@TestConfiguration
	static class PhoneNumberAddonServiceTestConfig {

		@Bean
		public PhoneNumberAddonServiceImpl phoneNumberAddonServiceImpl() {
			return new PhoneNumberAddonServiceImpl();
		}
	}

	@Autowired
	private PhoneNumberAddonService phoneNumberAddonService;

	@MockBean
	private PhoneNumberAddonRepository customerAddonRepository;
	// write test cases here
	@MockBean
	private PhoneNumberAddonMapper phoneNumberAddonMapper;
}