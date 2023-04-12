package infleranJpaBasic.example;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {
	public static void main(String args[]) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin(); // 트랜잭션 시작
		try {
			/* 등록 */
			//instMember(em);
			/* 조회 */
			findMember(em);
			/* 삭제 */
			//deltMember(em);
			/* 수정 */
			//updtMember(em);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		} finally {
			em.close();
		}
		emf.close();
	}
	
	// 회원 등록
	public static void instMember(EntityManager em) {
		Member memberA = new Member();
		memberA.setId(20L);
		memberA.setName("memberA");
		System.out.println("==BEFORE==");
		em.persist(memberA);
		System.out.println("==AFTER==");
		
		Member memberB = new Member();
		memberB.setId(30L);
		System.out.println("==BEFORE==");
		memberB.setName("memberB");
		System.out.println("==AFTER==");
		em.persist(memberB);
	}
	
	// 회원 조회
	public static void findMember(EntityManager em) {
		Member findMember = em.find(Member.class, 20L);
		System.out.println("findMember.getId   : "+findMember.getId());
		System.out.println("findMember.getName : "+findMember.getName());
	}
	
	// 회원 삭제
	public static void deltMember(EntityManager em) {
		Member member = em.find(Member.class, 20L);
		em.remove(member);
	}
	
	// 회원 수정
	public static void updtMember(EntityManager em) {
		Member member = em.find(Member.class, 30L);
		member.setName("memberC");
		System.out.println("member.getId   : " + member.getId());
		System.out.println("member.getName : " + member.getName());
	}
}