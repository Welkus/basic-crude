package com.crudelearning.cruddemo.service;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserFilter {
    private String firstName = null;
    private String lastName = null;
    private String role = null;
}
