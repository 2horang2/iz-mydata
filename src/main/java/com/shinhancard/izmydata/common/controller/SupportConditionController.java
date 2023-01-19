package com.shinhancard.izmydata.common.controller;

import java.net.URI;
import java.util.ArrayList;

import com.shinhancard.izmydata.common.entity.SupportCondition;
import com.shinhancard.izmydata.common.entity.SupportConditionVo;
import com.shinhancard.izmydata.common.repository.SupportConditionRepository;
import com.shinhancard.izmydata.common.vo.ResponseVo;
import com.shinhancard.izmydata.config.InitConfig;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping(value = "/open-api/support-condition-list")
@Tag(name = "관리자 API", description = "Mydata 서비스 지원조건정보 db 적재")
@Api(hidden = true)
public class SupportConditionController {
    private final InitConfig initConfig;
    private final SupportConditionRepository supportConditionRepository;
    final String apiUri = "/gov24/v1/supportConditions"; // 공공서비스 지원조건
    final int perPage = 1000;

    @GetMapping(value = "/initAllSupportCondition")
    @ApiOperation(value = "서비스지원조건 data 다시 읽어서, db 적재하기", hidden = true)
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
