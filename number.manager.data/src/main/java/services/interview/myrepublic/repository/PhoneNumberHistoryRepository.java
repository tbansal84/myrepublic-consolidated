package services.interview.myrepublic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import services.interview.myrepublic.entities.PhoneNumbersHistory;

@Repository
public interface PhoneNumberHistoryRepository extends JpaRepository<PhoneNumbersHistory, String> {

}
