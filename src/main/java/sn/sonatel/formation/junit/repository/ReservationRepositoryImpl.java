package sn.sonatel.formation.junit.repository;

import sn.sonatel.formation.junit.exceptions.ReservationNameCannotBeNullException;
import sn.sonatel.formation.junit.exceptions.ReservationNameMustBeUniqueException;
import sn.sonatel.formation.junit.exceptions.ReservationNotFoundException;
import sn.sonatel.formation.junit.model.Reservation;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by ext_sow18 on 08/01/2018.
 */
public class ReservationRepositoryImpl implements ReservationRepository {


    List<Reservation> reservations;

    public ReservationRepositoryImpl(List<Reservation> reservations) {
        this.reservations = reservations;
    }

    public Reservation findReservationById(String id) throws ReservationNotFoundException {

        for(Reservation rv : reservations){
            if(rv.getId().equalsIgnoreCase(id))
                return rv;
        }
        throw new ReservationNotFoundException("Aucune reservation à ce nom.");
    }

    public Reservation findReservationByName(String name) throws ReservationNotFoundException {

        for(Reservation rv : reservations){
            if(rv.getNom().equalsIgnoreCase(name))
                return rv;
        }
        throw new ReservationNotFoundException("Aucune reservation à ce nom.");
    }

    public List<Reservation> findAll() {
        return reservations;
    }

    public Reservation create(Reservation rv) throws ReservationNameMustBeUniqueException, ReservationNameCannotBeNullException {
        if(rv == null)
            throw new IllegalArgumentException("Vous devez renseigner une reservation valide");
        if(rv.getNom() == null || rv.getNom().isEmpty())
            throw new ReservationNameCannotBeNullException("Vous devez renseigner OBLIGATOIREMENT un nom de reservation.");
        if(rv.getId() != null || (rv.getId() != null && ! rv.getNom().isEmpty()))
            throw new IllegalArgumentException("Cette reservation possède dejà un identifiant. Vous devez appeler la methode update");

        try {
            if (findReservationByName(rv.getNom()) != null)
                throw new ReservationNameMustBeUniqueException("Une reservation avec le même nom existe dejà");
        } catch (ReservationNotFoundException e) {
            //
        }

        rv.setId(UUID.randomUUID().toString());
        rv.setDateReservation(new Date());
         reservations.add(rv);
         return rv;
    }

    public boolean update(Reservation rv) throws ReservationNotFoundException {

        if(rv == null)
            throw new IllegalArgumentException("Vous ne pouvez modifier un objet null");
        try {

            Reservation found = findReservationById(rv.getId());
            //puisque liste, donc dejà mis à jour
        } catch (ReservationNotFoundException e) {
            throw e;
        }

        return true;
    }
}
