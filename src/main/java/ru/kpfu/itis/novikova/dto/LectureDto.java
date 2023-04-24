package ru.kpfu.itis.novikova.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.kpfu.itis.novikova.model.Lecture;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LectureDto {

    private Long id;
    private String title;
    private String text;
    private String data;
    private Long accountId;
    private String accountEmail;


    public static LectureDto fromModel(Lecture lecture) {
        return new LectureDto(lecture.getId(), lecture.getTitle(), lecture.getText(),
                lecture.getData(), lecture.getAccount().getId(), lecture.getAccount().getEmail());
    }
}
