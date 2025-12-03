package edu.txts.zerocore.v1.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.proxy.HibernateProxy;

import java.time.LocalDate;
import java.util.Objects;

/*******************************************************************************
 * CODE NÀY VIẾT RA KHÔNG PHẢI ĐỂ HIỂU – MÀ ĐỂ KHIẾN NGƯỜI KHÁC KHÓC THÉT.
 * Author   : TXTsG7
 * Created  : 03 Dec 2025 09:26
 * Org      : Republic of Bugs - Where Bugs Are Born!!!
 ******************************************************************************/
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@ToString
public class UserE {
	@Id
			@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	String fullName;
	String username;
	String password;
	LocalDate birthday;
	String email;
	String phone;

	@Override
	public final boolean equals(Object o) {
		if (this == o) return true;
		if (o == null) return false;
		Class<?> oEffectiveClass = o instanceof HibernateProxy ?
				((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
		Class<?> thisEffectiveClass = this instanceof HibernateProxy ?
				((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() :
				this.getClass();
		if (thisEffectiveClass != oEffectiveClass) return false;
		UserE userE = (UserE) o;
		return getId() != null && Objects.equals(getId(), userE.getId());
	}

	@Override
	public final int hashCode() {
		return this instanceof HibernateProxy ?
				((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() :
				getClass().hashCode();
	}
}
