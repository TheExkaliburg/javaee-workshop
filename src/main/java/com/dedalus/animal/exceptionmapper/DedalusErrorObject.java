package com.dedalus.animal.exceptionmapper;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DedalusErrorObject {
    String message;
    String stackTrace;
    String detail;
}
