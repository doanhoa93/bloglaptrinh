package bloglaptrinh.com.common.utils;

import org.springframework.core.convert.converter.Converter;

public class ConverterFactory<K,T> implements Converter<K,T> {

    @Override
    public T convert(K k) {
        return null;
    }
}
