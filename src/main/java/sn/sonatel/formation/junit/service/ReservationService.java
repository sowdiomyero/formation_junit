package sn.sonatel.formation.junit.service;

import sn.sonatel.formation.junit.exceptions.ReservationNameCannotBeNullException;
import sn.sonatel.formation.junit.exceptions.ReservationNameMustBeUniqueException;
import sn.sonatel.formation.junit.exceptions.ReservationNotFoundException;
import sn.sonatel.formation.junit.model.Reservation;

import java.util.List;

/**
 * Created by ext_sow18 on 09/01/2018.
 */
public interface ReservationService {

    public Reservation reserver(Reservation rv) throws ReservationNameMustBeUniqueException, ReservationNameCannotBeNullException;
    public List<Reservation> finduserReservations(String author);
    public boolean annuler(Reservation rv) throws ReservationNotFoundException;
    public Reservation update(Reservation rv);
}
