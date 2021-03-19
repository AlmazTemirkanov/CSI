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
@Table(name = "hierarchy_teams", schema = "survey") // , schema = "survey"
public class HierarchyTeams {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotNull
    @Size(min = 2, max = 50)
    @Column(name = "name", length = 50)
    private String name;

    @NotNull
    @Size(min = 2, max = 50)
    @Column(name = "leader", length = 50)
    private String leader;

    @NotNull
    @Size(min = 2, max = 50)
    @Column(name = "leader_fullname", length = 50)
    private String leaderFullname;

    @NotNull
   // @Email(regexp = "^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$", message = "Email is not valid: ${validatedValue}")
    @Column(name = "leader_mail", length = 50)
    private String leaderMail;

    @Column(name = "site_id", updatable = false, insertable = false)
    private Long siteId;

//    @NotNull
////    @OneToOne
////    @JoinColumn(name = "site_id")
//    private String hierarchySites;

}
