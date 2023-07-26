package ru.model;
import ru.enums.StudyProfile;

public class Statistics {
    private StudyProfile studyProfile;
    private float avgExamScore;
    private int studentsCountOnProfile;
    private int universitiesCountOnProfile;
    private String universityName;

    public Statistics() {}

    public Statistics(StudyProfile studyProfile, float avgExamScore, int studentsCountOnProfile, int universitiesCountOnProfile, String universityName) {
        this.studyProfile = studyProfile;
        this.avgExamScore = avgExamScore;
        this.studentsCountOnProfile = studentsCountOnProfile;
        this.universitiesCountOnProfile = universitiesCountOnProfile;
        this.universityName = universityName;
    }

    public StudyProfile getStudyProfile() {
        return studyProfile;
    }

    public float getAvgExamScore() {
        return avgExamScore;
    }

    public int getStudentsCountOnProfile() {
        return studentsCountOnProfile;
    }

    public int getUniversitiesCountOnProfile() {
        return universitiesCountOnProfile;
    }

    public String getUniversityName() {
        return universityName;
    }

    public void setStudyProfile(StudyProfile studyProfile) {
        this.studyProfile = studyProfile;
    }

    public void setAvgExamScore(float avgExamScore) {
        this.avgExamScore = avgExamScore;
    }

    public void setStudentsCountOnProfile(int studentsCountOnProfile) {
        this.studentsCountOnProfile = studentsCountOnProfile;
    }

    public void setUniversitiesCountOnProfile(int universitiesCountOnProfile) {
        this.universitiesCountOnProfile = universitiesCountOnProfile;
    }

    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }
}
