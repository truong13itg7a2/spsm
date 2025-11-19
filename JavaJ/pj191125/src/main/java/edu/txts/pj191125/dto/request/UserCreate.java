package edu.txts.pj191125.dto.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

/*******************************************************************************
 * CODE NÀY VIẾT RA KHÔNG PHẢI ĐỂ HIỂU – MÀ ĐỂ KHIẾN NGƯỜI KHÁC KHÓC THÉT.
 * Author   : TXTsG7
 * Created  : 19 Nov 2025 12:47
 * Org      : Republic of Bugs - Where Bugs Are Born!!!
 ******************************************************************************/
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserCreate {
	String fullName;
	String username;
	String password;
}
