package br.com.alura.aluraflix.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ActiveFlagEnum {
    YES("S"),
    NO("N");

    private String value;

    @Override
    public String toString(){
        return String.valueOf(value);
    }
}
