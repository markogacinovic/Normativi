/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JPA;

import JPA.exceptions.NonexistentEntityException;
import entitiKlase.Radninalozi;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.persistence.TypedQuery;

/**
 *
 * @author Marko
 */
public class RadninaloziJpaController implements Serializable {

    public RadninaloziJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Radninalozi radninalozi) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(radninalozi);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
    
    public void edit(Radninalozi radninalozi, EntityManager em) {
        radninalozi = em.merge(radninalozi);
    }

    public void edit(Radninalozi radninalozi) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            radninalozi = em.merge(radninalozi);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = radninalozi.getId();
                if (findRadninalozi(id) == null) {
                    throw new NonexistentEntityException("The radninalozi with id " + id + " no longer exists.");
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
            Radninalozi radninalozi;
            try {
                radninalozi = em.getReference(Radninalozi.class, id);
                radninalozi.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The radninalozi with id " + id + " no longer exists.", enfe);
            }
            em.remove(radninalozi);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Radninalozi> findRadninaloziEntities() {
        return findRadninaloziEntities(true, -1, -1);
    }

    public List<Radninalozi> findRadninaloziEntities(int maxResults, int firstResult) {
        return findRadninaloziEntities(false, maxResults, firstResult);
    }

    private List<Radninalozi> findRadninaloziEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Radninalozi.class));
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

    public Radninalozi findRadninalozi(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Radninalozi.class, id);
        } finally {
            em.close();
        }
    }

    public Radninalozi findRadniNalogPoBroju(String Broj) {
        EntityManager em = getEntityManager();
        try {
            TypedQuery q = em.createNamedQuery("Radninalozi.findByBroj", Radninalozi.class);
            q.setParameter("broj", Broj);
            List<Radninalozi> ln = q.getResultList();
            if (ln.size() > 0)
            {
                return ln.get(0);
            }
            else
            {
                return null;
            } 
        } finally {
            em.close();
        }
    }
        
    public int getRadninaloziCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Radninalozi> rt = cq.from(Radninalozi.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
