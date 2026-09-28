package com.project.course_reg.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record InstructorRequest(
        @NotBlank(message = "First name is required!") @Size(max = 50, message = "First name must be less than 50") String firstName,

        @NotBlank(message = "Last name is required!") @Size(max = 50, message = "Last name must be less than 50") String lastName,

        @NotBlank(message = "Email is required!") @Email(message = "Email must be valid!") String email,

        @NotBlank(message = "Department is required!") @Size(max = 50, message = "Department must be less than 50") String department) {

}
