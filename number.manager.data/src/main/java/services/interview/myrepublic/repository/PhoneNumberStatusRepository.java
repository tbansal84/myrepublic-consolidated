package services.interview.myrepublic.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import services.interview.myrepublic.entities.NumberStatus;
import services.interview.myrepublic.entities.PhoneNumber;
@Repository
public interface PhoneNumberStatusRepository extends CrudRepository<NumberStatus, String> {
	


	

}
