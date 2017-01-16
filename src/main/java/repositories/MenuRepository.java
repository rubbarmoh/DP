package repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import domain.Menu;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Integer>{

}
