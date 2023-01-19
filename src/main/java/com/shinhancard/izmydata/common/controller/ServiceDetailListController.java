package com.shinhancard.izmydata.common.controller;

import java.net.URI;
import java.util.ArrayList;

import com.shinhancard.izmydata.common.entity.ServiceDetailInfo;
import com.shinhancard.izmydata.common.entity.ServiceDetailInfoVo;
import com.shinhancard.izmydata.common.repository.ServiceDetailInfoRepository;
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
@RequestMapping(value = "/open-api/service-detail-list")
@Tag(name = "관리자 API", description = "Mydata 서비스 상세정보 db 적재")
@Api(hidden = true)
public class ServiceDetailListController {
    private final InitConfig initConfig;
    private final ServiceDetailInfoRepository serviceDetailInfoRepository;
    final String apiUri = "/gov24/v1/serviceDetail";
    final int perPage = 1000;

    @ApiOperation(value = "서비스상세정보 data 다시 읽어서, db 적재하기", hidden = true)
    @GetMapping(value = "/initAllServiceDetailList")
    public ResponseEntity<ResponseVo> initAllServiceDetailList() throws Exception {

        serviceDetailInfoRepository.deleteAll();

        URI uri = initConfig.makeOpenApiUri(apiUri, 1, 1);
        RestTemplate restTemplate = new RestTemplate();
        ServiceDetailInfoVo response = restTemplate.getForObject(uri, ServiceDetailInfoVo.class);

        int totalCount = response.getTotalCount();
        for (int i = 1; i < totalCount / perPage + 2; i++) {
            uri = initConfig.makeOpenApiUri(apiUri, i, perPage);
            response = restTemplate.getForObject(uri, ServiceDetailInfoVo.class);
            ArrayList<ServiceDetailInfo> serviceDetailInfoList = response.getServiceDetailInfoList();
            serviceDetailInfoRepository.saveAll(serviceDetailInfoList);
        }

        return new ResponseEntity<>(new ResponseVo("00", "성공"), HttpStatus.OK);
    }
}
