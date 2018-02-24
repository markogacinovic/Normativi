/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JPA;

import JPA.exceptions.NonexistentEntityException;
import entitiKlase.Jedinicemere;
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
public class JedinicemereJpaController implements Serializable {

    public JedinicemereJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Jedinicemere jedinicemere) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(jedinicemere);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Jedinicemere jedinicemere) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            jedinicemere = em.merge(jedinicemere);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = jedinicemere.getId();
                if (findJedinicemere(id) == null) {
                    throw new NonexistentEntityException("The jedinicemere with id " + id + " no longer exists.");
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
            Jedinicemere jedinicemere;
            try {
                jedinicemere = em.getReference(Jedinicemere.class, id);
                jedinicemere.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The jedinicemere with id " + id + " no longer exists.", enfe);
            }
            em.remove(jedinicemere);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Jedinicemere> findJedinicemereEntities() {
        return findJedinicemereEntities(true, -1, -1);
    }

    public List<Jedinicemere> findJedinicemereEntities(int maxResults, int firstResult) {
        return findJedinicemereEntities(false, maxResults, firstResult);
    }

    private List<Jedinicemere> findJedinicemereEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Jedinicemere.class));
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

    public Jedinicemere findJedinicemere(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Jedinicemere.class, id);
        } finally {
            em.close();
        }
    }
    
    public Jedinicemere findJedinicuMerePoNazivu(String Naziv) {
        EntityManager em = getEntityManager();
        try {
            TypedQuery q = em.createNamedQuery("Jedinicemere.findByNaziv", Jedinicemere.class);
            q.setParameter("naziv", Naziv);
            List<Jedinicemere> ljm = q.getResultList();
            if (ljm.size() > 0)
            {
                return ljm.get(0);
            }
            else
            {
                return null;
            }            
        } finally {
            em.close();
        }
    }

    public int getJedinicemereCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Jedinicemere> rt = cq.from(Jedinicemere.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
