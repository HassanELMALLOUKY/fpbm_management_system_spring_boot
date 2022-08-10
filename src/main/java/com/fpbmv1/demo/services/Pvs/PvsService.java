package com.fpbmv1.demo.services.Pvs;

import com.fpbmv1.demo.Pvs.Pv;
import com.fpbmv1.demo.entites.*;
import com.fpbmv1.demo.entites.Module;
import com.fpbmv1.demo.services.Gestion_Examen.*;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Data
@Service
public class PvsService {
    //private static int nbEtudiantsCourants=1;
    private Pv pv;
    @Autowired
    private SurveillantService surveillantService;
    @Autowired
    private ProfesseurService professeurService;
    @Autowired
    private SalleService salleService;
    @Autowired
    private ExamenService examenService;
    @Autowired
    private EtudiantService etudiantService;
    @Autowired
    private FiliereService filiereService;
    @Autowired
    private SemestreService semestreService;
    @Autowired
    private ModuleService moduleService;

    public List<Pv> makePv(String filiere, String semestre, String module) {
        int nbEtudiantsCourants = 0;
        int nbSurveillantsCourants = 0;
        Filiere f = filiereService.getFiliereByName(filiere);
        Semestre s = semestreService.getFiliereByName(semestre);
        Module m = moduleService.getFiliereByName(module);
        List<Salle> salles = salleService.getAllSalles();
        List<Pv> pvs = new ArrayList<Pv>();
        List<Surveillant> surveillants = surveillantService.getSurveillantNames();

        List<Etudiant> etudiants = etudiantService.getEtudiantsByFiliere(f.getName(), s.getName(), m.getName());
        //Le nombre d'etudiants qui pas encore affecter à une salle d'examen
        int restEtud = etudiants.size();
        // indice de la salle dans la base
        int index = 0;

        //Le nombre d'etudiants qui pas encore affecter à une salle d'examen
        int restSurveillants = surveillants.size();

        while (restEtud > 0 && restSurveillants > 0) {

            Pv pv = new Pv();
            String p = salles.get(index).getName();
            pv.setLocal(salles.get(index).getName());

            pv.setModule(m.getName());
            //distrubier les etudiants dans les salles disponibles
            if (restEtud > salles.get(index).getCapaciteEtudiant()) {
                pv.setEtudiants(etudiants.subList(nbEtudiantsCourants, salles.get(index).getCapaciteEtudiant() + nbEtudiantsCourants));
                nbEtudiantsCourants += salles.get(index).getCapaciteEtudiant();

            } else {
                pv.setEtudiants(etudiants.subList(nbEtudiantsCourants, etudiants.size()));

            }
            //distrubier les surveillants dans les salles disponibles
            if (restSurveillants > salles.get(index).getNombreSurveillant()) {
                pv.setSurveillants(surveillants.subList(nbSurveillantsCourants, salles.get(index).getNombreSurveillant() + nbSurveillantsCourants));
                nbSurveillantsCourants += salles.get(index).getNombreSurveillant();
            } else {
                pv.setSurveillants(surveillants.subList(nbSurveillantsCourants, surveillants.size()));

            }

            restSurveillants -= salles.get(index).getNombreSurveillant();
            restEtud -= salles.get(index).getCapaciteEtudiant();

            index++;

            pvs.add(pv);


        }
        //si les salles ne sont pas suffisantes
        if (restEtud > 0) {
            System.out.println("affecter : " + restEtud + " étudinats à la salle X sont: " + etudiants.subList(nbEtudiantsCourants, etudiants.size()));
        }


        return pvs;


    }

    public Filiere makepv2(String filiere) {
        Filiere f = filiereService.getFiliereByName(filiere);
        return f;

    }
}
