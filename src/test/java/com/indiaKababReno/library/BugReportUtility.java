package com.indiaKababReno.library;
import org.apache.poi.ss.usermodel.*;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class BugReportUtility {

    public static void reportBug(String filePath, String testCaseName, String errorMessage) {
        try {
            // Load the Excel file
            FileInputStream fileInputStream = new FileInputStream(System.getProperty("user.dir")+"//Reports//BugReport.xlsx");
            Workbook workbook = WorkbookFactory.create(fileInputStream);

            // Select the first sheet
            Sheet sheet = workbook.getSheetAt(0);

            // Get the last row index
            int lastRow = sheet.getLastRowNum();

            // Create a new row
            Row newRow = sheet.createRow(lastRow + 1);

            // Set the values in each cell
            Cell testCaseCell = newRow.createCell(0);
            testCaseCell.setCellValue(testCaseName);

            Cell errorCell = newRow.createCell(1);
            errorCell.setCellValue(errorMessage);

            Cell timestampCell = newRow.createCell(2);
            timestampCell.setCellValue(getCurrentTimestamp());

            // Save the changes to the Excel file
            FileOutputStream outputStream = new FileOutputStream(filePath);
            workbook.write(outputStream);
            workbook.close();
            outputStream.close();

            System.out.println("Bug reported successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String getCurrentTimestamp() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return now.format(formatter);
    }
}

