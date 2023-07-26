package ru.mylov;

import org.apache.commons.lang3.StringUtils;
import ru.enums.StudyProfile;
import ru.model.Statistics;
import ru.model.Student;
import ru.model.University;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;
import java.util.Set;
import java.util.stream.Collectors;

public class StatisticsUtil {
    public static List<Statistics> createStatisticsList(List<Student> studentsList, List<University> universitiesList) {
        List<Statistics> statisticsList = new ArrayList<>();
        Set<StudyProfile> profiles = universitiesList.stream()
                .map(University::getMainProfile)
                .collect(Collectors.toSet());

        profiles.forEach(profile -> {
            Statistics statistics = new Statistics();
            statisticsList.add(statistics);
            statistics.setStudyProfile(profile);

            List<String> profileUniversityIds = universitiesList.stream()
                    .filter(university -> university.getMainProfile().equals(profile))
                    .map(University::getId).collect(Collectors.toList());

            statistics.setUniversitiesCountOnProfile(profileUniversityIds.size());
            statistics.setUniversityName(StringUtils.EMPTY);

            universitiesList.stream()
                    .filter(university -> profileUniversityIds.contains(university.getId()))
                    .map(University::getFullName)
                    .forEach(fullNameUniversity -> statistics.setUniversityName(
                            statistics.getUniversityName() + fullNameUniversity + ";"));

            List<Student> profileStudents = studentsList.stream()
                    .filter(student -> profileUniversityIds.contains(student.getUniversityId()))
                    .collect(Collectors.toList());

            statistics.setStudentsCountOnProfile(profileStudents.size());

            OptionalDouble avgExamScore = profileStudents.stream()
                    .mapToDouble(Student::getAvgExamScore)
                    .average();
            statistics.setAvgExamScore(0);
            avgExamScore.ifPresent(value -> statistics.setAvgExamScore(
                    (float) BigDecimal.valueOf(value).setScale(2, RoundingMode.HALF_UP).doubleValue()));
        });

        return statisticsList;
    }
}
