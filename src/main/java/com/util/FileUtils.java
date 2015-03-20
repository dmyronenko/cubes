package com.util;

import com.cubes.Facet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class FileUtils {

    private FileUtils() {
        throw new AssertionError("Instantiating utility class");
    }

    /**
     * Reads sides from input stream
     */
    public static List<Facet> readSides(InputStream stream) throws IOException {
        List<Facet> result = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(stream))) {
            for (int i = 0; i < 2; i++) {
                List<String> s1 = new ArrayList<>();
                List<String> s2 = new ArrayList<>();
                List<String> s3 = new ArrayList<>();

                for (int j = 0; j < 5; j++) {
                    String line = reader.readLine();
                    if (line == null) {
                        throw new IllegalStateException("Input file has invalid format");
                    }

                    s1.add(line.substring(0, 5));
                    s2.add(line.substring(5, 10));
                    s3.add(line.substring(10, 15));


                }
                result.addAll(Arrays.asList(new Facet(s1), new Facet(s2), new Facet(s3)));
            }
        }
        return result;
    }
}
