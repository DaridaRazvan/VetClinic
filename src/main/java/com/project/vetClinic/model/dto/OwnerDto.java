package com.project.vetClinic.model.dto;

import com.project.vetClinic.model.Owner;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OwnerDto{
    private Long id;
    private String name;
    private String password;
    private String phone;
    private String email;

    public OwnerDto convertModelToDto(Owner owner){
        return new OwnerDto(owner.getId(),
                owner.getName(),
                owner.getPassword(),
                owner.getEmail(),
                owner.getPhone());
    }
}
