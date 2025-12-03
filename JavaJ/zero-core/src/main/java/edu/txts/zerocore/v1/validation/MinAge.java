package edu.txts.zerocore.v1.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/*******************************************************************************
 * CODE NÀY VIẾT RA KHÔNG PHẢI ĐỂ HIỂU – MÀ ĐỂ KHIẾN NGƯỜI KHÁC KHÓC THÉT.
 * Author   : TXTsG7
 * Created  : 03 Dec 2025 12:57
 * Org      : Republic of Bugs - Where Bugs Are Born!!!
 ******************************************************************************/

@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = MinAgeValidator.class)
public @interface MinAge {

	String message() default "Tuổi không hợp lệ";
	int value();

	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};
}

