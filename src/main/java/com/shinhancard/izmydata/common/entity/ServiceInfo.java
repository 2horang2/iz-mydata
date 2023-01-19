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
public class ServiceInfo {
    @Id
    @JsonProperty("서비스ID")
    private String serviceId;

    @Column(length = 200)
    @JsonProperty("서비스명")
    private String serviceName;

    @Column(length = 1000)
    @JsonProperty("서비스목적")
    private String serviceGoal;

    @Column(length = 100)
    @JsonProperty("소관기관코드")
    private String orgCcd;

    @Column(length = 100)
    @JsonProperty("소관기관명")
    private String orgName;

    @Column(length = 1000)
    @JsonProperty("신청기한")
    private String requestPeriod;

    @Column(length = 5000)
    @JsonProperty("신청방법")
    private String requestMethod;

    @Column(length = 5000)
    @JsonProperty("지원대상")
    private String serviceTarget;

    @Column(length = 5000)
    @JsonProperty("지원내용")
    private String serviceContent;

    @Column(length = 100)
    @JsonProperty("지원유형")
    private String supportCcd;

    @Column(length = 200)
    @JsonProperty("상세조회URL")
    private String detiailRequestUrl;

    @Column(length = 100)
    @JsonProperty("부서명")
    private String bnNm;

}
