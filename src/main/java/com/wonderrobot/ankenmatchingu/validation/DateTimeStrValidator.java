package com.wonderrobot.ankenmatchingu.validation;
// DateTimeStrValidator.vm
import java.time.format.DateTimeFormatter;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.wonderfulfly.core.util.StringUtil;

/**
 * Validator datetime string validation
 */
public class DateTimeStrValidator implements ConstraintValidator<DateTimeStr, String> {
    
    private DateTimeStr dateTimeStr;

    @Override
    public void initialize(DateTimeStr dateTimeStr) {
        this.dateTimeStr = dateTimeStr;
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
    	
    	
    	int year = 0;//years
    	int month = 0;//month
    	int day = 0;//number of days
    	
    	// value If it is empty, no format validation will be performed，
    	// Null validation can be done using @NotBlank @NotNull @NotEmpty 
        if (StringUtil.isNullOrBlank(value)) {
            return true;
        }
       
        // Verify length
        String format = dateTimeStr.format();
        if (value.length() != format.length()) {
            return false;
        }
        
        // validation format
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(dateTimeStr.format());

        try {
        	
	        dtf.parse(value);
	        
	        if("YYYY/MM".equals(format)){
	        	year = Integer.parseInt(value.split("/")[0]);
	        	month = Integer.parseInt(value.split("/")[1]);
	        	return checkMonthAndDay(year,month,day);
	        }else if("YYYY-MM".equals(format)){
	        	year = Integer.parseInt(value.split("-")[0]);
	        	month = Integer.parseInt(value.split("-")[1]);
	        	return checkMonthAndDay(year,month,day);
	        }else if("YYYY.MM".equals(format)){
	        	year = Integer.parseInt(value.split("\\.")[0]);
	        	month = Integer.parseInt(value.split("\\.")[1]);
	        	return checkMonthAndDay(year,month,day);
	        }else if("MM-DD".equals(format)){
	        	month = Integer.parseInt(value.split("-")[0]);
	        	day = Integer.parseInt(value.split("-")[1]);
	        	return checkMonthAndDay(year,month,day);
	        }else if("MM.DD".equals(format)){
	        	month = Integer.parseInt(value.split("\\.")[0]);
	        	day = Integer.parseInt(value.split("\\.")[1]);
	        	return checkMonthAndDay(year,month,day);
	        }
        } catch (Exception e){
            return false;
        }
        return true;
    }
    
    public boolean checkMonthAndDay(int year,int month,int day) {
    	if (year < 1 && year != 0) {//Check year format
			return false;
		}
    	if (month < 1 || month > 12) {//Check month format
			return false;
		}
		if ((month == 4 || month == 6 || month == 9 || month == 11) &&(day == 31)) {//Whether the maximum number of days in April, June, September, and November is 30 days
			return false;
		}
		if(day > 0) {
			if (day < 1 || day > 31) {//Check the number of days format
				return false;
			}
			boolean leap=false;
			if (month == 2) {//February has 29 days in leap years and 28 days in normal years
				leap = (year % 4 == 0 &&(year % 100 != 0 || year % 400 == 0));
				if (day>29 || (day == 29 && !leap)) {
					return false;
				}
			}
		}
    	return true;
    }
}
