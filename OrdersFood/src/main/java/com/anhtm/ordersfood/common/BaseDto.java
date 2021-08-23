package com.anhtm.ordersfood.common;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@MappedSuperclass
public abstract class BaseDto<IdType extends Serializable> {

    @Schema(hidden = true)
    private LocalDateTime createdDate;

    @Schema(hidden = true)
    private LocalDateTime updatedDate;

    private Boolean active = true;
}
