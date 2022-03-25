package com.project.vetClinic.service;

import com.project.vetClinic.model.Vet;
import com.project.vetClinic.model.dto.AppointmentDto;
import com.project.vetClinic.model.dto.VetDto;

import java.util.Collection;

public interface VetService {
    VetDto create(Vet vet);
    VetDto get(Long id);
    VetDto update(Vet vet);
    Boolean delete(Long id);
    Collection<VetDto> getAll(int page, int limit);

    Collection<AppointmentDto> getAppointmentsForVet(Long id);
}
