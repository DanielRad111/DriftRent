package com.example.DriftRent.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

@Table(name = "`ad`")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Ad {
    /**
     * Unique identifier for the ad.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * Title of the ad.
     */
    @Column(nullable = false)
    private String title;

    /**
     * Description of the ad.
     */
    @Column(nullable = false)
    private String description;

    /**
     * Price of the ad.
     */
    @Column(nullable = false)
    private Double price;

    /**
     * User who created the ad.
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    /**
     * Car that the ad is for.
     */
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "car_id", nullable = false)
    private Car car;
}