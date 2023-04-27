package org.example.Comparator;

import org.apache.commons.lang3.StringUtils;
import org.example.Student;

public class StudentAvgExamScoreComparator implements StudentComparator{
    @Override
    public int compare(Student o1, Student o2) {
        return Float.compare(o1.getAvgExamScore(),o2.getAvgExamScore());
    }
}
