package com.googlecode.objectify.impl.translate;

import com.google.cloud.Timestamp;
import com.google.cloud.datastore.TimestampValue;
import com.google.cloud.datastore.Value;
import com.google.cloud.datastore.ValueType;
import java.time.Instant;

/**
 * Converts JSR-310 Instant into a java.util.Date.
 *
 * <p>All custom translators must be registered *before* entity classes are registered.
 */
public class InstantTimeTranslatorFactory extends SimpleTranslatorFactory<Instant, Timestamp> {
    public InstantTimeTranslatorFactory() {
        super(Instant.class, ValueType.TIMESTAMP);
    }

    @Override
    protected Instant toPojo(Value<Timestamp> value) {
        return Instant.ofEpochSecond(value.get().getSeconds()).plusNanos(value.get().getNanos());
    }

    @Override
    protected Value<Timestamp> toDatastore(Instant value) {
        return TimestampValue.of(
                Timestamp.ofTimeSecondsAndNanos(value.getEpochSecond(), value.getNano()));
    }
}
