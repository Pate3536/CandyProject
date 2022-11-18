package ca.sheridancollege.pate3536.beans;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Candy {
	
	private Long id;
	private Long quentity;
	private String category;
	private String brandName;
	private String discription;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate expiryDate;
	
	private final String[] CATEGORYS = {"Crunchy","Chewy","Chocolate"};

}
