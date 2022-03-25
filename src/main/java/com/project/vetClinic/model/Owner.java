package com.project.vetClinic.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Owner extends User{
    @OneToMany(mappedBy = "owner")
    List<Pet> pets;

    @OneToMany(mappedBy = "owner")
    List<Appointment> appointments;
}
