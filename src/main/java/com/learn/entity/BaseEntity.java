package com.learn.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@MappedSuperclass
@AllArgsConstructor
public class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Boolean isDeleted = false;
    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime insertDateTime;
    private Long insertUserId;
    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime lastUpdateDateTime;
    private Long lastUpdateUserId;



}
