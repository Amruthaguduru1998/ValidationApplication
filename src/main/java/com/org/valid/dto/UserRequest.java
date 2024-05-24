package com.org.valid.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {

    @NotNull(message = "name should not null")
    private String name;
    @Email(message = "invalid email ")
    private String email;

    @Pattern(regexp = "^\\d{10}$",message = "invalid mobile number")
    private String mobile;
    private String gender;
    @Min(18)
    @Max(60)
    private int age;
    @NotBlank
    private String nationality;
}
