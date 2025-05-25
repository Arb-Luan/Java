package objects;

import java.util.Objects;

public class Livros {

	private String title;
	private String author;
	private int year;
	
	//builders
	public Livros ()
	{
		this.title = null;
		this.author = null;
		this.year = 0;
	}
	public Livros(String t, String a, int y)
	{
		this.title = t;
		this.author = a;
		this.year = y;
	}
	public Livros (String t,int y)
	{
		this.title = t;
		this.year = y;
	}
	//getters and setters
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}
	//Hashcode
	@Override
	public int hashCode() {
		return Objects.hash(author, title, year);
	}
	//Equals
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Livros other = (Livros) obj;
		return Objects.equals(author, other.author) && Objects.equals(title, other.title)
				&& Objects.equals(year, other.year);
	}
	@Override
	public String toString() {
		return "Livro [title=" + title + ", author=" + author + ", year=" + year + "]";
	}
	

}
