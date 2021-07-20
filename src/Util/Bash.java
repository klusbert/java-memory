package Util;

import Objects.Client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Bash {

    public Bash() {

    }

    public List<String> executeCommand(String command) {

        try {

            Process process = Runtime.getRuntime().exec(command);
            InputStream stream = process.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(stream));

            String line;

            List<String> result = new ArrayList<>();
            while (true) {
                try {
                    if (!((line = reader.readLine()) != null)) break;
                    result.add(line);

                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
            return result;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
