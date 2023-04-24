package ru.kpfu.itis.novikova.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SignUpForm {
    @Size(min = 4, max =  20)
    @NotBlank
    private String firstName;

    @Size(min = 4, max =  20)
    @NotBlank
    private String lastName;

    @NotBlank
    private String password;

    @Email
    @NotBlank
    private String email;
}
