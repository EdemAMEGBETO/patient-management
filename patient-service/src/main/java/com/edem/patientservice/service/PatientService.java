package com.edem.patientservice.service;

import com.edem.patientservice.dto.PatientResponseDTO;
import com.edem.patientservice.mapper.PatientMapper;
import com.edem.patientservice.model.Patient;
import com.edem.patientservice.repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PatientService {

    private final PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public List<PatientResponseDTO> getPatients() {
        List<Patient> patients = patientRepository.findAll();

        return patients.stream().map(PatientMapper::toDTO).toList();
    }
}
