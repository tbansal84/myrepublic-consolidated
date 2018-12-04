package services.interview.myrepublic.service;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import services.interview.myrepublic.domain.PhoneNumberDomainService;
import services.interview.myrepublic.domain.vo.PhoneNumberAddOn;

public interface CustomerAddonService {
	
	@Autowired
	PhoneNumberDomainService phoneNumberDomainService;

	private static Logger logger = LoggerFactory.getLogger(PhoneNumberStatusServiceImpl.class);

	List<PhoneNumberAddOn> search(String number);

	void add(PhoneNumberAddOn input);

	void delete(PhoneNumberAddOn input);

	void delete(String number);

}
