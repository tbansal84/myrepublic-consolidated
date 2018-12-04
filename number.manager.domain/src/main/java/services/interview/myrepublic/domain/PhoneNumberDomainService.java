package services.interview.myrepublic.domain;

import java.util.List;

import services.interview.myrepublic.domain.exceptions.PhoneServiceDomainException;
import services.interview.myrepublic.domain.vo.PhoneNumberDTO;

public interface PhoneNumberDomainService {

	void update(PhoneNumberDTO phoneNumberVO) throws PhoneServiceDomainException;

	PhoneNumberDTO get(String phoneNumber) throws PhoneServiceDomainException;

	List<PhoneNumberDTO> search(PhoneNumberDTO dto);

	List<PhoneNumberDTO> searchHistory(PhoneNumberDTO dto);

}