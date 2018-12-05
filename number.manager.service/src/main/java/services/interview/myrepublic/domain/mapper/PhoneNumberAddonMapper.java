package services.interview.myrepublic.domain.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import services.interview.myrepublic.entities.PhoneNumberAddOn;
import services.interview.myrepublic.domain.dto.PhoneNumberAddOnDTO;
import services.interview.myrepublic.domain.dto.PhoneNumberDTO;
import services.interview.myrepublic.entities.PhoneNumber;


@Mapper(componentModel = "spring")
public interface PhoneNumberAddonMapper {

	PhoneNumberAddOnDTO phoneNumberAddonToPhoneNumberAddonDTO(PhoneNumberAddOn entity);

	PhoneNumberAddOn phoneNumberAddonDTOToPhoneNumberAddon(PhoneNumberAddOnDTO dto);

}