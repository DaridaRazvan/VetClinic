package com.project.vetClinic.service.serviceImpl;

import com.project.vetClinic.model.Appointment;
import com.project.vetClinic.model.Owner;
import com.project.vetClinic.model.Pet;
import com.project.vetClinic.model.dto.AppointmentDto;
import com.project.vetClinic.model.dto.OwnerDto;
import com.project.vetClinic.model.dto.PetDto;
import com.project.vetClinic.repository.OwnerRepository;
import com.project.vetClinic.service.OwnerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static java.lang.Boolean.TRUE;

@RequiredArgsConstructor
@Service
@Transactional
@Slf4j
public class OwnerServiceImpl implements OwnerService {
    private final OwnerRepository ownerRepository;

    @Override
    public OwnerDto create(Owner owner) {
        log.info("Saving new owner: {}",owner.getName());
        return new OwnerDto().convertModelToDto(ownerRepository.save(owner));
    }

    @Override
    public OwnerDto get(Long id) {
        log.info("Getting owner with id: {}",id);
        return new OwnerDto().convertModelToDto(ownerRepository.findById(id).get());
    }

    @Override
    public OwnerDto update(Owner owner) {
        log.info("Updating owner with id: {}",owner.getId());
        return new OwnerDto().convertModelToDto(ownerRepository.save(owner));
    }

    @Override
    public Boolean delete(Long id) {
        log.info("Deleting owner: {}",id);
        ownerRepository.deleteById(id);
        return TRUE;
    }

    @Override
    public Collection<OwnerDto> getAll(int page, int limit){
        log.info("Getting {} owners from page {}", limit, page);
        List<Owner> owners = ownerRepository.findAll(PageRequest.of(page,limit)).toList();

        List<OwnerDto> ownersDto= new ArrayList<>();
        owners.forEach(
                owner -> ownersDto.add(new OwnerDto().convertModelToDto(owner))
        );

        return ownersDto;
    }

    @Override
    public Collection<PetDto> getPetsForOwner(Long id) {
        log.info("List of pets for owner: {}",id);
        Owner owner = ownerRepository.getById(id);
        List<Pet> pets =  owner.getPets();

        List<PetDto> petsDto = new ArrayList<>();
        pets.forEach(
                pet -> petsDto.add(new PetDto().convertModelToDto(pet)));

        return petsDto;
    }

    @Override
    public Collection<AppointmentDto> getAppointmentsForOwner(Long id) {
        log.info("List of appointments for owner: {}",id);
        Owner owner = ownerRepository.getById(id);
        List<Appointment> appointments =  owner.getAppointments();

        List<AppointmentDto> appointmentsDto = new ArrayList<>();
        appointments.forEach(
                appointment -> appointmentsDto.add(new AppointmentDto().convertModelToDto(appointment))
        );

        return appointmentsDto;
    }
}
