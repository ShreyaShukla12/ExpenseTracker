package in.co.expenseTracker;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;


@Entity
@Table(name = "exp")
public class ExpenseDTO {
	
	@Id
	@GeneratedValue(generator = "Pk")
	@GenericGenerator(name = "Pk", strategy = "native")
	@Column(name = "ID", unique = true, nullable = false)
	    protected Long id;
	
	@Column(name = "CATEGORY", length = 50)
	    private String category;
	
	@Column(name = "DESCRIPTION", length = 50)
	    private String description;
	
	@Column(name = "AMOUNT", length = 50)
	    private double amount;
	
	@Column(name = "DATE", length = 50)
	    private LocalDate date;
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getCategory() {
			return category;
		}
		public void setCategory(String category) {
			this.category = category;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		public double getAmount() {
			return amount;
		}
		public void setAmount(double amount) {
			this.amount = amount;
		}
		public LocalDate getDate() {
			return date;
		}
		public void setDate(LocalDate date) {
			this.date = date;
		}
	    
	    

}
