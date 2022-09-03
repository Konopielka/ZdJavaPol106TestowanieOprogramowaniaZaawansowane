package pl.sdacademy.unit.test.advance.exercises.parametrized.valuesource;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class StringUtilTest {

    @ParameterizedTest
    @ValueSource(strings={"", " ", "    "})
    void shouldReturnTrueIfStringIsBlank(String input){
        //when
        boolean result = StringUtil.isBlank(input);
        //then
        assertTrue(result);  //Junit
        assertThat(result).isTrue(); //assertJ
    }

    @ParameterizedTest
    @ValueSource(strings = {"sda", " sda", "sda ", " sda "})
        void shouldReturnFalseIfStringIsNotEmpty(String value){
            //when
        boolean result = StringUtil.isBlank(value);
        //then
        assertFalse(result);//Junit
        assertThat(result).isFalse();//assertJ
    }

    @Test
    void shouldReturnTrueIfStringIsNull(){
        //when
        boolean result = StringUtil.isBlank(null);
        //then
        assertTrue(result);
        assertThat(result).isTrue();
    }
}