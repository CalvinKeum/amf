/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.amf.internal;

import com.liferay.amf.AMFRegistrationService;
import com.liferay.amf.configuration.AMFConfigurationValues;
import com.liferay.amf.exception.AddressCityException;
import com.liferay.amf.exception.AddressStateException;
import com.liferay.amf.exception.AddressStreetException;
import com.liferay.amf.exception.AddressZipException;
import com.liferay.amf.exception.BirthdayException;
import com.liferay.amf.exception.EmailAddressException;
import com.liferay.amf.exception.FirstNameException;
import com.liferay.amf.exception.HomePhoneException;
import com.liferay.amf.exception.LastNameException;
import com.liferay.amf.exception.MobilePhoneException;
import com.liferay.amf.exception.PasswordException;
import com.liferay.amf.exception.SecurityAnswerException;
import com.liferay.amf.exception.SecurityQuestionException;
import com.liferay.amf.exception.UsernameException;
import com.liferay.portal.kernel.exception.TermsOfUseException;
import com.liferay.portal.kernel.exception.UserPasswordException;
import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.kernel.model.Contact;
import com.liferay.portal.kernel.model.Country;
import com.liferay.portal.kernel.model.ListType;
import com.liferay.portal.kernel.model.ListTypeConstants;
import com.liferay.portal.kernel.model.Region;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.AddressLocalService;
import com.liferay.portal.kernel.service.ContactLocalService;
import com.liferay.portal.kernel.service.CountryService;
import com.liferay.portal.kernel.service.ListTypeLocalService;
import com.liferay.portal.kernel.service.PhoneLocalService;
import com.liferay.portal.kernel.service.RegionService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.service.UserService;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.CalendarUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Calvin Keum
 */
@Component(immediate = true, service = AMFRegistrationService.class)
public class AMFRegistrationServiceImpl implements AMFRegistrationService {

	public void createAccount(
			ThemeDisplay themeDisplay, String username, String emailAddress,
			String firstName, String lastName, boolean male, int birthdayMonth,
			int birthdayDay, int birthdayYear, String password1,
			String password2, String securityQuestion, String securityAnswer,
			boolean acceptedTOU, String homePhone, String mobilePhone,
			String address, String address2, String city, String state,
			String zip, ServiceContext userServiceContext,
			ServiceContext phoneServiceContext,
			ServiceContext addressServiceContext)
		throws Exception {

		validateUser(
			firstName, lastName, emailAddress, username, birthdayMonth,
			birthdayDay, birthdayYear, password1, password2, securityQuestion,
			securityAnswer, acceptedTOU);

		validatePhone(homePhone, mobilePhone);

		validateAddress(address, address2, city, state, zip);

		Company company = themeDisplay.getCompany();

		User user = addUser(
			company.getCompanyId(), firstName, lastName, emailAddress, username,
			male, birthdayMonth, birthdayDay, birthdayYear, password1,
			password2, securityQuestion, securityAnswer, acceptedTOU,
			userServiceContext);

		addPhone(user, homePhone, _LIST_TYPE_NAME_HOME, phoneServiceContext);
		addPhone(
			user, mobilePhone, _LIST_TYPE_NAME_MOBILE, phoneServiceContext);

		addAddress(
			user, address, address2, city, state, zip, addressServiceContext);
	}

	protected void addAddress(
			User user, String address, String address2, String city,
			String state, String zip, ServiceContext serviceContext)
		throws Exception {

		long classNameId = _portal.getClassNameId(Contact.class);

		long contactId = getContactId(user.getUserId());

		Country country = _countryService.getCountryByA3(_COUNTRY_A3_USA);

		Region region = _regionService.getRegion(country.getCountryId(), state);

		ListType listType = _listTypeLocalService.addListType(
			_LIST_TYPE_NAME_BILLING, ListTypeConstants.CONTACT_ADDRESS);

		_addressLocalService.addAddress(
			user.getUserId(), _portal.getClassName(classNameId), contactId,
			address, address2, StringPool.BLANK, city, zip,
			region.getRegionId(), country.getCountryId(),
			listType.getListTypeId(), false, false, serviceContext);
	}

