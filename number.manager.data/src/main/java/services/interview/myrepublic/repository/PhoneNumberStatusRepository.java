package services.interview.myrepublic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import services.interview.myrepublic.entities.NumberStatus;
@Repository
public interface PhoneNumberStatusRepository extends JpaRepository<NumberStatus, String> {
	


	

}
