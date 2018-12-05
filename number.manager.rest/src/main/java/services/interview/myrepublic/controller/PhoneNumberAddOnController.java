package services.interview.myrepublic.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import services.interview.myrepublic.domain.PhoneNumberAddonService;
import services.interview.myrepublic.domain.dto.PhoneNumberAddOnDTO;

@RestController
@RequestMapping("/customer/addon")
public class PhoneNumberAddOnController {

	@Autowired
	private PhoneNumberAddonService customerAddonService;

	@GetMapping(path = "/get/{number}")
	public List<PhoneNumberAddOnDTO> getAddons(@PathVariable("number") final String number, Pageable pageable) {

		return customerAddonService.search(number, pageable);

	}

	@PostMapping(path = "/create")
	public void addAddon(@Valid @RequestBody PhoneNumberAddOnDTO input) {

		customerAddonService.add(input);

	}

	@DeleteMapping(path = "/delete")
	public void removeMatchingAddon(@Valid @RequestBody PhoneNumberAddOnDTO input) {
		customerAddonService.deleteAllMatching(input);

	}

	@DeleteMapping(path = "/delete/{number}")
	public void removeAll(@PathVariable("number") final String number) {

		customerAddonService.delete(number);

	}

}
