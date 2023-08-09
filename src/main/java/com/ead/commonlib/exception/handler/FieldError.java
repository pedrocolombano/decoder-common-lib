package com.ead.commonlib.exception.handler;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class FieldError implements Serializable {

    private static final long serialVersionUID = 5462426397929699246L;

    private String field;
    private String errorMessage;

}
