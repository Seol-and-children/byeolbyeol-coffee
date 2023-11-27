package com.seolandfriends.byeolbyeolcoffee.user.command.application.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.seolandfriends.byeolbyeolcoffee.common.ResponseDTO;
import com.seolandfriends.byeolbyeolcoffee.user.command.application.dto.TokenDTO;
import com.seolandfriends.byeolbyeolcoffee.user.command.application.dto.UserDTO;
import com.seolandfriends.byeolbyeolcoffee.user.command.domain.service.AuthService;

import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RestController
@RequestMapping("/users")
public class AuthController {

	private final AuthService authService;

	public AuthController(AuthService authService){
		this.authService = authService;
	}

	@ApiOperation(value = "회원 가입 요청", notes = "회원 가입이 진행됩니다.", tags = {"AuthController"})
	@PostMapping("/signup")
	public ResponseEntity<ResponseDTO> signup(@RequestBody UserDTO userDTO){
		return ResponseEntity
			.ok()
			.body(new ResponseDTO(HttpStatus.CREATED, "회원가입 성공", authService.signup(userDTO)));

	}

	@PostMapping("/login")
	public ResponseEntity<ResponseDTO> login(@RequestBody UserDTO userDTO) {
		TokenDTO tokenDTO = authService.login(userDTO);
		String accessToken = tokenDTO.getAccessToken();
		return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "로그인 성공", accessToken));
	}

	@PostMapping("/logout")
	public ResponseEntity<ResponseDTO> logout() {
		/* 로그아웃 로직 블랙리스트 처리 */
		return ResponseEntity.ok(new ResponseDTO(HttpStatus.OK, "로그아웃 되었습니다.", null));
	}

}