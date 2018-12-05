package services.interview.myrepublic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import services.interview.myrepublic.entities.PhoneNumberAddOn;

@Repository
public interface PhoneNumberAddonRepository extends JpaRepository<PhoneNumberAddOn, String> {

}
