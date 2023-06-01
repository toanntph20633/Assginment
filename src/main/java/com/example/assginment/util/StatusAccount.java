package com.example.assginment.util;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum  StatusAccount {
    ACTIVE(0), INACTIVE(1), DELETED(2);
    private int value;

    public static StatusAccount valueOf(int x) {
        for (StatusAccount e : values()) {
            if (e.value == x) {
                return e;
            }
        }
        return null;
    }
}
