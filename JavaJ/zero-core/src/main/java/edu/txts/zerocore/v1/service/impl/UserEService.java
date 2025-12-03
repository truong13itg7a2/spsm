package edu.txts.zerocore.v1.service.impl;

import edu.txts.zerocore.v1.dto.request.UserECreate;
import edu.txts.zerocore.v1.dto.request.UserEUpdate;
import edu.txts.zerocore.v1.dto.response.UserEResponse;
import edu.txts.zerocore.v1.entity.UserE;
import edu.txts.zerocore.v1.mapper.UserEMapper;
import edu.txts.zerocore.v1.repository.UserERepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.security.PublicKey;
import java.util.List;

/*******************************************************************************
 * CODE NÀY VIẾT RA KHÔNG PHẢI ĐỂ HIỂU – MÀ ĐỂ KHIẾN NGƯỜI KHÁC KHÓC THÉT.
 * Author   : TXTsG7
 * Created  : 03 Dec 2025 09:53
 * Org      : Republic of Bugs - Where Bugs Are Born!!!
 ******************************************************************************/
@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class UserEService {
	UserERepository userERepository;
	UserEMapper userEMapper;

	public UserEResponse createUserE(UserECreate userECreate) {
		if (userERepository.existsByUsername(userECreate.getUsername())) {
			throw new RuntimeException("Username already exists");
		}
		/*if (userRepository.existsByEmail(request.getEmail())) {
			throw new BusinessException("error.email.duplicate");
		}

		if (userRepository.existsByUsername(request.getUsername())) {
			throw new BusinessException("error.username.duplicate");
		}*/

		UserE userE = userEMapper.toUserE(userECreate);
		userERepository.saveAndFlush(userE);
		return userEMapper.toUserEResponse(userE);
	}

	public List<UserE> getAllUserE() {
		return userERepository.findAll();
	}

	public UserE getUserE(Long id) {
		return userERepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
	}

	public UserEResponse updateUserE(UserEUpdate userEUpdate, Long id) {
		UserE userE = getUserE(id);
		userEMapper.updateUserE(userE, userEUpdate);
		userERepository.saveAndFlush(userE);
		return userEMapper.toUserEResponse(userE);
	}

	public void deleteUserE(Long id) {
		userERepository.deleteById(id);
	}

	public void deleteAllUserE() {
		userERepository.deleteAll();
	}

}
