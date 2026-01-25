package com.project.fitness.model;

import java.time.LocalDateTime;
import java.util.Map;

import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Activity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

   @Enumerated(EnumType.STRING)
    private ActivityType type;


    @JdbcTypeCode(SqlTypes.JSON)
    @Column(columnDefinition = "JSON")
    private Map<String,Object> additionalMetrics;

    private Integer duration;
    private Integer caloriesBurned;
    private LocalDateTime starTime;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    
}
