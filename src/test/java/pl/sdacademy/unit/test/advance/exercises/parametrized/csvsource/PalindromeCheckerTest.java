package pl.sdacademy.unit.test.advance.exercises.parametrized.csvsource;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PalindromeCheckerTest {

    @ParameterizedTest
    @CsvSource({"kajak, true", "kamil ślimak, true", "Potop, true", "sedes, true",
    "kobyla ma maly bok, true", "java, false", "programowanie, false"})
    void shouldVerifyIfWordIsPalindrome(String input, boolean expectedResult){
        //when
        boolean result = PalindromeChecker.isPalindrome(input);
        //then
        assertEquals(expectedResult, result);//Junit
        assertThat(result).isEqualTo(expectedResult);//assertJ
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/palindrome.csv",
                    delimiter ='|',
                    numLinesToSkip = 1)
    void shouldVerifyIfWordIsPalindromeUsingCsvFileSource(String input, boolean expectedResult){
        //when
        boolean result = PalindromeChecker.isPalindrome(input);
        //then
        assertEquals(expectedResult, result);//Junit
        assertThat(result).isEqualTo(expectedResult);//assertJ
    }

}