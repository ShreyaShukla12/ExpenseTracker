package in.co.expenseTracker;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExpenseService {
	
	@Autowired
	ExpenseDao dao;
	
	 public List<ExpenseDTO> getAllExpenses() {
	        return dao.getAllExpenses();
	    }

	    public ExpenseDTO getExpenseById(Long id) {
	        return dao.getExpenseById(id);
	    }

	    public ExpenseDTO addExpense(ExpenseDTO expense) {
	        return dao.addExpense(expense);
	    }

	    public ExpenseDTO updateExpense(Long id, ExpenseDTO expense) {
	        return dao.updateExpense(id, expense);
	    }

	    public void deleteExpense(Long id){
	        dao.deleteExpense(id);
	    }
	    public List<ExpenseDTO> findByCategory(String category) {
	        return dao.findByCategory(category);
	    }

	    public List<ExpenseDTO> findByDateBetween(LocalDate startDate, LocalDate endDate) {
	        return dao.findByDateBetween(startDate, endDate);
	    }
	}


