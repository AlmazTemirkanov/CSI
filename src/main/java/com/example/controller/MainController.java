package com.example.controller;

import com.example.repo.SmsSurveyRepo;
import com.example.repo.TaskRepo;
import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

//@Controller
 @RestController
@AllArgsConstructor
public class MainController {

    private TaskRepo taskRepo;
    private SmsSurveyRepo smsSurveyRepo;
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

//    @GetMapping("/main")
//    public String agentId (@RequestParam (required = false) String agentId, Model model) {
//        List<Object> messages = taskRepo.getAgentId(agentId);
//        if (agentId !=null && !agentId.isEmpty()){
//            messages = taskRepo.getAgentId(agentId);
//        } else {
//            taskRepo.getAgentId(agentId);
//        }
//        model.addAttribute("messages", messages);
//        model.addAttribute("agentId", agentId);
//
//        return "main";
//    }

// Agent ID 1 days

    @CrossOrigin
    @GetMapping("api/v1/1/{agentId}")
    public List<Object> agentId (@PathVariable String agentId) {

        return taskRepo.getAgentId(agentId);
    }

    // Agent ID 7 days

    @CrossOrigin
    @GetMapping("api/v1/7/{agentId}")
    public List<Object> agentId7Days (@PathVariable String agentId) {

        return taskRepo.getAgentId7Days(agentId);
    }

    // Agent ID 30 days

    @CrossOrigin
    @GetMapping("api/v1/30/{agentId}")
    public List<Object> getAgentId30Days (@PathVariable String agentId) {

        return taskRepo.getAgentId30Days(agentId);
    }

    // CSI GROUP 1 days

    @CrossOrigin
    @GetMapping("api/v1/1csi")
    public List<Object> getAllCsi1Days (String csi) {

        return taskRepo.getAllCsi1Days(csi);
    }

    // CSI GROUP 7 days

    @CrossOrigin
    @GetMapping("api/v1/7csi")
    public List<Object> getCsi7Days (String csi) {

        return taskRepo.getAllCsi7Days(csi);
    }


    // CSI GROUP 30 days

    @CrossOrigin
    @GetMapping("api/v1/30csi")
    public List<Object> getAllCsi30Days (String csi) {

        return taskRepo.getAllCsi30Days(csi);
    }

    @CrossOrigin
    @GetMapping("api/v1/30team/{team}")
    public List<Object> getTeamNameFor30Days (@PathVariable String team) {

        return taskRepo.getTeamNameFor30Days(team);
    }

    @CrossOrigin
    @GetMapping("api/v1/7team/{team}")
    public List<Object> getTeamNameFor7Days (@PathVariable String team) {

        return taskRepo.getTeamNameFor7Days(team);
    }

    @CrossOrigin
    @GetMapping("api/v1/all/{agentId}/{start}/{end}")
    public List<Object> getAgentIdDays (@PathVariable String agentId,
                                        @PathVariable (value = "start")
                                        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate start,
                                        @PathVariable (value = "end")
                                        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate end){

        return taskRepo.getAgentIdDays (agentId, start, end);
    }

    @CrossOrigin
    @GetMapping("api/v1/1team/{team}")
    public List<Object> getTeamNameFor1Days (@PathVariable String team) {

        return taskRepo.getTeamNameFor1Days(team);
    }

    // Teams CSI for Start and End Date

    @CrossOrigin
    @GetMapping("api/v1/{team}/{start}/{end}")
    public List<Object> getTeamNameForAllDays (@PathVariable String team,
                                               @PathVariable (value = "start")
                                               @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate start,
                                               @PathVariable (value = "end")
                                               @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate end){

        return taskRepo.getTeamNameForAllDays(team, start, end);
    }

    // Teams CSI for Teams for Start and End Date
    @CrossOrigin
    @GetMapping("api/v1/csi/{start}/{end}")
    public List<Object> getAllCsiStartAndEndDays (
                                                  @PathVariable (value = "start")
                                                  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate start,
                                                  @PathVariable (value = "end")
                                                  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate end) {

        return taskRepo.getAllCsiStartAndEndDays(start,end);
    }

    // Teams CSI for CC for Start and End Date
    @CrossOrigin
    @GetMapping("api/v1/cc/{start}/{end}")
    public List<Object> getAllCsiCC (
                                        @PathVariable (value = "start")
                                        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate start,
                                        @PathVariable (value = "end")
                                        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate end) {

        return taskRepo.getAllCsiCC(start,end);
    }

    @CrossOrigin
    @GetMapping("api/v1/nps/{start}/{end}")
    public List<Object> getCsiAndFcr (@PathVariable (value = "start")
                                      @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate start,
                                      @PathVariable (value = "end")
                                      @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate end){

        return taskRepo.getCsiAndFcr(start,end);
    }

}
