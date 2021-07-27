package com.example.repo;

import com.example.domain.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface TaskRepo extends JpaRepository<Task, String> {

    //survey.

    //agent ID for 1 days

    @Query(value = "select t.subscriber, s.response, to_char(s.response_date, 'dd-mon hh24:mm'), ag.full_name, t.agent_id, agt.name " +
            "from survey.task t, survey.sms_survey s, survey.hierarchy_agents ag, survey.hierarchy_teams agt  " +
            "where t.id=s.task_id and s.position=3 and ag.team_id=agt.id and t.agent_id=ag.agent_id " +
            "and t.agent_id=:agentId and s.response_date > current_timestamp - interval '24 hours' order by s.response_date desc", nativeQuery = true)
    List<Object> getAgentId (@Param("agentId") String agentId);

    //agent ID for 7 days

    @Query(value = "select t.subscriber, s.response, to_char(s.response_date, 'dd-mon hh24:mm'), ag.full_name, t.agent_id, agt.name " +
            "from survey.task t, survey.sms_survey s, survey.hierarchy_agents ag, survey.hierarchy_teams agt  " +
            "where t.id=s.task_id and s.position=3 and ag.team_id=agt.id and t.agent_id=ag.agent_id " +
            "and t.agent_id=:agentId and s.response_date > current_timestamp - interval '7 day' order by s.response_date desc", nativeQuery = true)
    List<Object> getAgentId7Days (@Param("agentId") String agentId);

    @Query(value = "select t.subscriber, s.response, to_char(s.response_date, 'dd-mon hh24:mm'), ag.full_name, t.agent_id, agt.name " +
            "from survey.task t, survey.sms_survey s, survey.hierarchy_agents ag, survey.hierarchy_teams agt  " +
            "where t.id=s.task_id and s.position=3 and ag.team_id=agt.id and t.agent_id=ag.agent_id " +
            "and t.agent_id=:agentId and s.response_date > current_timestamp - interval '30 day' order by s.response_date desc ", nativeQuery = true)
    List<Object> getAgentId30Days (@Param("agentId") String agentId);


    @Query(value = "select t.subscriber, s.response, to_char(s.response_date, 'dd-mon hh24:mm'), ag.full_name, t.agent_id, agt.name " +
            "from survey.task t, survey.sms_survey s, survey.hierarchy_agents ag, survey.hierarchy_teams agt  " +
            "where t.id=s.task_id and s.position=3 and ag.team_id=agt.id and t.agent_id=ag.agent_id " +
            "and t.agent_id=:agentId and s.response_date between :start and :end order by s.response_date desc ", nativeQuery = true)
    List<Object> getAgentIdDays (@Param("agentId") String agentId, @Param ("start") LocalDate start,
                                 @Param("end") LocalDate end);


    // All group CSI for 7 days

    @Query(value = "select round(AVG (re.q3_meaning),1), count(re.q3_meaning), re.team, re.team_manager     " +
            "from survey.common_report re " +
            "where survey_deliver_date > current_timestamp - interval '7 day'" +
            "and survey_type IN ('I_SOLVE_CONTACT_CENTER')" +
            "AND q3_meaning != '-1'" +
            "GROUP BY re.team, re.team_manager order by round desc", nativeQuery = true)
    List<Object> getAllCsi7Days (String csi);

    // All group CSI for 1 days

    @Query(value = "select round(AVG (re.q3_meaning),1), count(re.q3_meaning), re.team, re.team_manager     " +
            "from survey.common_report re " +
            "where survey_deliver_date > current_timestamp - interval '24 hours'" +
            "and survey_type IN ('I_SOLVE_CONTACT_CENTER')" +
            "AND q3_meaning != '-1'" +
            "GROUP BY re.team, re.team_manager order by round desc", nativeQuery = true)
    List<Object> getAllCsi1Days (String csi);

// All group CSI for 30 days

    @Query(value = "select round(AVG (re.q3_meaning),1), count(re.q3_meaning), re.team, re.team_manager     " +
            "from survey.common_report re " +
            "where survey_deliver_date > current_timestamp - interval '30 day'" +
            "and survey_type IN ('I_SOLVE_CONTACT_CENTER')" +
            "AND q3_meaning != '-1'" +
            "GROUP BY re.team, re.team_manager order by round desc", nativeQuery = true)
    List<Object> getAllCsi30Days (String csi);

// Team CSI 30 days

    @Query(value = "select round(AVG (re.q3_meaning),1), count(re.q3_meaning), re.agent, re.agent_id, re.team, re.team_manager    " +
            "from survey.common_report re " +
            "where re.survey_deliver_date > current_timestamp - interval '30 day'" +
            "and re.survey_type IN ('I_SOLVE_CONTACT_CENTER')" +
            "AND re.q3_meaning != '-1' and re.team=:team " +
            "GROUP BY re.agent, re.team, re.team_manager, re.agent_id order by round desc", nativeQuery = true)
    List<Object> getTeamNameFor30Days (@Param("team") String team);

    // Team CSI 7 days

    @Query(value = "select round(AVG (re.q3_meaning),1), count(re.q3_meaning), re.agent, re.agent_id, re.team, re.team_manager    " +
            "from survey.common_report re " +
            "where re.survey_deliver_date > current_timestamp - interval '7 day'" +
            "and re.survey_type IN ('I_SOLVE_CONTACT_CENTER')" +
            "AND re.q3_meaning != '-1' and re.team=:team " +
            "GROUP BY re.agent, re.team, re.team_manager, re.agent_id order by round desc", nativeQuery = true)
    List<Object> getTeamNameFor7Days (@Param("team") String team);


    // Team CSI 1 days

    @Query(value = "select round(AVG (re.q3_meaning),1), count(re.q3_meaning), re.agent, re.agent_id, re.team, re.team_manager    " +
            "from survey.common_report re " +
            "where re.survey_deliver_date > current_timestamp - interval '24 hours'" +
            "and re.survey_type IN ('I_SOLVE_CONTACT_CENTER')" +
            "AND re.q3_meaning != '-1' and re.team=:team " +
            "GROUP BY re.agent, re.team, re.team_manager, re.agent_id order by round desc", nativeQuery = true)
    List<Object> getTeamNameFor1Days (@Param("team") String team);

// start and end date on all teams


    @Query(value = "select round(AVG (re.q3_meaning),1), count(re.q3_meaning), re.agent, re.agent_id, re.team, re.team_manager    " +
            "from survey.common_report re " +
            "where re.survey_type IN ('I_SOLVE_CONTACT_CENTER')" +
            "AND re.q3_meaning != '-1'" +
            "and re.survey_deliver_date between :start and :end and re.team=:team  " +
            "GROUP BY re.agent, re.team, re.team_manager, re.agent_id order by round desc", nativeQuery = true)

    List<Object> getTeamNameForAllDays (@Param("team") String team, @Param ("start") LocalDate start,
                                        @Param("end") LocalDate end);



    // All group CSI start and end date

    @Query(value = "select round(AVG (re.q3_meaning),1), count(re.q3_meaning), re.team, re.team_manager     " +
            "from survey.common_report re " +
            "where survey_type IN ('I_SOLVE_CONTACT_CENTER')" +
            "AND q3_meaning != '-1' and re.survey_deliver_date between :start and :end " +
            "GROUP BY re.team, re.team_manager order by round desc", nativeQuery = true)
    List<Object> getAllCsiStartAndEndDays (@Param ("start") LocalDate start,
                                           @Param("end") LocalDate end);


    // CSI all CC start and end date
    @Query(value = "select round(AVG (re.q3_meaning),1), count(re.q3_meaning), re.agent_id, re.agent, re.team, re.team_manager " +
            "from survey.common_report re " +
            "where survey_type IN ('I_SOLVE_CONTACT_CENTER')" +
            "AND q3_meaning != '-1' and re.survey_deliver_date between :start and :end " +
            "GROUP BY re.team, re.agent_id, re.team_manager, re.agent order by round desc, count desc", nativeQuery = true)
    List<Object> getAllCsiCC (@Param ("start") LocalDate start,
                              @Param("end") LocalDate end);

}
