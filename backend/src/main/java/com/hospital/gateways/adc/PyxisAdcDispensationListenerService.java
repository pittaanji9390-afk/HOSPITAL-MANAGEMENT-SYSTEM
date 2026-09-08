package com.hospital.gateways.adc;

import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

@Service
public class PyxisAdcDispensationListenerService {

    @Data
    @Builder
    public static class AdcTransactionEvent {
        private String cabinetDeviceId;
        private String transactionType; // DISPENSE, RETURN, WASTE, RESTOCK
        private String userNurseId;
        private String witnessNurseId;
        private String rxCui;
        private String drugName;
        private int quantity;
        private LocalDateTime transactionTimestamp;
        private boolean isDiscrepancyFlagged;
    }

    public AdcTransactionEvent recordAdcTransaction(String cabinetId, String txType, String nurseId, String witnessId, String rxCui, String drug, int qty) {
        return AdcTransactionEvent.builder()
                .cabinetDeviceId(cabinetId)
                .transactionType(txType)
                .userNurseId(nurseId)
                .witnessNurseId(witnessId)
                .rxCui(rxCui)
                .drugName(drug)
                .quantity(qty)
                .transactionTimestamp(LocalDateTime.now())
                .isDiscrepancyFlagged(false)
                .build();
    }
}
