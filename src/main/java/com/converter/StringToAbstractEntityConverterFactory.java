package com.converter;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.converter.ConverterFactory;

import com.entity.Store;


public class StringToAbstractEntityConverterFactory
        implements ConverterFactory<String, Object> {

    @Override
    public <T extends Object> Converter<String, T> getConverter(Class<T> targetClass) {
        return new StringToAbstractEntityConverter<>(targetClass);
    }

    private static class StringToAbstractEntityConverter<T extends Object>
            implements Converter<String, T> {

        private Class<T> targetClass;

        public StringToAbstractEntityConverter(Class<T> targetClass) {
            this.targetClass = targetClass;
        }

        @Override
        public T convert(String source) {
            long id = Long.parseLong(source);
            if(this.targetClass == Store.class) {
                return (T) new Store();
            }
                return null;
            }
        }
    }



