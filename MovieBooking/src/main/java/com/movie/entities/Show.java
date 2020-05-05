package com.movie.entities;

import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
@Entity
@Table(name="shows")
@DynamicUpdate
@DynamicInsert
//@JsonIgnoreProperties("show")

@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class,property="showId",scope=Show.class)
public class Show {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="show_id")
	private Integer showId;
	
	
	@Column(name="show_start_time")
	private LocalDateTime showStartTime;
	
	@Column(name="show_end_time")
	private LocalDateTime showEndTime;
	
	
	
	@OneToMany(mappedBy="show",cascade=CascadeType.ALL,orphanRemoval=true)
	private List<Seat> seats;
	
	@Column(name="show_name")
	private String showName;
	
	@OneToOne
	@JoinColumn(name="movie_id",referencedColumnName="movie_id")
	private Movie movie;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="screen_id")
	private Screen screen;
	
	@ManyToOne()
	@JoinColumn(name="theatre_id")
	private Theatre theatre;
	

	public Show() {
		super();
	}

	public int getShowId() {
		return showId;
	}

	public void setShowId(int showId) {
		this.showId = showId;
	}

	public LocalDateTime getShowStartTime() {
		return showStartTime;
	}

	public void setShowStartTime(LocalDateTime showStartTime) {
		this.showStartTime = showStartTime;
	}

	public LocalDateTime getShowEndTime() {
		return showEndTime;
	}

	public void setShowEndTime(LocalDateTime showEndTime) {
		this.showEndTime = showEndTime;
	}

	@JsonIgnore
	public List<Seat> getSeats() {
		return seats;
	}
	
	public void setSeats(List<Seat> seats) {
		this.seats = seats;
	}
	

	public String getShowName() {
		return showName;
	}

	public void setShowName(String showName) {
		this.showName = showName;
	}

	@JsonIgnore
	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	@JsonIgnore
	public Screen getScreen() {
		return screen;
	}

	public String getScreenName() {
		return screen.getScreenName();
	}
	
	public Integer getScreenId()
	{
		return screen.getScreenId();
	}

	public void setScreen(Screen screenId) {
		this.screen = screenId;
	}

	public Theatre getTheatre() {
		return theatre;
	}

	public void setTheatre(Theatre theatreId) {
		this.theatre = theatreId;
	}
	
	
	
	
}
