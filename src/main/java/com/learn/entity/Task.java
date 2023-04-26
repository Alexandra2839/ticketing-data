package com.learn.entity;


import com.learn.enums.Status;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Where;

import javax.persistence.*;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "tasks")
@Where(clause = "is_deleted=false")
public class Task extends BaseEntity{

    private String taskSubject;
    private String taskDetail;
    @Enumerated(EnumType.STRING)
    private Status taskStatus;
    private LocalDate assignedDate;


    @ManyToOne
    private Project project;

    @OneToOne (fetch = FetchType.LAZY)
    private User assignedEmployee;


}
