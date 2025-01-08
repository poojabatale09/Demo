package utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.io.IOException;

public class ConsoleLogCapturer {

    private PrintStream originalSystemOut;
    private PrintStream customPrintStream;

    public ConsoleLogCapturer(String logFileName) {
        try {
            // Create the log file
            File logFile = new File(logFileName);
            if (!logFile.exists()) {
                logFile.createNewFile();
            }

            // Create a FileOutputStream to write to the log file
            FileOutputStream fileOutputStream = new FileOutputStream(logFile, true);  // true for appending

            // Create a PrintStream from the FileOutputStream
            customPrintStream = new PrintStream(fileOutputStream);

            // Capture the original System.out
            originalSystemOut = System.out;

            // Set the custom PrintStream as the System.out
            System.setOut(customPrintStream);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void stopCapturingLogs() {
        // Reset System.out to its original state
        System.setOut(originalSystemOut);
    }
}