package org.example;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        List<University> universities = XlsFileReader.readXlsUniversities("src/main/resources/universityInfo.xlsx");
        for (University university : universities){
            System.out.println(university);
        }

        List<Student> students = XlsFileReader.readXlsStudents("src/main/resources/universityInfo.xlsx");
        for (Student student : students){
            System.out.println(student);
        }

/*
        XlsFileReader xlsFileReader = new XlsFileReader();
        xlsFileReader.studentFileReader();
        System.out.println();
        xlsFileReader.universityFileReader();
*/

    }
}
