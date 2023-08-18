package com.spring.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class UserDto {
    private int id;
    @NotEmpty()
    @Pattern(regexp = "^[a-zA-Z ]*$", message = "Name must contain only Alphabet")
    private String name;
    @Email(message = "Email should be well formed ex.abc@xyz.com")
    private String email;
    @Pattern(regexp = "^[a-zA-Z0-9@ ]*$", message = "Name must contain only Alphabet")
    private String password;
    @Pattern(regexp = "^[a-zA-Z]*$", message = "Name must contain only Alphabet")
    private String role;
    @Pattern(regexp = "^\\d{10}$", message = "Contact must contain 10 digit")
    private String contact;
    @Min(20)
    @Max(100)
    private Integer age;
    @Pattern(regexp = "^[a-zA-Z]*$", message = "Nationality must contain only Alphabet")
    private String nationality;

    private boolean active;

}
