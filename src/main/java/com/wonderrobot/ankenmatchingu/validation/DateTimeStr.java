package com.wonderrobot.ankenmatchingu.validation;
// DateTimeStr.vm
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = DateTimeStrValidator.class)
public @interface DateTimeStr {
 
    String message() default "format incorrect";
 
    String format() default "yyyy-MM-dd HH:mm:ss";
 
    Class<?>[] groups() default {};
 
    Class<? extends Payload>[] payload() default {};
}
