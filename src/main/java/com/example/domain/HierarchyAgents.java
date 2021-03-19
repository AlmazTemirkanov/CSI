package com.example.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "hierarchy_agents", schema = "survey") //, schema = "survey"
public class HierarchyAgents {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotNull
    @Size(min = 2, max = 50)
    @Column(name = "username", length = 50)
    private String username;

    @NotNull
    @Size(min = 2, max = 50)
    @Column(name = "full_name", length = 50)
    private String fullName;

  //  @NotNull
  //  @Email(regexp = "^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$", message = "Email is not valid: ${validatedValue}")
    @Column(name = "mail", length = 50)
    private String mail;

    @NotNull
    @Column(name = "skill_global", length = 3)
    private String skillGlobal;

    @NotNull
    @Column(name = "support_line", length = 20)
    private Integer supportLine;

    @Column(name = "team_id", updatable = false, insertable = false)
    private Long teamId;

//    @NotNull
////    @OneToOne
//    @JoinColumn(name = "team_id")
//    private String hierarchyTeams;

    @NotNull
    @Column(name = "agent_id", length = 50)
    private String agentId;

}
