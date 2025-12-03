package edu.txts.zerocore.v1.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

/*******************************************************************************
 * CODE NÀY VIẾT RA KHÔNG PHẢI ĐỂ HIỂU – MÀ ĐỂ KHIẾN NGƯỜI KHÁC KHÓC THÉT.
 * Author   : TXTsG7
 * Created  : 03 Dec 2025 09:59
 * Org      : Republic of Bugs - Where Bugs Are Born!!!
 ******************************************************************************/
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserEResponse {
	Long id;
	String fullName;
	String username;
	String password;
	LocalDate birthday;
}
