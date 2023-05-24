package org.example.Comparator;

import org.apache.commons.lang3.StringUtils;
import org.example.Model.University;

public class UniversityIdComparator implements UniversityComparator {
    @Override
    public int compare(University o1, University o2) {
        return StringUtils.compare(o1.getId(), o2.getId());
    }
}
