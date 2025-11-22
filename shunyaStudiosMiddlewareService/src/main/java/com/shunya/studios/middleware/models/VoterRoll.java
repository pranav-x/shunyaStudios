package com.shunya.studios.middleware.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import jakarta.persistence.*;

@Data @NoArgsConstructor @AllArgsConstructor
@Entity @Table(name = "voter_roll")
public class VoterRoll {
    @Id
    @Column(name = "serial_no")
    private Integer serialNo;

    @Column(name = "house_no", length = 32)
    private String houseNo;

    @Column(length = 128)
    private String name;

    @Column(name = "relation_type", length = 8)
    private String relationType;

    @Column(name = "relation_name", length = 128)
    private String relationName;

    @Column(length = 8)
    private String gender;

    private Integer age;

    @Column(name = "voter_id", length = 64)
    private String voterId;

    // getters/setters omitted for brevity
    // (generate them or use Lombok if you already have it)
}
