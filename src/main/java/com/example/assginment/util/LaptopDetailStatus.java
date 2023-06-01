package com.example.assginment.util;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum LaptopDetailStatus {
    DABAN(1), TRONGKHO(0), DAXOA(2), BAOHANH(3);
    private int value;

    public static LaptopDetailStatus valueOf(int x) {
        for (LaptopDetailStatus e : values()) {
            if (e.value == x) {
                return e;
            }
        }
        return null;
    }
}
