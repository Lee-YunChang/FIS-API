package com.fis.domain.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
public class ContractInformationRequest {

    @NotNull(message = "크리에이터 ID는 필수값입니다.")
    private Long creatorId;

    @NotNull(message = "채널 ID는 필수값입니다.")
    private Long channelId;

    private Integer rate;

    @NotBlank(message = "계약일은 필수 입력 값입니다.")
    @Pattern(regexp = "\\d{4}-(0[1-9]|1[012])-(0[1-9]|[12][0-9]|3[01])",
            message = "yyyy-mm-dd형식으로 입력해주세요")

    private String createDtime;
}
