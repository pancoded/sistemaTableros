package ar.edu.ottokrause.sistemaTableros.persistencia;

import java.io.Serializable;
import jakarta.persistence.Query;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import ar.edu.ottokrause.sistemaTableros.logica.Prestamo;
import ar.edu.ottokrause.sistemaTableros.logica.Tablero;
import ar.edu.ottokrause.sistemaTableros.persistencia.exceptions.NonexistentEntityException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.List;

public class TableroJpaController implements Serializable {

    private EntityManagerFactory emf = null;

    public TableroJpaController() {
        emf = Persistence.createEntityManagerFactory("sistemaTablerosPU");
    }

    public TableroJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Tablero tablero) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Prestamo prestamo = tablero.getPrestamo();
            if (prestamo != null) {
                prestamo = em.getReference(prestamo.getClass(), prestamo.getId());
                tablero.setPrestamo(prestamo);
            }
            em.persist(tablero);
            if (prestamo != null) {
                prestamo.getTableros().add(tablero);
                prestamo = em.merge(prestamo);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Tablero tablero) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Tablero persistentTablero = em.find(Tablero.class, tablero.getId());
            Prestamo prestamoOld = persistentTablero.getPrestamo();
            Prestamo prestamoNew = tablero.getPrestamo();
            if (prestamoNew != null) {
                prestamoNew = em.getReference(prestamoNew.getClass(), prestamoNew.getId());
                tablero.setPrestamo(prestamoNew);
            }
            tablero = em.merge(tablero);
            if (prestamoOld != null && !prestamoOld.equals(prestamoNew)) {
                prestamoOld.getTableros().remove(tablero);
                prestamoOld = em.merge(prestamoOld);
            }
            if (prestamoNew != null && !prestamoNew.equals(prestamoOld)) {
                prestamoNew.getTableros().add(tablero);
                prestamoNew = em.merge(prestamoNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = tablero.getId();
                if (findTablero(id) == null) {
                    throw new NonexistentEntityException("The tablero with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(int id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Tablero tablero;
            try {
                tablero = em.getReference(Tablero.class, id);
                tablero.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The tablero with id " + id + " no longer exists.", enfe);
            }
            Prestamo prestamo = tablero.getPrestamo();
            if (prestamo != null) {
                prestamo.getTableros().remove(tablero);
                prestamo = em.merge(prestamo);
            }
            em.remove(tablero);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Tablero> findTableroEntities() {
        return findTableroEntities(true, -1, -1);
    }

    public List<Tablero> findTableroEntities(int maxResults, int firstResult) {
        return findTableroEntities(false, maxResults, firstResult);
    }

    private List<Tablero> findTableroEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Tablero.class));
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

    public Tablero findTablero(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Tablero.class, id);
        } finally {
            em.close();
        }
    }

    public int getTableroCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Tablero> rt = cq.from(Tablero.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}
