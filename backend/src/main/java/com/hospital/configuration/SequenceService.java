package com.hospital.configuration;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

@Entity
@Table(name = "system_sequences")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SystemSequence {

    @Id
    @Column(length = 50)
    private String name;

    @Column(name = "current_val", nullable = false)
    private Long currentVal;

    @Column(nullable = false, length = 10)
    private String prefix;
}

@Repository
interface SystemSequenceRepository extends JpaRepository<SystemSequence, String> {

    @Query(value = "SELECT current_val FROM system_sequences WHERE name = :seqName FOR UPDATE", nativeQuery = true)
    Long getCurrentValForUpdate(@Param("seqName") String seqName);

    @Modifying
    @Query(value = "UPDATE system_sequences SET current_val = current_val + 1 WHERE name = :seqName", nativeQuery = true)
    void incrementSequence(@Param("seqName") String seqName);
}

@Service
@RequiredArgsConstructor
public class SequenceService {

    private final SystemSequenceRepository sequenceRepository;

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public synchronized String getNextNumber(String seqName) {
        SystemSequence seq = sequenceRepository.findById(seqName)
                .orElseGet(() -> {
                    SystemSequence newSeq = SystemSequence.builder()
                            .name(seqName)
                            .currentVal(10001L)
                            .prefix(seqName.replace("_SEQ", "-"))
                            .build();
                    return sequenceRepository.save(newSeq);
                });

        Long nextVal = seq.getCurrentVal();
        seq.setCurrentVal(nextVal + 1);
        sequenceRepository.save(seq);

        return seq.getPrefix() + nextVal;
    }
}
