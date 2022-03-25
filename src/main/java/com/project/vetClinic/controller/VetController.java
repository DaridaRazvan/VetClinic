package com.project.vetClinic.controller;

import com.project.vetClinic.model.Owner;
import com.project.vetClinic.model.Vet;
import com.project.vetClinic.model.dto.VetDto;
import com.project.vetClinic.model.response.Response;
import com.project.vetClinic.service.serviceImpl.VetServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

import static java.time.LocalDateTime.now;

@RestController
@RequestMapping("/vet")
@RequiredArgsConstructor
public class VetController {
    private final VetServiceImpl vetService;

    @GetMapping("/getAll/{page}")
    public ResponseEntity<Response> getVets(@PathVariable("page") int page) {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("vets", vetService.getAll(page, 10)))
                        .message("Vets retrieved")
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .build()
        );
    }

    @PostMapping("/save")
    public ResponseEntity<Response> saveVet(@RequestBody Vet vet) {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("vet", vetService.create(vet)))
                        .message("Vet created")
                        .status(HttpStatus.CREATED)
                        .statusCode(HttpStatus.CREATED.value())
                        .build()
        );
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Response> getVet(@PathVariable("id") Long id) {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("vet", vetService.get(id)))
                        .message("Vet retrieved")
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .build()
        );
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Response> deleteVet(@PathVariable("id") Long id) {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("deleted", vetService.delete(id)))
                        .message("Vet deleted")
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .build()
        );
    }

    @PostMapping("/update")
    public ResponseEntity<Response> updateVet(@RequestBody Vet vet) {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("vet", vetService.update(vet)))
                        .message("Vet updated")
                        .status(HttpStatus.CREATED)
                        .statusCode(HttpStatus.CREATED.value())
                        .build()
        );
    }

    @GetMapping("/getAppointments/{id}")
    public ResponseEntity<Response> getAppointmentsForVet(@PathVariable("id") Long id) {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("appointments", vetService.getAppointmentsForVet(id)))
                        .message("Appointment list")
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .build()
        );
    }
}
