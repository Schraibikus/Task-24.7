package org.example.Comparator;

import org.apache.commons.lang3.StringUtils;
import org.example.Model.University;

public class UniversityMainProfileComparator implements UniversityComparator {
    @Override
    public int compare(University o1, University o2) {
        if (o1.getMainProfile() == null) {
            return 1;
        } else if (o2.getMainProfile() == null) {
            return -1;
        }
        return StringUtils.compare(o1.getMainProfile().name(), o2.getMainProfile().name());
    }
}
