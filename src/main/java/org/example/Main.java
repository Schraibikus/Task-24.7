package org.example;

import org.example.Comparator.StudentComparator;
import org.example.Comparator.UniversityComparator;
import org.example.Enums.StudentEnum;
import org.example.Enums.UniversityEnum;
import org.example.Model.Statistics;
import org.example.Reader.XlsWriter;
import org.example.Util.CompareEnum;
import org.example.Util.JsonUtil;
import org.example.Model.Student;
import org.example.Model.University;
import org.example.Reader.XlsFileReader;
import org.example.Util.StatisticUtil;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class Main {
    public static final Logger logger = Logger.getLogger(Main.class.getName());
    public static void main(String[] args) throws IOException {

        try {
            LogManager.getLogManager().readConfiguration(
                    Main.class.getResourceAsStream("/logging.properties"));
        } catch (IOException e){
            System.err.println("Could not setup logger configuration: " + e.toString());
        }
        logger.log(Level.INFO, "Application started, Logger configured");


        List<University> universities = XlsFileReader.readXlsUniversities("src/main/resources/universityInfo.xlsx");
        UniversityComparator universityComparator = CompareEnum.getUniversityComparator(UniversityEnum.YEAR);
        universities.sort(universityComparator);

        /*String universitiesJson = JsonUtil.universityListToJson(universities);
        System.out.println(universitiesJson);
        List<University> universitiesFromJson = JsonUtil.jsonToUniversityList(universitiesJson);
        System.out.println(universities.size() == universitiesFromJson.size());

        universities.forEach(university -> {
            String universityJson = JsonUtil.universityToJson(university);
            System.out.println(universityJson);
            University universityFromJson = JsonUtil.jsonToUniversity(universityJson);
            System.out.println(universityFromJson);
        });*/


        List<Student> students = XlsFileReader.readXlsStudents("src/main/resources/universityInfo.xlsx");
        StudentComparator studentComparator = CompareEnum.getStudentComparator(StudentEnum.AVG_EXAM_SCOPE);
        students.sort(studentComparator);

        /*String studentsJson = JsonUtil.studentListToJson(students);
        System.out.println(studentsJson);
        List<Student> studentsFromJson = JsonUtil.jsonToStudentList(studentsJson);
        System.out.println(students.size() == studentsFromJson.size());

        students.forEach(student -> {
            String studentJson = JsonUtil.studentToJson(student);
            System.out.println(studentJson);
            Student studentFromJson = JsonUtil.jsonToStudent(studentJson);
            System.out.println(studentFromJson);
        });*/

        List<Statistics> statisticsList = StatisticUtil.createStatistics(students, universities);
        XlsWriter.writeXlsStatistics(statisticsList, "statistics.xlsx");

        logger.log(Level.INFO, "Application finished");

    }

}
