package com.dedalus.animal.restclient;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RemoteAnimal {

    String name;
    RemoteTaxonomy taxonomy;
}
