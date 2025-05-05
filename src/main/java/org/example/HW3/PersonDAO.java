package org.example.HW3;

import jakarta.persistence.*;

public class PersonDAO {
    public EntityManagerFactory emf;
    public EntityManager em;

    public PersonDAO() {

        emf = Persistence.createEntityManagerFactory("my-pu");
        em = emf.createEntityManager();
    }

    public void addPerson(Person person) {
        em.getTransaction().begin();
        em.persist(person);
        em.flush();
        em.getTransaction().commit();
    }

    public void updatePerson(Person person) {
        em.getTransaction().begin();
        em.merge(person);
        em.getTransaction().commit();
    }

    public void deletePerson(Long id) {
        em.getTransaction().begin();
        Person person = em.find(Person.class, id);
        if (person != null) {
            em.remove(person);
            System.out.println("Удалён: " + person);
        } else {
            System.out.println("Запись с ID=" + id + " не найдена");
        }
        em.getTransaction().commit();
    }


    public Person getPersonById(Long id) {
        return em.find(Person.class, id);
    }

    public void close() {
        if (em != null && em.isOpen()) {
            em.close();
        }
        if (emf != null && emf.isOpen()) {
            emf.close();
        }
    }
}