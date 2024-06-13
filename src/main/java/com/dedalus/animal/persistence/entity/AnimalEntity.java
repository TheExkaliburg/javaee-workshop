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
    @Column(columnDefinition = "uuid")
    private UUID speciesUuid;
    private String comment;
    private String owner;

    public boolean isAvailable() {
        return owner == null;
    }
}
