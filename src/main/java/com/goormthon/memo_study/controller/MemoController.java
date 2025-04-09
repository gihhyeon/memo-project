package com.goormthon.memo_study.controller;


import com.goormthon.memo_study.dto.MemoRequestDto;
import com.goormthon.memo_study.entity.Memo;
import com.goormthon.memo_study.service.MemoService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/memos")
public class MemoController {

    private final MemoService memoService;

    // 메모 생성
    @PostMapping(produces = "application/json")
    @Operation(summary = "메모 등록", description = "새로운 메모를 등록할 때 사용하는 API")
    public ResponseEntity<Memo> createMemo(@RequestBody @Validated MemoRequestDto memoRequestDto) {
        Memo createdMemo = memoService.createMemo(memoRequestDto);
        return ResponseEntity.ok(createdMemo);
    }

    // 모든 메모 조회
    @GetMapping(produces = "application/json")
    @Operation(summary = "모든 메모 조회", description = "저장된 모든 메모를 조회하는 API")
    public ResponseEntity<List<Memo>> getAllMemos() {
        return ResponseEntity.ok(memoService.getAllMemos());
    }

    // 특정 메모 조회
    @GetMapping(value = "/{id}", produces = "application/json")
    @Operation(summary = "특정 메모 조회", description = "id로 특정 메모를 조회하는 API")
    public ResponseEntity<Memo> getMemoById(@PathVariable Long id) {
        return ResponseEntity.ok(memoService.getMemoById(id));
    }

    // 메모 수정
    @PutMapping(value = "/{id}", produces = "application/json")
    @Operation(summary = "메모 수정", description = "id로 특정 메모를 수정하는 API")
    public ResponseEntity<Memo> updateMemo(@PathVariable Long id, @RequestBody @Validated MemoRequestDto memoRequestDto) {
        return ResponseEntity.ok(memoService.updateMemo(id, memoRequestDto));
    }

    // 메모 삭제
    @DeleteMapping("/{id}")
    @Operation(summary = "메모 삭제", description = "id로 특정 메모를 삭제하는 API")
    public ResponseEntity<Void> deleteMemo(@PathVariable Long id) {
        memoService.deleteMemo(id);
        return ResponseEntity.noContent().build();
    }

}
