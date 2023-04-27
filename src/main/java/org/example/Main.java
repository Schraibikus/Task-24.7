package org.example;

import org.example.Comparator.StudentComparator;
import org.example.Comparator.UniversityComparator;
import org.example.Enums.StudentEnum;
import org.example.Enums.UniversityEnum;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {



        List<University> universities = XlsFileReader.readXlsUniversities("src/main/resources/universityInfo.xlsx");
        UniversityComparator universityComparator = CompareEnum.getUniversityComparator(UniversityEnum.YEAR);
        universities.stream()
                .sorted(universityComparator)
                .forEach(System.out::println);

        List<Student> students = XlsFileReader.readXlsStudents("src/main/resources/universityInfo.xlsx");
        StudentComparator studentComparator = CompareEnum.getStudentComparator(StudentEnum.AVG_EXAM_SCOPE);
        students.stream()
                .sorted(studentComparator)
                .forEach(System.out::println);




    }
}
