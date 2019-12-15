package com.scs.web.space.api.domain.dto;

import lombok.Data;

@Data
public class AlbumDto {
    private Integer userId;
    private String name;
    private String cover;
}
