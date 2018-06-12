package com.company;

import com.company.dto.PersonaDTO;
import com.company.jdbc.PersonaDao;
import com.company.jdbc.PersonaDaoJdbc;

import java.sql.SQLException;
import java.util.List;

public class Main {

    public static void main(String[] args)
            throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        PersonaDao personaDao = new PersonaDaoJdbc();
        PersonaDTO personaDTO = new PersonaDTO();
        personaDTO.setNombre("Cesar_01");
        personaDTO.setApellido("Segura_01");
        try{
            personaDao.insert(personaDTO);
//            personaDao.delete(new PersonaDTO(2));
//            personaDao.update(new PersonaDTO(
//                    5,
//                    "Patsy",
//                    "Alcántara"));
//            List<PersonaDTO> personaDTOList = personaDao.select();
//            for (PersonaDTO personaDTO1: personaDTOList) {
//                System.out.println(personaDTO1.toString());
//            }
        } finally {
            System.out.println("Termina ejecución");
        }
    }
}
