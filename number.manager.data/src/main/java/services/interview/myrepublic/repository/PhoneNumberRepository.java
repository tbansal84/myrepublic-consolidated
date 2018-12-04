package services.interview.myrepublic.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import services.interview.myrepublic.entities.PhoneNumber;
@Repository
public interface PhoneNumberRepository extends CrudRepository<PhoneNumber, String> {
	


	

}
