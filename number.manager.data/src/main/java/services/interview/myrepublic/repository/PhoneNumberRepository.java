package services.interview.myrepublic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import services.interview.myrepublic.entities.PhoneNumber;
@Repository
public interface PhoneNumberRepository extends JpaRepository<PhoneNumber, String> {
	


	

}
