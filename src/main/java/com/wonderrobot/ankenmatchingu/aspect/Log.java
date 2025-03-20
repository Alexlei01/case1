package com.wonderrobot.ankenmatchingu.aspect;
// Log.vm
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Custom operation logging notes
 */
@Target({ ElementType.PARAMETER, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Log {

    /**
     * modular
     */
    public String title() default "";

    /**
     * function
     */
    public BusinessType businessType() default BusinessType.OTHER;

    /**
     * Operator category
     */
    public OperatorType operatorType() default OperatorType.MANAGE;
}