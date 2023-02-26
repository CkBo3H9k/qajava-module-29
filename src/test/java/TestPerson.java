import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


import static org.testng.Assert.assertEquals;

public class TestPerson {

    {
    }

    public void currentTime() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        System.out.println(dtf.format(now));
    }

    @BeforeClass
    void beforeClass() {
        System.out.print("The test started in: ");
        currentTime();
    }

    @AfterClass()
    void afterClass() {
        System.out.print("The test is finished in: ");
        currentTime();
    }

    @DataProvider(name = "ageProvider")
    Object[][] AgeTest() {
        return new Object[][] {
                {-1, false},
                {0, false},
                {12, false},
                {13,true},
                {15,true},
                {18,true},
                {19,true},
                {20,false}
        };
    }

    @Test(dataProvider = "ageProvider")
    void personIsTeenagerTest(int age, boolean expected) {
        boolean result = Person.isTeenager(age);
        System.out.println("Для возраста " + age + ": " + "Результат: " + result + " / " + "Ожидаемый результат: " + expected);
        assertEquals(result, expected);
    }
}