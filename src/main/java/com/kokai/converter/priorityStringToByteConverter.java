package com.kokai.converter;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class priorityStringToByteConverter implements AttributeConverter<String, Byte> {

    @Override
    public Byte convertToDatabaseColumn(String attribute) {

        try {
            int priorityNumber = Integer.parseInt(attribute);
            return (byte) priorityNumber;
        } catch (NumberFormatException _) {

        }

        if (attribute == null) {
            return null;
        }
        return switch (attribute.toLowerCase()) {
            case "high" -> 1;
            case "normal" -> 2;
            default -> 3;
        };
    }

    @Override
    public String convertToEntityAttribute(Byte dbData) {

        if (dbData == null) {
            return null;
        }
        return switch (dbData) {
            case 1 -> "high";
            case 2 -> "normal";
            default -> "low";
        };
    }
}
