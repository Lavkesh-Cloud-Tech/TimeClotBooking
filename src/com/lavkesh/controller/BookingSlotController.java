package com.lavkesh.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lavkesh.validator.BookingValidator;
import com.lavkesh.vo.BookingSlotVO;

@Controller
@ControllerAdvice
public class BookingSlotController {

	@Autowired
	private BookingValidator bookingValidator;

	private AtomicInteger bookingIdGenerator = new AtomicInteger(0);

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
		binder.setValidator(bookingValidator);
	}

	// to do business logic for each request in jsp
	@RequestMapping(value = "/show", method = RequestMethod.GET)
	public String showBookingPage(ModelMap modelMap) {
		modelMap.addAttribute("bookingSlot", new BookingSlotVO());
		return "booking";
	}

	@RequestMapping(value = "/confirm", method = RequestMethod.POST)
	public String confirmBookingDetails(@ModelAttribute("bookingSlot") BookingSlotVO bookingSlot, BindingResult errors,
			ModelMap modelMap) {

		bookingValidator.validate(bookingSlot, errors);
		if (errors.hasErrors()) {
			return "booking";
		}

		int bookingId = bookingIdGenerator.incrementAndGet();
		bookingSlot.setBookingId(bookingId);
		modelMap.addAttribute("bookingSlot", bookingSlot);
		return "bookingSuccess";
	}

	@ModelAttribute("assessmentList")
	public Map<String, String> populateAssessmentList() {

		// Data referencing for java skills list box
		Map<String, String> assesmentList = new LinkedHashMap<String, String>();
		assesmentList.put("Spring 4.x Level1", "Spring 4.x CA Enablement Level1");
		assesmentList.put("Spring 4.x Level2", "Spring 4.x CA Enablement Level2");
		assesmentList.put("Spring 4.x Level3", "Spring 4.x CA Enablement Level3");
		assesmentList.put("Struts 2.x Level1", "Struts 2.x CA Enablement Level1");
		assesmentList.put("Struts 2.x Level2", "Struts 2.x CA Enablement Level2");
		assesmentList.put("Struts 2.x Level3", "Struts 2.x CA Enablement Level3");
		assesmentList.put("Hibernate 3.x Level1", "Hibernate 3.x CA Enablement Level1");
		assesmentList.put("Hibernate 3.x Level2", "Hibernate 3.x CA Enablement Level2");
		assesmentList.put("Hibernate 3.x Level3", "Hibernate 3.x CA Enablement Level3");
		assesmentList.put("JSF 1.x Level1", "JSF 1.x CA Enablement Level1");
		assesmentList.put("JSF 1.x Level2", "JSF 1.x CA Enablement Level2");
		assesmentList.put("JSF 1.x Level3", "JSF 1.x CA Enablement Level3");
		assesmentList.put("Core Java Level1", "Core Java CA Enablement Level1");
		assesmentList.put("Core Java Level2", "Core Java CA Enablement Level2");
		assesmentList.put("Core Java Level3", "Core Java CA Enablement Level3");
		assesmentList.put("Spring 4 MVC Level1", "Spring 4 MVC CA Enablement Level1");
		assesmentList.put("Spring 4 MVC Level2", "Spring 4 MVC CA Enablement Level2");
		assesmentList.put("Spring 4 MVC Level3", "Spring 4 MVC CA Enablement Level3");

		return assesmentList;
	}

	@ModelAttribute("levelList")
	public Map<String, String> populateLevelList() {

		// Data referencing for java skills list box
		Map<String, String> levelList = new LinkedHashMap<String, String>();
		levelList.put("Level1", "Level1");
		levelList.put("Level2", "Level2");
		levelList.put("Level3", "Level3");

		return levelList;
	}

	@ModelAttribute("slotList")
	public Map<String, String> populatetimeSlotList() {

		// Data referencing for java skills list box
		Map<String, String> slotList = new LinkedHashMap<String, String>();
		slotList.put("10:00 AM", "10:00 AM");
		slotList.put("12:00 PM", "12:00 PM");
		slotList.put("02:00 PM", "02:00 PM");
		slotList.put("04:00 PM", "04:00 PM");
		slotList.put("06:00 PM", "06:00 PM");

		return slotList;
	}
}