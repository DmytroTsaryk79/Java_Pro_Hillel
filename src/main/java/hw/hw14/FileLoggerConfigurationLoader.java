package hw.hw14;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileLoggerConfigurationLoader {
    public FileLoggerConfiguration load(String configFile) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(configFile));
        FileLoggerConfiguration config = new FileLoggerConfiguration("path/to/log/file.txt", LoggingLevel.DEBUG, 1024, "yyyy-MM-dd HH:mm:ss");

        String line;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(": ");
            if (parts.length == 2) {
                String key = parts[0].trim();
                String value = parts[1].trim();

                switch (key) {
                    case "FILE":
                        config.setFilePath(value);
                        break;
                    case "LEVEL":
                        config.setLoggingLevel(LoggingLevel.valueOf(value));
                        break;
                    case "MAX-SIZE":
                        config.setMaxSize(Long.parseLong(value));
                        break;
                    case "FORMAT":
                        config.setFormat(value);
                        break;
                }
            }
        }

        reader.close();
        return config;
    }
}