package com.example.catchtable.dto.menu;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PostMenuRequest {
    private String name;
    private Long price;
}
