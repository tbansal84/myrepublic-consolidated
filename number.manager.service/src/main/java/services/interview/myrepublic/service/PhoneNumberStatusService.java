package services.interview.myrepublic.service;

import java.util.List;

import services.interview.myrepublic.service.exceptions.PhoneNumberServiceDomainException;
import services.interview.myrepublic.service.vo.PhoneNumberServiceDTO;

public interface PhoneNumberStatusService {

	String getStatus(String phoneNumber) throws PhoneNumberServiceDomainException;

	void register(String phoneNumber) throws PhoneNumberServiceDomainException;

	void deregister(String phoneNumber) throws PhoneNumberServiceDomainException;

	List<PhoneNumberServiceDTO> search(PhoneNumberServiceDTO phoneNumberDTO) throws PhoneNumberServiceDomainException;

	List<PhoneNumberServiceDTO> searchHistory(PhoneNumberServiceDTO phoneNumberDTO) throws PhoneNumberServiceDomainException;


}