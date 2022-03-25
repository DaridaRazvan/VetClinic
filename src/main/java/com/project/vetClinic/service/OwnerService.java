package com.project.vetClinic.service;

import com.project.vetClinic.model.Appointment;
import com.project.vetClinic.model.Owner;
import com.project.vetClinic.model.Pet;
import com.project.vetClinic.model.dto.AppointmentDto;
import com.project.vetClinic.model.dto.OwnerDto;
import com.project.vetClinic.model.dto.PetDto;

import java.util.Collection;

public interface OwnerService {
    OwnerDto create(Owner owner);
    OwnerDto get(Long id);
    OwnerDto update(Owner owner);
    Boolean delete(Long id);
    Collection<OwnerDto> getAll(int page, int limit);

    Collection<PetDto> getPetsForOwner(Long id);
    Collection<AppointmentDto> getAppointmentsForOwner(Long id);
}
