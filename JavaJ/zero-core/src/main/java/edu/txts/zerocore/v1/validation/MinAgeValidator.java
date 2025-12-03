package edu.txts.zerocore.v1.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.time.LocalDate;

/*******************************************************************************
 * CODE NÀY VIẾT RA KHÔNG PHẢI ĐỂ HIỂU – MÀ ĐỂ KHIẾN NGƯỜI KHÁC KHÓC THÉT.
 * Author   : TXTsG7
 * Created  : 03 Dec 2025 12:58
 * Org      : Republic of Bugs - Where Bugs Are Born!!!
 ******************************************************************************/

public class MinAgeValidator implements ConstraintValidator<MinAge, LocalDate> {

	private int minAge;

	@Override
	public void initialize(MinAge constraintAnnotation) {
		this.minAge = constraintAnnotation.value();
	}

	@Override
	public boolean isValid(LocalDate birthday, ConstraintValidatorContext context) {
		if (birthday == null) return true;

		return birthday
				.plusYears(minAge)
				.isBefore(LocalDate.now()) ||
				birthday.plusYears(minAge).isEqual(LocalDate.now());
	}
}

