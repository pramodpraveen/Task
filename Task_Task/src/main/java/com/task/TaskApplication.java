package com.task;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TaskApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaskApplication.class, args);
	}

}

/*URL's of BackEnd Services
 * 
 *Insert Data= 		 	http://localhost:2000
 *Retrieving Data:   	http://localhost:2000/getAll
 *Finding Average:   	http://localhost:2000/average
 *Finding Middle No: 	http://localhost:2000/middle
 *Finding Duplicates:	http://localhost:2000/duplicates
 *Finding even-odd-averages: http://localhost:2000/even-odd-averages
 */
