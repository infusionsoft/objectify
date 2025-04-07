package com.googlecode.objectify.impl.translate;

import com.google.cloud.datastore.StringValue;
import com.google.cloud.datastore.Value;
import com.google.cloud.datastore.ValueType;
import java.math.BigDecimal;

/**
 * Converts java.math.BigDecimal into a java.lang.String.
 *
 * <p>All custom translators must be registered *before* entity classes are registered.
 */
public class BigDecimalTranslatorFactory extends SimpleTranslatorFactory<BigDecimal, String> {
    public BigDecimalTranslatorFactory() {
        super(BigDecimal.class, ValueType.STRING);
    }

    @Override
    protected BigDecimal toPojo(Value<String> value) {
        return new BigDecimal(value.get());
    }

    @Override
    protected Value<String> toDatastore(BigDecimal value) {
        return StringValue.of(value.toString());
    }
}
