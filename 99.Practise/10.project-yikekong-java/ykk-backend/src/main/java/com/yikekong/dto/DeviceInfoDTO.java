package com.yikekong.dto;

import lombok.Data;

import java.util.List;

@Data
public class DeviceInfoDTO {


    private DeviceDTO device;//设备

    private List<QuotaDTO> quotaList;//指标列表


}
