package com.dedalus.animal.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.UUID;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ANIMAL")
public class AnimalEntity {

    @Id
    @GeneratedValue
    private UUID uuid;

    private String name;
    private SpeciesType type;
    private String comment;
    private Boolean available;
    private UUID owner;
}
