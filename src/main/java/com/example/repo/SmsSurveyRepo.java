package com.example.repo;

import com.example.domain.SmsSurvey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface SmsSurveyRepo extends JpaRepository<SmsSurvey,String> {

    @Query(value = "select u.username, round (AVG (re.q3_meaning),1), COUNT(re.q3_meaning), up.division_name, up.position_manager_name " +
            "from common_report re, task t, retail_hierarchy_users u, retail_hierarchy_positions up " +
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
            "from common_report re, task t, retail_hierarchy_users u, retail_hierarchy_positions up " +
            "where re.survey_type IN ('I_JOIN_I_SOLVE_RETAIL')" +
            "AND q3_meaning != '-1' " +
            "AND t.id=re.task_id AND t.agent_id=u.username " +
            "AND u.position_id=up.position_id " +
            "and re.survey_deliver_date between :start and :end " +
            "GROUP BY up.position_manager_name, up.division_name " +
            "order by position_manager_name ASC, round DESC, COUNT desc", nativeQuery = true)
    List<Object> getAllRetail (@Param("start") LocalDate start,
                               @Param("end") LocalDate end);


    @Query(value = "SELECT ROUND (AVG (re.q3_meaning),1), COUNT(re.q3_meaning), up.position_manager_name, up.region_name " +
            "from common_report re, task t, retail_hierarchy_users u, retail_hierarchy_positions up " +
            "where re.survey_type IN ('I_JOIN_I_SOLVE_RETAIL')" +
            "AND q3_meaning != '-1' " +
            "AND t.id=re.task_id " +
            "AND t.agent_id=u.username " +
            "AND u.position_id=up.position_id " +
            "and re.survey_deliver_date between :start and :end " +
            "GROUP BY up.region_name, up.position_manager_name " +
            "order by round desc, count desc", nativeQuery = true)
    List<Object> getRetailBro (@Param("start") LocalDate start,
                               @Param("end") LocalDate end);


    @Query(value = "SELECT adt.subscriber,  TO_CHAR( aas.created_at, 'dd-mon hh24:mm:ss'), aas.response,  u.username, up.division_name, up.position_manager_name, up.region_name " +
            "FROM  task adt, sms_survey aas, retail_hierarchy_users u,retail_hierarchy_positions up " +
            "where adt.survey_type IN ('I_JOIN_I_SOLVE_RETAIL')" +
            "AND aas.response IS not NULL " +
            "AND aas.position IN ('3','5') " +
            "AND adt.id = aas.task_id " +
            "AND adt.agent_id=u.username " +
            "AND u.position_id=up.position_id " +
            "and aas.created_at between :start and :end " +
            "and u.username=:username " +
            "order by TO_CHAR desc", nativeQuery = true)
    List<Object> getRetailOne (@Param("username") String username, @Param("start") LocalDate start,
                               @Param("end") LocalDate end);
}
