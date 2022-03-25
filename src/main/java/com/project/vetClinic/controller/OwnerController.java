package com.project.vetClinic.controller;

import com.project.vetClinic.model.Owner;
import com.project.vetClinic.model.response.Response;
import com.project.vetClinic.service.OwnerService;
import com.project.vetClinic.service.serviceImpl.OwnerServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

import static java.time.LocalDateTime.now;

@RestController
@RequestMapping("/owner")
@RequiredArgsConstructor
public class OwnerController {
    private final OwnerServiceImpl ownerService;

    @GetMapping("/getAll/{page}")
    public ResponseEntity<Response> getOwners(@PathVariable("page") int page) {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("owners", ownerService.getAll(page, 10)))
                        .message("Owners retrieved")
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .build()
        );
    }

    @PostMapping("/save")
    public ResponseEntity<Response> saveOwner(@RequestBody Owner owner) {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("owner", ownerService.create(owner)))
                        .message("Owner created")
                        .status(HttpStatus.CREATED)
                        .statusCode(HttpStatus.CREATED.value())
                        .build()
        );
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Response> getOwner(@PathVariable("id") Long id) {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("owner", ownerService.get(id)))
                        .message("Owner retrieved")
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .build()
        );
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Response> deleteOwner(@PathVariable("id") Long id) {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("deleted", ownerService.delete(id)))
                        .message("Owner deleted")
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .build()
        );
    }

    @PostMapping("/update")
    public ResponseEntity<Response> updateOwner(@RequestBody Owner owner) {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("owner", ownerService.update(owner)))
                        .message("Owner updated")
                        .status(HttpStatus.CREATED)
                        .statusCode(HttpStatus.CREATED.value())
                        .build()
        );
    }

    @GetMapping("/getPets/{id}")
    public ResponseEntity<Response> getPetsForOwner(@PathVariable("id") Long id) {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("pets", ownerService.getPetsForOwner(id)))
                        .message("Pet list")
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .build()
        );
    }

    @GetMapping("/getAppointments/{id}")
    public ResponseEntity<Response> getAppointmentsForOwner(@PathVariable("id") Long id) {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("appointments", ownerService.getAppointmentsForOwner(id)))
                        .message("Appointment list")
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .build()
        );
    }
}
