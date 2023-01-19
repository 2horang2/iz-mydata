package com.shinhancard.izmydata.common.entity;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ServiceInfoVo {
    int page;
    int perPage;
    int totalCount;
    int currentCount;
    int matchCount;
    @JsonProperty("data")
    ArrayList<ServiceInfo> serviceInfoList = new ArrayList<>();
}
