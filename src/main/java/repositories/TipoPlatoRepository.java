package repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import domain.TipoPlato;

@Repository
public interface TipoPlatoRepository extends JpaRepository<TipoPlato, Integer>{

}
