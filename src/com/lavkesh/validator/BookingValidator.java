package com.lavkesh.validator;

import java.util.Date;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.lavkesh.vo.BookingSlotVO;

@Component
public class BookingValidator implements Validator {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.validation.Validator#supports(java.lang.Class)
	 */
	@Override
	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return BookingSlotVO.class.equals(arg0);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.validation.Validator#validate(java.lang.Object,
	 * org.springframework.validation.Errors)
	 */
	@Override
	public void validate(Object obj, Errors errors) {

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "employeeId", "required.employeeId");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "employeeName", "required.employeeName");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "required.email");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "phone", "required.phone");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "accountName", "required.accountName");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "assessmentName", "required.assessmentName");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "level", "required.level");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "slot", "required.slot");
		ValidationUtils.rejectIfEmpty(errors, "dateOfAssessment", "required.dateOfAssessment");

		BookingSlotVO bookingSlotVO = (BookingSlotVO) obj;

		String employeeId = bookingSlotVO.getEmployeeId();
		employeeId = employeeId != null ? employeeId.trim() : "";
		if (!StringUtils.isEmpty(employeeId) && employeeId.length() != 6) {
			errors.rejectValue("employeeId", "invalid.employeeId");
		}

		String employeeName = bookingSlotVO.getEmployeeName();
		employeeName = employeeName != null ? employeeName.trim() : "";
		if (!StringUtils.isEmpty(employeeName) && (employeeName.length() < 2 || employeeName.length() > 30)) {
			errors.rejectValue("employeeName", "invalid.employeeName");
		}

		String phone = bookingSlotVO.getPhone();
		phone = phone != null ? phone.trim() : "";
		if (!StringUtils.isEmpty(phone) && phone.length() != 10) {
			errors.rejectValue("phone", "phone.format");
		}

		Date dateOfAssessment = bookingSlotVO.getDateOfAssessment();
		if (dateOfAssessment != null) {
			Date date = new Date();
			if (dateOfAssessment.before(date)) {
				errors.rejectValue("dateOfAssessment", "before.dateOfAssessment");
			}
		}

		String email = bookingSlotVO.getEmail();
		email = email != null ? email.trim() : "";
		if (!StringUtils.isEmpty(email) && !email.matches("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$")) {
			errors.rejectValue("email", "invalid.email");
		}
	}

}