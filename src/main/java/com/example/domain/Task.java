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
@Table(name = "task", schema = "survey") //, schema = "survey"
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",  nullable = false)
    private Long id;

    @Column(name = "subscriber")
    private Long subscriber;

    @Column(name = "lang")
    private String lang;

    @Column(name = "service_number")
    private String serviceNumber;

    @Column(name = "survey_template_id", updatable = false, insertable = false)
    private Long surveyTemplateId;

  //  @NotNull
 //   @OneToOne
  //  @JoinColumn(name = "survey_template_id")
   // private String surveyTemplate;

 //   @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumns({
//            @JoinColumn(name = "questionnaire_id", referencedColumnName = "id"),
//    })
 @Column(name = "questionnaire_id")
    private String questionnaire;

  //  @Enumerated(EnumType.STRING)
//    @Column(name = "status")
//    private String status;

   // @Enumerated(EnumType.STRING)
    @Column(name = "survey_type")
    private String surveyType;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "agent_id")
    private String agentId;

    @Column(name = "reported")
    private Boolean reported;

    @Column(name = "indicators")
    private Boolean indicators;

  //  @PrePersist
    public void prePersistLog() {
        indicators = false;
    }
}
