/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JPA;

import JPA.exceptions.NonexistentEntityException;
import entitiKlase.Artikli;
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
public class ArtikliJpaController implements Serializable {

    public ArtikliJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Artikli artikli) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(artikli);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Artikli artikli) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            artikli = em.merge(artikli);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = artikli.getId();
                if (findArtikli(id) == null) {
                    throw new NonexistentEntityException("The artikli with id " + id + " no longer exists.");
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
            Artikli artikli;
            try {
                artikli = em.getReference(Artikli.class, id);
                artikli.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The artikli with id " + id + " no longer exists.", enfe);
            }
            em.remove(artikli);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Artikli> findArtikliEntities() {
        return findArtikliEntities(true, -1, -1);
    }

    public List<Artikli> findArtikliEntities(int maxResults, int firstResult) {
        return findArtikliEntities(false, maxResults, firstResult);
    }

    private List<Artikli> findArtikliEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Artikli.class));
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

    public Artikli findArtikli(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Artikli.class, id);
        } finally {
            em.close();
        }
    }
    
    public Artikli findArtikalPoSifri(String Sifra) {
        EntityManager em = getEntityManager();
        try {
            TypedQuery q = em.createNamedQuery("Artikli.findBySifra", Artikli.class);
            q.setParameter("sifra", Sifra);
            List<Artikli> ln = q.getResultList();
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
    
    public Artikli findArtikalPoNazivu(String Naziv) {
        EntityManager em = getEntityManager();
        try {
            TypedQuery q = em.createNamedQuery("Artikli.findByNaziv", Artikli.class);
            q.setParameter("naziv", Naziv);
            List<Artikli> ln = q.getResultList();
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

    public int getArtikliCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Artikli> rt = cq.from(Artikli.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
