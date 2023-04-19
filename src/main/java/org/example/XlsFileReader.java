package org.example;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class XlsFileReader {

    public static List<University> readXlsUniversities(String filePath) throws IOException {

        List<University> universities = new ArrayList<>();

        FileInputStream inputStream = new FileInputStream(filePath);
        XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
        XSSFSheet sheet = workbook.getSheet("Университеты");

        Iterator<Row> rows = sheet.iterator();
        rows.next();

        while (rows.hasNext()) {
            Row currentRow = rows.next();
            University university = new University();
            universities.add(university);
            university.setId(currentRow.getCell(0).getStringCellValue());
            university.setFullName(currentRow.getCell(1).getStringCellValue());
            university.setShortName(currentRow.getCell(2).getStringCellValue());
            university.setYearOfFoundation((int) currentRow.getCell(3).getNumericCellValue());
            university.setMainProfile(StudyProfile.valueOf(StudyProfile.class, currentRow.getCell(4).getStringCellValue()));
        }
        return universities;
    }

    public static List<Student> readXlsStudents(String filePath) throws IOException {

        List<Student> students = new ArrayList<>();

        FileInputStream inputStream = new FileInputStream(filePath);
        XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
        XSSFSheet sheet = workbook.getSheet("Студентики");

        Iterator<Row> rows = sheet.iterator();
        rows.next();

        while (rows.hasNext()) {
            Row currentRow = rows.next();
            Student student = new Student();
            students.add(student);
            student.setFullName(currentRow.getCell(0).getStringCellValue());
            student.setUniversityId(currentRow.getCell(1).getStringCellValue());
            student.setCurrentCourseNumber((int) currentRow.getCell(2).getNumericCellValue());
            student.setAvgExamScore((float) currentRow.getCell(3).getNumericCellValue());
        }
        return students;
    }


    /*public void studentFileReader() {
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
    }*/
}


