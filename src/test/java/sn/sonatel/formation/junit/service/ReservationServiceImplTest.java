package sn.sonatel.formation.junit.service;

import org.junit.Test;
import org.mockito.Matchers;
import sn.sonatel.formation.junit.exceptions.ReservationNameCannotBeNullException;
import sn.sonatel.formation.junit.exceptions.ReservationNameMustBeUniqueException;
import sn.sonatel.formation.junit.exceptions.ReservationNotFoundException;
import sn.sonatel.formation.junit.model.Reservation;
import sn.sonatel.formation.junit.repository.ReservationRepository;

import java.util.Date;
import java.util.UUID;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;
import static sn.sonatel.formation.junit.model.Reservation.STATUT.RESERVED;

/**
 * Created by ext_sow18 on 09/01/2018.
 */
public class ReservationServiceImplTest {

    ReservationService service;

    ReservationRepository repo;

    @Test
    public void reserver_shouldSuccess() throws Exception, ReservationNameMustBeUniqueException, ReservationNameCannotBeNullException {
        repo = mock(ReservationRepository.class);
        service = new ReservationServiceImpl(repo);
        Reservation rv1 = new Reservation(UUID.randomUUID().toString(),"RV1", "Diom", new Date(), Reservation.STATUT.PENDING);
        Reservation reservation = service.reserver(rv1);
        assertEquals(RESERVED, reservation.getStatut() );
        verify(repo, times(1)).create(any(Reservation.class));
    }


    @Test(expected = ReservationNameCannotBeNullException.class)
    public void reserver_shouldThrowException() throws Exception, ReservationNameMustBeUniqueException, ReservationNameCannotBeNullException, ReservationNotFoundException {

        repo = mock(ReservationRepository.class);

        service = new ReservationServiceImpl(repo);
        Reservation rv1 = new Reservation(UUID.randomUUID().toString(),"RV1", "Diom", new Date(), Reservation.STATUT.PENDING);

        when(repo.create(rv1)).thenThrow(new ReservationNameCannotBeNullException("Exception Lancée depuis le mock"));
        Reservation reservation = service.reserver(rv1);
        //assertEquals(RESERVED, reservation.getStatut() );
    }

    @Test
    public void finduserReservations() throws Exception {
    }

    @Test
    public void annuler() throws Exception {
    }

    @Test
    public void update() throws Exception {
    }

}