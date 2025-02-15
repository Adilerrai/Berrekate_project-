package spring.berrekate.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.stereotype.Repository;
import spring.berrekate.entities.UsersEvents;
@Repository
public interface UsersEventsRepository extends JpaRepository<UsersEvents,Long>{
	@Query("SELECT t FROM UsersEvents t WHERE t.user_id=?1 AND t.event_id=?2")
	List<UsersEvents> checkUserEvent(Long user_id, long event_id);
	
	@Query("SELECT t FROM UsersEvents t WHERE t.event_id=?1")
	List<UsersEvents> findAllEventEntries(long event_id);
	
	UsersEvents findById(long id);

	void deleteById(int id);
}
