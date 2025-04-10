package com.goormthon.memo_study.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Entity
@Getter
@NoArgsConstructor
@Table(name = "memo")
public class Memo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "PK")
    private Long id;

    @Column(nullable = false, length = 255)
    @Schema(description = "메모 제목", example = "메모 제목")
    private String title;

    @Column(nullable = false, columnDefinition = "TEXT")
    @Schema(description = "메모 내용", example = "메모 내용")
    private String content;

    public Memo(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }

}
