package com.googlecode.objectify.impl.translate;

import com.google.cloud.datastore.StringValue;
import com.google.cloud.datastore.Value;
import com.google.cloud.datastore.ValueType;
import java.time.LocalDate;

/**
 * Converts JSR-310 LocalDate into a String.
 *
 * <p>All custom translators must be registered *before* entity classes are registered.
 */
public class LocalDateTranslatorFactory extends SimpleTranslatorFactory<LocalDate, String> {
    public LocalDateTranslatorFactory() {
        super(LocalDate.class, ValueType.STRING);
    }

    @Override
    protected LocalDate toPojo(Value<String> value) {
        return LocalDate.parse(value.get());
    }

    @Override
    protected Value<String> toDatastore(LocalDate value) {
        return StringValue.of(value.toString());
    }
}
