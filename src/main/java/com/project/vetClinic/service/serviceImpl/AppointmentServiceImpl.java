package com.project.vetClinic.service.serviceImpl;

import com.project.vetClinic.model.Appointment;
import com.project.vetClinic.model.Owner;
import com.project.vetClinic.model.Pet;
import com.project.vetClinic.model.Vet;
import com.project.vetClinic.model.dto.AppointmentDto;
import com.project.vetClinic.repository.AppointmentRepository;
import com.project.vetClinic.repository.OwnerRepository;
import com.project.vetClinic.repository.PetRepository;
import com.project.vetClinic.repository.VetRepository;
import com.project.vetClinic.service.AppointmentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import static java.lang.Boolean.TRUE;


@RequiredArgsConstructor
@Service
@Transactional
@Slf4j
public class AppointmentServiceImpl implements AppointmentService {
    private final AppointmentRepository appointmentRepository;
    private final OwnerRepository ownerRepository;
    private final VetRepository vetRepository;
    private final PetRepository petRepository;

    @Override
    public AppointmentDto create(AppointmentDto appointmentDto) {
        log.info("Creating appointment with date: {}", appointmentDto.getDate());

        Owner owner = ownerRepository.getById(appointmentDto.getOwnerId());
        Pet pet = petRepository.getById(appointmentDto.getPetId());
        Vet vet = vetRepository.getById(appointmentDto.getVetId());

        Appointment appointment = new Appointment();
        appointment.setOwner(owner);
        appointment.setPet(pet);
        appointment.setVet(vet);
        appointment.setDate(appointmentDto.getDate());
        appointment.setStart(appointmentDto.getStart());
        appointment.setFinish(appointmentDto.getFinish());
        appointment.setReason(appointmentDto.getReason());

        return new AppointmentDto().convertModelToDto(appointmentRepository.save(appointment));

    }

    @Override
    public AppointmentDto get(Long id) {
        log.info("Getting appointment with id: {}", id);
        return new AppointmentDto().convertModelToDto(appointmentRepository.getById(id));
    }

    @Override
    public AppointmentDto update(AppointmentDto appointmentDto) {
        log.info("Updating appointment with id: {}", appointmentDto.getId());
        Appointment appointment = appointmentRepository.getById(appointmentDto.getId());
        appointment.setDate(appointmentDto.getDate());
        appointment.setStart(appointmentDto.getStart());
        appointment.setFinish(appointmentDto.getFinish());
        appointment.setReason(appointmentDto.getReason());

        return new AppointmentDto().convertModelToDto(appointmentRepository.save(appointment));
    }

    @Override
    public Boolean delete(Long id) {
        log.info("Deleting appointment with id: {}", id);
        appointmentRepository.deleteById(id);
        return TRUE;
    }
}
