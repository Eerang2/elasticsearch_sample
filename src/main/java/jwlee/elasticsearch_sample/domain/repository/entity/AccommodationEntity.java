package jwlee.elasticsearch_sample.domain.repository.entity;

import jakarta.persistence.*;
import jwlee.elasticsearch_sample.domain.enums.AccommodationType;
import jwlee.elasticsearch_sample.domain.enums.ParkingType;
import jwlee.elasticsearch_sample.domain.model.ParkingInfo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.JdbcType;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

@Entity
@Table(name = "accommodation")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AccommodationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "acmd_no", nullable = false)
    @JdbcTypeCode(SqlTypes.BIGINT)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private String locationGuideText;


    @Column(nullable = false)
    private boolean isFreeParking;

    @Enumerated(EnumType.STRING)
    private ParkingType parkingType;

    @Enumerated(EnumType.STRING)
    private AccommodationType accommodationType;



}
