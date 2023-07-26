package ru.model;
import com.google.gson.annotations.SerializedName;


public class Student {
    @SerializedName("studentName")
    private String fullName;
    @SerializedName("iniversityIdentifier")
    private String universityId;
    @SerializedName("studentCourse")
    private int currentCourseNumber;
    @SerializedName("studentAvgScore")
    private float avgExamScore;


    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setUniversityId(String universityId) {
        this.universityId = universityId;
    }

    public void setCurrentCourseNumber(int currentCourseNumber) {
        this.currentCourseNumber = currentCourseNumber;
    }

    public void setAvgExamScore(float avgExamScore) {
        this.avgExamScore = avgExamScore;
    }

    public String getFullName() {
        return fullName;
    }

    public String getUniversityId() {
        return universityId;
    }

    public int getCurrentCourseNumber() {
        return currentCourseNumber;
    }

    public float getAvgExamScore() {
        return avgExamScore;
    }

    @Override
    public String toString() {
        return "\n" + "Name of student: " + getFullName() + ", university ID: " + getUniversityId() +
                ", current course number: " + getCurrentCourseNumber() + ", average exam score: " + getAvgExamScore() + "\n";
    }
}
