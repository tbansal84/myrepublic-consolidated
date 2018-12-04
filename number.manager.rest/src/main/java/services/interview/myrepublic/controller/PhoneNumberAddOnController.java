package services.interview.myrepublic.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import services.interview.myrepublic.domain.vo.PhoneNumberAddOn;
import services.interview.myrepublic.service.CustomerAddonService;

@RestController
@RequestMapping("/customer/addon")
public class PhoneNumberAddOnController {

	@Autowired
	private CustomerAddonService customerAddonService;

	@GetMapping(path = "/get/{number}")
	public List<PhoneNumberAddOn> getAddons(@PathVariable("number") final String number) {

		return customerAddonService.search(number);

	}

	@PostMapping(path = "/create")
	public void addAddon(@Valid @RequestBody PhoneNumberAddOn input) {

		customerAddonService.add(input);

	}

	@DeleteMapping(path = "/delete")
	public void removeAddon(@Valid @RequestBody PhoneNumberAddOn input) {
		customerAddonService.delete(input);

	}

	@DeleteMapping(path = "/delete/{number}")
	public void removeAll(@PathVariable("number") final String number) {
		
		customerAddonService.delete(number);

	}

}
