package com.multiple.root.util;

import org.springframework.core.convert.converter.Converter;

public class StringTrimmingConverter implements Converter<String, String> {

    public String convert(String source) {
		source = source.replaceAll("\"", "'");
		source = source.replaceAll("<", "&lt;");
		source = source.replaceAll(">", "&gt;");
		return source.trim();
    }

}
