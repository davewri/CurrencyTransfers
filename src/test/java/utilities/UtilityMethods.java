package utilities;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by David Wright - 27/09/2019
 *
 * Utility methods class:
 *      Method to read a file
 *
 */

public class UtilityMethods {

    public static ArrayList<String> readFile(String csvFile) throws IOException {
        File file = new File(csvFile);

        ArrayList<String> csvLines = new ArrayList<String>();

        BufferedReader bufRdr;
        bufRdr = new BufferedReader(new FileReader(file));
        String line = null;

        while ((line = bufRdr.readLine()) != null) {
            csvLines.add(line);
        }
        return csvLines;
    }

}
