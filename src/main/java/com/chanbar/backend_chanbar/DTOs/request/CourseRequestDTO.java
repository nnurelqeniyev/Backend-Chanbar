package com.chanbar.backend_chanbar.DTOs.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseRequestDTO {
    private String courseName;
    private String imgCourse;
    private String courseDescription;
    private String coursePrice;
    private String courseDiscount;
    private Boolean isLiked;
    private String subCategory;
}
