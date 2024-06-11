package com.dedalus.animal.model;

import java.util.UUID;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OwnerDto {
    private UUID uuid;
    private String name;
    private String address;
}
