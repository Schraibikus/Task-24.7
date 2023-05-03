package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.example.Comparator.StudentComparator;
import org.example.Comparator.UniversityComparator;
import org.example.Enums.StudentEnum;
import org.example.Enums.UniversityEnum;
import org.example.Json.JsonUtil;
import org.example.Reader.XlsFileReader;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        List<University> universities = XlsFileReader.readXlsUniversities("src/main/resources/universityInfo.xlsx");
        UniversityComparator universityComparator = CompareEnum.getUniversityComparator(UniversityEnum.YEAR);
        universities.sort(universityComparator);
        String universitiesJson = JsonUtil.universityListToJson(universities);
        System.out.println(universitiesJson);
        List<University> universitiesFromJson = JsonUtil.jsonToUniversityList(universitiesJson);
        System.out.println(universities.size() == universitiesFromJson.size());

        universities.forEach(university -> {
            String universityJson = JsonUtil.universityToJson(university);
            System.out.println(universityJson);
            University universityFromJson = JsonUtil.jsonToUniversity(universityJson);
            System.out.println(universityFromJson);
        });




        List<Student> students = XlsFileReader.readXlsStudents("src/main/resources/universityInfo.xlsx");
        StudentComparator studentComparator = CompareEnum.getStudentComparator(StudentEnum.AVG_EXAM_SCOPE);
        students.sort(studentComparator);
        String studentsJson = JsonUtil.studentListToJson(students);
        System.out.println(studentsJson);
        List<Student> studentsFromJson = JsonUtil.jsonToStudentList(studentsJson);
        System.out.println(students.size() == studentsFromJson.size());

        students.forEach(student -> {
            String studentJson = JsonUtil.studentToJson(student);
            System.out.println(studentJson);
            Student studentFromJson = JsonUtil.jsonToStudent(studentJson);
            System.out.println(studentFromJson);
        });

    }

}
