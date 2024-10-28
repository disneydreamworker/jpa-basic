package jpabasic.reserve.app;

import static java.time.LocalDateTime.now;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jpabasic.reserve.domain.User;
import jpabasic.reserve.jpa.EMF;

public class RemoveUserService {
    public void removeUser(String email) {
        EMF.init();
        EntityManager em = EMF.createEntityManager();
        EntityTransaction et = em.getTransaction();

        try {
            et.begin();
            User user = em.find(User.class, email);
            em.remove(user);
            et.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
            EMF.close();
        }
    }
}