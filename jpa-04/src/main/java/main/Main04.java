package main;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jpabasic.reserve.domain.Grade;
import jpabasic.reserve.domain.Hotel;
import jpabasic.reserve.jpa.EMF;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main04 {
    private static Logger logger = LoggerFactory.getLogger(Main04.class);

    public static void main(String[] args) {
        EMF.init();

        Hotel hotel = new Hotel("H-01", "SSG", 2024, Grade.S7);
        save(hotel);

        Hotel h2 = read("H-01");

        if (h2 == null) {
            logger.info("NULL");
        } else {
            logger.info("해당 호텔의 정보 : {}", h2);
        }

        EMF.close();
    }

    private static void save(Hotel entity) {
        EntityManager em = EMF.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            em.persist(entity);
            tx.commit();
            logger.info("Hotel saved: " + entity.getName());
        } catch (Exception e) {
            tx.rollback();
            throw e;
        } finally {
            em.close();
        }
    }

    private static Hotel read(String id) {
        EntityManager em = EMF.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        Hotel hotel = null;

        try {
            tx.begin();
            hotel = em.find(Hotel.class, id);
            tx.commit();
            return hotel;
        } catch (Exception e) {
            throw e;
        } finally {
            em.close();
        }
        return hotel;
    }
}
