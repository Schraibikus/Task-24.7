package org.example.Util;

import org.example.Comparator.*;
import org.example.Enums.StudentEnum;
import org.example.Enums.UniversityEnum;

public class CompareEnum {
    private CompareEnum() {
    }

    public static UniversityComparator getUniversityComparator(UniversityEnum universityEnum) {
        switch (universityEnum) {
            case ID:
                return new UniversityIdComparator();
            case FULL_NAME:
                return new UniversityFullNameComparator();
            case SHORT_NAME:
                return new UniversityShortNameComparator();
            case YEAR:
                return new UniversityYearOfFoundationComparator();
            case PROFILE:
                return new UniversityMainProfileComparator();
            default:
                return new UniversityFullNameComparator();
        }
    }
    public static StudentComparator getStudentComparator(StudentEnum studentEnum){
        switch (studentEnum){
            case UNIVERSITY_ID:
                return new StudentUniversityIdComparator();
            case FULL_NAME:
                return new StudentFullNameComparator();
            case COURSE:
                return new StudentCurrentCourseNumberComparator();
            case AVG_EXAM_SCOPE:
                return new StudentAvgExamScoreComparator();
            default:
                return new StudentFullNameComparator();
        }
    }
}


