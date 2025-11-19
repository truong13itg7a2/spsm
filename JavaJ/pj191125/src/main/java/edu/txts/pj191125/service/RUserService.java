package edu.txts.pj191125.service;

import edu.txts.pj191125.dto.request.UserCreate;
import edu.txts.pj191125.dto.request.UserUpdate;
import edu.txts.pj191125.dto.response.UserResponse;
import edu.txts.pj191125.entity.RUser;
import edu.txts.pj191125.exception.AppException;
import edu.txts.pj191125.exception.ErrorCode;
import edu.txts.pj191125.mapper.RUserMapper;
import edu.txts.pj191125.repository.RUserRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

/*******************************************************************************
 * CODE NÀY VIẾT RA KHÔNG PHẢI ĐỂ HIỂU – MÀ ĐỂ KHIẾN NGƯỜI KHÁC KHÓC THÉT.
 * Author   : TXTsG7
 * Created  : 19 Nov 2025 12:56
 * Org      : Republic of Bugs - Where Bugs Are Born!!!
 ******************************************************************************/
@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class RUserService {
	RUserRepository repo;
	RUserMapper mapper;

	public UserResponse createRUser(UserCreate create) {

		if (repo.existsByUsername(create.getUsername())) {
			throw new RuntimeException("Username already exists");
		}
		RUser rUser = mapper.toRUser(create);
		return mapper.toUserResponse(repo.save(rUser));
	}

	public List<RUser> getAllRUsers() {
		return repo.findAll();
	}

	public RUser getRUserById(Long id) {
		return repo.findById(id).orElseThrow(() -> new AppException(ErrorCode.USER_NOT_FOUNDV2));
	}

	public UserResponse updateRUser(Long id, UserUpdate update) {
		RUser rUser = getRUserById(id);
		mapper.updateRUser(rUser, update);
		return mapper.toUserResponse(repo.save(rUser));
	}

	public void deleteRUserById(Long id) {
		repo.deleteById(id);
	}

	public void deleteAllRUsers() {
		repo.deleteAll();
	}
}
