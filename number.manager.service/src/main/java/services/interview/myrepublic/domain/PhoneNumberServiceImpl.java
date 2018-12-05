package services.interview.myrepublic.domain;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import services.interview.myrepublic.domain.dto.PhoneNumberDTO;
import services.interview.myrepublic.domain.exceptions.PhoneServiceDomainException;
import services.interview.myrepublic.domain.mapper.PhoneNumberMapper;
import services.interview.myrepublic.entities.NumberStatus;
import services.interview.myrepublic.entities.PhoneNumber;
import services.interview.myrepublic.repository.PhoneNumberRepository;
import services.interview.myrepublic.repository.PhoneNumberStatusRepository;

@Service
public class PhoneNumberServiceImpl implements PhoneNumberService {

	enum PhoneNumberStatus {
		ACTIVE("Active"), AVAIABLE("Available"), BLOCKED("Blocked");
		private String status;

		private PhoneNumberStatus(String status) {
			this.status = status;
		}

		public static PhoneNumberDTO exampleWithStatus(PhoneNumberStatus status) {
			return new PhoneNumberDTO(status.status, null, null);
		}

	}

	private static Logger logger = LoggerFactory.getLogger(PhoneNumberServiceImpl.class);

	@Autowired
	PhoneNumberRepository phoneNumberRepository;
	@Autowired
	PhoneNumberStatusRepository phoneNumberStatusRepository;

	@Autowired
	PhoneNumberMapper phoneNumberMapper;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * services.interview.myrepublic.service.PhoneNumberStatusService#updateStatus(
	 * java.lang.String, java.lang.String)
	 */
	@Override
	public void register(String phoneNumber) throws PhoneServiceDomainException {
		PhoneNumberDTO phoneNumberVO = new PhoneNumberDTO(phoneNumber, "Register", null, null, null);
		try {
			update(phoneNumberVO);
		} catch (PhoneServiceDomainException e) {
			logger.error(e.getMessage(), e);
			throw new PhoneServiceDomainException();
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
	public void deregister(String phoneNumber) throws PhoneServiceDomainException {
		PhoneNumberDTO phoneNumberVO = new PhoneNumberDTO(phoneNumber, "Deregister", null, null, null);

		try {
			update(phoneNumberVO);
		} catch (PhoneServiceDomainException e) {
			logger.error(e.getMessage(), e);
			throw new PhoneServiceDomainException();
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
	public String getStatus(String phoneNumber) throws PhoneServiceDomainException {
		String status = null;
		try {
			PhoneNumberDTO phoneNumberVO = null;
			if (phoneNumberVO != null) {
				status = phoneNumberVO.getStatus();
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new PhoneServiceDomainException();
		}
		return status;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * services.interview.myrepublic.domain.PhoneNumberDomainService#update(services
	 * .interview.myrepublic.domain.vo.PhoneNumberVO)
	 */
	@CachePut(value = "phonenumbers", key = "#phoneNumberDTO.phoneNumber")
	@Transactional
	private void update(PhoneNumberDTO phoneNumberDTO) throws PhoneServiceDomainException {

		try {
			Optional<NumberStatus> o = phoneNumberStatusRepository.findById(phoneNumberDTO.getStatus());
			NumberStatus status = null;
			if (o.isPresent()) {
				status = o.get();
			}
			PhoneNumber phoneNumber = null;
			if (status != null) {
				Optional<PhoneNumber> o1 = phoneNumberRepository.findById(phoneNumberDTO.getPhoneNumber());
				if (o.isPresent()) {
					phoneNumber = o1.get();
					phoneNumber.setStatus(status);
				}
			} else {
				throw new PhoneServiceDomainException("Status could not be found");
			}
			phoneNumberRepository.save(phoneNumber);
		} catch (Exception e) {
			logger.error("Exception" + e.getMessage());
			throw new PhoneServiceDomainException();
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * services.interview.myrepublic.domain.PhoneNumberDomainService#update(services
	 * .interview.myrepublic.domain.vo.PhoneNumberVO)
	 */
	@Transactional
	@CachePut(value = "phonenumbers", key = "#phoneNumberDTO.phoneNumber")
	private void create(PhoneNumberDTO phoneNumberDTO) throws PhoneServiceDomainException {

		try {
			Optional<NumberStatus> o = phoneNumberStatusRepository.findById(phoneNumberDTO.getStatus());
			NumberStatus status = null;
			if (o.isPresent()) {
				status = o.get();
			}
			PhoneNumber phoneNumber = new PhoneNumber();
			phoneNumber.setStatus(status);
			phoneNumberRepository.save(phoneNumber);
		} catch (Exception e) {
			logger.error("Exception" + e.getMessage());
			throw new PhoneServiceDomainException();
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * services.interview.myrepublic.domain.PhoneNumberDomainService#get(java.lang.
	 * String)
	 */
	@Transactional(readOnly = true)
	@Cacheable("phonenumbers")
	private PhoneNumberDTO get(String phoneNumber) throws PhoneServiceDomainException {
		PhoneNumber entity = null;
		try {
			Optional<PhoneNumber> o = phoneNumberRepository.findById(phoneNumber);
			if (o.isPresent()) {
				entity = o.get();
			}
		} catch (Exception e) {
			logger.error("Exception" + e.getMessage());
			throw new PhoneServiceDomainException();
		}
		return entity == null ? null : phoneNumberMapper.phoneNumberToPhoneNumberDTO(entity);

	}

	@Override
	public List<PhoneNumberDTO> search(PhoneNumberDTO PhoneNumberServiceDTO, Pageable pageable)
			throws PhoneServiceDomainException {
		phoneNumberRepository.findAll(Example.of(phoneNumberMapper.phoneNumberDTOToPhoneNumber(PhoneNumberServiceDTO)),
				pageable);
		return null;
	}

	@Override
	public List<PhoneNumberDTO> searchHistory(PhoneNumberDTO PhoneNumberServiceDTO, Pageable pageable)
			throws PhoneServiceDomainException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PhoneNumberDTO> findAvailableNumber(Pageable pageable) throws PhoneServiceDomainException {
		Example<PhoneNumber> example = Example.of(phoneNumberMapper
				.phoneNumberDTOToPhoneNumber(PhoneNumberStatus.exampleWithStatus(PhoneNumberStatus.AVAIABLE)));
		List<PhoneNumberDTO> avaiables = phoneNumberMapper
				.phoneNumberToPhoneNumberDTO(phoneNumberRepository.findAll(example));
		return avaiables;
	}

}
