package pl.sdacademy.unit.test.advance.exercises.parametrized.task5;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class PasswordResetServiceTest {

    @Mock
    private PasswordProvider passwordProvider;

    @Mock
    private DateTimeProvider dateTimeProvider;

    @InjectMocks
    private PasswordResetService passwordResetService;

    @Test
    void shouldGenerateCorrectEmailBodyMessage(){

        //given
        LocalDateTime mockedDateTime = LocalDateTime.of(2022, 8, 15, 10, 15,02);
        Mockito.when(dateTimeProvider.currentDateTime()).thenReturn(mockedDateTime);
        Mockito.when(passwordProvider.generateNewPassword()).thenReturn("admin1234");
        String expectedResult = "Twoje tymczasowe hasło wygenerowane dnia 2022-08-15 o godzinie 10:15:02 to admin1234";
            //when
        String result = passwordResetService.generateEmailBodyMessage();
        //then
        assertEquals(expectedResult, result);//JUnit
        assertThat(result).isEqualTo(expectedResult);//assertJ

    }

}