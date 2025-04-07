package com.googlecode.objectify.impl.translate;

import com.google.cloud.datastore.StringValue;
import com.google.cloud.datastore.Value;
import com.google.cloud.datastore.ValueType;
import java.time.LocalDateTime;

/**
 * Converts JSR-310 LocalDateTime into a String.
 *
 * <p>All custom translators must be registered *before* entity classes are registered.
 */
public class LocalDateTimeTranslatorFactory extends SimpleTranslatorFactory<LocalDateTime, String> {
    public LocalDateTimeTranslatorFactory() {
        super(LocalDateTime.class, ValueType.STRING);
    }

    @Override
    protected LocalDateTime toPojo(Value<String> value) {
        return LocalDateTime.parse(value.get());
    }

    @Override
    protected Value<String> toDatastore(LocalDateTime value) {
        return StringValue.of(value.toString());
    }
}
