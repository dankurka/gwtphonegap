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
		contact.setId(getFieldAsString(jsonContact.get("id")));
		contact.setDisplayName(getFieldAsString(jsonContact.get("displayName")));
		contact.setNickName(getFieldAsString(jsonContact.get("nickName")));
		contact.setRevision(getFieldAsString(jsonContact.get("revision")));
		contact.setGender(getFieldAsString(jsonContact.get("gender")));
		contact.setNote(getFieldAsString(jsonContact.get("note")));
		contact.setTimeZone(getFieldAsString(jsonContact.get("timeZone")));

		//birthday
		JSONValue dateValue = jsonContact.get("birthday");
		if (dateValue != null && dateValue.isNumber() != null) {
			contact.setBirthDay(new Date((long) dateValue.isNumber().doubleValue()));
		}

		//contact fields
		JSONArray phoneNumberArray = jsonContact.get("phoneNumbers").isArray();
		LightArray<ContactField> phoneNumbers = getContactFieldsForArray(phoneNumberArray);
		contact.setPhoneNumbers(phoneNumbers);

		JSONArray emailsArray = jsonContact.get("emails").isArray();
		LightArray<ContactField> emails = getContactFieldsForArray(emailsArray);
		contact.setEmails(emails);

		JSONArray imsArray = jsonContact.get("ims").isArray();
		LightArray<ContactField> ims = getContactFieldsForArray(imsArray);
		contact.setIms(ims);

		JSONArray photosArray = jsonContact.get("photos").isArray();
		LightArray<ContactField> photos = getContactFieldsForArray(photosArray);
		contact.setPhotos(photos);

		JSONArray categoriesArray = jsonContact.get("categories").isArray();
		LightArray<ContactField> categories = getContactFieldsForArray(categoriesArray);
		contact.setCategories(categories);

		JSONArray urlsArray = jsonContact.get("urls").isArray();
		LightArray<ContactField> urls = getContactFieldsForArray(urlsArray);
		contact.setUrls(urls);

		ContactName name = getName(jsonContact.get("name").isObject());
		contact.setName(name);

		LightArray<ContactAddress> addresses = getAddressArray(jsonContact.get("addresses").isArray());
		contact.setContactAddresses(addresses);

		LightArray<ContactOrganisation> organisations = getContactOrganisationArray(jsonContact.get("organisation").isArray());
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

		String name = getFieldAsString(object.get("name"));
		String department = getFieldAsString(object.get("department"));
		String title = getFieldAsString(object.get("title"));

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

		String formatted = getFieldAsString(object.get("formatted"));
		String streedAddress = getFieldAsString(object.get("streetAddress"));
		String locality = getFieldAsString(object.get("locality"));
		String region = getFieldAsString(object.get("region"));
		String postalCode = getFieldAsString(object.get("postalCode"));
		String country = getFieldAsString(object.get("country"));

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

		String formatted = getFieldAsString(object.get("formatted"));
		String familyName = getFieldAsString(object.get("familyName"));
		String givenName = getFieldAsString(object.get("givenName"));
		String middleName = getFieldAsString(object.get("middleName"));
		String prefix = getFieldAsString(object.get("prefix"));
		String suffix = getFieldAsString(object.get("suffix"));

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

			String type = getFieldAsString(object.get("type"));
			String value = getFieldAsString(object.get("value"));
			boolean pref = getFieldAsBoolean(object.get("pref"));
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
		root.put("id", getAsJSONString(this.getId()));
		root.put("displayName", getAsJSONString(this.getDisplayName()));
		root.put("nickName", getAsJSONString(this.getNickName()));
		root.put("revision", getAsJSONString(this.getRevision()));
		root.put("gender", getAsJSONString(this.getGender()));
		root.put("timezone", getAsJSONString(this.getTimeZone()));

		if (this.getBirthDay() != null) {
			double value = this.getBirthDay().getTime();
			root.put("birthday", new JSONNumber(value));
		}

		root.put("phoneNumbers", toJSONArray(this.getPhoneNumbers()));

		root.put("emails", toJSONArray(this.getEmails()));
		root.put("ims", toJSONArray(this.getIms()));
		root.put("photos", toJSONArray(this.getPhotos()));
		root.put("categories", toJSONArray(this.getCategories()));
		root.put("urls", toJSONArray(this.getUrls()));

		root.put("name", createContact(this.getName()));

		root.put("addresses", createAddresses(this.getContactAddresses()));

		root.put("organisation", createOrganisation(this.getOrganisations()));

		return root;
	}

	private JSONArray createOrganisation(LightArray<ContactOrganisation> organisations) {
		JSONArray jsonArray = new JSONArray();

		for (int i = 0; i < organisations.length(); i++) {
			ContactOrganisation co = organisations.get(i);
			JSONObject orga = new JSONObject();

			orga.put("name", getAsJSONString(co.getName()));
			orga.put("department", getAsJSONString(co.getDepartment()));
			orga.put("title", getAsJSONString(co.getTitle()));

			jsonArray.set(i, orga);
		}

		return jsonArray;
	}

	private JSONArray createAddresses(LightArray<ContactAddress> addresses) {
		JSONArray jsonArray = new JSONArray();

		for (int i = 0; i < addresses.length(); i++) {
			ContactAddress contactAddress = addresses.get(i);
			JSONObject address = new JSONObject();
			address.put("formatted", getAsJSONString(contactAddress.getFormatted()));
			address.put("streetAddress", getAsJSONString(contactAddress.getStreetAddress()));
			address.put("locality", getAsJSONString(contactAddress.getLocality()));
			address.put("region", getAsJSONString(contactAddress.getRegion()));
			address.put("postalCode", getAsJSONString(contactAddress.getPostalCode()));
			address.put("country", getAsJSONString(contactAddress.getCountry()));
			jsonArray.set(i, address);
		}

		return jsonArray;
	}

	private JSONObject createContact(ContactName contactName) {
		JSONObject jsonName = new JSONObject();

		jsonName.put("formatted", getAsJSONString(contactName.getFormatted()));
		jsonName.put("familyName", getAsJSONString(contactName.getFamilyName()));
		jsonName.put("givenName", getAsJSONString(contactName.getGivenName()));
		jsonName.put("middleName", getAsJSONString(contactName.getMiddleName()));
		jsonName.put("prefix", getAsJSONString(contactName.getHonoricPrefix()));
		jsonName.put("suffix", getAsJSONString(contactName.getHonoricSuffix()));

		return jsonName;
	}

	private JSONValue toJSONArray(LightArray<ContactField> contactField) {
		JSONArray jsonArray = new JSONArray();
		for (int i = 0; i < contactField.length(); i++) {
			ContactField field = contactField.get(i);
			JSONObject jsonField = new JSONObject();
			jsonField.put("type", getAsJSONString(field.getType()));
			jsonField.put("value", getAsJSONString(field.getValue()));

			jsonField.put("pref", JSONBoolean.getInstance(field.isPref()));
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
