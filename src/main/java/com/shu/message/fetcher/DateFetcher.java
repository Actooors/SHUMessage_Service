package com.shu.message.fetcher;

import graphql.language.IntValue;
import graphql.language.StringValue;
import graphql.schema.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * @program: message
 * @description: graphql自己重写的日期函数
 * @author: 0GGmr0
 * @create: 2019-02-25 22:44
 */
@Component
public class DateFetcher extends GraphQLScalarType {

    public DateFetcher() {
        super("Date", "date", new Coercing() {
            @Override
            public String serialize(Object dataFetcherResult) throws CoercingSerializeException {
                return LocalDateTime.ofInstant(((Date) dataFetcherResult).toInstant(), ZoneId.of("Asia/Shanghai"))
                    .format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss"));
            }

            @Override
            public Object parseValue(Object input) throws CoercingParseValueException {
                return serialize(input);
            }

            @Override
            public ZonedDateTime parseLiteral(Object input) throws CoercingParseLiteralException {
                if (input instanceof String) {
                    return ZonedDateTime.parse(((StringValue) input).getValue());
                } else if (input instanceof Integer) {
                    return Instant.ofEpochMilli(((IntValue) input).getValue().longValue()).atZone(ZoneOffset.UTC);
                } else {
                    return null;
                }
            }
        });
    }
}