package com.googlecode.objectify.impl.translate;

import com.google.cloud.Timestamp;
import com.google.cloud.datastore.TimestampValue;
import com.google.cloud.datastore.Value;
import com.google.cloud.datastore.ValueType;
import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

/**
 * Converts JSR-310 OffsetDateTime into a java.util.Date.
 *
 * <p>All custom translators must be registered *before* entity classes are registered.
 */
public class OffsetDateTimeTranslatorFactory
        extends SimpleTranslatorFactory<OffsetDateTime, Timestamp> {
    public OffsetDateTimeTranslatorFactory() {
        super(OffsetDateTime.class, ValueType.TIMESTAMP);
    }

    @Override
    protected OffsetDateTime toPojo(Value<Timestamp> value) {
        return Instant.ofEpochSecond(value.get().getSeconds())
                .plusNanos(value.get().getNanos())
                .atZone(ZoneOffset.UTC)
                .toOffsetDateTime();
    }

    @Override
    protected Value<Timestamp> toDatastore(OffsetDateTime value) {
        return TimestampValue.of(
                Timestamp.ofTimeSecondsAndNanos(value.toEpochSecond(), value.getNano()));
    }
}
