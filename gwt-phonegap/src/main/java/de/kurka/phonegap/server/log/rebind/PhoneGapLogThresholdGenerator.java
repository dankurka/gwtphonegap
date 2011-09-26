package de.kurka.phonegap.server.log.rebind;

import java.util.List;

import com.google.gwt.core.ext.BadPropertyValueException;
import com.google.gwt.core.ext.ConfigurationProperty;
import com.google.gwt.core.ext.Generator;
import com.google.gwt.core.ext.GeneratorContext;
import com.google.gwt.core.ext.PropertyOracle;
import com.google.gwt.core.ext.TreeLogger;
import com.google.gwt.core.ext.UnableToCompleteException;

public class PhoneGapLogThresholdGenerator extends Generator {

	/**
	 * 
	 */
	private static final String BASE = "de.kurka.phonegap.client.log.PhoneGapLogThreshold";

	@Override
	public String generate(TreeLogger logger, GeneratorContext context, String typeName) throws UnableToCompleteException {

		PropertyOracle propertyOracle = context.getPropertyOracle();
		ConfigurationProperty property = null;
		String level = "INFO";
		try {
			property = propertyOracle.getConfigurationProperty("phonegap.logging.threshold");
			List<String> values = property.getValues();
			if (values.size() < 1) {
				logger.log(TreeLogger.WARN, "can not resolve phonegap.logging.threshold variable - defaulting to INFO");
			} else {
				level = values.get(0);

			}
		} catch (BadPropertyValueException e) {
			logger.log(TreeLogger.WARN, "can not resolve phonegap.logging.threshold variable - defaulting to INFO", e);
		}

		if ("INFO".equalsIgnoreCase(level)) {
			return BASE + ".Info";
		}
		if ("ALL".equalsIgnoreCase(level)) {
			return BASE + ".Info";
		}
		if ("FINEST".equalsIgnoreCase(level)) {
			return BASE + ".Finest";
		}
		if ("FINER".equalsIgnoreCase(level)) {
			return BASE + ".Finer";
		}
		if ("FINE".equalsIgnoreCase(level)) {
			return BASE + ".Fine";
		}
		if ("CONFIG".equalsIgnoreCase(level)) {
			return BASE + ".Config";
		}
		if ("WARNING".equalsIgnoreCase(level)) {
			return BASE + ".Warning";
		}
		if ("SEVERE".equalsIgnoreCase(level)) {
			return BASE + ".Severe";
		}
		if ("SEVERE".equalsIgnoreCase(level)) {
			return BASE + ".All";

		}

		logger.log(TreeLogger.WARN, "unkown value for phonegap.logging.threshold: '" + level + "' - defaulting to INFO");
		return BASE + ".Info";

	}
}
