package com.movie.entities;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name="movies")
@DynamicUpdate
@DynamicInsert
//@JsonIgnoreProperties("listOfMovies")

@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class,property="movieId")
public class Movie {
	
	@Id
	@Column(name="movie_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer movieId;
	
	
	@Column(name="movie_name")
	private String movieName;
	
	@Column(name="release_year")
	private int releaseYear;
	
	@Column(name="genre")
	private String genre;
	
	@Column(name="director")
	private String director;
	
	@Column(name="runtime")
	private Integer runtime;
	
	@Column(name="language")
	private String Language;
	
	@Column(name="hero")
	private String hero;
	
	@Column(name="heroine")
	private String heroine;
	
	@Column(name="trailer_link")
	private String trailerLink;
	
	@Column(name="image_link")
	private String imageLink;
	
	@ManyToMany(fetch=FetchType.LAZY,cascade=CascadeType.PERSIST)
	@JoinTable(name="movie_theatre",
			joinColumns=@JoinColumn(name="movie_id"),
			inverseJoinColumns=@JoinColumn(name="theatre_id")
	)
	private Set<Theatre> listOfTheatres;
	
	@JsonIgnore
	public Set<Theatre> getListOfTheatres() {
		return listOfTheatres;
	}

	public void setListOfTheatres(Set<Theatre> listOfTheatres) {
		this.listOfTheatres = listOfTheatres;
	}

	public void setMovieId(Integer movieId) {
		this.movieId = movieId;
	}

	public void setRuntime(Integer runtime) {
		this.runtime = runtime;
	}

	public Movie() {
		super();
	}

	public int getMovieId() {
		return movieId;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public int getReleaseYear() {
		return releaseYear;
	}

	public void setReleaseYear(int releaseYear) {
		this.releaseYear = releaseYear;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public int getRuntime() {
		return runtime;
	}

	public void setRuntime(int runtime) {
		this.runtime = runtime;
	}

	public String getLanguage() {
		return Language;
	}

	public void setLanguage(String language) {
		Language = language;
	}

	public String getHero() {
		return hero;
	}

	public void setHero(String hero) {
		this.hero = hero;
	}

	public String getHeroine() {
		return heroine;
	}

	public void setHeroine(String heroine) {
		this.heroine = heroine;
	}

	public String getTrailerLink() {
		return trailerLink;
	}

	public void setTrailerLink(String trailerLink) {
		this.trailerLink = trailerLink;
	}

	public String getImageLink() {
		return imageLink;
	}

	public void setImageLink(String imageLinks) {
		this.imageLink = imageLink;
	}
	
	
	

}
