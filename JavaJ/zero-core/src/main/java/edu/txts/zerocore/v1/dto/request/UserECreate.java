package edu.txts.zerocore.v1.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import edu.txts.zerocore.v1.validation.MinAge;
import jakarta.validation.constraints.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

/*******************************************************************************
 * CODE NÀY VIẾT RA KHÔNG PHẢI ĐỂ HIỂU – MÀ ĐỂ KHIẾN NGƯỜI KHÁC KHÓC THÉT.
 * Author   : TXTsG7
 * Created  : 03 Dec 2025 10:00
 * Org      : Republic of Bugs - Where Bugs Are Born!!!
 ******************************************************************************/

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserECreate {
	//	Long id;
	@NotBlank(message = "{user.fullname.not_blank}")
	String fullName;

	@NotBlank(message = "{user.username.not_blank}")
	@Size(min = 4, max = 30, message = "{user.username.size}")
	String username;


	@NotBlank(message = "{user.password.not_blank}")
	@Size(min = 6, max = 255, message = "{user.password.size}")
	@Pattern(
			regexp = "^(?=.*[A-Z])(?=.*\\W).{8,}$",
			message = "Mật khẩu phải có ít nhất 8 ký tự, một chữ hoa và ký tự đặc biệt!"
	)
	String password;

	@NotNull(message = "{user.birthday.not_null}")
	@Past(message = "{user.birthday.past}")
	@MinAge(value = 18, message = "{user.birthday.min_age}")
//	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	LocalDate birthday;

	@NotBlank(message = "{user.email.not_blank}")
	@Email(message = "{user.email.invalid}")
	String email;

	@Pattern(
			regexp = "^(\\+84|0)[0-9]{9}$",
			message = "{user.phone.invalid}"
	)
	private String phone;
}
