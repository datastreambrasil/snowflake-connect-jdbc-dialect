package br.com.datastreambrasil.connect.dialect.snowflake;

import io.debezium.connector.jdbc.ValueBindDescriptor;
import java.time.LocalDateTime;
import java.util.List;
import net.snowflake.client.jdbc.SnowflakeUtil;
import org.apache.kafka.connect.data.Schema;
import org.apache.kafka.connect.errors.ConnectException;

public class TimestampType extends io.debezium.connector.jdbc.type.debezium.TimestampType {

    public static final TimestampType INSTANCE = new TimestampType();

    @Override
    public List<ValueBindDescriptor> bind(int index, Schema schema, Object value) {

        if (value == null) {
            return List.of(new ValueBindDescriptor(index, null));
        }
        if (value instanceof Number) {

            final LocalDateTime localDateTime = getLocalDateTime(((Number) value).longValue());

            if (getDialect().isTimeZoneSet()) {
                return List.of(new ValueBindDescriptor(index,
                        localDateTime.atZone(getDatabaseTimeZone().toZoneId()).toLocalDateTime(),
                        SnowflakeUtil.EXTRA_TYPES_TIMESTAMP_NTZ));
            }

            return List.of(new ValueBindDescriptor(index, localDateTime, SnowflakeUtil.EXTRA_TYPES_TIMESTAMP_NTZ));
        }

        throw new ConnectException(String.format("Unexpected %s value '%s' with type '%s'", getClass().getSimpleName(),
                value, value.getClass().getName()));
    }
}
