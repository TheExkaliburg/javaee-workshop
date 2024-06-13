package com.dedalus.animal.service.mapper;

import com.dedalus.animal.model.response.SpeciesDetailedResponse;
import com.dedalus.animal.model.response.SpeciesDto;
import com.dedalus.animal.model.response.SpeciesListResponse;
import com.dedalus.animal.persistence.entity.SpeciesEntity;
import com.dedalus.animal.service.SpeciesService;
import com.dedalus.ninja.client.ApiNinjaService;
import com.dedalus.ninja.model.NinjaAnimalResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Named;

import javax.inject.Inject;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Mapper(componentModel = "cdi")
public abstract class SpeciesMapper {

    @Inject
    SpeciesService speciesService;

    @Inject
    ApiNinjaService ninjaService;

    public SpeciesListResponse mapToListResponse(List<SpeciesEntity> entityList) {
        var builder = SpeciesListResponse.builder();
        builder.list(entityList.stream().map(this::mapSpeciesToDto).collect(Collectors.toList()));
        return builder.build();
    }

    public abstract SpeciesDto mapSpeciesToDto(SpeciesEntity entity);


    @Named("uuidToSpeciesName")
    public String mapSpeciesUuidToName(UUID speciesUuid) {
        return speciesService.findByUuid(speciesUuid).orElseThrow().getName();
    }

    @Named("uuidToSpeciesDto")
    public SpeciesDto mapSpeciesUuidToDto(UUID speciesUuid) {
        SpeciesEntity species = speciesService.findByUuid(speciesUuid).orElseThrow();
        return mapSpeciesToDto(species);
    }

    @Named("uuidToSpeciesDetailedDto")
    public SpeciesDetailedResponse mapSpeciesUuidToDetailedDto(UUID speciesUuid) {
        SpeciesEntity species = speciesService.findByUuid(speciesUuid).orElseThrow();
        NinjaAnimalResponse ninjaAnimalResponse = ninjaService.getAnimals(species.getName()).stream()
                .filter(a -> a.getName().equalsIgnoreCase(species.getName()))
                .findFirst().orElseThrow();


        return SpeciesDetailedResponse.builder()
                .uuid(species.getUuid())
                .name(species.getName())
                .taxonomy(ninjaAnimalResponse.getTaxonomy())
                .characteristics(ninjaAnimalResponse.getCharacteristics())
                .build();
    }


    @Named("nameToSpeciesUuid")
    public UUID mapNameToSpeciesReference(String name) {
        return speciesService.findByName(name)
                .orElseGet(() -> speciesService.create(name)).getUuid();
    }


}
