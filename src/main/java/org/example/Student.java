package org.example;

import org.apache.commons.lang3.StringUtils;
import org.example.Comparator.StudentComparator;


public class Student {
    private String fullName;
    private String universityId;
    private int currentCourseNumber;
    private float avgExamScore;

    public Student() {

    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUniversityId() {
        return universityId;
    }

    public void setUniversityId(String universityId) {
        this.universityId = universityId;
    }

    public int getCurrentCourseNumber() {
        return currentCourseNumber;
    }

    public void setCurrentCourseNumber(int currentCourseNumber) {
        this.currentCourseNumber = currentCourseNumber;
    }

    public float getAvgExamScore() {
        return avgExamScore;
    }

    public void setAvgExamScore(float avgExamScore) {
        this.avgExamScore = avgExamScore;
    }

    @Override
    public String toString() {
        return String.format("fullName = %s, universityId = %s, currentCourseNumber = %s, avgExamScore = %s",
                this.fullName,
                this.universityId,
                this.currentCourseNumber,
                this.avgExamScore);
    }

}
