package com.goormthon.memo_study.service;

import com.goormthon.memo_study.entity.Memo;
import com.goormthon.memo_study.repository.MemoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@RequiredArgsConstructor
public class MemoService {

    private final MemoRepository memoRepository;

    // 메모 생성
    @Transactional
    public Memo createMemo(Memo memo) {
        return memoRepository.save(memo);
    }

    // 모든 메모 조회
    @Transactional(readOnly = true)
    public List<Memo> getAllMemos() {
        return memoRepository.findAll();
    }

    // 특정 메모 조회
    @Transactional(readOnly = true)
    public Memo getMemoById(Long id) {
        return memoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("메모를 찾을 수 없습니다. ID: " + id));
    }

    // 메모 수정
    @Transactional
    public Memo updateMemo(Long id, Memo newMemo) {
        Memo memo = getMemoById(id);
        memo.update(newMemo.getTitle(), newMemo.getContent());
        return memoRepository.save(memo);
    }

    // 메모 삭제
    @Transactional
    public void deleteMemo(Long id) {
        Memo memo = getMemoById(id);
        memoRepository.delete(memo);
    }
}
