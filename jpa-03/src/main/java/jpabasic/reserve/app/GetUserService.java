package jpabasic.reserve.app;

import jakarta.persistence.EntityManager;
import jpabasic.reserve.domain.User;
import jpabasic.reserve.jpa.EMF;

public class GetUserService {
  public User getUser(String email) {
    EMF.init();
    EntityManager em = EMF.createEntityManager();

    try {
      User user = em.find(User.class, email);
      return user;
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    } finally {
      em.close();
      EMF.close();
    }
  }
}
