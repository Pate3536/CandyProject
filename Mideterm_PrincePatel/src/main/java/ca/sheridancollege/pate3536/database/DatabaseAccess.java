package ca.sheridancollege.pate3536.database;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import ca.sheridancollege.pate3536.beans.Candy;


@Repository
public class DatabaseAccess {
	
	@Autowired
	protected NamedParameterJdbcTemplate jdbc;
	
	
public void insertCandy(Candy candy) {
		
		MapSqlParameterSource namedParameters = new MapSqlParameterSource();
		String query ="INSERT INTO candy(quentity,category,brandName,discription,expiryDate) VALUES (:quentity,:category,:brandName,:discription,:expiryDate)";
		namedParameters.addValue("quentity",candy.getQuentity())
		.addValue("category", candy.getCategory())
		.addValue("brandName",candy.getBrandName())
		.addValue("discription", candy.getDiscription())
		.addValue("expiryDate", candy.getExpiryDate());
		jdbc.update(query, namedParameters);
	}

public List<Candy> getCandyList() {

	MapSqlParameterSource namedParameters = new MapSqlParameterSource();
	String query = "SELECT * FROM candy ";

	return jdbc.query(query, namedParameters, new BeanPropertyRowMapper<Candy>(Candy.class));

}
public void deleteCandyById(Long id) {
	
	MapSqlParameterSource namedParameters = new MapSqlParameterSource();
	String query = "DELETE FROM candy WHERE id = :id";
	namedParameters.addValue("id",id);
	
	if(jdbc.update(query, namedParameters) > 0);
	System.out.println("Delete candy id:"+id);
}

public List<Candy> getCandyById(Long id){
	
	MapSqlParameterSource namedParameters = new MapSqlParameterSource();
	
	String query = "SELECT * FROM candy WHERE id = :id";
	namedParameters.addValue("id",id);
	
	return jdbc.query(query, namedParameters,new BeanPropertyRowMapper<Candy>(Candy.class));
}




}
