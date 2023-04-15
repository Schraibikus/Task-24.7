package org.example;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

public class FileReader {


    public void studentFileReader() throws IOException {
        try {
            FileInputStream file = new FileInputStream(new File("C:\\Users\\kurt-\\module_gradle\\Practic24.7\\src\\main\\resources\\universityInfo.xlsx"));
            XSSFWorkbook workbook = new XSSFWorkbook(file);
            XSSFSheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rowIterator = sheet.iterator();
            rowIterator.next();
            while (rowIterator.hasNext()){
                Row row = rowIterator.next();
                Iterator<Cell> cellIterator = row.cellIterator();
                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    switch (cell.getCellType()) {
                        case NUMERIC -> System.out.printf("%.2f" + "\t", cell.getNumericCellValue());
                        case STRING -> System.out.print(cell.getStringCellValue() + "\t");
                    }
                }
                System.out.println();
            }
            file.close();
        } catch (Exception e) {
            System.out.println("Что-то пошло не так со студентиками))");
        }
    }

    public void universityFileReader() {
        try {
            FileInputStream file = new FileInputStream(new File("C:\\Users\\kurt-\\module_gradle\\Practic24.7\\src\\main\\resources\\universityInfo.xlsx"));
            XSSFWorkbook workbook = new XSSFWorkbook(file);
            XSSFSheet sheet = workbook.getSheetAt(1);
            Iterator<Row> rowIterator = sheet.iterator();
            rowIterator.next();
            while (rowIterator.hasNext()){
                Row row = rowIterator.next();
                Iterator<Cell> cellIterator = row.cellIterator();
                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    switch (cell.getCellType()) {
                        case NUMERIC -> System.out.printf("%.0f" + "\t", cell.getNumericCellValue());
                        case STRING -> System.out.print(cell.getStringCellValue() + "\t");
                    }
                }
                System.out.println();
            }
            file.close();
        } catch (Exception e) {
            System.out.println("Что-то пошло не так с университетами");
        }
    }
}


