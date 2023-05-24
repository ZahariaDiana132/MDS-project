package ro.pao.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@Getter
@AllArgsConstructor
public enum tipuriproduse {
    CARTE("carte"),
    CULEGERE("culegere"),
    MANUAL("manual"),
    NONE("none"); // in cazul in care nu este niciun field

    private final String typeString;

    public static tipuriproduse getEnumByFieldString(String field) {
        return Arrays.stream(tipuriproduse.values())
                .filter(enumElement -> enumElement.typeString.equals(field))
                .findAny()
                .orElse(NONE); // in cazul in care nu este niciun field
    }
}


