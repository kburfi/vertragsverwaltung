package com.burfi.vertragsverwaltung.customer.repository;

import com.burfi.vertragsverwaltung.common.BaseEntity;
import com.burfi.vertragsverwaltung.mandant.repository.Mandant;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "customer")
public class Customer extends BaseEntity<UUID> {

    @Id
    @GenericGenerator(name = "UUIDGenerator", strategy = "uuid2")
    @GeneratedValue(generator = "UUIDGenerator")
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @Column(name = "name", nullable = false)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mandant_id")
    private Mandant mandant;

    @Override
    public String toString() {
        return super.toString();
    }
}
