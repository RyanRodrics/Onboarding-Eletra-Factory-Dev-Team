package com.energy.energy.api.models.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public record BoxDTO(
        Long id,
        Integer packNumber,
        String productionOrder,
        Integer palletNumber,
        Integer boxNumber,
        Integer quantityMetersInBox,
        BigDecimal boxWeight,
        Boolean closed,
        Boolean printed,
        String closedByUserName,
        String userCreate,
        String userEdit,
        LocalDateTime dateCreate,
        LocalDateTime dateEdit,
        List<MeterDTO> boxMeters
) {}