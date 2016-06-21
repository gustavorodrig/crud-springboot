package br.com.gustavorodrigues.repository;

import br.com.gustavorodrigues.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Usuarios extends JpaRepository<Usuario, Long> {

}
