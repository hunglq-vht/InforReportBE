package com.information.api.models;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

public class Reporter {
    private String name;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    private String address;

    @OneToMany(mappedBy = "reporter", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Information> informationList = new ArrayList<Information>();
}
