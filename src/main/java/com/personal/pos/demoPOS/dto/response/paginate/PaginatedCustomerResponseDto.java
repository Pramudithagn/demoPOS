package com.personal.pos.demoPOS.dto.response.paginate;


import com.personal.pos.demoPOS.dto.response.CustomerResponseDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class PaginatedCustomerResponseDto {
    private long dataCount;
    private List<CustomerResponseDto> dataList;
}
