package com.anhtm.ordersfood.common;

import com.anhtm.ordersfood.dto.UserDto;
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

    @Schema(hidden = true)
    private Integer createdBy;

    @Schema(hidden = true)
    private Integer updatedBy;

    @Schema(hidden = true)
    private UserDto updatedByUser;

    @Schema(hidden = true)
    private UserDto createdByUser;

    private Boolean active = true;
}
