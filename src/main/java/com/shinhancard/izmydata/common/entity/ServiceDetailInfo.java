package com.shinhancard.izmydata.common.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ServiceDetailInfo {
    @Id
    @JsonProperty("SVC_ID")
    private String serviceId;

    @Column(columnDefinition = "TEXT")
    @JsonProperty("구비서류")
    private String document;

    @Column(length = 200)
    @JsonProperty("문의처전화번호")
    private String orgPhoneNumbeString;

    @Column(columnDefinition = "TEXT")
    @JsonProperty("법령")
    private String law;

    @Column(length = 200)
    @JsonProperty("서비스명")
    private String serviceName;

    @Column(length = 1000)
    @JsonProperty("서비스목적")
    private String serviceGoal;

    @Column(length = 4000)
    @JsonProperty("선정기준")
    private String selectionCriteria;

    @Column(length = 100)
    @JsonProperty("소관기관명")
    private String orgName;

    @Column(length = 20)
    @JsonProperty("수정일시")
    private String updateDate;

    @Column(length = 1000)
    @JsonProperty("신청기한")
    private String requestPeriod;

    @Column(length = 3000)
    @JsonProperty("신청방법")
    private String requestMethod;

    @Column(length = 300)
    @JsonProperty("온라인신청사이트URL")
    private String requestUrl;

    @Column(length = 1000)
    @JsonProperty("자치법규")
    private String localStatutes;

    @Column(length = 300)
    @JsonProperty("접수기관명")
    private String requestOrgName;

    @Column(length = 3000)
    @JsonProperty("지원내용")
    private String serviceContent;

    @Column(length = 3000)
    @JsonProperty("지원대상")
    private String serviceTarget;

    @Column(length = 100)
    @JsonProperty("지원유형")
    private String supportCcd;

    @Column(length = 1000)
    @JsonProperty("행정규칙")
    private String adminRule;

}
