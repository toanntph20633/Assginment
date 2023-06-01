package com.example.assginment.util;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum LaptopStatus {
    ACTIVE(0), INACTIVE(1), DELETED(2);
    private int value;

    public static LaptopStatus valueOf(int x) {
        for (LaptopStatus e : values()) {
            if (e.value == x) {
                return e;
            }
        }
        return null;
    }
}
