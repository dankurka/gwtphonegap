package com.googlecode.gwtphonegap.server.log.rebind;

import java.io.PrintWriter;
import java.util.List;

import com.google.gwt.core.ext.BadPropertyValueException;
import com.google.gwt.core.ext.ConfigurationProperty;
import com.google.gwt.core.ext.Generator;
import com.google.gwt.core.ext.GeneratorContext;
import com.google.gwt.core.ext.PropertyOracle;
import com.google.gwt.core.ext.TreeLogger;
import com.google.gwt.core.ext.UnableToCompleteException;
import com.google.gwt.core.ext.typeinfo.JClassType;
import com.google.gwt.core.ext.typeinfo.NotFoundException;
import com.google.gwt.user.rebind.ClassSourceFileComposerFactory;
import com.google.gwt.user.rebind.SourceWriter;

public class PhoneGapLogValueGenerator extends Generator {

	@Override
	public String generate(TreeLogger logger, GeneratorContext context, String typeName) throws UnableToCompleteException {

		PropertyOracle propertyOracle = context.getPropertyOracle();
		ConfigurationProperty property = null;
		int value = 100;
		try {
			property = propertyOracle.getConfigurationProperty("phonegap.logging.maxentries");
			List<String> values = property.getValues();
			if (values.size() < 1) {
				logger.log(TreeLogger.WARN, "can not resolve phonegap.logging.maxentries variable - defaulting to 100");
			} else {
				String stringValue = values.get(0);
				try {
					value = Integer.parseInt(stringValue);
				} catch (Exception e) {
					logger.log(TreeLogger.WARN, "can not prase phonegap.logging.maxentries variable - value: '" + stringValue + "' - defaulting to 100");
				}

			}
		} catch (BadPropertyValueException e) {
			logger.log(TreeLogger.WARN, "can not resolve phonegap.logging.maxentries variable - defaulting to 100", e);
		}

		JClassType classType = null;

		try {
			classType = context.getTypeOracle().getType(typeName);
		} catch (NotFoundException e) {
			logger.log(TreeLogger.ERROR, "can not find type: '" + typeName + "'", e);
			throw new UnableToCompleteException();
		}

		String packageName = classType.getPackage().getName();
		String simpleName = classType.getSimpleSourceName() + "_" + value;
		String fullName = packageName + "." + simpleName;

		ClassSourceFileComposerFactory composer = new ClassSourceFileComposerFactory(packageName, simpleName);
		composer.addImplementedInterface(typeName);
		composer.addImport(typeName);

		PrintWriter printWriter = context.tryCreate(logger, packageName, simpleName);

		if (printWriter == null) {
			return fullName;
		}

		SourceWriter writer = composer.createSourceWriter(context, printWriter);

		writer.println("public int getMaxEntries() {");
		writer.println("return " + value + ";");
		writer.println("}");

		writer.commit(logger);

		return fullName;

	}
}
