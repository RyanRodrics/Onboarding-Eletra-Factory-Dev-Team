package com.energy.energy.api.models.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record MeterDTO(
        Long id,
        String productionOrder,
        Integer packNumber,
        Integer boxNumber,
        String eletraNumber,
        String clientNumber,
        BigDecimal meterWeight,
        BigDecimal meterBoxWeight,
        LocalDateTime dateCreate,
        LocalDateTime dateEdit
) {}