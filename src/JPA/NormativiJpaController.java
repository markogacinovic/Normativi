/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JPA;

import JPA.exceptions.NonexistentEntityException;
import entitiKlase.Normativi;
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
public class NormativiJpaController implements Serializable {

    public NormativiJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Normativi normativi) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(normativi);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Normativi normativi) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            normativi = em.merge(normativi);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = normativi.getId();
                if (findNormativi(id) == null) {
                    throw new NonexistentEntityException("The normativi with id " + id + " no longer exists.");
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
            Normativi normativi;
            try {
                normativi = em.getReference(Normativi.class, id);
                normativi.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The normativi with id " + id + " no longer exists.", enfe);
            }
            em.remove(normativi);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Normativi> findNormativiEntities() {
        return findNormativiEntities(true, -1, -1);
    }

    public List<Normativi> findNormativiEntities(int maxResults, int firstResult) {
        return findNormativiEntities(false, maxResults, firstResult);
    }

    private List<Normativi> findNormativiEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Normativi.class));
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

    public Normativi findNormativi(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Normativi.class, id);
        } finally {
            em.close();
        }
    }
    
    public Normativi findNormativPoSifri(String Sifra) {
        EntityManager em = getEntityManager();
        try {
            TypedQuery q = em.createNamedQuery("Normativi.findBySifra", Normativi.class);
            q.setParameter("sifra", Sifra);
            List<Normativi> ln = q.getResultList();
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
    
    public List<Normativi> findNormativiPoIDGrupe(int idGrupe) {
        EntityManager em = getEntityManager();
        try {
            TypedQuery q = em.createNamedQuery("Normativi.findByIdGrupe", Normativi.class);
            q.setParameter("idGrupe", idGrupe);
            List<Normativi> ln = q.getResultList();
            if (ln.size() > 0)
            {
                return ln;
            }
            else
            {
                return null;
            } 
        } finally {
            em.close();
        }
    }
    
    public Normativi findNormativPoNazivu(String Naziv) {
        EntityManager em = getEntityManager();
        try {
            TypedQuery q = em.createNamedQuery("Normativi.findByNaziv", Normativi.class);
            q.setParameter("naziv", Naziv);
            List<Normativi> ln = q.getResultList();
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

    public int getNormativiCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Normativi> rt = cq.from(Normativi.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
