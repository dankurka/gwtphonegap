package com.googlecode.gwtphonegap.client.contacts.browser;

import java.util.Date;

import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONBoolean;
import com.google.gwt.json.client.JSONNull;
import com.google.gwt.json.client.JSONNumber;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONString;
import com.google.gwt.json.client.JSONValue;
import com.googlecode.gwtphonegap.client.contacts.Contact;
import com.googlecode.gwtphonegap.client.contacts.ContactAddress;
import com.googlecode.gwtphonegap.client.contacts.ContactField;
import com.googlecode.gwtphonegap.client.contacts.ContactName;
import com.googlecode.gwtphonegap.client.contacts.ContactOrganisation;
import com.googlecode.gwtphonegap.collection.shared.CollectionFactory;
import com.googlecode.gwtphonegap.collection.shared.LightArray;

public class ContactBrowserImpl implements Contact {

	private static final String CONTACT_FIELD_PREF = "pref";

	private static final String CONTACT_FIELD_VALUE = "value";

	private static final String CONTACT_FIELD_TYPE = "type";

	private static final String NAME_SUFFIX = "suffix";

	private static final String NAME_PREFIX = "prefix";

	private static final String NAME_MIDDLE_NAME = "middleName";

	private static final String NAME_GIVEN_NAME = "givenName";

	private static final String NAME_FAMILY_NAME = "familyName";

	private static final String NAME_FORMATTED = "formatted";

	private static final String ADDRESS_COUNTRY = "country";

	private static final String ADDRESS_POSTAL_CODE = "postalCode";

	private static final String ADDRESS_REGION = "region";

	private static final String ADDRESS_LOCALITY = "locality";

	private static final String ADDRESS_STREET_ADDRESS = "streetAddress";

	private static final String ADDRESS_FORMATTED = "formatted";

	private static final String ORGA_TITLE = "title";

	private static final String ORGA_DEPARTMENT = "department";

	private static final String CONTACT_ORGANISATION = "organisation";

	private static final String CONTACT_ADDRESSES = "addresses";

	private static final String CONTACT_NAME = "name";

	private static final String CONTACT_URLS = "urls";

	private static final String CONTACT_CATEGORIES = "categories";

	private static final String CONTACT_PHOTOS = "photos";

	private static final String CONTACT_IMS = "ims";

	private static final String CONTACT_EMAILS = "emails";

	private static final String CONTACT_PHONE_NUMBERS = "phoneNumbers";

	private static final String CONTACT_BIRTHDAY = "birthday";

	private static final String CONTACT_TIME_ZONE = "timeZone";

	private static final String CONTACT_NOTE = "note";

	private static final String CONTACT_GENDER = "gender";

	private static final String CONTACT_REVISION = "revision";

	private static final String CONTACT_NICK_NAME = "nickName";

	private static final String CONTACT_DISPLAY_NAME = "displayName";

	private static final String FIELD_ID = "id";

	private static final String ORGA_NAME = "name";

	private final ContactsBrowserImpl contactBrowserImpl;

	private String id;
	private String displayName;
	private String nickName;
	private String revision;
	private Date birthday;
	private String gender;
	private String note;
	private String timeZone;

	private ContactName contactName;

	private LightArray<ContactField> phoneNumbers;

	private LightArray<ContactField> emails;

	private LightArray<ContactAddress> contactAddresses;

	private LightArray<ContactField> ims;

	private LightArray<ContactOrganisation> organisations;

	private LightArray<ContactField> photos;

	private LightArray<ContactField> categories;

	private LightArray<ContactField> urls;

