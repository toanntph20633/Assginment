package com.example.assginment.util;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum BillStatus {
    ACTIVE(0), INACTIVE(1), DELETED(2);
    private int value;

    public static BillStatus valueOf(int x) {
        for (BillStatus e : values()) {
            if (e.value == x) {
                return e;
            }
        }
        return null;
    }
}
