package services.interview.myrepublic.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import services.interview.myrepublic.domain.PhoneNumberDomainService;
import services.interview.myrepublic.domain.exceptions.PhoneServiceDomainException;
import services.interview.myrepublic.domain.vo.PhoneNumberDTO;
import services.interview.myrepublic.service.exceptions.PhoneNumberServiceDomainException;
import services.interview.myrepublic.service.vo.PhoneNumberServiceDTO;

@Service
public class PhoneNumberStatusServiceImpl implements PhoneNumberStatusService {
	@Autowired
	PhoneNumberDomainService phoneNumberDomainService;

	private static Logger logger = LoggerFactory.getLogger(PhoneNumberStatusServiceImpl.class);

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * services.interview.myrepublic.service.PhoneNumberStatusService#updateStatus(
	 * java.lang.String, java.lang.String)
	 */
	@Override
	public void register(String phoneNumber) throws PhoneNumberServiceDomainException {
		PhoneNumberServiceDTO phoneNumberVO = new PhoneNumberServiceDTO(phoneNumber, "Register", null, null, null);
		PhoneNumberDTO dto = new PhoneNumberDTO();
		try {
			phoneNumberDomainService.update(dto);
		} catch (PhoneServiceDomainException e) {
			logger.error(e.getMessage(), e);
			throw new PhoneNumberServiceDomainException();
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * services.interview.myrepublic.service.PhoneNumberStatusService#updateStatus(
	 * java.lang.String, java.lang.String)
	 */
	@Override
	public void deregister(String phoneNumber) throws PhoneNumberServiceDomainException {
		PhoneNumberDTO dto = new PhoneNumberDTO();
		PhoneNumberServiceDTO phoneNumberVO = new PhoneNumberServiceDTO(phoneNumber, "Deregister", null, null, null);
		try {
			phoneNumberDomainService.update(dto);
		} catch (PhoneServiceDomainException e) {
			logger.error(e.getMessage(), e);
			throw new PhoneNumberServiceDomainException();
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * services.interview.myrepublic.service.PhoneNumberStatusService#getStatus(java
	 * .lang.String)
	 */
	@Override
	public String getStatus(String phoneNumber) throws PhoneNumberServiceDomainException {
		String status = null;
		try {
			PhoneNumberServiceDTO phoneNumberVO = null;
			if (phoneNumberVO != null) {
				status = phoneNumberVO.getStatus();
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new PhoneNumberServiceDomainException();
		}
		return status;

	}

	@Override
	public List<PhoneNumberServiceDTO> search(
			services.interview.myrepublic.service.vo.PhoneNumberServiceDTO PhoneNumberServiceDTO) {
		PhoneNumberDTO dto = new PhoneNumberDTO();
		List<PhoneNumberDTO> results = phoneNumberDomainService.search(dto);
		return null;
	}

	@Override
	public List<PhoneNumberServiceDTO> searchHistory(
			services.interview.myrepublic.service.vo.PhoneNumberServiceDTO PhoneNumberServiceDTO) {
		PhoneNumberDTO dto = new PhoneNumberDTO();
		List<PhoneNumberDTO> results = phoneNumberDomainService.searchHistory(dto);
		return null;
	}

}
