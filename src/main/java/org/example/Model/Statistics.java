package org.example.Model;

import org.example.Enums.StudyProfile;

public class Statistics {
    private StudyProfile learningProfile;
    private float averageScore;
    private int numberOfStudentsByProfile;
    private int numberOfUniversitiesByProfile;
    private String universityNames;

    public Statistics(){

    }

    public StudyProfile getLearningProfile() {
        return learningProfile;
    }

    public void setLearningProfile(StudyProfile learningProfile) {
        this.learningProfile = learningProfile;
    }

    public float getAverageScore() {
        return averageScore;
    }

    public void setAverageScore(float averageScore) {
        this.averageScore = averageScore;
    }

    public int getNumberOfStudentsByProfile() {
        return numberOfStudentsByProfile;
    }

    public void setNumberOfStudentsByProfile(int numberOfStudentsByProfile) {
        this.numberOfStudentsByProfile = numberOfStudentsByProfile;
    }

    public int getNumberOfUniversitiesByProfile() {
        return numberOfUniversitiesByProfile;
    }

    public void setNumberOfUniversitiesByProfile(int numberOfUniversitiesByProfile) {
        this.numberOfUniversitiesByProfile = numberOfUniversitiesByProfile;
    }

    public String getUniversityNames() {
        return universityNames;
    }

    public void setUniversityNames(String universityNames) {
        this.universityNames = universityNames;
    }
}
