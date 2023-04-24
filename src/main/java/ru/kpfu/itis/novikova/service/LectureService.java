package ru.kpfu.itis.novikova.service;

import ru.kpfu.itis.novikova.dto.LectureDto;
import ru.kpfu.itis.novikova.model.Lecture;

import java.util.List;

public interface LectureService {

    LectureDto save(Lecture lecture);

    LectureDto getLectureById(Long lectureId);

    Lecture getRawLectureById(Long lectureId);

    List<LectureDto> getAll();

    List<LectureDto> getLecturesByTitleLike(String title);

    List<LectureDto> getLecturesByTitleLikeAndAccountId(String title, Long id);

    List<LectureDto> getAllByAccountId(Long userId);

    void deleteLecturesById(Long id);

}
