package com.example.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "sms_survey", schema = "survey") //, schema = "survey"
public class SmsSurvey {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "task_id")
    private Long taskId;

   // @NotNull
   // @ManyToOne
  //  @JoinColumn(name = "task_id", referencedColumnName = "id", insertable = false, updatable = false)
  //  private Task task;

    @Column(name = "position")
    private Integer position;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "is_sent")
    private Boolean isSent;

    @Column(name = "sms_id")
    private String smsId;

    @Column(name = "delivered")
    private Integer delivered;

    @Column(name = "delivered_date")
    private LocalDateTime deliveredDate;

    @Column(name = "response")
    private String response;

    @Column(name = "response_date")
    private LocalDateTime responseDate;

    @Column(name = "error")
    private String error;

    //todo added to make less request to DB and make logic more simple, need to discuss
 //   @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumns({
//            @JoinColumn(name = "question_id", referencedColumnName = "id"),
//    })
    @Column(name = "question_id")
    private String questions;
}
