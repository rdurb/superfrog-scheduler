package tcu.webtech.superfrogscheduler.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tcu.webtech.superfrogscheduler.models.Event;
import tcu.webtech.superfrogscheduler.models.EventStatus;

import java.util.List;


@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
    public List<Event> findAllByStatus(EventStatus status);
}
