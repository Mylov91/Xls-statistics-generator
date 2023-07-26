package ru.mylov;
import ru.comparators.StudentComparator;
import ru.comparators.UniversityComparator;
import ru.enums.StudentComparatorType;
import ru.enums.UniversityComparatorType;
import ru.model.Statistics;
import ru.model.Student;
import ru.model.University;
import java.io.IOException;
import java.util.List;


public class Main {
    public static void main(String[] args) throws IOException {

        List<Student> studentsFromExcelList = ExcelReader.getExcelReader().readStudents();
        StudentComparator studentComparator =
                ComparatorUtil.getStudentComparator(StudentComparatorType.FULL_NAME);
        studentsFromExcelList.sort(studentComparator);
        String studentsJson = JsonUtil.studentsListToJson(studentsFromExcelList);
        System.out.println(studentsJson);
        List<Student> studentsFromJsonList = JsonUtil.studentsJsonToList(studentsJson);
        JsonUtil.checkStudentsSerializeDeserializeCorrectness(studentsFromExcelList, studentsFromJsonList);
        studentsFromExcelList.forEach(student -> {
            String studentJson = JsonUtil.studentToJson(student);
            System.out.println(studentJson);
            Student studentFromJson = JsonUtil.jsonToStudent(studentJson);
            System.out.println(studentFromJson);
        });

        List<University> universitiesFromExcelList = ExcelReader.getExcelReader().readUniversities();
        UniversityComparator universityComparator =
                ComparatorUtil.getUniversityComparator(UniversityComparatorType.YEAR);
        universitiesFromExcelList.sort(universityComparator);
        String universitiesJson = JsonUtil.universitiesListToJson(universitiesFromExcelList);
        System.out.println(universitiesJson);
        List<University> universitiesFromJsonList = JsonUtil.universitiesJsonToList(universitiesJson);
        JsonUtil.checkUniversitiesSerializeDeserializeCorrectness(universitiesFromExcelList, universitiesFromJsonList);
        universitiesFromExcelList.forEach(university -> {
            String universityJson = JsonUtil.universityToJson(university);
            System.out.println(universityJson);
            University universityFromJson = JsonUtil.jsonToUniversity(universityJson);
            System.out.println(universityFromJson);
        });

        List<Statistics> statisticsList = StatisticsUtil.createStatisticsList(studentsFromExcelList, universitiesFromExcelList);
        XlsWriter.createTable(statisticsList, "src/main/resources/statistics.xlsx");
    }
}