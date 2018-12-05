package services.interview.myrepublic.domain.mapper;

import java.util.Collection;
import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import services.interview.myrepublic.domain.dto.PhoneNumberDTO;
import services.interview.myrepublic.entities.PhoneNumber;


@Mapper(componentModel = "spring")
public interface PhoneNumberMapper {

	@Mappings({ @Mapping(target = "phoneNumber", source = "entity.number"),
			@Mapping(target = "status", source = "entity.status.status") })
	PhoneNumberDTO phoneNumberToPhoneNumberDTO(PhoneNumber entity);

	@Mappings({ @Mapping(target = "number", source = "dto.phoneNumber"),
			@Mapping(target = "status.status", source = "dto.status") })
	PhoneNumber phoneNumberDTOToPhoneNumber(PhoneNumberDTO dto);
	
	public abstract List<PhoneNumberDTO> phoneNumberToPhoneNumberDTO(Collection<PhoneNumber> transactions);

}