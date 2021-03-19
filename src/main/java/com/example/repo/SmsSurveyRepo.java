package com.example.repo;

import com.example.domain.SmsSurvey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface SmsSurveyRepo extends JpaRepository<SmsSurvey,String> {
    SmsSurvey findByResponse (String response);

//, QuerydslPredicateExecutor<SmsSurvey>
}
