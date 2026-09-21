# University Course & Enrollment Management System
## Project Reference Map

### Tech Stack
| Layer | Technology |
|---|---|
| Language | Java 25 |
| Framework | Spring Boot 4 |
| Build | Maven |
| Database | PostgreSQL |
| ORM | Spring Data JPA + Hibernate |
| Web | Spring Web MVC |
| Validation | Jakarta Bean Validation |
| Security | Spring Security 7 + JWT (JJWT) |
| Testing | JUnit 5, Mockito, MockMvc |
| Docs | Swagger / OpenAPI |
| Deploy | Docker + Docker Compose |

---

### Target Package Structure
```
com.project.course_reg
├── config/                      # Security config, JWT config, app config
├── controller/                  # REST controllers (Phase 7) ✅
│   ├── StudentController.java   # ✅
│   ├── InstructorController.java# ✅
│   ├── CourseController.java    # ✅
│   └── EnrollmentController.java# ✅
├── dto/
│   ├── request/                 # Incoming request DTOs (Phase 8) ✅
│   │   ├── StudentRequest.java
│   │   ├── InstructorRequest.java
│   │   ├── CourseRequest.java
│   │   └── EnrollmentRequest.java
│   └── response/                # Outgoing response DTOs (Phase 8) ✅
│       ├── StudentResponse.java
│       ├── InstructorResponse.java
│       ├── CourseResponse.java
│       └── EnrollmentResponse.java
├── entity/                      # JPA entities (Phase 2–4) ✅
│   ├── Student.java             # Phase 2 ✅
│   ├── Instructor.java          # Phase 3 ✅
│   ├── Course.java              # Phase 3 ✅
│   ├── Enrollment.java          # Phase 4 ✅
│   └── EnrollmentStatus.java    # Phase 4 ✅
├── exception/                   # Custom exceptions + global handler (Phase 11)
├── mapper/                      # Manual DTO mappers (Phase 9) 🔄
├── repository/                  # Spring Data JPA repositories (Phase 5) ✅
│   ├── StudentRepository.java   # ✅
│   ├── InstructorRepository.java# ✅
│   ├── CourseRepository.java    # ✅
│   └── EnrollmentRepository.java# ✅
├── security/                    # JWT filter, UserDetailsService impl (Phase 15–16)
├── service/                     # Business logic services (Phase 6) ✅
│   ├── StudentService.java      # ✅
│   ├── InstructorService.java   # ✅
│   ├── CourseService.java       # ✅
│   └── EnrollmentService.java   # ✅
└── CourseRegApplication.java
```

---

### Entities & Relationships
```
Instructor ──< Course         (@OneToMany / @ManyToOne)
Student    ──< Enrollment >── Course   (join table via Enrollment entity)
```

---

### Business Rules Summary
- Student cannot enroll in the same course twice
- Course has a max capacity; enrollment must check it
- Only the owning Instructor can update their course
- Enrollment is a transactional operation
- Roles: ADMIN, INSTRUCTOR, STUDENT

---

### Phase Progress Tracker
| Phase | Topic | Status |
|---|---|---|
| 0 | Project Setup | ✅ Completed |
| 1 | Database Configuration | ✅ Completed |
| 2 | Student Entity | ✅ Completed |
| 3 | Instructor & Course | ✅ Completed |
| 4 | Enrollment | ✅ Completed |
| 5 | Repositories | ✅ Completed |
| 6 | Services | ✅ Completed |
| 7 | REST Controllers | ✅ Completed |
| 8 | DTOs | ✅ Completed |
| 9 | Manual Mappers | 🔄 In Progress |
| 10 | Validation | ⬜ |
| 11 | Global Exception Handling | ⬜ |
| 12 | HTTP Responses | ⬜ |
| 13 | Pagination / Sorting / Searching | ⬜ |
| 14 | Transactions | ⬜ |
| 15 | Spring Security | ⬜ |
| 16 | JWT | ⬜ |
| 17 | Authorization | ⬜ |
| 18 | Unit Testing | ⬜ |
| 19 | Integration Testing | ⬜ |
| 20 | Swagger / OpenAPI | ⬜ |
| 21 | Docker | ⬜ |

---

### Key Dependencies (pom.xml)
```xml
<!-- Core -->
spring-boot-starter-webmvc
spring-boot-starter-data-jpa
spring-boot-starter-validation
spring-boot-starter-security

<!-- DB -->
postgresql (runtime)

<!-- Dev -->
spring-boot-devtools (runtime, optional)

<!-- Test -->
spring-boot-starter-test
spring-security-test
```
