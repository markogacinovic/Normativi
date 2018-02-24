/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JPA;

import JPA.exceptions.NonexistentEntityException;
import entitiKlase.Grupenormativa;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author Marko
 */
public class GrupenormativaJpaController implements Serializable {

    public GrupenormativaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Grupenormativa grupenormativa) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(grupenormativa);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Grupenormativa grupenormativa) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            grupenormativa = em.merge(grupenormativa);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = grupenormativa.getId();
                if (findGrupenormativa(id) == null) {
                    throw new NonexistentEntityException("The grupenormativa with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Grupenormativa grupenormativa;
            try {
                grupenormativa = em.getReference(Grupenormativa.class, id);
                grupenormativa.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The grupenormativa with id " + id + " no longer exists.", enfe);
            }
            em.remove(grupenormativa);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Grupenormativa> findGrupenormativaEntities() {
        return findGrupenormativaEntities(true, -1, -1);
    }

    public List<Grupenormativa> findGrupenormativaEntities(int maxResults, int firstResult) {
        return findGrupenormativaEntities(false, maxResults, firstResult);
    }

    private List<Grupenormativa> findGrupenormativaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Grupenormativa.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Grupenormativa findGrupenormativa(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Grupenormativa.class, id);
        } finally {
            em.close();
        }
    }
    
    public Grupenormativa findGrupuNormativaPoNazivu(String Naziv) {
        EntityManager em = getEntityManager();
        try {
            TypedQuery q = em.createNamedQuery("Grupenormativa.findByNaziv", Grupenormativa.class);
            q.setParameter("naziv", Naziv);
            List<Grupenormativa> lg = q.getResultList();
            if (lg.size() > 0)
            {
                return lg.get(0);
            }
            else
            {
                return null;
            } 
        } finally {
            em.close();
        }
    }

    public int getGrupenormativaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Grupenormativa> rt = cq.from(Grupenormativa.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
