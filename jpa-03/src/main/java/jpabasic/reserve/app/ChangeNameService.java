package jpabasic.reserve.app;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jpabasic.reserve.domain.User;
import jpabasic.reserve.jpa.EMF;

public class ChangeNameService {
  public void changeUserName(String email, String newName) {
    EMF.init();
    EntityManager em = EMF.createEntityManager();
    EntityTransaction et = em.getTransaction();

    try {
      et.begin();
      User user = em.find(User.class, email);
      user.changeName(newName);
      et.commit();
    } catch (Exception e) {
      if (et.isActive()) {
        et.rollback();
      }
      e.printStackTrace();
    } finally {
      // 엔티티 매니저 닫기
      em.close();
      EMF.close();
    }
  }
}
