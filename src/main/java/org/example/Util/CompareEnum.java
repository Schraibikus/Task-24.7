package org.example.Util;

import org.example.Comparator.*;
import org.example.Enums.StudentEnum;
import org.example.Enums.UniversityEnum;

public class CompareEnum {
    private CompareEnum() {
    }

    public static UniversityComparator getUniversityComparator(UniversityEnum universityEnum) {
        return switch (universityEnum) {
            case ID -> new UniversityIdComparator();
            case FULL_NAME -> new UniversityFullNameComparator();
            case SHORT_NAME -> new UniversityShortNameComparator();
            case YEAR -> new UniversityYearOfFoundationComparator();
            case PROFILE -> new UniversityMainProfileComparator();
            default -> new UniversityFullNameComparator();
        };
    }
    public static StudentComparator getStudentComparator(StudentEnum studentEnum){
        return switch (studentEnum) {
            case UNIVERSITY_ID -> new StudentUniversityIdComparator();
            case FULL_NAME -> new StudentFullNameComparator();
            case COURSE -> new StudentCurrentCourseNumberComparator();
            case AVG_EXAM_SCOPE -> new StudentAvgExamScoreComparator();
            default -> new StudentFullNameComparator();
        };
    }
}


