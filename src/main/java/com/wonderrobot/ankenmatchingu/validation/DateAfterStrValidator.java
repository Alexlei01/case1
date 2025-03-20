package com.wonderrobot.ankenmatchingu.validation;

// DateAfterStrValidator.vm
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.wonderfulfly.core.util.StringUtil;

/**
 * Validator datetime string validation
 */
public class DateAfterStrValidator implements ConstraintValidator<DateAfterStr, String> {

    private DateAfterStr dateStr;

    @Override
    public void initialize(DateAfterStr dateStr) {
        this.dateStr = dateStr;
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        // value If it is empty, no format validation will be performed，
        // Null validation can be done using @NotBlank @NotNull @NotEmpty
        if (StringUtil.isNullOrBlank(value)) {
            return true;
        }

        // Verify length
        String format = dateStr.format();
        if (value.length() != format.length()) {
            return false;
        }

        try {

            // validation format
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(dateStr.format());

            LocalDate inputDate = LocalDate.parse(value, formatter);

            LocalDate currentDate = LocalDate.now();

            return inputDate.isAfter(currentDate);

        } catch (Exception e) {
            return false;
        }
    }
}