	protected void addPhone(
			User user, String phoneNumber, String listTypeName,
			ServiceContext serviceContext)
		throws Exception {

		if (Validator.isNull(phoneNumber)) {
			return;
		}

		long contactClassNameId = _portal.getClassNameId(Contact.class);

		long contactId = getContactId(user.getUserId());

		ListType listType = _listTypeLocalService.addListType(
			listTypeName, ListTypeConstants.CONTACT_PHONE);

		_phoneLocalService.addPhone(
			user.getUserId(), _portal.getClassName(contactClassNameId),
			contactId, phoneNumber, StringPool.BLANK, listType.getListTypeId(),
			false, serviceContext);
	}

	protected User addUser(
			long companyId, String firstName, String lastName,
			String emailAddress, String username, boolean male,
			int birthdayMonth, int birthdayDay, int birthdayYear,
			String password1, String password2, String securityQuestion,
			String securityAnswer, boolean acceptedTOU,
			ServiceContext serviceContext)
		throws Exception {

		User user = _userService.addUserWithWorkflow(
			companyId, false, password1, password2, false, username,
			emailAddress, 0, StringPool.BLANK,
			LocaleUtil.fromLanguageId(StringPool.BLANK), firstName,
			StringPool.BLANK, lastName, 0, 0, male, birthdayMonth, birthdayDay,
			birthdayYear, StringPool.BLANK, null, null, null, null, false,
			serviceContext);

		_userLocalService.updateReminderQuery(
			user.getUserId(), securityQuestion, securityAnswer);

		_userLocalService.updateAgreedToTermsOfUse(
			user.getUserId(), acceptedTOU);

		return user;
	}

	protected long getContactId(long userId) {
		long userClassNameId = _portal.getClassNameId(User.class);

		List<Contact> contacts = _contactLocalService.getContacts(
			userClassNameId, userId, 0, 1, null);

		Contact contact = contacts.get(0);

		return contact.getContactId();
	}

	@Reference(unbind = "-")
	protected void setUserLocalService(UserLocalService userLocalService) {
		_userLocalService = userLocalService;
	}

	@Reference(unbind = "-")
	protected void setUserService(UserService userService) {
		_userService = userService;
	}

	protected void validateAddress(
			String address, String address2, String city, String state,
			String zip)
		throws Exception {

		validateStreetAddress(address, address2);
		validateCityAddress(city);
		validateStateAddress(state);
		validateZipAddress(zip);
	}

	protected void validateBirthday(
			int birthdayMonth, int birthdayDay, int birthdayYear)
		throws Exception {

		Date birthdayDate = new GregorianCalendar(
			birthdayYear, birthdayMonth, birthdayDay).getTime();

		int age = CalendarUtil.getAge(birthdayDate, Calendar.getInstance());

		if (age < AMFConfigurationValues.AGE_MIN) {
			throw new BirthdayException.MinAge(AMFConfigurationValues.AGE_MIN);
		}
	}

	protected void validateCityAddress(String city) throws Exception {
		if (Validator.isNull(city)) {
			throw new AddressCityException.MustNotBeNull();
		}
		else if (!Validator.isAlphanumericName(city)) {
			throw new AddressCityException.MustBeAlphanumeric();
		}
		else if (city.length() >
					AMFConfigurationValues.CITY_MAX_LENGTH) {

			throw new AddressCityException.MaxLength(
				AMFConfigurationValues.CITY_MAX_LENGTH);
		}
	}

	protected void validateEmailAddress(String emailAddress) throws Exception {
		if (Validator.isNull(emailAddress)) {
			throw new EmailAddressException.MustNotBeNull();
		}
		else if (!emailAddress.matches(_REGEX_EMAIL_ADDRESS)) {
			throw new EmailAddressException.MustBeAlphanumeric();
		}
		else if (emailAddress.length() >
					AMFConfigurationValues.EMAIL_ADDRESS_MAX_LENGTH) {

			throw new EmailAddressException.MaxLength(
				AMFConfigurationValues.EMAIL_ADDRESS_MAX_LENGTH);
		}
	}

