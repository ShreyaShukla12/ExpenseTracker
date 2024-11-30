package in.co.expenseTracker;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/expenses")
public class ExpenseCtl {
	
	@Autowired
	private ExpenseService service;
	
	@GetMapping
    public List<ExpenseDTO> getAllExpenses() {
        return service.getAllExpenses();
    }

    @GetMapping("/{id}")
    public ExpenseDTO getExpenseById(@PathVariable Long id) {
        return service.getExpenseById(id);
    }

    @PostMapping
    public ExpenseDTO addExpense(@RequestBody ExpenseDTO expense) {
        return service.addExpense(expense);
    }

    @PutMapping("/{id}")
    public ExpenseDTO updateExpense(@PathVariable Long id, @RequestBody ExpenseDTO expense) {
        return service.updateExpense(id, expense);
    }

    @DeleteMapping("/{id}")
    public String deleteExpense(@PathVariable Long id) {
        service.deleteExpense(id);
        return "Expense with ID " + id + " has been deleted.";
    }

    @GetMapping("/filter/category")
    public List<ExpenseDTO> findByCategory(@RequestParam String category) {
        return service.findByCategory(category);
    }

    @GetMapping("/filter/daterange")
    public List<ExpenseDTO> findByDateBetween( @RequestParam("startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
    		@RequestParam("endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {
        return service.findByDateBetween(startDate, endDate);
    }


}
