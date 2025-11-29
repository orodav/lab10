package it.unibo.mvc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ConfigurationFromFile {
        
    private static final String PATH = "config.yml";

    public Configuration configSet() throws IOException {

        final InputStream is = getClass().getClassLoader().getResourceAsStream(PATH);
        if (is == null) {
            throw new IOException ("Configuration file not found" + PATH);
        }

        final Configuration.Builder builder = new Configuration.Builder();
        final BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        String ln;

        while ((ln = reader.readLine()) != null) {
            if (ln.length() == 0) {

            } else {
                int pos = ln.indexOf(':');
                if (pos != -1) {
                    String key = ln.substring(0, pos);
                    String val = ln.substring(pos + 1);
                    while (val.startsWith(" ")) {
                        val = val.substring(1);
                    }
                    int n = Integer.parseInt(val);
                    if (key.equals("minimum")) {
                        builder.setMin(n);
                    } else if (key.equals("maximum")) {
                        builder.setMax(n);
                    } else if (key.equals("attempts")) {
                        builder.setAttempts(n);
                    }
                }
            }
        }
        reader.close();
        return builder.build();
    }
}
