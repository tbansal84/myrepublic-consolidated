package services.interview.myrepublic.controller;

import java.util.Date;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import services.interview.myrepublic.domain.PhoneNumberService;
import services.interview.myrepublic.domain.dto.PhoneNumberDTO;
import services.interview.myrepublic.domain.exceptions.PhoneServiceDomainException;

@RestController
@RequestMapping("/phone/number")
public class PhoneNumberController {

	@Autowired
	private PhoneNumberService phoneNumberDomainService;

	@GetMapping(path = "/status/get/{number}")
	public String getStatus(@PathVariable("number") final String number) {
		try {
			return phoneNumberDomainService.getStatus(number);
		} catch (PhoneServiceDomainException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;

	}

	@GetMapping(path = "/search/{status}")
	public List<PhoneNumberDTO> search(@PathVariable("number") final String number, Pageable pageable) {
		try {
			return phoneNumberDomainService.search(new PhoneNumberDTO(number, null, null, null, null), pageable);
		} catch (PhoneServiceDomainException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;

	}

	@GetMapping(path = "/history/search/{number}")
	public List<PhoneNumberDTO> searchHistory(@PathVariable("number") final String number,
			@PathParam("status") final String status, @PathParam("user") final String user,
			@PathParam("date") @DateTimeFormat(pattern = "dd-MM-yyyy") Date date, Pageable pageable) {
		try {
			return phoneNumberDomainService.searchHistory(new PhoneNumberDTO(number, status, user, date), pageable);
		} catch (PhoneServiceDomainException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;

	}

	@GetMapping(path = "/history/search/status/{status}")
	public List<PhoneNumberDTO> searchHistoryByStatus(@PathVariable("status") final String status,
			@PathParam("user") final String user,
			@PathParam("date") final @DateTimeFormat(pattern = "dd-MM-yyyy") Date date, Pageable pageable) {
		try {
			return phoneNumberDomainService.searchHistory(new PhoneNumberDTO(status, user, date), pageable);
		} catch (PhoneServiceDomainException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;

	}

	@GetMapping(path = "/history/search/user/{user}")
	public List<PhoneNumberDTO> searchHistoryByUser(@PathVariable("user") final String user,
			@PathParam("date") final @DateTimeFormat(pattern = "dd-MM-yyyy") Date date, Pageable pageable) {
		try {
			return phoneNumberDomainService.searchHistory(new PhoneNumberDTO(user, date), pageable);
		} catch (PhoneServiceDomainException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;

	}

	@PutMapping(path = "/register/{number}}")
	public void registerPhoneNumber(@PathVariable("number") final String number) {
		try {
			phoneNumberDomainService.register(number);
		} catch (PhoneServiceDomainException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@PutMapping(path = "/deregister/{number}}")
	public void deregisterPhoneNumber(@PathVariable("number") final String number) {
		try {
			phoneNumberDomainService.deregister(number);
		} catch (PhoneServiceDomainException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@PutMapping(path = "/available")
	public List<PhoneNumberDTO> findAvailableNumber(Pageable pageable) {
		List<PhoneNumberDTO> result = null;
		try {
			result = phoneNumberDomainService.findAvailableNumber(pageable);
		} catch (PhoneServiceDomainException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	// Convert a predefined exception to an HTTP Status code
	@ResponseStatus(value = HttpStatus.CONFLICT, reason = "Data integrity violation") // 409
	@ExceptionHandler(PhoneServiceDomainException.class)
	public void conflict() {
		// Nothing to do
	}

}
