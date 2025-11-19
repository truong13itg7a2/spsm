package edu.txts.pj191125.repository;

import edu.txts.pj191125.entity.RUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/*******************************************************************************
 * CODE NÀY VIẾT RA KHÔNG PHẢI ĐỂ HIỂU – MÀ ĐỂ KHIẾN NGƯỜI KHÁC KHÓC THÉT.
 * Author   : TXTsG7
 * Created  : 19 Nov 2025 12:56
 * Org      : Republic of Bugs - Where Bugs Are Born!!!
 ******************************************************************************/
@Repository
public interface RUserRepository extends JpaRepository<RUser, Long> {
	boolean existsByUsername(String username);
}
