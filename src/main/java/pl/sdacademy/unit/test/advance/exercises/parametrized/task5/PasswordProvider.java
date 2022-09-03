package pl.sdacademy.unit.test.advance.exercises.parametrized.task5;

import java.util.UUID;

public class PasswordProvider {
    public String generateNewPassword(){
        return UUID.randomUUID().toString();
    }
}
