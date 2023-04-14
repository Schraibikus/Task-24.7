package org.example;

public class Main {
    public static void main(String[] args) {

        Student student = new Student();
        student.setAvgExamScore((float)3.5);
        student.setCurrentCourseNumber(3);
        student.setFullName("Ivanov Ivan Ivanovich");
        student.setUniversityId("0001-high");
        System.out.println(student);

        University university = new University();
        university.setId("0001-high");
        university.setFullName("Some Technical University");
        university.setShortName("STU");
        university.setYearOfFoundation(1985);
        university.setMainProfile(StudyProfile.MEDICINE);
        System.out.println(university);
    }
}
