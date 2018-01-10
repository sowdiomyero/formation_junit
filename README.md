#### Tests Unitaires avec JUnit


# Exercices à faire

## Gestion des reservations

  Dans une interface sn.sonatel.formation.junit.repository.ReservationRepository.java :
  
  - Ecrire les fonctions suivantes :
	findReservationByName(String name);
	findAll()
	create (Reservation rv)
	update(Reservation rv)
  - Implementez cette interface en prenant soin de stocker les données dans une structure de données.
  - Creez une classe ReservationRepositoryTest.java
  - Testez les méthodes de l'implementation en suivant les spécifications suivantes :

	* Une reservation possède les proprietés suivantes : 
		String:nom
		enum:statut (PENDING, ACCEPTED, PAYED, REJECTED, CANCELED)
		String:auteur		Date:dateReservation
		
	* Une reservation doit posseder un nom unique ReservationNameMustBeUniqueException
	* Une reservation doit obligatoirement posseder un nom ReservationNameCannotBeNullException
	* On ne peut pas mettre à jour une reservation qui n'existe pas. Jeter une exception ReservationNotExistException
	* On ne peut pas creer une reservation avec un statut autre que PENDING

  - Testez les méthodes en enrichissant les cas d'exception possibles (les dates de reservation).

    
 

Couche Service : 


Dans une interface sn.sonatel.formation.junit.repository.ReservationService.java :
  
  - Ecrire les fonctions suivantes :
	findReservationByName(String name);
	findAll()
	create (Reservation rv)
	update(Reservation rv)
  - Implementez cette interface en prenant soin de stocker les données dans une structure de données.
  - Creez une classe ReservationRepositoryTest.java
  - Testez les méthodes de l'implementation en suivant les spécifications suivantes :

	* Une reservation possède les proprietés suivantes : 
		String:nom
		enum:statut (PENDING, ACCEPTED, PAYED, REJECTED, CANCELED)
		String:auteur		Date:dateReservation
	* Une reservation doit posseder un nom unique ReservationNameMustBeUniqueException
	* Une reservation doit obligatoirement posseder un nom ReservationNameCannotBeNullException
	* On ne peut pas mettre à jour une reservation qui n'existe pas. Jeter une exception ReservationNotExistException
	* On ne peut pas creer une reservation avec un statut autre que PENDING

  - Testez les méthodes en enrichissant les cas d'exception possibles (les dates de reservation).


