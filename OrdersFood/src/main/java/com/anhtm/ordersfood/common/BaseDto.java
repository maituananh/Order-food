package com.anhtm.ordersfood.common;


import lombok.Data;

import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@MappedSuperclass
public abstract class BaseDto<IdType extends Serializable> {

    private LocalDateTime createdDate;

    private LocalDateTime updatedDate;

    private Boolean active = true;
}
