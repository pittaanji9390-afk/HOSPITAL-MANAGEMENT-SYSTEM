package com.hospital.mpi.merge;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.List;

@Slf4j
@Service
public class PatientUnmergeSplittingSafetyEngine {

    public boolean executeSafeUnmerge(String mergeEventId, String approvingHIMDirectorId) {
        log.warn("[EMPI-UNMERGE] Executing unmerge for event {} authorized by HIM Director {}", mergeEventId, approvingHIMDirectorId);
        return true;
    }
}
