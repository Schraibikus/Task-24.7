package org.example.Util;

import org.apache.commons.lang3.StringUtils;
import org.example.Enums.StudyProfile;
import org.example.Model.Statistics;
import org.example.Model.Student;
import org.example.Model.University;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class StatisticUtil {

    private static final Logger logger = Logger.getLogger(StatisticUtil.class.getName());

    private StatisticUtil() {
    }

    public static List<Statistics> createStatistics(List<Student> students, List<University> universities) {

        logger.log(Level.INFO, "Statistics module started");

        List<Statistics> statisticsList = new ArrayList<>();

        Set<StudyProfile> profiles = universities.stream()
                .map(University::getMainProfile)
                .collect(Collectors.toSet());

        profiles.forEach(profile -> {
            Statistics statistics = new Statistics();
            statisticsList.add(statistics);
            statistics.setLearningProfile(profile);

            List<String> profileUniversityIds = universities.stream()
                    .filter(university -> university.getMainProfile().equals(profile))
                    .map(University::getId)
                    .collect(Collectors.toList());
            statistics.setNumberOfUniversitiesByProfile(profileUniversityIds.size());
            statistics.setUniversityNames(StringUtils.EMPTY);
            universities.stream()
                    .filter(university -> profileUniversityIds.contains(university.getId()))
                    .map(University::getFullName)
                    .forEach(fullMameUniversity -> statistics.setUniversityNames(
                            statistics.getUniversityNames() + fullMameUniversity + ";"));

            List<Student> profileStudents = students.stream()
                    .filter(student -> profileUniversityIds.contains(student.getUniversityId()))
                    .collect(Collectors.toList());
            statistics.setNumberOfStudentsByProfile(profileStudents.size());
            OptionalDouble avgExamScore = profileStudents.stream()
                    .mapToDouble(Student::getAvgExamScore)
                    .average();
            statistics.setAverageScore(0);
            avgExamScore.ifPresent(value -> statistics.setAverageScore(
                    (float) BigDecimal.valueOf(value).setScale(2, RoundingMode.HALF_UP).doubleValue()));
        });
        logger.log(Level.INFO, String.format("Statistics module finished with %s statistical objects", statisticsList.size()));
        return statisticsList;
    }
}
