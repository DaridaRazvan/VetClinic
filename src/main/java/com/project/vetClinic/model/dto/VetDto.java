package com.project.vetClinic.model.dto;

import com.project.vetClinic.model.Owner;
import com.project.vetClinic.model.Vet;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VetDto{
    private Long id;
    private String name;
    private String password;
    private String phone;
    private String email;

    public VetDto convertModelToDto(Vet vet){
        return new VetDto(vet.getId(),
                vet.getName(),
                vet.getPassword(),
                vet.getPhone(),
                vet.getEmail());
    }
}
