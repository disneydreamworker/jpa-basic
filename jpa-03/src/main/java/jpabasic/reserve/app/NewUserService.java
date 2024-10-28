package jpabasic.reserve.app;

import static java.time.LocalDateTime.now;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jpabasic.reserve.domain.User;
import jpabasic.reserve.jpa.EMF;

public class NewUserService {

    public void saveNewUser(User user) {
        EMF.init();
        EntityManager em = EMF.createEntityManager();
        EntityTransaction et = em.getTransaction();

        try {
            et.begin();
            em.persist(user);
            et.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
            EMF.close();
        }
    }
}
