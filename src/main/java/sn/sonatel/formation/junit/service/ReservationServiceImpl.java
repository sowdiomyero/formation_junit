package sn.sonatel.formation.junit.service;

import sn.sonatel.formation.junit.exceptions.ReservationNameCannotBeNullException;
import sn.sonatel.formation.junit.exceptions.ReservationNameMustBeUniqueException;
import sn.sonatel.formation.junit.exceptions.ReservationNotFoundException;
import sn.sonatel.formation.junit.model.Reservation;
import sn.sonatel.formation.junit.repository.ReservationRepository;

import java.util.List;

import static sn.sonatel.formation.junit.model.Reservation.STATUT.*;

/**
 * Created by ext_sow18 on 09/01/2018.
 */
public class ReservationServiceImpl implements ReservationService {

    ReservationRepository repo;

    public ReservationServiceImpl(ReservationRepository repo) {
        this.repo = repo;
    }

    public Reservation reserver(Reservation rv) throws ReservationNameMustBeUniqueException, ReservationNameCannotBeNullException {
        if(rv != null && rv.getStatut() != PENDING) {
            throw new IllegalArgumentException();
        }
        rv.setStatut(RESERVED);
        repo.create(rv);
        return rv;
    }

    public List<Reservation> finduserReservations(String author) {
        return null;
    }

    public boolean annuler(Reservation rv) throws ReservationNotFoundException {
        if(rv != null && (rv.getStatut() == PAYED || rv.getStatut() == CANCELED ||rv.getStatut() == REJECTED ) ){
            throw new IllegalArgumentException();
        }
       return repo.update(rv);
    }

    public Reservation update(Reservation rv) {
        return null;
    }
}
