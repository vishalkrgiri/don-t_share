package com.cg;

import java.sql.Time;
import java.sql.Timestamp;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.cg.dao.CustomerDao;
import com.cg.dao.ShowDao;
import com.cg.dao.UniversalDao;
import com.cg.dao.UserDao;
import com.cg.entity.Customer;
import com.cg.entity.Movie;
import com.cg.entity.Screen;
import com.cg.entity.Seat;
import com.cg.entity.SeatState;
import com.cg.entity.Show;
import com.cg.entity.Theatre;
import com.cg.entity.User;
import com.cg.entity.UserType;

@SpringBootApplication
public class OnlineMovieBookingApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(OnlineMovieBookingApplication.class, args);
		System.out.println("Hello");
	}

	@Autowired
	ShowDao dao;
	
	@Autowired
	UniversalDao<Theatre> dao2;
	
	@Autowired
	UniversalDao<Screen> dao3;
	
	@Autowired
	UniversalDao<Show> dao4;
	@Autowired
	UniversalDao<Movie> dao5;
	
	@Autowired
	UniversalDao<Seat> dao6;
	@Override
	public void run(String... args) throws Exception {
		
//		Show s=dao4.findById(8);
//		Screen screen=dao3.findById(11);
//		s.setScreenId(screen);
//		dao4.update(s);
//		System.out.println(s);
		System.out.println("done");
		
		
	}
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedOrigins("http://localhost:4200");
			}
		};
	}


}
// TODO Auto-generated method stub'

//Movie movie=dao.findById(4);
//Movie movie2=dao.findById(6);
//Movie movie3=dao.findById(7);
//
//Theatre t=dao2.findById(5);

//Customer c=dao.getCustomer(3);
//System.out.println(c.getUsername());
//Set<Movie> movies=t.getListOfMovies();
//
//for (Iterator iterator = t.getListOfMovies().iterator(); iterator.hasNext();) {
//	Movie type = (Movie) iterator.next();
//	System.out.println(type.getMovieName());;
//};

//movies.add(movie);
//movies.add(movie2);
//movies.add(movie3);


//
//t.setListOfMovies(movies);
//
//dao2.update(t);




//dao2.update(t);
//t=dao2.update(t);

//System.out.println(t.getTheatreName());

//System.out.println(movie.getDirector());
//movie.setDirector("trivikram");
//movie.setGenre("drama");
//movie.setHero("MB");
//movie.setHeroine("Trisha");
//movie.setMovieName("Athadu 3");

//Theatre t =new Theatre();
//t.setManagerContact("6532162");
//t.setManagerName("polsani");
//t.setTheatreCity("warangal");
//t.setTheatreName("Amrutha");
//
//dao.addTheatre(t);

//dao.addMovie(movie);














//Theatre t=dao2.findById(5);
//Show s=new Show();
//s.setMovie(dao3.findById(4));
//s.setSeats(null);
//s.setShowEndTime(Timestamp.valueOf(LocalDateTime.now()));
//s.setShowStartTime(Timestamp.valueOf(LocalDateTime.now()));
//s.setShowName("Morning show");
//s.setTheatreId(t);
//dao.save(s);
//try
//{
//List<Show> shows=dao.findActiveShows();
//for (Iterator iterator = shows.iterator(); iterator.hasNext();) {
//	Show show = (Show) iterator.next();
//	System.out.println(show.getShowStartTime().format(DateTimeFormatter.ofPattern("dd-MM-YYYY, EEEE HH:mm:ss")));
//}
//}
//catch(NullPointerException e)
//{
//	System.out.println("null pointer exceprtion occured");
//}
//System.out.println("hai sandeep");
//}












//Seat Insertion
//Show s=dao4.findById(8);
//List<Seat> seats=new ArrayList<Seat>();
//for (int i = 0; i < s1.getHallHeight(); i++) {
//	for (int j = 0; j < s1.getHallWidth(); j++) {
//		Seat seat=new Seat();
//		seat.setSeatPrice(100.0);
//		seat.setShow(s);
//		seat.setSeatStatus(SeatState.AVAILABLE);
//		dao6.save(seat);
//		seats.add(seat);
//		}
//}
//s.setSeats(seats);
//dao4.update(s);