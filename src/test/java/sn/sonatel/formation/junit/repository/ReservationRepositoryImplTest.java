package sn.sonatel.formation.junit.repository;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import sn.sonatel.formation.junit.exceptions.ReservationNameCannotBeNullException;
import sn.sonatel.formation.junit.exceptions.ReservationNameMustBeUniqueException;
import sn.sonatel.formation.junit.exceptions.ReservationNotFoundException;
import sn.sonatel.formation.junit.model.Reservation;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import static org.junit.Assert.*;

/**
 * Created by ext_sow18 on 09/01/2018.
 */
public class ReservationRepositoryImplTest {

    ReservationRepository repo;
    List<Reservation> reservations;

    @Before
    public void setUp() throws Exception {
        Reservation rv1 = new Reservation(UUID.randomUUID().toString(),"RV1", "Diom", new Date(), Reservation.STATUT.PENDING);
        Reservation rv2 = new Reservation(UUID.randomUUID().toString(),"RV2", "Aziz", new Date(), Reservation.STATUT.REJECTED);
        Reservation rv3 = new Reservation(UUID.randomUUID().toString(),"RV3", "Gatta", new Date(), Reservation.STATUT.PAYED);
        Reservation rv4 = new Reservation(UUID.randomUUID().toString(),"RV4", "Abdou Karim", new Date(), Reservation.STATUT.PENDING);
        Reservation rv5 = new Reservation(UUID.randomUUID().toString(),"RV5", "Fatoumata", new Date(), Reservation.STATUT.ACCEPTED);
        reservations = new ArrayList<Reservation>();
        reservations.add(rv1);
        reservations.add(rv2);
        reservations.add(rv3);
        reservations.add(rv4);
        reservations.add(rv5);
        repo = new ReservationRepositoryImpl(reservations);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void findReservationByName_shouldFindSuccessfully() throws Exception, ReservationNotFoundException {
        Reservation rv = repo.findReservationByName("RV1");
        assertEquals("RV1", rv.getNom());
    }

    @Test(expected = ReservationNotFoundException.class)
    public void findReservationByName_shouldThrowReservationNotFoundException() throws Exception, ReservationNotFoundException {
        Reservation rv = repo.findReservationByName("RV10");
    }

    @Test
    public void findAll_shouldReturnAllListeInitiated() throws Exception {
        assertEquals(5, repo.findAll().size());
    }

    @Test(expected = ReservationNameMustBeUniqueException.class)
    public void create_shoudlThrowReservationNameMustBeUniqueException() throws Exception, ReservationNameMustBeUniqueException, ReservationNameCannotBeNullException {
        Reservation rv6 = new Reservation("RV5", "Ndongo", new Date(), Reservation.STATUT.ACCEPTED);
        repo.create(rv6);
    }

    @Test(expected = ReservationNameCannotBeNullException.class)
    public void create_shoudlThrowReservationNameCannotBeNullException() throws Exception, ReservationNameMustBeUniqueException, ReservationNameCannotBeNullException {
        Reservation rv6 = new Reservation(null, "Ndongo", new Date(), Reservation.STATUT.ACCEPTED);
        repo.create(rv6);
    }

    @Test(expected = IllegalArgumentException.class)
    public void create_shoudlThrowIllegalArgumentException() throws Exception, ReservationNameMustBeUniqueException, ReservationNameCannotBeNullException {
        repo.create(null);
    }

    @Test(expected = ReservationNameCannotBeNullException.class)
    public void create_EmptyReservationName_shoudlThrowReservationNameCannotBeNullException() throws Exception, ReservationNameMustBeUniqueException, ReservationNameCannotBeNullException {
        Reservation rv6 = new Reservation("", "Ndongo", new Date(), Reservation.STATUT.ACCEPTED);
        repo.create(rv6);
    }


    @Test
    public void create_shoudlReturnNewObject() throws Exception, ReservationNameMustBeUniqueException, ReservationNameCannotBeNullException {
        Reservation rv6 = new Reservation("RV6", "Ndongo", new Date(), Reservation.STATUT.ACCEPTED);
        int sizeBeforeAdd = reservations.size();
        repo.create(rv6);
        int sizeAfterAdd = sizeBeforeAdd +1;
        assertNotNull(rv6.getId());
        assertFalse(rv6.getId().isEmpty());
        assertEquals(sizeAfterAdd, reservations.size());
    }


    @Test
    public void update() throws Exception, ReservationNotFoundException {
        Reservation rv = repo.findReservationByName("RV1");
        rv.setAuteur("UpdatedAuthor");
        assertTrue(repo.update(rv));
        assertEquals("UpdatedAuthor", repo.findReservationByName(rv.getNom()).getAuteur());
    }

    @Test(expected = IllegalArgumentException.class)
    public void update_shouldThrowReservationNotFoundException() throws Exception, ReservationNotFoundException {
        boolean rv = repo.update(null);

    }

}