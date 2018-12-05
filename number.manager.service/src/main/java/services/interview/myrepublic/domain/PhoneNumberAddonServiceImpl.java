package services.interview.myrepublic.domain;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Pageable;

import services.interview.myrepublic.domain.dto.PhoneNumberAddOnDTO;
import services.interview.myrepublic.domain.mapper.PhoneNumberAddonMapper;
import services.interview.myrepublic.entities.PhoneNumberAddOn;
import services.interview.myrepublic.repository.PhoneNumberAddonRepository;

public class PhoneNumberAddonServiceImpl implements PhoneNumberAddonService {

	private static final Logger logger = LoggerFactory.getLogger(PhoneNumberAddonServiceImpl.class);

	@Autowired
	PhoneNumberAddonRepository phoneNumberAddonRepository;

	@Autowired
	PhoneNumberAddonMapper phoneNumberAddonMapper;

	@Override
	public List<PhoneNumberAddOnDTO> search(String number, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void add(PhoneNumberAddOnDTO dto) {

		PhoneNumberAddOn entity = phoneNumberAddonMapper.phoneNumberAddonDTOToPhoneNumberAddon(dto);
		phoneNumberAddonRepository.save(entity);

	}

	@Override
	public void deleteAllMatching(PhoneNumberAddOnDTO input) {
		Example<PhoneNumberAddOn> example = Example
				.of(phoneNumberAddonMapper.phoneNumberAddonDTOToPhoneNumberAddon(input));
		List<PhoneNumberAddOn> deletables = phoneNumberAddonRepository.findAll(example);
		phoneNumberAddonRepository.deleteAll(deletables);

	}

	@Override
	public void delete(String addOn) {
		PhoneNumberAddOn entity = new PhoneNumberAddOn();
		Optional<PhoneNumberAddOn> entityOptional = phoneNumberAddonRepository.findById(addOn);
		entityOptional.ifPresent(e -> {
			phoneNumberAddonRepository.delete(e);
		});

	}

}
