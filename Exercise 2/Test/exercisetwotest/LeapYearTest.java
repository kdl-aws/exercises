package exercisetwotest;

import exercisetwo.LeapYear;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Random;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LeapYearTest {
    @DisplayName("Divisible by 400")
    @Test
    void testIsLeapYear_DivisibleByFourHundred_ShouldReturnTrue() {
        int yearTwoThousand = 2000;
        LeapYear twoThousand = new LeapYear(yearTwoThousand);
        boolean expectedResult = true;
        
        boolean leapYearCheck = twoThousand.isLeapYear();
        
        assertEquals(expectedResult, leapYearCheck, () -> "2000 is not a leap year.");
    }
    
    @DisplayName("Divisible by 100 but not 400")
    @Test
    void testIsLeapYear_DivisibleByOneHundredButNotFourHundred_ShouldReturnFalse() {
        int yearNineteenHundred = 1900;
        LeapYear nineteenHundred = new LeapYear(yearNineteenHundred);
        boolean expectedResult = false;
        
        boolean leapYearCheck = nineteenHundred.isLeapYear();
        
        assertEquals(expectedResult, leapYearCheck, () -> "1900 is a leap year.");
    }
    
    @DisplayName("Divisible by 4 but not 100")
    @Test
    void testIsLeapYear_DivisibleByFourButNotOneHundred_ShouldReturnTrue() {
        int yearTwoThousandFour = 2004;
        LeapYear twoThousandFour = new LeapYear(yearTwoThousandFour);
        boolean expectedResult = true;
        
        boolean leapYearCheck = twoThousandFour.isLeapYear();
        
        assertEquals(expectedResult, leapYearCheck, () -> "2004 is not a leap year.");
    }

    @DisplayName("Not Divisible by 4")
    @Test
    void testIsLeapYear_NotDivisibleByFour_ShouldReturnFalse() {
        int yearTwentyTen = 2010;
        LeapYear twentyTen = new LeapYear(yearTwentyTen);
        boolean expectedResult = false;
        
        boolean leapYearCheck = twentyTen.isLeapYear();
        
        assertEquals(expectedResult, leapYearCheck, () -> "2010 is a leap year.");
    }
    
    @DisplayName("Random Leap Year")
    @Test
    void testIsLeapYear_RandomLeapYear_ShouldReturnTrue() {
        Random rng = new Random();
        int arrIndex = rng.nextInt(5);
        int[] yearArr = {2000, 2004, 1976, 1992, 2012};
        int seededYear = yearArr[arrIndex];
        LeapYear leapYear = new LeapYear(seededYear);
        System.out.println(seededYear);
        boolean expectedResult = true;
        
        boolean leapYearCheck = leapYear.isLeapYear();
        
        assertEquals(expectedResult, leapYearCheck, () -> "It was not a leap year.");
    }
    
    @DisplayName("Random Non Leap Year")
    @Test
    void testIsLeapYear_RandomNonLeapYear_ShouldReturnFalse() {
        Random rng = new Random();
        int arrIndex = rng.nextInt(5);
        int[] yearArr = {1900, 1995, 1970, 2009, 2017};
        int seededYear = yearArr[arrIndex];
        LeapYear leapYear = new LeapYear(seededYear);
        System.out.println(seededYear);
        boolean expectedResult = false;
        
        boolean leapYearCheck = leapYear.isLeapYear();
        
        assertEquals(expectedResult, leapYearCheck, () -> "It was a leap year.");
    }
    
    @DisplayName("Test Getter")
    @Test
    void testGetYear_GetCurrentYear_ShouldBeEqual() {
        int yearNineteenHundred = 1900;
        LeapYear nineteenHundred = new LeapYear(yearNineteenHundred);
        
        int retrievedYear = nineteenHundred.getYear();
        
        assertEquals(yearNineteenHundred, retrievedYear, 
                () -> "Retrieved year is not the same as the year passed to the constructor!");
    }

    @Test
    void testMainFunction_ReturnsVoid() {
        LeapYear.main(null);
    }
}
