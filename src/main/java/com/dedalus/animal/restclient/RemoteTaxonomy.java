package com.dedalus.animal.restclient;

import javax.json.bind.annotation.JsonbProperty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class RemoteTaxonomy {
    String kingdom;
    String phylum;
    @JsonbProperty("class")
    String clazz;
    String order;
    String family;
    String genus;
    @JsonbProperty("scientific_name")
    String scientificName;
}
