package pl.sdacademy.unit.test.advance.exercises.parametrized.csvsource;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PalindromeCheckerTest {

    @ParameterizedTest
    @CsvSource({
            "kajak, true",
            "Potop, true",
            "sedes, true",
            "kobyla ma maly bok, true",
            "java, false",
            "programowanie, false"})
    void shouldVerifyIfWordIsPalindrome(String input, boolean expectedResult) {
        //when
        boolean result = PalindromeChecker.isPalindrome(input);
        //then
        assertEquals(expectedResult, result); //Junit
        assertThat(result).isEqualTo(expectedResult); //assertJ
    }

    @ParameterizedTest
    @CsvFileSource(
            resources = "/palindrome.csv",
            delimiter = '|',
            numLinesToSkip = 1)
    void shouldVerifyIfWordIsPalindromeUsingCsvFileSource(String input, boolean expectedResult) {
        //when
        boolean result = PalindromeChecker.isPalindrome(input);
        //then
        assertEquals(expectedResult, result); //Junit
        assertThat(result).isEqualTo(expectedResult); //assertJ
    }

// poprzez CsvSource nie możemy przekazać własnego obiektu, ale możemy przekazać pola/skladowe tego obiektu
// i stworzyc ten obiekt 'recznie' w tescie, w sekcji given
//    @ParameterizedTest
//    @CsvSource({
//            "1, pawel, 16, false",
//            "2, jan, 100, true"
//    })
//    void test1(int id, String name, int age, boolean expectedResult){
//        //given
//        Person person = new Person(id, name, age);
//        //when
//        result = isValid(person);
//        //then
//        assertEquals(expectedResult, result); //Junit
//        assertThat(result).isEqualTo(expectedResult); //assertJ
//    }

}