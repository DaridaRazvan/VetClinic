package com.project.vetClinic.service;

import com.project.vetClinic.model.Appointment;
import com.project.vetClinic.model.Owner;
import com.project.vetClinic.model.Pet;
import com.project.vetClinic.model.dto.AppointmentDto;
import com.project.vetClinic.model.dto.PetDto;

import java.util.Collection;

public interface PetService {
    PetDto create(PetDto petDto);
    PetDto get(Long id);
    PetDto update(PetDto petDto);
    Boolean delete(Long id);

    Collection<AppointmentDto> getPetAppointments(Long id);
}