	protected void validateFirstName(String firstName) throws Exception {
		if (Validator.isNull(firstName)) {
			throw new FirstNameException.MustNotBeNull();
		}
		else if (!Validator.isAlphanumericName(firstName)) {
			throw new FirstNameException.MustBeAlphanumeric();
		}
		else if (firstName.length() >
					AMFConfigurationValues.FIRST_NAME_MAX_LENGTH) {

			throw new FirstNameException.MaxLength(
				AMFConfigurationValues.FIRST_NAME_MAX_LENGTH);
		}
	}

	protected void validateHomePhone(String homePhone) throws Exception {
		if (Validator.isNull(homePhone)) {
			return;
		}

		if (!Validator.isDigit(homePhone)) {
			throw new HomePhoneException.MustBeNumeric();
		}
		else if (homePhone.length() !=
					AMFConfigurationValues.PHONE_LENGTH) {

			throw new HomePhoneException.MustHaveLength(
				AMFConfigurationValues.PHONE_LENGTH);
		}
	}

	protected void validateLastName(String lastName) throws Exception {
		if (Validator.isNull(lastName)) {
			throw new LastNameException.MustNotBeNull();
		}
		else if (!Validator.isAlphanumericName(lastName)) {
			throw new LastNameException.MustBeAlphanumeric();
		}
		else if (lastName.length() >
					AMFConfigurationValues.FIRST_NAME_MAX_LENGTH) {

			throw new LastNameException.MaxLength(
				AMFConfigurationValues.LAST_NAME_MAX_LENGTH);
		}
	}

	protected void validateMobilePhone(String mobilePhone) throws Exception {
		if (Validator.isNull(mobilePhone)) {
			return;
		}

		if (!Validator.isDigit(mobilePhone)) {
			throw new MobilePhoneException.MustBeNumeric();
		}
		else if (mobilePhone.length() !=
					AMFConfigurationValues.PHONE_LENGTH) {

			throw new MobilePhoneException.MustHaveLength(
				AMFConfigurationValues.PHONE_LENGTH);
		}
	}

	protected void validatePassword(String password1, String password2)
		throws Exception {

		if (Validator.isNull(password1)) {
			throw new PasswordException.MustNotBeNull();
		}

		if (password1.length() <
				AMFConfigurationValues.PASSWORD_MIN_LENGTH) {

			throw new PasswordException.MinLength(
				AMFConfigurationValues.PASSWORD_MIN_LENGTH);
		}

		if (!password1.matches(_REGEX_UPPERCASE)) {
			throw new PasswordException.MustHaveUppercase();
		}
		else if (!password1.matches(_REGEX_DIGIT)) {
			throw new PasswordException.MustHaveNumber();
		}
		else if (!password1.matches(_REGEX_SPECIAL_CHARACTER)) {
			throw new PasswordException.MustHaveSpecial();
		}
		else if (!password1.equals(password2)) {
			throw new UserPasswordException.MustMatch(0L);
		}
	}

	protected void validatePhone(String homePhone, String mobilePhone)
		throws Exception {

		validateHomePhone(homePhone);
		validateMobilePhone(mobilePhone);
	}

	protected void validateSecurityAnswer(String securityAnswer)
		throws Exception {

		if (Validator.isNull(securityAnswer)) {
			throw new SecurityAnswerException.MustNotBeNull();
		}
		else if (!Validator.isAlphanumericName(securityAnswer)) {
			throw new SecurityAnswerException.MustBeAlphanumeric();
		}
		else if (securityAnswer.length() >
					AMFConfigurationValues.SECURITY_ANSWER_MAX_LENGTH) {

			throw new SecurityAnswerException.MaxLength(
				AMFConfigurationValues.SECURITY_ANSWER_MAX_LENGTH);
		}
	}

	protected void validateSecurityQuestion(String securityQuestion)
		throws Exception {

		if (Validator.isNull(securityQuestion)) {
			throw new SecurityQuestionException.MustNotBeNull();
		}
	}

	protected void validateStateAddress(String state) throws Exception {
		Country country = _countryService.getCountryByA3(_COUNTRY_A3_USA);

		Region region = _regionService.fetchRegion(
			country.getCountryId(), state);

		if (region == null) {
			throw new AddressStateException();
		}
	}

