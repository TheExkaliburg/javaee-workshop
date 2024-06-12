package com.dedalus.animal.persistence.entity;

import com.dedalus.animal.model.SpeciesType;
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
    @NonNull
    private String name;
    @NonNull
    @Enumerated(EnumType.STRING)
    private SpeciesType type;
    private String comment;
    private String owner;

    public boolean isAvailable() {
        return owner == null;
    }
}
