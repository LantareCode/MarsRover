package org.lantarecode;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void testRun() {
        String filePath = "./src/test/resources/input.txt";
        assertEquals("1 3 N\n5 1 E\n", Main.run(filePath));
    }
}


