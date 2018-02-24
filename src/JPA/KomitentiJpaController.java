/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JPA;

import JPA.exceptions.NonexistentEntityException;
import entitiKlase.Komitenti;
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
public class KomitentiJpaController implements Serializable {

    public KomitentiJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Komitenti komitenti) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(komitenti);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Komitenti komitenti) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            komitenti = em.merge(komitenti);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = komitenti.getId();
                if (findKomitenti(id) == null) {
                    throw new NonexistentEntityException("The komitenti with id " + id + " no longer exists.");
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
            Komitenti komitenti;
            try {
                komitenti = em.getReference(Komitenti.class, id);
                komitenti.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The komitenti with id " + id + " no longer exists.", enfe);
            }
            em.remove(komitenti);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Komitenti> findKomitentiEntities() {
        return findKomitentiEntities(true, -1, -1);
    }

    public List<Komitenti> findKomitentiEntities(int maxResults, int firstResult) {
        return findKomitentiEntities(false, maxResults, firstResult);
    }

    private List<Komitenti> findKomitentiEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Komitenti.class));
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

    public Komitenti findKomitenti(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Komitenti.class, id);
        } finally {
            em.close();
        }
    }
    
    public Komitenti findKomitentaPoNazivu(String Naziv) {
        EntityManager em = getEntityManager();
        try {
            TypedQuery q = em.createNamedQuery("Komitenti.findByNaziv", Komitenti.class);
            q.setParameter("naziv", Naziv);
            List<Komitenti> lk = q.getResultList();
            if (lk.size() > 0)
            {
                return lk.get(0);
            }
            else
            {
                return null;
            }            
        } finally {
            em.close();
        }
    }

    public int getKomitentiCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Komitenti> rt = cq.from(Komitenti.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
