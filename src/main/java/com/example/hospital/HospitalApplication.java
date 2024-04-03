package com.example.hospital;

import com.example.hospital.entities.Patient;
import com.example.hospital.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class  HospitalApplication implements CommandLineRunner {

    @Autowired
    private PatientRepository patientRepository;
    public static void main(String[] args) {
        SpringApplication.run(HospitalApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        //Using builder
        Patient patient1 = Patient.builder().nom("ahmad")
                .score(23).dateNaissance(new Date()).malade(true).build();

        Patient patient2 = Patient.builder().nom("sara")
                .score(3).dateNaissance(new Date()).malade(true).build();

        Patient patient3 = Patient.builder().nom("ali")
                .score(43).dateNaissance(new Date()).malade(true).build();

        patientRepository.save(patient1);
        patientRepository.save(patient2);
        patientRepository.save(patient3 );


    }
}
