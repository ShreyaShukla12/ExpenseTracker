package in.co.expenseTracker;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class ExpenseDao {
	
	@PersistenceContext
    private EntityManager entityManager;

	public List<ExpenseDTO> getAllExpenses() {
		return entityManager.createQuery("SELECT e FROM ExpenseDTO e", ExpenseDTO.class).getResultList();
	}

	public ExpenseDTO getExpenseById(Long id) {
		return  entityManager.find(ExpenseDTO.class, id);
	}

	public ExpenseDTO addExpense(ExpenseDTO expense) {
		entityManager.merge(expense);
		return expense;
	}

	public ExpenseDTO updateExpense(Long id, ExpenseDTO exp) {
		ExpenseDTO dto=entityManager.find(ExpenseDTO.class, id);
		if(dto !=null) {
			dto.setCategory(exp.getCategory());
			dto.setDescription(exp.getDescription());
			dto.setAmount(exp.getAmount());
			dto.setDate(exp.getDate());
		}
		return entityManager.merge(dto);
	}

	public void deleteExpense(Long id) {
		ExpenseDTO dto=entityManager.find(ExpenseDTO.class, id);
		if(dto!= null) {
			entityManager.remove(dto);
		}
		
	}

	
	public List<ExpenseDTO> findByCategory(String category) {
		return entityManager.createQuery("SELECT e FROM ExpenseDTO e WHERE e.category = :category", ExpenseDTO.class)
				.setParameter("category", category).getResultList();
		
	}


	public List<ExpenseDTO> findByDateBetween(LocalDate startDate, LocalDate endDate) {
		return  entityManager.createQuery("SELECT e FROM ExpenseDTO e WHERE e.date BETWEEN :startDate AND :endDate", ExpenseDTO.class)
                .setParameter("startDate", startDate)
                .setParameter("endDate", endDate)
                .getResultList();
	}


	
	}

