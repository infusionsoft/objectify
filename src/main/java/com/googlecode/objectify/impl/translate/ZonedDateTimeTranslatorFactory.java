package com.googlecode.objectify.impl.translate;

import com.google.cloud.Timestamp;
import com.google.cloud.datastore.TimestampValue;
import com.google.cloud.datastore.Value;
import com.google.cloud.datastore.ValueType;
import java.time.Instant;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;

/**
 * Converts JSR-310 ZonedDateTime into a java.util.Date.
 *
 * <p>All custom translators must be registered *before* entity classes are registered.
 */
public class ZonedDateTimeTranslatorFactory
        extends SimpleTranslatorFactory<ZonedDateTime, Timestamp> {
    public ZonedDateTimeTranslatorFactory() {
        super(ZonedDateTime.class, ValueType.TIMESTAMP);
    }

    @Override
    protected ZonedDateTime toPojo(Value<Timestamp> value) {
        return Instant.ofEpochSecond(value.get().getSeconds())
                .plusNanos(value.get().getNanos())
                .atZone(ZoneOffset.UTC);
    }

    @Override
    protected Value<Timestamp> toDatastore(ZonedDateTime value) {
        return TimestampValue.of(
                Timestamp.ofTimeSecondsAndNanos(value.toEpochSecond(), value.getNano()));
    }
}
