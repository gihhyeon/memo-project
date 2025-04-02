package com.goormthon.memo_study.controller;

import com.goormthon.memo_study.dto.MemoRequestDto;
import com.goormthon.memo_study.dto.MemoResponseDto;
import com.goormthon.memo_study.entity.Memo;
import com.goormthon.memo_study.service.MemoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class MemoController {

    private final MemoService memoService;

    // 메모 생성
    @PostMapping("/memos")
    public ResponseEntity<Memo> createMemo(@RequestBody Memo memo) {
        Memo createdMemo = memoService.createMemo(memo);
        return ResponseEntity.ok(createdMemo);
    }

    // 모든 메모 조회
    @GetMapping("/memos")
    public ResponseEntity<List<Memo>> getAllMemos() {
        return ResponseEntity.ok(memoService.getAllMemos());
    }

    // 특정 메모 조회
    @GetMapping("/memos/{id}")
    public ResponseEntity<Memo> getMemoById(@PathVariable Long id) {
        return ResponseEntity.ok(memoService.getMemoById(id));
    }

    // 메모 수정
    @PutMapping("/memos/{id}")
    public ResponseEntity<Memo> updateMemo(@PathVariable Long id, @RequestBody Memo memo) {
        return ResponseEntity.ok(memoService.updateMemo(id, memo));
    }

    // 메모 삭제
    @DeleteMapping("/memos/{id}")
    public ResponseEntity<Void> deleteMemo(@PathVariable Long id) {
        memoService.deleteMemo(id);
        return ResponseEntity.noContent().build();
    }

}
