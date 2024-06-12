package com.dedalus.animal.model;

import lombok.*;

import javax.persistence.*;
import java.util.UUID;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "ANIMAL")
public class AnimalEntity {

    @Id
    @GeneratedValue
    @Column(columnDefinition = "uuid")
    @EqualsAndHashCode.Include
    private UUID uuid;

    private String name;
    @Enumerated(EnumType.STRING)
    private SpeciesType type;
    private String comment;
    private Boolean available;
    private UUID owner;
}
