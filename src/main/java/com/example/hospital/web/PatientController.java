package com.example.hospital.web;

import com.example.hospital.entities.Patient;
import com.example.hospital.repository.PatientRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@Controller
@AllArgsConstructor
public class PatientController {

    private PatientRepository patientRepository;
    @GetMapping("/index")
    public String index(Model model, @RequestParam(name ="page",defaultValue = "0")int page,
                                    @RequestParam (name = "size", defaultValue = "2")  int size,
                                    @RequestParam(name = "keyword", defaultValue = "") String kw){
        Page<Patient> pagePatientList = patientRepository.findByNomContains(kw,PageRequest.of(page,size));
        model.addAttribute("listPatients",pagePatientList);
        model.addAttribute("pages", new int[pagePatientList.getTotalPages()]);
        model.addAttribute("currentPage", page);
        model.addAttribute("keyword", kw);

        return "patients";

    }

    @GetMapping("/delete")
    public String delete(Long id){
        patientRepository.deleteById(id);
        return "redirect:/index";}

}
