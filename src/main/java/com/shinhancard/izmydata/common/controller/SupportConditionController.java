package com.shinhancard.izmydata.common.controller;

import java.net.URI;
import java.util.ArrayList;

import com.shinhancard.izmydata.common.config.InitConfig;
import com.shinhancard.izmydata.common.entity.SupportCondition;
import com.shinhancard.izmydata.common.entity.SupportConditionVo;
import com.shinhancard.izmydata.common.repository.SupportConditionRepository;
import com.shinhancard.izmydata.common.vo.ResponseVo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping(value = "/open-api/support-condition-list")
public class SupportConditionController {
    private final InitConfig initConfig;
    private final SupportConditionRepository supportConditionRepository;
    final String apiUri = "/gov24/v1/supportConditions"; // 공공서비스 지원조건
    final int perPage = 1000;

    @GetMapping(value = "/initAllSupportCondition")
    public ResponseEntity<ResponseVo> initAllServiceList() throws Exception {

        supportConditionRepository.deleteAll();

        URI uri = initConfig.makeOpenApiUri(apiUri, 1, 1);
        RestTemplate restTemplate = new RestTemplate();
        SupportConditionVo response = restTemplate.getForObject(uri, SupportConditionVo.class);

        int totalCount = response.getTotalCount();
        for (int i = 1; i < totalCount / perPage + 2; i++) {
            uri = initConfig.makeOpenApiUri(apiUri, i, perPage);
            response = restTemplate.getForObject(uri, SupportConditionVo.class);
            ArrayList<SupportCondition> supportConditionList = response.getSupportConditionList();
            supportConditionRepository.saveAll(supportConditionList);
        }

        return new ResponseEntity<>(new ResponseVo("00", "성공"), HttpStatus.OK);
    }
}
