package com.burfi.vertragsverwaltung.mandant.repository;

import com.burfi.vertragsverwaltung.common.BaseEntity;
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
@Table(name = "mandant")
public class Mandant extends BaseEntity<UUID> {

    @Id
    @GenericGenerator(name = "UUIDGenerator", strategy = "uuid2")
    @GeneratedValue(generator = "UUIDGenerator")
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @Column(nullable = false)
    private String name;

    @Column
    private byte[] logo;

    @Override
    public String toString() {
        return super.toString();
    }
}
