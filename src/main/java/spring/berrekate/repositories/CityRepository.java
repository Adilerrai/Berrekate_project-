package spring.berrekate.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;
import spring.berrekate.entities.City;

@Repository
public interface CityRepository extends JpaRepository<City, Integer> {
	City findById(int id);

	void deleteById(int id);
}