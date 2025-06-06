package com.goormthon.memo_study.service;

import com.goormthon.memo_study.dto.MemoRequestDto;
import com.goormthon.memo_study.entity.Memo;
import com.goormthon.memo_study.error.CustomException;
import com.goormthon.memo_study.repository.MemoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.goormthon.memo_study.error.ErrorCode.*;


@Service
@RequiredArgsConstructor
public class MemoService {

    private final MemoRepository memoRepository;

    // 메모 생성
    @Transactional
    public Memo createMemo(MemoRequestDto memoRequestDto) {
        Memo memo = new Memo(memoRequestDto.getTitle(), memoRequestDto.getContent());
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
        if (!memoRepository.existsById(id)) {
            throw new CustomException(MEMO_NOT_FOUND);
        }

        return memoRepository.findById(id).get();
    }

    // 메모 수정
    @Transactional
    public Memo updateMemo(Long id, MemoRequestDto memoRequestDto) {
        if (!memoRepository.existsById(id)) {
            throw new CustomException(MEMO_NOT_FOUND);
        }

        Memo memo = getMemoById(id);
        memo.update(memoRequestDto.getTitle(), memoRequestDto.getContent());
        return memoRepository.save(memo);
    }

    // 메모 삭제
    @Transactional
    public void deleteMemo(Long id) {
        if (!memoRepository.existsById(id)) {
            throw new CustomException(MEMO_NOT_FOUND);
        }
        Memo memo = getMemoById(id);
        memoRepository.delete(memo);
    }
}
