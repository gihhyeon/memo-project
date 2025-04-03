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

import static org.assertj.core.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class MemoServiceTest {

    @Mock
    private MemoRepository memoRepository;

    @InjectMocks
    private MemoService memoService;

    @Test
    @DisplayName("메모 생성 성공 테스트")
    void createMemo() {
        // given
        MemoRequestDto requestDto = new MemoRequestDto("테스트 제목", "테스트 내용");
        Memo savedMemo = new Memo(requestDto.getTitle(), requestDto.getContent());

        when(memoRepository.save(any(Memo.class))).thenReturn(savedMemo); // Mock 설정
        // when
        Memo result = memoService.createMemo(requestDto);

        // then
        assertThat(result).isNotNull();
        assertThat(result.getTitle()).isEqualTo("테스트 제목");
        assertThat(result.getContent()).isEqualTo("테스트 내용");

    }
}