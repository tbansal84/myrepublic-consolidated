package services.interview.myrepublic.domain;

import java.util.List;

import org.springframework.data.domain.Pageable;

import services.interview.myrepublic.domain.dto.PhoneNumberAddOnDTO;

public interface PhoneNumberAddonService {


	List<PhoneNumberAddOnDTO> search(String number, Pageable pageable);

	void add(PhoneNumberAddOnDTO input);

	void deleteAllMatching(PhoneNumberAddOnDTO input);

	void delete(String number);

}