	public ContactBrowserImpl(ContactsBrowserImpl contactBrowserImpl) {
		this.contactBrowserImpl = contactBrowserImpl;

	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String getId() {
		return id;
	}

	@Override
	public void setDisplayName(String displayName) {
		this.displayName = displayName;

	}

	@Override
	public String getDisplayName() {
		if (displayName == null || "".equals(displayName)) {
			String first = getName().getGivenName();
			String lastName = getName().getGivenName();

			String disp = "";
			if (first != null) {
				disp += first + " ";

			}
			if (lastName != null) {
				disp += lastName;
			}
		}

		return displayName;
	}

	@Override
	public void setName(ContactName contactName) {
		this.contactName = contactName;

	}

	@Override
	public ContactName getName() {
		if (contactName == null) {
			contactName = new ContactNameBrowserImpl();
		}
		return contactName;
	}

	@Override
	public void setNickName(String name) {
		this.nickName = name;

	}

	@Override
	public String getNickName() {
		return nickName;
	}

	@Override
	public LightArray<ContactField> getPhoneNumbers() {
		if (phoneNumbers == null) {
			phoneNumbers = CollectionFactory.constructArray();
		}
		return this.phoneNumbers;
	}

	@Override
	public void setPhoneNumbers(LightArray<ContactField> array) {
		this.phoneNumbers = array;

	}

	@Override
	public void setEmails(LightArray<ContactField> emails) {
		this.emails = emails;

	}

	@Override
	public LightArray<ContactField> getEmails() {
		if (emails == null) {
			emails = CollectionFactory.constructArray();
		}
		return emails;
	}

	@Override
	public void setContactAddresses(LightArray<ContactAddress> contactAddresses) {
		this.contactAddresses = contactAddresses;

	}

	@Override
	public LightArray<ContactAddress> getContactAddresses() {
		if (contactAddresses == null) {
			contactAddresses = CollectionFactory.constructArray();
		}
		return contactAddresses;
	}

	@Override
	public void setIms(LightArray<ContactField> ims) {
		this.ims = ims;

	}

	@Override
	public LightArray<ContactField> getIms() {
		if (ims == null) {
			ims = CollectionFactory.constructArray();
		}
		return ims;
	}

	@Override
	public void setOrganisations(LightArray<ContactOrganisation> organisations) {
		this.organisations = organisations;

	}

	@Override
	public LightArray<ContactOrganisation> getOrganisations() {
		if (organisations == null) {
			organisations = CollectionFactory.constructArray();
		}
		return this.organisations;
	}

	@Override
	public String getRevision() {
		return revision;
	}

	public void setRevision(String revision) {
		this.revision = revision;
	}

	@Override
	public Date getBirthDay() {
		return birthday;
	}

	@Override
	public void setBirthDay(Date birthday) {
		this.birthday = birthday;

	}

	@Override
	public void setGender(String gender) {
		this.gender = gender;

	}

	@Override
	public String getGender() {
		return gender;
	}

	@Override
	public void setNote(String note) {
		this.note = note;

	}

	@Override
	public String getNote() {
		return note;
	}

	@Override
	public void setPhotos(LightArray<ContactField> photos) {
		this.photos = photos;

	}

	@Override
	public LightArray<ContactField> getPhotos() {
		if (photos == null) {
			photos = CollectionFactory.constructArray();
		}
		return photos;
	}

	@Override
	public void setCategories(LightArray<ContactField> categories) {
		this.categories = categories;

	}

	@Override
	public LightArray<ContactField> getCategories() {
		if (categories == null) {
			categories = CollectionFactory.constructArray();
		}
		return categories;
	}

	@Override
	public void setUrls(LightArray<ContactField> urls) {
		this.urls = urls;

	}

	@Override
	public LightArray<ContactField> getUrls() {
		if (urls == null) {
			urls = CollectionFactory.constructArray();
		}
		return this.urls;
	}

	@Override
	public void setTimeZone(String zone) {
		timeZone = zone;

	}

	@Override
	public String getTimeZone() {
		return timeZone;
	}

	@Override
	public void remove() {
		contactBrowserImpl.remove(this);

	}

	@Override
	public void save() {
		contactBrowserImpl.save(this);

	}

	@Override
	public Contact cloneContact() {
		return contactBrowserImpl.cloneContact(this);
	}

	public static Contact fromJSON(ContactsBrowserImpl controller, JSONObject jsonContact) {
		ContactBrowserImpl contact = new ContactBrowserImpl(controller);

		//simple fields
		contact.setId(getFieldAsString(jsonContact.get(FIELD_ID)));
		contact.setDisplayName(getFieldAsString(jsonContact.get(CONTACT_DISPLAY_NAME)));
		contact.setNickName(getFieldAsString(jsonContact.get(CONTACT_NICK_NAME)));
		contact.setRevision(getFieldAsString(jsonContact.get(CONTACT_REVISION)));
		contact.setGender(getFieldAsString(jsonContact.get(CONTACT_GENDER)));
		contact.setNote(getFieldAsString(jsonContact.get(CONTACT_NOTE)));
		contact.setTimeZone(getFieldAsString(jsonContact.get(CONTACT_TIME_ZONE)));

		//birthday
		JSONValue dateValue = jsonContact.get(CONTACT_BIRTHDAY);
		if (dateValue != null && dateValue.isNumber() != null) {
			contact.setBirthDay(new Date((long) dateValue.isNumber().doubleValue()));
		}

		//contact fields
		JSONArray phoneNumberArray = jsonContact.get(CONTACT_PHONE_NUMBERS).isArray();
		LightArray<ContactField> phoneNumbers = getContactFieldsForArray(phoneNumberArray);
		contact.setPhoneNumbers(phoneNumbers);

		JSONArray emailsArray = jsonContact.get(CONTACT_EMAILS).isArray();
		LightArray<ContactField> emails = getContactFieldsForArray(emailsArray);
		contact.setEmails(emails);

		JSONArray imsArray = jsonContact.get(CONTACT_IMS).isArray();
		LightArray<ContactField> ims = getContactFieldsForArray(imsArray);
		contact.setIms(ims);

		JSONArray photosArray = jsonContact.get(CONTACT_PHOTOS).isArray();
		LightArray<ContactField> photos = getContactFieldsForArray(photosArray);
		contact.setPhotos(photos);

		JSONArray categoriesArray = jsonContact.get(CONTACT_CATEGORIES).isArray();
		LightArray<ContactField> categories = getContactFieldsForArray(categoriesArray);
		contact.setCategories(categories);

		JSONArray urlsArray = jsonContact.get(CONTACT_URLS).isArray();
		LightArray<ContactField> urls = getContactFieldsForArray(urlsArray);
		contact.setUrls(urls);

		ContactName name = getName(jsonContact.get(CONTACT_NAME).isObject());
		contact.setName(name);

		LightArray<ContactAddress> addresses = getAddressArray(jsonContact.get(CONTACT_ADDRESSES).isArray());
		contact.setContactAddresses(addresses);

		LightArray<ContactOrganisation> organisations = getContactOrganisationArray(jsonContact.get(CONTACT_ORGANISATION).isArray());
		contact.setOrganisations(organisations);

		return contact;
	}

	private static LightArray<ContactOrganisation> getContactOrganisationArray(JSONArray jsonArray) {
		LightArray<ContactOrganisation> array = CollectionFactory.constructArray();

		if (jsonArray == null) {
			return array;
		}

		for (int i = 0; i < jsonArray.size(); i++) {
			array.push(getOrganisation(jsonArray.get(i).isObject()));
		}

		return array;
	}

	private static ContactOrganisation getOrganisation(JSONObject object) {
		ContactOrganisationBrowserImpl co = new ContactOrganisationBrowserImpl();
		if (object == null) {
			return co;
		}

		String name = getFieldAsString(object.get(CONTACT_NAME));
		String department = getFieldAsString(object.get(ORGA_DEPARTMENT));
		String title = getFieldAsString(object.get(ORGA_TITLE));

		co.setDepartment(department);
		co.setName(name);
		co.setTitle(title);

		return co;
	}

	private static LightArray<ContactAddress> getAddressArray(JSONArray jsonArray) {
		LightArray<ContactAddress> array = CollectionFactory.constructArray();

		if (jsonArray == null) {
			return array;
		}

		for (int i = 0; i < jsonArray.size(); i++) {
			array.push(getAddress(jsonArray.get(i).isObject()));
		}

		return array;
	}

	private static ContactAddress getAddress(JSONObject object) {
		ContactAddressBrowserImpl ca = new ContactAddressBrowserImpl();
		if (object == null) {
			return ca;
		}

		String formatted = getFieldAsString(object.get(ADDRESS_FORMATTED));
		String streedAddress = getFieldAsString(object.get(ADDRESS_STREET_ADDRESS));
		String locality = getFieldAsString(object.get(ADDRESS_LOCALITY));
		String region = getFieldAsString(object.get(ADDRESS_REGION));
		String postalCode = getFieldAsString(object.get(ADDRESS_POSTAL_CODE));
		String country = getFieldAsString(object.get(ADDRESS_COUNTRY));

		ca.setFormatted(formatted);
		ca.setStreetAddress(streedAddress);
		ca.setLocality(locality);
		ca.setRegion(region);
		ca.setPostalCode(postalCode);
		ca.setCountry(country);

		return ca;
	}

	private static ContactName getName(JSONObject object) {
		ContactNameBrowserImpl name = new ContactNameBrowserImpl();
		if (object == null) {
			return name;
		}

		String formatted = getFieldAsString(object.get(NAME_FORMATTED));
		String familyName = getFieldAsString(object.get(NAME_FAMILY_NAME));
		String givenName = getFieldAsString(object.get(NAME_GIVEN_NAME));
		String middleName = getFieldAsString(object.get(NAME_MIDDLE_NAME));
		String prefix = getFieldAsString(object.get(NAME_PREFIX));
		String suffix = getFieldAsString(object.get(NAME_SUFFIX));

		name.setFormatted(formatted);
		name.setFamilyName(familyName);
		name.setGivenName(givenName);
		name.setMiddleName(middleName);
		name.setHonoricfPrefix(prefix);
		name.setHonoricfSuffix(suffix);

		return name;
	}

	private static LightArray<ContactField> getContactFieldsForArray(JSONArray jsonArray) {
		LightArray<ContactField> array = CollectionFactory.constructArray();
		if (jsonArray == null) {
			return array;
		}

		for (int i = 0; i < jsonArray.size(); i++) {
			ContactFieldBrowserImpl cf = new ContactFieldBrowserImpl();
			JSONObject object = jsonArray.get(i).isObject();

			String type = getFieldAsString(object.get(CONTACT_FIELD_TYPE));
			String value = getFieldAsString(object.get(CONTACT_FIELD_VALUE));
			boolean pref = getFieldAsBoolean(object.get(CONTACT_FIELD_PREF));
			cf.setPref(pref);
			cf.setType(type);
			cf.setValue(value);
			array.push(cf);
		}

		return array;
	}

	private static boolean getFieldAsBoolean(JSONValue field) {
		return field.isBoolean() != null ? field.isBoolean().booleanValue() : false;
	}

	private static String getFieldAsString(JSONValue field) {
		return (field != null && field.isString() != null) ? field.isString().stringValue() : "";
	}

	public JSONObject serializeContact() {
		JSONObject root = new JSONObject();

		//simple values
		root.put(FIELD_ID, getAsJSONString(this.getId()));
		root.put(CONTACT_DISPLAY_NAME, getAsJSONString(this.getDisplayName()));
		root.put(CONTACT_NICK_NAME, getAsJSONString(this.getNickName()));
		root.put(CONTACT_REVISION, getAsJSONString(this.getRevision()));
		root.put(CONTACT_GENDER, getAsJSONString(this.getGender()));
		root.put(CONTACT_TIME_ZONE, getAsJSONString(this.getTimeZone()));

		if (this.getBirthDay() != null) {
			double value = this.getBirthDay().getTime();
			root.put(CONTACT_BIRTHDAY, new JSONNumber(value));
		}

		root.put(CONTACT_PHONE_NUMBERS, toJSONArray(this.getPhoneNumbers()));

		root.put(CONTACT_EMAILS, toJSONArray(this.getEmails()));
		root.put(CONTACT_IMS, toJSONArray(this.getIms()));
		root.put(CONTACT_PHOTOS, toJSONArray(this.getPhotos()));
		root.put(CONTACT_CATEGORIES, toJSONArray(this.getCategories()));
		root.put(CONTACT_URLS, toJSONArray(this.getUrls()));

		root.put(CONTACT_NAME, createContact(this.getName()));

		root.put(CONTACT_ADDRESSES, createAddresses(this.getContactAddresses()));

		root.put(CONTACT_ORGANISATION, createOrganisation(this.getOrganisations()));

		return root;
	}

	private JSONArray createOrganisation(LightArray<ContactOrganisation> organisations) {
		JSONArray jsonArray = new JSONArray();

		for (int i = 0; i < organisations.length(); i++) {
			ContactOrganisation co = organisations.get(i);
			JSONObject orga = new JSONObject();

			orga.put(ORGA_NAME, getAsJSONString(co.getName()));
			orga.put(ORGA_DEPARTMENT, getAsJSONString(co.getDepartment()));
			orga.put(ORGA_TITLE, getAsJSONString(co.getTitle()));

			jsonArray.set(i, orga);
		}

		return jsonArray;
	}

	private JSONArray createAddresses(LightArray<ContactAddress> addresses) {
		JSONArray jsonArray = new JSONArray();

		for (int i = 0; i < addresses.length(); i++) {
			ContactAddress contactAddress = addresses.get(i);
			JSONObject address = new JSONObject();
			address.put(ADDRESS_FORMATTED, getAsJSONString(contactAddress.getFormatted()));
			address.put(ADDRESS_STREET_ADDRESS, getAsJSONString(contactAddress.getStreetAddress()));
			address.put(ADDRESS_LOCALITY, getAsJSONString(contactAddress.getLocality()));
			address.put(ADDRESS_REGION, getAsJSONString(contactAddress.getRegion()));
			address.put(ADDRESS_POSTAL_CODE, getAsJSONString(contactAddress.getPostalCode()));
			address.put(ADDRESS_COUNTRY, getAsJSONString(contactAddress.getCountry()));
			jsonArray.set(i, address);
		}

		return jsonArray;
	}

	private JSONObject createContact(ContactName contactName) {
		JSONObject jsonName = new JSONObject();

		jsonName.put(NAME_FORMATTED, getAsJSONString(contactName.getFormatted()));
		jsonName.put(NAME_FAMILY_NAME, getAsJSONString(contactName.getFamilyName()));
		jsonName.put(NAME_GIVEN_NAME, getAsJSONString(contactName.getGivenName()));
		jsonName.put(NAME_MIDDLE_NAME, getAsJSONString(contactName.getMiddleName()));
		jsonName.put(NAME_PREFIX, getAsJSONString(contactName.getHonoricPrefix()));
		jsonName.put(NAME_SUFFIX, getAsJSONString(contactName.getHonoricSuffix()));

		return jsonName;
	}

	private JSONValue toJSONArray(LightArray<ContactField> contactField) {
		JSONArray jsonArray = new JSONArray();
		for (int i = 0; i < contactField.length(); i++) {
			ContactField field = contactField.get(i);
			JSONObject jsonField = new JSONObject();
			jsonField.put(CONTACT_FIELD_TYPE, getAsJSONString(field.getType()));
			jsonField.put(CONTACT_FIELD_VALUE, getAsJSONString(field.getValue()));

			jsonField.put(CONTACT_FIELD_PREF, JSONBoolean.getInstance(field.isPref()));
			jsonArray.set(i, jsonField);
		}

		return jsonArray;
	}

	private static JSONValue getAsJSONString(String id) {
		if (id == null) {
			return JSONNull.getInstance();
		}

		return new JSONString(id);
	}

}
