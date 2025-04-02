package com.goormthon.memo_study.repository;

import com.goormthon.memo_study.entity.Memo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemoRepository extends JpaRepository<Memo, Long> {
}
