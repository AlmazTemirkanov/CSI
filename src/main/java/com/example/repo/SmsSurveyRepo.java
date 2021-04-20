package com.example.repo;

import com.example.domain.SmsSurvey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface SmsSurveyRepo extends JpaRepository<SmsSurvey,String> {

    @Query(value = "select u.username, round (AVG (re.q3_meaning),1), COUNT(re.q3_meaning), up.division_name, up.position_manager_name " +
            "from survey.common_report re, survey.task t, survey.retail_hierarchy_users u, survey.retail_hierarchy_positions up " +
            "where re.survey_type IN ('I_JOIN_I_SOLVE_RETAIL')" +
            "AND q3_meaning != '-1' " +
            "AND t.id=re.task_id AND t.agent_id=u.username " +
            "AND u.position_id=up.position_id " +
            "and re.survey_deliver_date between :start and :end " +
            "GROUP BY up.position_manager_name, up.division_name, u.username " +
            "order by position_manager_name ASC, division_name,round desc", nativeQuery = true)
    List<Object> getAllRetailUsers (@Param("start") LocalDate start,
                                    @Param("end") LocalDate end);


    @Query(value = "SELECT ROUND (AVG (re.q3_meaning),1), COUNT(re.q3_meaning), up.division_name, up.position_manager_name " +
            "from survey.common_report re, survey.task t, survey.retail_hierarchy_users u, survey.retail_hierarchy_positions up " +
            "where re.survey_type IN ('I_JOIN_I_SOLVE_RETAIL')" +
            "AND q3_meaning != '-1' " +
            "AND t.id=re.task_id AND t.agent_id=u.username " +
            "AND u.position_id=up.position_id " +
            "and re.survey_deliver_date between :start and :end " +
            "GROUP BY up.position_manager_name, up.division_name " +
            "order by position_manager_name ASC, round DESC, COUNT desc", nativeQuery = true)
    List<Object> getAllRetail (@Param("start") LocalDate start,
                               @Param("end") LocalDate end);
}
