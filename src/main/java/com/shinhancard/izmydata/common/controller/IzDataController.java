package com.shinhancard.izmydata.common.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.shinhancard.izmydata.common.entity.ServiceDetailInfo;
import com.shinhancard.izmydata.common.entity.ServiceInfo;
import com.shinhancard.izmydata.common.entity.SupportCondition;
import com.shinhancard.izmydata.common.repository.ServiceDetailInfoRepository;
import com.shinhancard.izmydata.common.repository.ServiceInfoRepository;
import com.shinhancard.izmydata.common.repository.SupportConditionRepository;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping(value = "/iz-data")
public class IzDataController {

    private final ServiceInfoRepository serviceInfoRepository;
    private final ServiceDetailInfoRepository serviceDetailInfoRepository;
    private final SupportConditionRepository supportConditionRepository;

    @ApiOperation(value = "서비스 정보 전체조회", notes = "<strong>서비스 기본정보</strong>를 전체 조회한다.")
    @GetMapping(value = "/findAll")
    public ResponseEntity<List<ServiceInfo>> findServiceInfo() throws Exception {
        return new ResponseEntity<>(serviceInfoRepository.findAll(), HttpStatus.OK);
    }

    @ApiOperation(value = "서비스 세부정보 전체조회", notes = "<strong>서비스 아이디</strong>기준으로, 기본정보,상세정보,지원조건 순으로 모두 조회한다." + "\n"
            + "약 10,000여건으로 10여초 정도 소요됩니다.")
    @GetMapping(value = "/findService")
    public ResponseEntity<List<Object>> findService(@RequestParam("서비스아이디") String svcId) throws Exception {
        List<Object> list = new ArrayList<>();
        list.add(serviceInfoRepository.findById(svcId).get());
        list.add(serviceDetailInfoRepository.findById(svcId).get());
        list.add(supportConditionRepository.findById(svcId).get());
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @ApiOperation(value = "서비스 정보조회", notes = "<strong>서비스 기본정보</strong>를 조회한다")
    @GetMapping(value = "/findServiceInfo")
    public ResponseEntity<ServiceInfo> findServiceInfo(@RequestParam("서비스아이디") String svcId) throws Exception {
        Optional<ServiceInfo> serviceInfo = serviceInfoRepository.findById(svcId);
        return new ResponseEntity<>(serviceInfo.get(), HttpStatus.OK);
    }

    @ApiOperation(value = "서비스 상세정보 조회", notes = "<strong>서비스 상세정보</strong>를 조회한다")
    @GetMapping(value = "/findServiceDetailInfo")
    public ResponseEntity<ServiceDetailInfo> findServiceDetailInfo(@RequestParam("서비스아이디") String svcId)
            throws Exception {
        Optional<ServiceDetailInfo> serviceDetailInfo = serviceDetailInfoRepository.findById(svcId);
        return new ResponseEntity<>(serviceDetailInfo.get(), HttpStatus.OK);
    }

    @ApiOperation(value = "서비스 조건조회", notes = "<strong>서비스 조건정보</strong>를 조회한다")
    @GetMapping(value = "/findSupprotCondition")
    public ResponseEntity<SupportCondition> findSupprotCondition(@RequestParam("서비스아이디") String svcId)
            throws Exception {
        Optional<SupportCondition> supportCondition = supportConditionRepository.findById(svcId);
        return new ResponseEntity<>(supportCondition.get(), HttpStatus.OK);
    }

}
