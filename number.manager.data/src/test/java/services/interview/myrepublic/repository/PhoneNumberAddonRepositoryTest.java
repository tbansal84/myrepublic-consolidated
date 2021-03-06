
package services.interview.myrepublic.repository;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class PhoneNumberAddonRepositoryTest {

	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	private PhoneNumberAddonRepository employeeRepository;

	// write test cases here

}