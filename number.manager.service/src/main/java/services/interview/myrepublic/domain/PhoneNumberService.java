package services.interview.myrepublic.domain;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import services.interview.myrepublic.domain.dto.PhoneNumberDTO;
import services.interview.myrepublic.domain.exceptions.PhoneServiceDomainException;
import services.interview.myrepublic.entities.PhoneNumber;

public interface PhoneNumberService {

	void deregister(String phoneNumber) throws PhoneServiceDomainException;

	void register(String phoneNumber) throws PhoneServiceDomainException;

	String getStatus(String phoneNumber) throws PhoneServiceDomainException;

	List<PhoneNumberDTO> searchHistory(PhoneNumberDTO PhoneNumberServiceDTO, Pageable pageable)
			throws PhoneServiceDomainException;

	List<PhoneNumberDTO> findAvailableNumber(Pageable pageable) throws PhoneServiceDomainException;

	Page<PhoneNumber> search(PhoneNumberDTO PhoneNumberServiceDTO, Pageable pageable)
			throws PhoneServiceDomainException;

}