	protected void validateStreetAddress(String address, String address2)
		throws Exception {

		if (Validator.isNull(address)) {
			throw new AddressStreetException.MustNotBeNull();
		}
		else if (!Validator.isAlphanumericName(address)) {
			throw new AddressStreetException.MustBeAlphanumeric();
		}
		else if (address.length() >
					AMFConfigurationValues.ADDRESS_MAX_LENGTH) {

			throw new AddressStreetException.MaxLength(
				AMFConfigurationValues.ADDRESS_MAX_LENGTH);
		}

		if (Validator.isNotNull(address2)) {
			if (!Validator.isAlphanumericName(address2)) {
				throw new AddressStreetException.MustBeAlphanumeric();
			}
			else if (address2.length() >
						AMFConfigurationValues.ADDRESS_MAX_LENGTH) {

				throw new AddressStreetException.MaxLength(
					AMFConfigurationValues.ADDRESS_MAX_LENGTH);
			}
		}
	}

	protected void validateTermsOfUser(boolean acceptedTOU) throws Exception {
		if (!acceptedTOU) {
			throw new TermsOfUseException();
		}
	}

	protected void validateUser(
			String firstName, String lastName, String emailAddress,
			String username, int birthdayMonth, int birthdayDay,
			int birthdayYear, String password1, String password2,
			String securityQuestion, String securityAnswer, boolean acceptedTOU)
		throws Exception {

		validateFirstName(firstName);
		validateLastName(firstName);
		validateEmailAddress(emailAddress);
		validateUsername(username);
		validateBirthday(birthdayMonth, birthdayDay, birthdayYear);
		validatePassword(password1, password2);
		validateSecurityQuestion(securityQuestion);
		validateSecurityAnswer(securityAnswer);
		validateTermsOfUser(acceptedTOU);
	}

	protected void validateUsername(String username) throws Exception {
		if (Validator.isNull(username)) {
			throw new UsernameException.MustNotBeNull();
		}
		else if (!Validator.isAlphanumericName(username)) {
			throw new UsernameException.MustBeAlphanumeric();
		}
		else if (username.length() <
					AMFConfigurationValues.USERNAME_MIN_LENGTH) {

			throw new UsernameException.MinLength(
				AMFConfigurationValues.USERNAME_MIN_LENGTH);
		}
		else if (username.length() >
					AMFConfigurationValues.USERNAME_MAX_LENGTH) {

			throw new UsernameException.MaxLength(
				AMFConfigurationValues.USERNAME_MAX_LENGTH);
		}
	}

	protected void validateZipAddress(String zip) throws Exception {
		if (Validator.isNull(zip)) {
			throw new AddressZipException.MustNotBeNull();
		}
		else if (!Validator.isDigit(zip)) {
			throw new AddressZipException.MustBeNumeric();
		}
		else if (zip.length() !=
					AMFConfigurationValues.ZIP_LENGTH) {

			throw new AddressZipException.MustHaveLength(
				AMFConfigurationValues.ZIP_LENGTH);
		}
	}

	private static final String _COUNTRY_A3_USA = "USA";

	private static final String _LIST_TYPE_NAME_BILLING = "billing";

	private static final String _LIST_TYPE_NAME_HOME = "home";

	private static final String _LIST_TYPE_NAME_MOBILE = "mobile-phone";

	private static final String _REGEX_DIGIT = ".*\\d.*";

	private static final String _REGEX_EMAIL_ADDRESS =
		"[\\w\\d\\.]*\\@[\\w\\d\\.]*";

	private static final String _REGEX_SPECIAL_CHARACTER =
		".*[\\s!\"#$%&'()*+,\\-./:;<=>?@[\\\\]^_`{|}~].*";

	private static final String _REGEX_UPPERCASE = ".*[A-Z]+.*";

	@Reference
	private AddressLocalService _addressLocalService;

	@Reference
	private ContactLocalService _contactLocalService;

	@Reference
	private CountryService _countryService;

	@Reference
	private ListTypeLocalService _listTypeLocalService;

	@Reference
	private PhoneLocalService _phoneLocalService;

	@Reference
	private Portal _portal;

	@Reference
	private RegionService _regionService;

	private UserLocalService _userLocalService;
	private UserService _userService;

}