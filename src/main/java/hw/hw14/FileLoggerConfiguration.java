package hw.hw14;

import java.io.File;

public class FileLoggerConfiguration {
    private String filePath;
    private LoggingLevel loggingLevel;
    private long maxSize;
    private String format;

    public FileLoggerConfiguration(String filePath, LoggingLevel loggingLevel, long maxSize, String format) {
        this.filePath = filePath;
        this.loggingLevel = loggingLevel;
        this.maxSize = maxSize;
        this.format = format;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public LoggingLevel getLoggingLevel() {
        return loggingLevel;
    }

    public void setLoggingLevel(LoggingLevel loggingLevel) {
        this.loggingLevel = loggingLevel;
    }

    public long getMaxSize() {
        return maxSize;
    }

    public void setMaxSize(long maxSize) {
        this.maxSize = maxSize;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }
}
