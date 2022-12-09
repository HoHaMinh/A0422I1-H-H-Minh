package display_picture.repository;

import display_picture.bean.Comment;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Repository
@Transactional
public class CommentRepository implements ICommentRepository {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Comment> showCommentThisDay() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        format.setLenient(false);
        String now = format.format(new Date());
        Date currentDay;
        try {
            currentDay = format.parse(now);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        return entityManager.createQuery("select c from Comment c where c.dateComment = :now")
                .setParameter("now", currentDay).getResultList();
    }

    @Override
    public void save(Comment comment) {
        entityManager.persist(comment);
    }

    @Override
    public void updateLike(Integer id) {
        Integer numbersLike = (Integer) entityManager.createQuery("select c.numberLike from Comment c where c.id= :id")
                .setParameter("id",id).getSingleResult();
        if (numbersLike == null) {
            numbersLike = 1;
        } else {
            numbersLike++;
        }
        entityManager.createQuery("UPDATE Comment c set c.numberLike = :numbersLike where c.id = :id")
                .setParameter("numbersLike", numbersLike)
                .setParameter("id", id)
                .executeUpdate();
    }
}
