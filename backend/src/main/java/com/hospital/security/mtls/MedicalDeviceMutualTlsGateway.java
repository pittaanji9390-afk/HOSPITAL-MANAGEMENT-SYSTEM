package com.hospital.security.mtls;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.*;

@Slf4j
@Service
public class MedicalDeviceMutualTlsGateway {

    @Data
    @AllArgsConstructor
    public static class DeviceCertificateProfile {
        private String deviceSerialNumber;
        private String deviceModel;
        private String x509CertificateThumbprint;
        private LocalDate certificateExpiration;
        private boolean isRevoked;
        private String assignedDepartment;
    }

    private final Map<String, DeviceCertificateProfile> authorizedDevices = new LinkedHashMap<>();

    public MedicalDeviceMutualTlsGateway() {
        authorizedDevices.put("PUMP-ALARIS-9921", new DeviceCertificateProfile("PUMP-ALARIS-9921", "BD Alaris 8015 PCU", "E8A271B49C018274112", LocalDate.now().plusYears(1), false, "ICU"));
        authorizedDevices.put("VENT-PB980-4401", new DeviceCertificateProfile("VENT-PB980-4401", "Medtronic Puritan Bennett 980", "A1C49821034FF820129", LocalDate.now().plusYears(1), false, "PICU"));
    }

    public boolean authenticateDeviceCertificate(String serialNumber, String thumbprint) {
        DeviceCertificateProfile profile = authorizedDevices.get(serialNumber);
        if (profile != null && !profile.isRevoked() && profile.getX509CertificateThumbprint().equals(thumbprint)) {
            log.info("[mTLS] Successfully authenticated medical device: {}", serialNumber);
            return true;
        }
        log.warn("[mTLS] Device authentication REJECTED for serial: {}", serialNumber);
        return false;
    }

    public List<DeviceCertificateProfile> getAuthorizedDevices() { return new ArrayList<>(authorizedDevices.values()); }
}
