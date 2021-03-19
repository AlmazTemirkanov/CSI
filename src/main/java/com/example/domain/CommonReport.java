package com.example.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "common_report", schema = "survey") //  , schema = "survey"
public class CommonReport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "task_id", nullable = false)
    private Long taskId;

    @Column(name = "subscriber", nullable = false)
    private Long subscriber;

    @Column(name = "survey_lang", nullable = false, length = 4)
    private String surveyLang;

    @Column(name = "survey_type", nullable = false, length = 100)
    private String surveyType;

    @Column(name = "survey_start_date", nullable = false)
    private LocalDateTime surveyStartDate;

    @Column(name = "survey_deliver_date")
    private LocalDateTime surveyDeliverDate;

    @Column(name = "survey_about", length = 50)
    private String surveyAbout;

    @Column(name = "customer_comment")
    private String customerComment;

    @Column(name = "agent", length = 50)
    private String agent;

    @Column(name = "agent_id", length = 50)
    private String agentId;

    @Column(name = "team", length = 50)
    private String team;

    @Column(name = "team_manager", length = 50)
    private String teamManager;

    @Column(name = "site", length = 50)
    private String site;

    @Column(name = "site_manager", length = 50)
    private String siteManager;

    @Column(name = "q1_text", length = 1000)
    private String q1Text;

    @Column(name = "q1_response")
    private String q1Response;

    @Column(name = "q1_meaning")
    private Integer q1Meaning;

    @Column(name = "q2_text", length = 1000)
    private String q2Text;

    @Column(name = "q2_response", length = 1000)
    private String q2Response;

    @Column(name = "q2_meaning")
    private Integer q2Meaning;

    @Column(name = "q3_text", length = 1000)
    private String q3Text;

    @Column(name = "q3_response", length = 1000)
    private String q3Response;

    @Column(name = "q3_meaning")
    private Integer q3Meaning;

    @Column(name = "q4_text", length = 1000)
    private String q4Text;

    @Column(name = "q4_response", length = 1000)
    private String q4Response;

    @Column(name = "q4_meaning")
    private Integer q4Meaning;

    @Column(name = "q5_text", length = 1000)
    private String q5Text;

    @Column(name = "q5_response", length = 1000)
    private String q5Response;

    @Column(name = "q5_meaning")
    private Integer q5Meaning;

    @Column(name = "q6_text", length = 1000)
    private String q6Text;

    @Column(name = "q6_response", length = 1000)
    private String q6Response;

    @Column(name = "q6_meaning")
    private Integer q6Meaning;

    @Column(name = "q7_text", length = 1000)
    private String q7Text;

    @Column(name = "q7_response", length = 1000)
    private String q7Response;

    @Column(name = "q7_meaning")
    private Integer q7Meaning;

    @Column(name = "q8_text", length = 1000)
    private String q8Text;

    @Column(name = "q8_response", length = 1000)
    private String q8Response;

    @Column(name = "q8_meaning")
    private Integer q8Meaning;

    @Column(name = "q9_text", length = 1000)
    private String q9Text;

    @Column(name = "q9_response", length = 1000)
    private String q9Response;

    @Column(name = "q9_meaning")
    private Integer q9Meaning;

    @Column(name = "q10_text", length = 1000)
    private String q10Text;

    @Column(name = "q10_response", length = 1000)
    private String q10Response;

    @Column(name = "q10_meaning")
    private Integer q10Meaning;

    @Column(name = "dt_dt")
    private Date dtDt;

    @Column(name = "subs_key")
    private Long subsKey;

    @Column(name = "phone_num")
    private String phoneNum;

    @Column(name = "device_type_cval")
    private String deviceTypeCval;

    @Column(name = "device_name")
    private String deviceName;

    @Column(name = "price_plan_name_ru")
    private String pricePlanNameRu;

    @Column(name = "prev_price_plan_name_ru")
    private String prevPricePlanNameRu;

    @Column(name = "activation_dt")
    private Date activationDt;

    @Column(name = "revenue_abonka_dl")
    private Float revenueAbonkaDl;

    @Column(name = "rev_abon_non_tp_dl")
    private Float revAbonNonTpDl;

    @Column(name = "recharge_total_amt")
    private Float rechargeTotalAmt;

    @Column(name = "usage_out_onnet_voice_dl")
    private Float usageOutOnnetVoiceDl;

    @Column(name = "usage_out_offnet_voice_dl")
    private Float usageOutOffnetVoiceDl;

    @Column(name = "usage_internet_dl")
    private Float usageInternetDl;

    @Column(name = "count0611_dl")
    private Integer count0611Dl;

    @Column(name = "ivr_lang")
    private String ivrLang;

    @Column(name = "cell_name")
    private String cellName;

    @Column(name = "orig_price_plan_name_ru")
    private String origPricePlanNameRu;

    @Column(name = "usage_internet_lte_free_dl")
    private Float usageInternetLteFreeDl;

    @Column(name = "usage_internet_3g_free_dl")
    private Float usageInternet3GFreeDl;

    @Column(name = "ind_lte")
    private Integer indLte;
}