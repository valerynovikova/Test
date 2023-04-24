package ru.kpfu.itis.novikova.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.kpfu.itis.novikova.model.Lecture;

import java.util.List;

public interface LectureRepository extends JpaRepository<Lecture, Long> {

    List<Lecture> getAllByTitleContains(@Param("title") String title);

    List<Lecture> getAllByTitleContainsAndAccountId(String title, Long id);

    @Query(value = "select u from Lecture u where u.account.id = :userId")
    List<Lecture> getAllByAccountId(@Param("userId") Long userId);

    void deletePostById(Long id);
}
