package com.chanbar.backend_chanbar.DTOs.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseResponseDTO {
    private Long id;
    private String courseName;
    private String imgCourse;
    private String courseDescription;
    private String coursePrice;
    private String courseDiscount;
    private Boolean isLiked;
    private String  subCategory;
}
