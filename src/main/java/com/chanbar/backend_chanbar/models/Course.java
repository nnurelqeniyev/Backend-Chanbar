package com.chanbar.backend_chanbar.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "course")
public class Course {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "course_name")
    private String courseName;

    @Column(name = "course_img")
    private String imgCourse;

    @Column(name = "course_description")
    private String courseDescription;

    @Column(name = "course_price")
    private String coursePrice;

    @Column(name = "course_discount")
    private String courseDiscount;

    @Column(name = "likes")
    private Boolean isLiked;

    @ManyToOne
    @JoinColumn(name = "sub_category_id", nullable = false)
    private SubCategory subCategory;
}
