package com.academy.naveenautomationlabs.api.post;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class User {
    private String name;
    private String email;
    private String gender;
    private String status;
}
