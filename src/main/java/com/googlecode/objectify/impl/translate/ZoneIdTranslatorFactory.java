package com.googlecode.objectify.impl.translate;

import com.google.cloud.datastore.StringValue;
import com.google.cloud.datastore.Value;
import com.google.cloud.datastore.ValueType;
import java.time.ZoneId;

/**
 * Converts JSR-310 ZoneId into a java.lang.String.
 *
 * <p>All custom translators must be registered *before* entity classes are registered.
 */
public class ZoneIdTranslatorFactory extends SimpleTranslatorFactory<ZoneId, String> {
    public ZoneIdTranslatorFactory() {
        super(ZoneId.class, ValueType.STRING);
    }

    @Override
    protected ZoneId toPojo(Value<String> value) {
        return ZoneId.of(value.get());
    }

    @Override
    protected Value<String> toDatastore(ZoneId value) {
        return StringValue.of(value.getId());
    }
}
