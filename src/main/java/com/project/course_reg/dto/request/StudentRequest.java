package com.project.course_reg.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record StudentRequest(
        @NotBlank(message = "First name is required!") @Size(max = 30, message = "Max length is 50 characters") String firstName,

        @NotBlank(message = "Last name is required!") @Size(max = 30, message = "Max length is 50 characters") String lastName,

        @NotBlank(message = "Email is required!") @Email(message = "Email must be valid!") String email,

        @NotBlank(message = "Student code is required")

        @Size(max = 20, message = "Student code must be less than 20 characters!") String studentCode) {

}
