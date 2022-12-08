package com.abc.app.service;

import com.abc.app.eh.PatientNotFoundException;
import com.abc.app.model.Patient;
import com.abc.app.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppService {

    @Autowired
    PatientRepository patientRepository;

    public Patient getPatientById(Long id)  {
        Optional<Patient> patient = patientRepository.findById(id);
        if(patient.isPresent())
        return patient.get();
        else
            throw new PatientNotFoundException();
    }

    public List<Patient> getPatient()  {
        List<Patient> patient = patientRepository.findAll();
        return patient;
    }

    public void createPatient(Patient patient) {
        patientRepository.save(patient);
    }

    public void deletePatientById(Long id) {
        patientRepository.deleteById(id);
    }

    public void updatePatient(Patient patient) {
        patientRepository.save(patient);
    }
}
