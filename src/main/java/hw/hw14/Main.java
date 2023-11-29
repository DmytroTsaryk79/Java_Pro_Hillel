package hw.hw14;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            FileLoggerConfigurationLoader loader = new FileLoggerConfigurationLoader();
            FileLoggerConfiguration config = loader.load("path/to/config.txt");

            FileLogger logger = new FileLogger(config);
            logger.debug("This is a debug message.");
            logger.info("This is an info message.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}