package ru.kpfu.itis.novikova.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "lectures")
public class Lecture {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(columnDefinition = "TEXT", length = 5000)
    private String text;

    private String title;
    private String data;

    @ManyToOne()
    @JoinColumn(name = "account_id")
    private Account account;

    public Lecture(String title, String text, String data, Account account) {
        this.title = title;
        this.text = text;
        this.data = data;
        this.account = account;
    }
}
