package ru.mylov;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import ru.model.Student;
import ru.model.University;
import java.util.List;


public class JsonUtil {
    private JsonUtil() {}

    public static String studentToJson(Student student) {
        return new GsonBuilder().setPrettyPrinting().create().toJson(student);
    }

    public static Student jsonToStudent(String json) {
        return new Gson().fromJson(json, Student.class);
    }

    public static String studentsListToJson(List<Student> studentsList) {
        return new GsonBuilder().setPrettyPrinting().create().toJson(studentsList);
    }

    public static List<Student> studentsJsonToList(String studentsJson) {
        return new Gson().fromJson(studentsJson, new TypeToken<List<Student>>() {}.getType());
    }

    public static String universityToJson(University university) {
        return new GsonBuilder().setPrettyPrinting().create().toJson(university);
    }

    public static University jsonToUniversity(String json) {
        return new Gson().fromJson(json, University.class);
    }

    public static String universitiesListToJson(List<University> universitiesList) {
        return new GsonBuilder().setPrettyPrinting().create().toJson(universitiesList);
    }

    public static List<University> universitiesJsonToList(String universitiesJson) {
        return new Gson().fromJson(universitiesJson, new TypeToken<List<Student>>() {}.getType());
    }

    public static void checkStudentsSerializeDeserializeCorrectness(List<Student> list1, List<Student> list2) {
        if (list1.size() == list2.size()) {
            System.out.println("Check size status of students serialization/deserialization: success");
        } else {
            System.out.println("Check size status of students serialization/deserialization: error");
        }
    }

    public static void checkUniversitiesSerializeDeserializeCorrectness(List<University> list1, List<University> list2) {
        if (list1.size() == list2.size()) {
            System.out.println("Check size status of universities serialization/deserialization: success");
        } else {
            System.out.println("Check size status of universities serialization/deserialization: error");
        }
    }
}
