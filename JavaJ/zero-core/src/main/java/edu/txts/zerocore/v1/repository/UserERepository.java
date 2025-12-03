package edu.txts.zerocore.v1.repository;

import edu.txts.zerocore.v1.entity.UserE;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/*******************************************************************************
 * CODE NÀY VIẾT RA KHÔNG PHẢI ĐỂ HIỂU – MÀ ĐỂ KHIẾN NGƯỜI KHÁC KHÓC THÉT.
 * Author   : TXTsG7
 * Created  : 03 Dec 2025 09:54
 * Org      : Republic of Bugs - Where Bugs Are Born!!!
 ******************************************************************************/
@Repository
public interface UserERepository extends JpaRepository<UserE, Long> {
	boolean existsByUsername(String username);
}
