package ru.mylov;
import ru.comparators.*;
import ru.enums.StudentComparatorType;
import ru.enums.UniversityComparatorType;


public class ComparatorUtil {

    private ComparatorUtil() {}

    public static StudentComparator getStudentComparator(StudentComparatorType studentComparatorType) {
        switch (studentComparatorType) {
            case UNIVERSITY_ID:
                return new StudentUniversityIdComparator();
            case FULL_NAME:
                //noinspection DuplicateBranchesInSwitch
                return new StudentFullNameComparator();
            case COURSE:
                return new StudentCurrentCourseComparator();
            case AVG_EXAM_SCORE:
                return new StudentAvgExamScoreComparator();
            default:
                return new StudentFullNameComparator();
        }
    }

    public static UniversityComparator getUniversityComparator(UniversityComparatorType universityComparatorType) {
        switch (universityComparatorType) {
            case ID:
                return new UniversityIdComparator();
            case SHORT_NAME:
                return new UniversityShortNameComparator();
            case PROFILE:
                return new UniversityProfileComparator();
            case YEAR:
                return new UniversityYearOfFoundationComparator();
            case FULL_NAME:
            default:
                return new UniversityFullNameComparator();
        }
    }
}
