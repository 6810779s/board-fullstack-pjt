package board.pjt.back.controller;

import board.pjt.back.common.codes.SuccessCode;
import board.pjt.back.common.response.ApiResponse;
import board.pjt.back.dao.CategoryDao;
import board.pjt.back.dto.category.*;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {
    private final CategoryDao categoryDao;

    public CategoryController(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }

    @GetMapping("/")
    public ResponseEntity<ApiResponse<List<CategorySelectResponseDto>>> getCategoryList() {
        List<CategorySelectResponseDto> categoryList = categoryDao.selectAll();
        ApiResponse<List<CategorySelectResponseDto>> response = ApiResponse.of(SuccessCode.SELECT_SUCCESS, categoryList);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/detail")
    public ResponseEntity<ApiResponse<CategorySelectResponseDto>> getCategoryDetail(@RequestBody CategorySelectRequestDto requestDto) {
        CategorySelectResponseDto categoryDetail = categoryDao.select(requestDto);
        ApiResponse<CategorySelectResponseDto> response = ApiResponse.of(SuccessCode.SELECT_SUCCESS, categoryDetail);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/")
    public ResponseEntity<ApiResponse<Void>> createCategory(@AuthenticationPrincipal UserDetails userDetails, @RequestBody CategoryCreateRequestDto requestDto) {
        categoryDao.insert(userDetails, requestDto);
        ApiResponse<Void> response = ApiResponse.of(SuccessCode.INSERT_SUCCESS);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/")
    public ResponseEntity<ApiResponse<Void>> deleteCategory(@RequestBody CategoryDeleteRequestDto requestDto) {
        categoryDao.delete(requestDto);
        ApiResponse<Void> response = ApiResponse.of(SuccessCode.DELETE_SUCCESS);
        return ResponseEntity.ok(response);
    }

    @PatchMapping("/")
    public ResponseEntity<ApiResponse<Void>> updateCategory(@AuthenticationPrincipal UserDetails userDetails, @RequestBody CategoryUpdateRequestDto requestDto) {
        categoryDao.update(userDetails, requestDto);
        ApiResponse<Void> response = ApiResponse.of(SuccessCode.UPDATE_SUCCESS);
        return ResponseEntity.ok(response);
    }
}
