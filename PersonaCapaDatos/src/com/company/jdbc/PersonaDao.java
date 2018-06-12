package com.company.jdbc;

import com.company.dto.PersonaDTO;

import java.sql.SQLException;
import java.util.List;

/**
 * @author Cesar Segura Granados
 * 04/06/2018
 * @version 1.0
 */
public interface PersonaDao {

    int insert(PersonaDTO personaDTO) throws SQLException, IllegalAccessException, InstantiationException, ClassNotFoundException;

    int update(PersonaDTO personaDTO) throws SQLException, IllegalAccessException, InstantiationException, ClassNotFoundException;

    int delete(PersonaDTO personaDTO) throws SQLException, IllegalAccessException, InstantiationException, ClassNotFoundException;

    List<PersonaDTO> select() throws SQLException, IllegalAccessException, InstantiationException, ClassNotFoundException;
}
