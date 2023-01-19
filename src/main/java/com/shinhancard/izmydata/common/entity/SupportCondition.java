package com.shinhancard.izmydata.common.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mysql.cj.jdbc.Blob;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SupportCondition {

    @Id
    @JsonProperty("SVC_ID")
    String serviceId;

    @Column(length = 20)
    @JsonProperty("JA0101")
    String ja0101;

    @Column(length = 20)
    @JsonProperty("JA0102")
    String ja0102;

    @Column(length = 20)
    @JsonProperty("JA0103")
    String ja0103;

    @Column(length = 20)
    @JsonProperty("JA0104")
    String ja0104;

    @Column(length = 20)
    @JsonProperty("JA0105")
    String ja0105;

    @Column(length = 20)
    @JsonProperty("JA0106")
    String ja0106;

    @Column(length = 20)
    @JsonProperty("JA0107")
    String ja0107;

    @Column(length = 20)
    @JsonProperty("JA0108")
    String ja0108;

    @Column(length = 20)
    @JsonProperty("JA0109")
    String ja0109;

    @Column(length = 20)
    @JsonProperty("JA0110")
    String ja0110;

    @Column(length = 20)
    @JsonProperty("JA0111")
    String ja0111;

    @Column(length = 20)
    @JsonProperty("JA0201")
    String ja0201;

    @Column(length = 20)
    @JsonProperty("JA0202")
    String ja0202;

    @Column(length = 20)
    @JsonProperty("JA0203")
    String ja0203;

    @Column(length = 20)
    @JsonProperty("JA0204")
    String ja0204;

    @Column(length = 20)
    @JsonProperty("JA0205")
    String ja0205;

    @Column(length = 20)
    @JsonProperty("JA0301")
    String ja0301;

    @Column(length = 20)
    @JsonProperty("JA0302")
    String ja0302;

    @Column(length = 20)
    @JsonProperty("JA0303")
    String ja0303;

    @Column(length = 20)
    @JsonProperty("JA0304")
    String ja0304;

    @Column(length = 20)
    @JsonProperty("JA0305")
    String ja0305;

    @Column(length = 20)
    @JsonProperty("JA0306")
    String ja0306;

    @Column(length = 20)
    @JsonProperty("JA0307")
    String ja0307;

    @Column(length = 20)
    @JsonProperty("JA0308")
    String ja0308;

    @Column(length = 20)
    @JsonProperty("JA0309")
    String ja0309;

    @Column(length = 20)
    @JsonProperty("JA0310")
    String ja0310;

    @Column(length = 20)
    @JsonProperty("JA0311")
    String ja0311;

    @Column(length = 20)
    @JsonProperty("JA0312")
    String ja0312;

    @Column(length = 20)
    @JsonProperty("JA0313")
    String ja0313;

    @Column(length = 20)
    @JsonProperty("JA0314")
    String ja0314;

    @Column(length = 20)
    @JsonProperty("JA0315")
    String ja0315;

    @Column(length = 20)
    @JsonProperty("JA0316")
    String ja0316;

    @Column(length = 20)
    @JsonProperty("JA0317")
    String ja0317;

    @Column(length = 20)
    @JsonProperty("JA0318")
    String ja0318;

    @Column(length = 20)
    @JsonProperty("JA0319")
    String ja0319;

    @Column(length = 20)
    @JsonProperty("JA0320")
    String ja0320;

    @Column(length = 20)
    @JsonProperty("JA0321")
    String ja0321;

    @Column(length = 20)
    @JsonProperty("JA0322")
    String ja0322;

    @Column(length = 20)
    @JsonProperty("JA0323")
    String ja0323;

    @Column(length = 20)
    @JsonProperty("JA0324")
    String ja0324;

    @Column(length = 20)
    @JsonProperty("JA0325")
    String ja0325;

    @Column(length = 20)
    @JsonProperty("JA0326")
    String ja0326;

    @Column(length = 20)
    @JsonProperty("JA0327")
    String ja0327;

    @Column(length = 20)
    @JsonProperty("JA0401")
    String ja0401;

    @Column(length = 20)
    @JsonProperty("JA0402")
    String ja0402;

    @Column(length = 20)
    @JsonProperty("JA0403")
    String ja0403;

    @Column(length = 20)
    @JsonProperty("JA0404")
    String ja0404;

    @Column(length = 20)
    @JsonProperty("JA0405")
    String ja0405;

    @Column(length = 20)
    @JsonProperty("JA0406")
    String ja0406;

    @Column(length = 20)
    @JsonProperty("JA0407")
    String ja0407;

    @Column(length = 20)
    @JsonProperty("JA0408")
    String ja0408;

    @Column(length = 20)
    @JsonProperty("JA0409")
    String ja0409;

    @Column(length = 20)
    @JsonProperty("JA0410")
    String ja0410;

    @Column(length = 20)
    @JsonProperty("JA0411")
    String ja0411;

    @Column(length = 20)
    @JsonProperty("JA0412")
    String ja0412;

    @Column(length = 20)
    @JsonProperty("JA0413")
    String ja0413;

    @Column(length = 20)
    @JsonProperty("JA0414")
    String ja0414;

}
