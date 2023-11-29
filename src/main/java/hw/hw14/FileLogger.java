package hw.hw14;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileLogger {
    private FileLoggerConfiguration config;
    private FileWriter fileWriter;
    private long currentFileSize;

    public FileLogger(FileLoggerConfiguration config) throws IOException {
        this.config = config;
        this.fileWriter = new FileWriter(config.getFilePath(), true);
        this.currentFileSize = new File(config.getFilePath()).length();
    }

    public void debug(String message) {
        log(LoggingLevel.DEBUG, message);
    }

    public void info(String message) {
        log(LoggingLevel.INFO, message);
    }

    private void log(LoggingLevel level, String message) {
        if (level.ordinal() >= config.getLoggingLevel().ordinal()) {
            try {
                String logEntry = String.format("[%s][%s] Повідомлення: %s%n",
                        getCurrentTime(), level, message);

                if (currentFileSize + logEntry.length() > config.getMaxSize()) {
                    createNewLogFile();
                }

                fileWriter.write(logEntry);
                fileWriter.flush();
                currentFileSize += logEntry.length();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private String getCurrentTime() {
        SimpleDateFormat dateFormat = new SimpleDateFormat(config.getFormat());
        return dateFormat.format(new Date());
    }

    private void createNewLogFile() throws IOException {
        fileWriter.close();
        String newFileName = String.format("Log_%s.txt", getCurrentTime());
        fileWriter = new FileWriter(newFileName, true);
        currentFileSize = 0;
    }
}