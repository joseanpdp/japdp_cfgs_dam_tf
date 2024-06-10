package japdp.damtf.application.persistence.model;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * La clase Product representa un producto disponible en el sistema. Cada producto tiene
 * un identificador único, un nombre, un precio, una descripción, una cantidad disponible
 * en el inventario y una categoría a la que pertenece. La cantidad representa la cantidad
 * disponible en el inventario para ese producto.
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "T_PRODUCT")
@Entity
public class Product implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@NotNull(message = "Order date cannot be null")
	@NotEmpty(message = "Order date cannot be an empty string")
	@NotBlank(message = "Order date cannot be blank")
	private String name;

	@NotNull(message = "Order description cannot be null")
	@NotEmpty(message = "Order description cannot be an empty string")
	@NotBlank(message = "Order description cannot be blank")
	private String description;

	@Min(0)
	private double price;

	@Min(0)
	private int quantity;

	@NotNull(message = "Order category cannot be null")
	@ManyToOne
	private Category category;

	public Product(String name, double price, String description, Category category, int quantity) {
		this();
		this.name = name;
		this.price = price;
		this.description = description;
		this.category = category;
		this.quantity = quantity;
	}
}
