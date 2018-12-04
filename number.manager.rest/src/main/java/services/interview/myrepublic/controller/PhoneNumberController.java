package services.interview.myrepublic.controller;

import java.util.Date;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import services.interview.myrepublic.service.PhoneNumberStatusService;
import services.interview.myrepublic.service.exceptions.PhoneNumberServiceDomainException;
import services.interview.myrepublic.service.vo.PhoneNumberServiceDTO;

@RestController
@RequestMapping("/phone/number")
public class PhoneNumberController {

	@Autowired
	private PhoneNumberStatusService phoneNumberService;

	@GetMapping(path = "/status/get/{number}")
	public String getStatus(@PathVariable("number") final String number) {
		try {
			return phoneNumberService.getStatus(number);
		} catch (PhoneNumberServiceDomainException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;

	}

	@GetMapping(path = "/search/{status}")
	public  List<PhoneNumberServiceDTO> search(@PathVariable("number") final String number) {
		try {
			return phoneNumberService.search(new PhoneNumberServiceDTO(number, null, null, null, null));
		} catch (PhoneNumberServiceDomainException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;

	}

	@GetMapping(path = "/history/search/{number}")
	public  List<PhoneNumberServiceDTO> searchHistory(@PathVariable("number") final String number, @PathParam("status") final String status,
			@PathParam("user") final String user,
			@PathParam("date") @DateTimeFormat(pattern = "dd-MM-yyyy") Date date) {
		try {
			return phoneNumberService.searchHistory(new PhoneNumberServiceDTO(number, status, user, date));
		} catch (PhoneNumberServiceDomainException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;

	}

	@GetMapping(path = "/history/search/status/{status}")
	public List<PhoneNumberServiceDTO> searchHistoryByStatus(@PathVariable("status") final String status,
			@PathParam("user") final String user,
			@PathParam("date") final @DateTimeFormat(pattern = "dd-MM-yyyy") Date date) {
		try {
			return phoneNumberService.searchHistory(new PhoneNumberServiceDTO(status, user, date));
		} catch (PhoneNumberServiceDomainException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;

	}

	@GetMapping(path = "/history/search/user/{user}")
	public  List<PhoneNumberServiceDTO> searchHistoryByUser(@PathVariable("user") final String user,
			@PathParam("date") final @DateTimeFormat(pattern = "dd-MM-yyyy") Date date) {
		try {
			return phoneNumberService.searchHistory(new PhoneNumberServiceDTO(user, date));
		} catch (PhoneNumberServiceDomainException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;

	}

	@PutMapping(path = "/register/{number}}")
	public void registerPhoneNumber(@PathVariable("number") final String number) {
		try {
			phoneNumberService.register(number);
		} catch (PhoneNumberServiceDomainException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@PutMapping(path = "/deregister/{number}}")
	public void deregisterPhoneNumber(@PathVariable("number") final String number) {
		try {
			phoneNumberService.deregister(number);
		} catch (PhoneNumberServiceDomainException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// Convert a predefined exception to an HTTP Status code
	@ResponseStatus(value = HttpStatus.CONFLICT, reason = "Data integrity violation") // 409
	@ExceptionHandler(PhoneNumberServiceDomainException.class)
	public void conflict() {
		// Nothing to do
	}

}
