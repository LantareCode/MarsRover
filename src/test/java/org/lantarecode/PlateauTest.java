package org.lantarecode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlateauTest {

    @Test
    void negativesShouldResultInIllegalStateException() {
        assertThrows(IllegalStateException.class, () -> {
            Plateau plateau = new Plateau(-1, 1);
        });

        assertThrows(IllegalStateException.class, () -> {
            Plateau plateau = new Plateau(1, -1);
        });
    }

}