package com.example.MJ_App_BE.controller;


import com.example.MJ_App_BE.data.dto.testdto.TestResponseDto;
import com.example.MJ_App_BE.service.TestService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
//@Tag(name = "테스트", description = "테스트 api입니다.")

@RequestMapping("/test")
@CrossOrigin(origins = "*")
public class TestController {

    private final TestService testService;

    @Autowired
    public TestController(TestService testService) {
        this.testService = testService;
    }

    @GetMapping(value = "/test/{id}")
    @Operation(summary = "청구정보 조회 메서드", description = "청구정보 조회 메서드입니다.")
    public ResponseEntity<TestResponseDto> getTest(
            @Parameter @PathVariable int id) {
        TestResponseDto testResponseDto = testService.getTest(id);

        return ResponseEntity.status(HttpStatus.OK).body(testResponseDto);
    }
}
