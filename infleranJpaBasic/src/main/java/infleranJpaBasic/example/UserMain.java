package infleranJpaBasic.example;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.hibernate.Hibernate;

public class UserMain {
	public static void main(String args[]) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin(); // 트랜잭션 시작
		try {
			System.out.println("시작");
			User user1 = new User();
			user1.setUsername("유저1");
			em.persist(user1);
			
			User user2 = new User();
			user2.setUsername("유저2");
			em.persist(user2);
			
			em.flush();
			em.clear();
			
			User refUser = em.getReference(User.class, user1.getId());
			System.out.println("refUser.getClass : "+refUser.getClass()); // froxy
			Hibernate.initialize(refUser); // 강제초기화
			System.out.println(emf.getPersistenceUnitUtil().isLoaded(refUser));
			
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			em.close();
		}
		emf.close();
	}
}
