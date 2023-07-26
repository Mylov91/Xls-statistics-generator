package ru.mylov;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import ru.enums.StudyProfile;
import ru.model.Student;
import ru.model.University;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class ExcelReader {
    private static ExcelReader excelReader;

    private ExcelReader() {}

    FileInputStream fis;
    {
        try {
            fis = new FileInputStream("src/main/resources/universityInfo.xlsx");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    XSSFWorkbook wb;
    {
        try {
            wb = new XSSFWorkbook(fis);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static ExcelReader getExcelReader() {
        if (excelReader == null) {
            excelReader = new ExcelReader();
        }
        return excelReader;
    }

    public List<Student> readStudents() throws IOException {
        List<Student> students = new ArrayList<>();
        XSSFSheet sheet1 = wb.getSheetAt(0);
        Iterator<Row> rowIterator = sheet1.iterator();
        rowIterator.next();
        while (rowIterator.hasNext()) {
            Row currentRow = rowIterator.next();
            Student student = new Student();
            students.add(student);
            student.setUniversityId(currentRow.getCell(0).getStringCellValue());
            student.setFullName(currentRow.getCell(1).getStringCellValue());
            student.setCurrentCourseNumber((int) currentRow.getCell(2).getNumericCellValue());
            student.setAvgExamScore((float) currentRow.getCell(3).getNumericCellValue());
        }
        fis.close();
        return students;
    }

    public List<University> readUniversities() throws IOException {
        List<University> universities = new ArrayList<>();
        XSSFSheet sheet2 = wb.getSheetAt(1);
        Iterator<Row> rowIterator = sheet2.iterator();
        rowIterator.next();
        while (rowIterator.hasNext()) {
            Row currentRow = rowIterator.next();
            University university = new University();
            universities.add(university);
            university.setId(currentRow.getCell(0).getStringCellValue());
            university.setFullName(currentRow.getCell(1).getStringCellValue());
            university.setShortName(currentRow.getCell(2).getStringCellValue());
            university.setYearOfFoundation((int) currentRow.getCell(3).getNumericCellValue());
            university.setMainProfile(StudyProfile.valueOf(StudyProfile.class, currentRow.getCell(4).getStringCellValue()));
        }
        fis.close();
        return universities;
    }
}