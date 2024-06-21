package com.googlecode.objectify.impl.translate;

import com.google.cloud.datastore.StringValue;
import com.google.cloud.datastore.Value;
import com.google.cloud.datastore.ValueType;
import java.util.Locale;

/**
 * Converts java.util.Locale into a java.lang.String.
 *
 * <p>All custom translators must be registered *before* entity classes are registered.
 */
public class LocaleTranslatorFactory extends SimpleTranslatorFactory<Locale, String> {
    public LocaleTranslatorFactory() {
        super(Locale.class, ValueType.STRING);
    }

    @Override
    protected Locale toPojo(Value<String> value) {
        return Locale.forLanguageTag(value.get());
    }

    @Override
    protected Value<String> toDatastore(Locale value) {
        return StringValue.of(value.toLanguageTag());
    }
}
