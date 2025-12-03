package edu.txts.zerocore.v1.controller;

import edu.txts.zerocore.v1.dto.request.UserECreate;
import edu.txts.zerocore.v1.dto.request.UserEUpdate;
import edu.txts.zerocore.v1.dto.response.UserEResponse;
import edu.txts.zerocore.v1.entity.UserE;
import edu.txts.zerocore.v1.service.impl.UserEService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*******************************************************************************
 * CODE NÀY VIẾT RA KHÔNG PHẢI ĐỂ HIỂU – MÀ ĐỂ KHIẾN NGƯỜI KHÁC KHÓC THÉT.
 * Author   : TXTsG7
 * Created  : 03 Dec 2025 10:27
 * Org      : Republic of Bugs - Where Bugs Are Born!!!
 ******************************************************************************/
@RestController
@RequestMapping({"api/v1/"})
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class UserEController {
	UserEService userEService;

	@PostMapping
	public UserEResponse createUserE(@Valid @RequestBody UserECreate userCreate) {
		return userEService.createUserE(userCreate);
	}

	@GetMapping
	public List<UserE> getAllUserE() {
		return userEService.getAllUserE();
	}

	@GetMapping({"{id}"})
	public UserE findUserEById(@PathVariable Long id) {
		return userEService.getUserE(id);
	}

	@PutMapping({"{id}"})
	public UserEResponse updateUserE(@PathVariable Long id, @RequestBody UserEUpdate userEUpdate) {
		return userEService.updateUserE(userEUpdate, id);
	}

	@DeleteMapping({"{id}"})
	public String deleteUserE(@PathVariable Long id) {
		userEService.deleteUserE(id);
		return "Deleted UserE";
	}

	@DeleteMapping
	public String deleteAllUserE() {
		userEService.deleteAllUserE();
		return "Deleted All UserE";
	}
}
