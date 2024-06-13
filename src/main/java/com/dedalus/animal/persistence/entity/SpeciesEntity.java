package com.dedalus.animal.persistence.entity;

import lombok.*;

import javax.persistence.*;
import java.util.UUID;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "SPECIES")
public class SpeciesEntity {

    @Id
    @GeneratedValue
    @Column(columnDefinition = "uuid")
    @EqualsAndHashCode.Include
    private UUID uuid;
    @NonNull
    private String name;
}
