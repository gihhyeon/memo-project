package com.goormthon.memo_study.service;

import com.goormthon.memo_study.dto.MemoRequestDto;
import com.goormthon.memo_study.entity.Memo;
import com.goormthon.memo_study.repository.MemoRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class MemoServiceTest {

    @Mock   // 가짜 객체를 만들어 반환해주는 어노테이션
    private MemoRepository memoRepository;

    @InjectMocks    // 가짜 객체를 자동으로 주입시켜주는 어노테이션
    private MemoService memoService;

    @Test
    @DisplayName("메모 생성 성공 테스트")
    void createMemo() {
        // given(준비): 어떠한 데이터가 준비되었을 때
        MemoRequestDto requestDto = new MemoRequestDto("테스트 제목", "테스트 내용");
        Memo savedMemo = new Memo(requestDto.getTitle(), requestDto.getContent());

        when(memoRepository.save(any(Memo.class))).thenReturn(savedMemo); // Mock 설정

        // when(실행): 어떠한 함수를 실행하면
        Memo result = memoService.createMemo(requestDto);

        // then(검증): 어떠한 결과가 나와야 한다.
        assertThat(result).isNotNull();
        assertThat(result.getTitle()).isEqualTo("테스트 제목");
        assertThat(result.getContent()).isEqualTo("테스트 내용");

    }

    @Test
    @DisplayName("특정 메모 조회 테스트")
    void getMemoById() {
        // given: 테스트할 메모 ID와 해당 메모 객체 준비
        Long memoId = 1L;
        Memo memo = new Memo("테스트 제목", "테스트 내용");

        when(memoRepository.existsById(memoId)).thenReturn(true);
        when(memoRepository.findById(memoId)).thenReturn(Optional.of(memo));

        // when: 메서드 실행
        Memo result = memoService.getMemoById(memoId);

        // then: 반환 결과 검증
        assertThat(result).isNotNull();
        assertThat(result.getTitle()).isEqualTo("테스트 제목");
        assertThat(result.getContent()).isEqualTo("테스트 내용");
    }
}