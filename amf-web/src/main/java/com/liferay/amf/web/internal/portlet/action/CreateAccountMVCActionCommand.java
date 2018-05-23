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

package com.liferay.amf.web.internal.portlet.action;

import com.liferay.amf.AMFRegistrationService;
import com.liferay.amf.web.constants.AMFPortletKeys;
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
import com.liferay.portal.kernel.exception.CompanyMaxUsersException;
import com.liferay.portal.kernel.exception.ContactBirthdayException;
import com.liferay.portal.kernel.exception.ContactNameException;
import com.liferay.portal.kernel.exception.DuplicateOpenIdException;
import com.liferay.portal.kernel.exception.GroupFriendlyURLException;
import com.liferay.portal.kernel.exception.NoSuchCountryException;
import com.liferay.portal.kernel.exception.NoSuchListTypeException;
import com.liferay.portal.kernel.exception.NoSuchOrganizationException;
import com.liferay.portal.kernel.exception.NoSuchRegionException;
import com.liferay.portal.kernel.exception.OrganizationParentException;
import com.liferay.portal.kernel.exception.PhoneNumberException;
import com.liferay.portal.kernel.exception.RequiredFieldException;
import com.liferay.portal.kernel.exception.RequiredUserException;
import com.liferay.portal.kernel.exception.TermsOfUseException;
import com.liferay.portal.kernel.exception.UserEmailAddressException;
import com.liferay.portal.kernel.exception.UserIdException;
import com.liferay.portal.kernel.exception.UserPasswordException;
import com.liferay.portal.kernel.exception.UserScreenNameException;
import com.liferay.portal.kernel.exception.UserSmsException;
import com.liferay.portal.kernel.exception.WebsiteURLException;
import com.liferay.portal.kernel.model.Address;
import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.kernel.model.Contact;
import com.liferay.portal.kernel.model.Country;
import com.liferay.portal.kernel.model.ListType;
import com.liferay.portal.kernel.model.ListTypeConstants;
import com.liferay.portal.kernel.model.Phone;
import com.liferay.portal.kernel.model.Region;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.security.auth.session.AuthenticatedSessionManager;
import com.liferay.portal.kernel.service.AddressLocalService;
import com.liferay.portal.kernel.service.ContactLocalService;
import com.liferay.portal.kernel.service.CountryService;
import com.liferay.portal.kernel.service.ListTypeLocalService;
import com.liferay.portal.kernel.service.PhoneLocalService;
import com.liferay.portal.kernel.service.RegionService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.service.UserService;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.CalendarUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Calvin Keum
*/
@Component(
	immediate = true,
	property = {
		"javax.portlet.name=" + AMFPortletKeys.AMF_REGISTRATION,
		"mvc.command.name=/create_account"
	},
	service = MVCActionCommand.class
)
public class CreateAccountMVCActionCommand extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		ServiceContext serviceContext = ServiceContextFactory.getInstance(
			actionRequest);

		try {
			ThemeDisplay themeDisplay = 
				(ThemeDisplay)actionRequest.getAttribute(WebKeys.THEME_DISPLAY);

			String username = ParamUtil.getString(actionRequest, "username");
			String emailAddress = ParamUtil.getString(
				actionRequest, "email_address");
			String firstName = ParamUtil.getString(actionRequest, "first_name");
			String lastName = ParamUtil.getString(actionRequest, "last_name");
			boolean male = ParamUtil.getBoolean(actionRequest, "male", true);
			int birthdayMonth = ParamUtil.getInteger(actionRequest, "b_month");
			int birthdayDay = ParamUtil.getInteger(actionRequest, "b_day");
			int birthdayYear = ParamUtil.getInteger(actionRequest, "b_year");
			String password1 = ParamUtil.getString(actionRequest, "password1");
			String password2 = ParamUtil.getString(actionRequest, "password2");
			String securityQuestion = ParamUtil.getString(
				actionRequest, "security_question");
			String securityAnswer = ParamUtil.getString(
				actionRequest, "security_answer");
			boolean acceptedTOU = ParamUtil.getBoolean(
				actionRequest, "accepted_tou", false);
			String homePhone = ParamUtil.getString(actionRequest, "home_phone");
			String mobilePhone = ParamUtil.getString(
				actionRequest, "mobile_phone");
			String address = ParamUtil.getString(actionRequest, "address");
			String address2 = ParamUtil.getString(actionRequest, "address2");
			String city = ParamUtil.getString(actionRequest, "city");
			String state = ParamUtil.getString(actionRequest, "state");
			String zip = ParamUtil.getString(actionRequest, "zip");

			ServiceContext userServiceContext =
				ServiceContextFactory.getInstance(
					User.class.getName(), actionRequest);

			ServiceContext phoneServiceContext =
				ServiceContextFactory.getInstance(
					Phone.class.getName(), actionRequest);

			ServiceContext addressServiceContext =
				ServiceContextFactory.getInstance(
					Address.class.getName(), actionRequest);

			_amfRegistrationService.createAccount(
				themeDisplay, username, emailAddress, firstName, lastName, male,
				birthdayMonth, birthdayDay, birthdayYear, password1, password2,
				securityQuestion, securityAnswer, acceptedTOU, homePhone,
				mobilePhone, address, address2, city, state, zip,
				userServiceContext, phoneServiceContext, addressServiceContext);

			HttpServletRequest request = _portal.getHttpServletRequest(
				actionRequest);

			SessionMessages.add(request, "accountCreated");

			hideDefaultSuccessMessage(actionRequest);
		}
		catch (Exception e) {
			if (e instanceof AddressCityException ||
				e instanceof AddressStateException ||
				e instanceof AddressStreetException ||
				e instanceof AddressZipException ||
				e instanceof BirthdayException ||
				e instanceof CompanyMaxUsersException ||
				e instanceof ContactBirthdayException ||
				e instanceof ContactNameException ||
				e instanceof DuplicateOpenIdException ||
				e instanceof EmailAddressException ||
				e instanceof EmailAddressException ||
				e instanceof FirstNameException ||
				e instanceof GroupFriendlyURLException ||
				e instanceof HomePhoneException ||
				e instanceof LastNameException ||
				e instanceof MobilePhoneException ||
				e instanceof NoSuchCountryException ||
				e instanceof NoSuchListTypeException ||
				e instanceof NoSuchOrganizationException ||
				e instanceof NoSuchRegionException ||
				e instanceof OrganizationParentException ||
				e instanceof PasswordException ||
				e instanceof PhoneNumberException ||
				e instanceof RequiredFieldException ||
				e instanceof RequiredUserException ||
				e instanceof SecurityAnswerException ||
				e instanceof SecurityQuestionException ||
				e instanceof TermsOfUseException ||
				e instanceof UserEmailAddressException ||
				e instanceof UserIdException ||
				e instanceof UsernameException ||
				e instanceof UserPasswordException ||
				e instanceof UserScreenNameException ||
				e instanceof UserSmsException ||
				e instanceof WebsiteURLException) {

				SessionErrors.add(actionRequest, e.getClass(), e);
			}
			else {
				throw e;
			}
		}

		sendRedirect(actionRequest, actionResponse);
	}

	@Reference
	private AMFRegistrationService _amfRegistrationService;

	@Reference
	private Portal _portal;

}