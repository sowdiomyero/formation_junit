package sn.sonatel.formation.junit.repository;

import sn.sonatel.formation.junit.exceptions.ReservationNameCannotBeNullException;
import sn.sonatel.formation.junit.exceptions.ReservationNameMustBeUniqueException;
import sn.sonatel.formation.junit.exceptions.ReservationNotFoundException;
import sn.sonatel.formation.junit.model.Reservation;

import java.util.List;

/**
 * Created by ext_sow18 on 08/01/2018.
 */
public interface ReservationRepository {
    Reservation findReservationByName(String name) throws ReservationNotFoundException;
    List<Reservation> findAll();
    Reservation create (Reservation rv) throws ReservationNameMustBeUniqueException, ReservationNameCannotBeNullException;
    boolean update(Reservation rv) throws ReservationNotFoundException;
}
