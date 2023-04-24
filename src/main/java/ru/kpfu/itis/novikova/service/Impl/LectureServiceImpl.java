package ru.kpfu.itis.novikova.service.Impl;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kpfu.itis.novikova.dto.LectureDto;
import ru.kpfu.itis.novikova.model.Lecture;
import ru.kpfu.itis.novikova.repositories.LectureRepository;
import ru.kpfu.itis.novikova.service.LectureService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Log4j2
public class LectureServiceImpl implements LectureService {

    private final LectureRepository lectureRepository;

    @Autowired
    public LectureServiceImpl(LectureRepository lectureRepository) {
        this.lectureRepository = lectureRepository;
    }

    @Override
    public LectureDto save(Lecture lecture) {
        return LectureDto.fromModel(lectureRepository.save(lecture));
    }

    @Override
    public LectureDto getLectureById(Long lectureId) {
        return LectureDto.fromModel(lectureRepository.findById(lectureId).get());
    }

    @Override
    public Lecture getRawLectureById(Long lectureId) {
        return lectureRepository.findById(lectureId).get();
    }

    @Override
    public List<LectureDto> getAll() {
        List<Lecture> allLectures = lectureRepository.findAll();

        return allLectures.stream()
                .map(LectureDto::fromModel)
                .collect(Collectors.toList());
    }

    @Override
    public List<LectureDto> getLecturesByTitleLike(String title) {
        List<Lecture> allLectures;

        if (title.isEmpty() || title == null) {
            allLectures = lectureRepository.findAll();
        } else {
            allLectures = lectureRepository.getAllByTitleContains(title);
        }

        return allLectures.stream()
                .map(LectureDto::fromModel)
                .collect(Collectors.toList());
    }



    @Override
    public List<LectureDto> getLecturesByTitleLikeAndAccountId(String title, Long id) {
        List<Lecture> allLectures;

        if (title.isEmpty() || title == null) {
            allLectures = lectureRepository.findAll();
        } else {
            allLectures = lectureRepository.getAllByTitleContainsAndAccountId(title, id);
        }

        return allLectures.stream()
                .map(LectureDto::fromModel)
                .collect(Collectors.toList());
    }

    @Override
    public List<LectureDto> getAllByAccountId(Long userId) {
        List<Lecture> allLectures = lectureRepository.getAllByAccountId(userId);

        return allLectures.stream()
                .map(LectureDto::fromModel)
                .collect(Collectors.toList());
    }

    @Transactional
    @Override
    public void deleteLecturesById(Long id) {
        lectureRepository.deletePostById(id);
    }
}
