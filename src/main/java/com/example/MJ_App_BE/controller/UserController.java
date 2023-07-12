package com.example.MJ_App_BE.controller;


import com.example.MJ_App_BE.data.dto.userdto.ChangeUserYearDto;
import com.example.MJ_App_BE.data.dto.userdto.UserDto;
import com.example.MJ_App_BE.data.dto.userdto.UserResponseDto;
import com.example.MJ_App_BE.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Tag(name = "user", description = "user api입니다.")

@RequestMapping("/user")
@CrossOrigin(origins = "*")

public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/user/{id}")
    @Operation(summary = "기기정보 조회 메서드", description = "기기정보 조회 메서드입니다.")
    public ResponseEntity<UserResponseDto> getTest(
            @Parameter @PathVariable int id) {
        UserResponseDto userResponseDto = userService.getUser(id);

        return ResponseEntity.status(HttpStatus.OK).body(userResponseDto);
    }

    @PostMapping(value = "/user/register")
    @Operation(summary = "기기정보 등록 메서드", description = "기기정보 등록 메서드입니다.")
    public ResponseEntity<UserResponseDto> createUser(@RequestBody UserDto userDto) {
        UserResponseDto userResponseDto = userService.saveUser(userDto);

        return ResponseEntity.status(HttpStatus.OK).body(userResponseDto);
    }

    @PutMapping(value = "/user/modifyYear")
    @Operation(summary = "기기정보 수정 메서드", description = "기기정보 수정 메서드입니다.")
    public ResponseEntity<UserResponseDto> changeUserYear(
            @RequestBody ChangeUserYearDto changeUserYearDto) throws Exception{
        UserResponseDto userResponseDto = userService.changeUserYear(
                changeUserYearDto.getUserId(),
                changeUserYearDto.getYear()
        );

        return ResponseEntity.status(HttpStatus.OK).body(userResponseDto);
    }

    @DeleteMapping(value = "/user/deletion/{id}")
    @CrossOrigin(origins = "http://localhost:3000")
    @Operation(summary = "회원 정보 삭제 메서드", description = "회원정보 삭제 메서드입니다.")
    public ResponseEntity<String> deleteUser(
            @Parameter @PathVariable
            int id) throws Exception{
        userService.deleteUser(id);

        return ResponseEntity.status(HttpStatus.OK).body("DELETE SUCCESSFULLY :)");
    }
}
