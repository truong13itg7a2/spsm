package edu.txts.pj191125.controller;

import edu.txts.pj191125.dto.request.UserCreate;
import edu.txts.pj191125.dto.request.UserUpdate;
import edu.txts.pj191125.dto.response.UserResponse;
import edu.txts.pj191125.entity.RUser;
import edu.txts.pj191125.exception.ApiResponse;
import edu.txts.pj191125.exception.ResponseUtils;
import edu.txts.pj191125.service.RUserService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*******************************************************************************
 * CODE NÀY VIẾT RA KHÔNG PHẢI ĐỂ HIỂU – MÀ ĐỂ KHIẾN NGƯỜI KHÁC KHÓC THÉT.
 * Author   : TXTsG7
 * Created  : 19 Nov 2025 13:01
 * Org      : Republic of Bugs - Where Bugs Are Born!!!
 ******************************************************************************/
@RestController
@RequestMapping({"/api/v1"})
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class RUserController {
	RUserService userService;

	@PostMapping
	public ApiResponse<UserResponse> createUser(@RequestBody UserCreate user) {
		return ResponseUtils.success(userService.createRUser(user));
	}

	@GetMapping
	public ApiResponse<List<RUser>> getUsers() {
		return ResponseUtils.success(userService.getAllRUsers());
	}

	@GetMapping({"/{id}"})
	public ApiResponse<RUser> getUser(@PathVariable Long id) {
//		return ResponseEntity.ok(userService.getRUserById(id));
		return ResponseUtils.success(userService.getRUserById(id));
	}

	@PutMapping({"/{id}"})
	public ApiResponse<UserResponse> updateUser(@PathVariable Long id, @RequestBody UserUpdate user) {
		return ResponseUtils.success(userService.updateRUser(id, user));
	}

	@DeleteMapping({"/{id}"})
	public ApiResponse<String> deleteUser(@PathVariable Long id) {
		userService.deleteRUserById(id);
		return ResponseUtils.success("Delete user " + id);
	}

	@DeleteMapping
	public ApiResponse<String> deleteUsers() {
		userService.deleteAllRUsers();
		return ResponseUtils.success("Delete users");
	}

}
