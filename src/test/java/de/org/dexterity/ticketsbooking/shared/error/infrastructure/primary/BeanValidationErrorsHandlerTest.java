package de.org.dexterity.ticketsbooking.shared.error.infrastructure.primary;

import static org.mockito.Mockito.*;

import ch.qos.logback.classic.Level;
import de.org.dexterity.ticketsbooking.Logs;
import de.org.dexterity.ticketsbooking.LogsSpy;
import de.org.dexterity.ticketsbooking.LogsSpyExtension;
import de.org.dexterity.ticketsbooking.UnitTest;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validation;
import jakarta.validation.constraints.NotNull;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.core.MethodParameter;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;

@UnitTest
@ExtendWith(LogsSpyExtension.class)
class BeanValidationErrorsHandlerTest {

    private static final BeanValidationErrorsHandler handler = new BeanValidationErrorsHandler();

    @Logs
    private LogsSpy logs;

    @Test
    void shouldLogMethodArgumentNotValidInInfo() throws NoSuchMethodException, SecurityException {
        handler.handleMethodArgumentNotValid(
            new MethodArgumentNotValidException(
                new MethodParameter(BeanValidationErrorsHandlerTest.class.getMethod("failingMethod"), -1),
                mock(BindingResult.class)
            )
        );

        logs.shouldHave(Level.INFO, "failingMethod");
    }

    public void failingMethod() {
        // empty method
    }

    @Test
    void shouldLogConstraintViolationInInfo() throws SecurityException {
        handler.handleConstraintViolationException(
            new ConstraintViolationException(Validation.buildDefaultValidatorFactory().getValidator().validate(new ValidatedBean()))
        );

        logs.shouldHave(Level.INFO, "parameter");
    }

    static class ValidatedBean {

        @NotNull
        private String parameter;
    }
}
