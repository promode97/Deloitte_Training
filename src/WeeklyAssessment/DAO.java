package WeeklyAssessment;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;

import jdbc_plsql.dBConnector;

public class DAO {

	private static ArrayList<Book> books = new ArrayList<Book>();
	private static ArrayList<Author> authors = new ArrayList<Author>();
	private static ArrayList<Publisher> publishers = new ArrayList<Publisher>(); 
	public static void main(String[] args) {
		getData();
		listBooks();
		

	}
	
		
		
	
	private static void getData() {
		Connection con = new dBConnector("jdbc:oracle:thin:@localhost:1521:orcl","hr","hr").getConnection();
		String sql1 = "select name,city from publisher";
		try {
			PreparedStatement pst = con.prepareStatement(sql1);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				publishers.add(new Publisher(rs.getString(1),rs.getString(2)));
			}
		} catch (SQLException e) {
			System.out.println("Could not Prepare Statement "+e.getMessage());
		}
		
		String sql2 = "select name,nationality from author";
		try {
			PreparedStatement pst = con.prepareStatement(sql2);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				authors.add(new Author(rs.getString(1),rs.getString(2)));
			}
		} catch (SQLException e) {
			System.out.println("Could not Prepare Statement "+e.getMessage());
		}
		
		String sql3 = "select isbn,title,pages,pub_year,type,author_name,publisher_name from book";
		try {
			PreparedStatement pst = con.prepareStatement(sql3);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				Author a = null;
				for(Author i: authors) {
					if(i.getName().equalsIgnoreCase(rs.getString(6))) {
						a=i;
						break;
					}
				}
				Publisher p = null;
				for(Publisher i: publishers) {
					if(i.getName().equalsIgnoreCase(rs.getString(7))) {
						p=i;
						break;
					}
				}
				books.add(new Book(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getInt(4),rs.getString(5),a,p));
			}
		} catch (SQLException e) {
			System.out.println("Could not Prepare Statement "+e.getMessage());
		}
		
		
	}
	private static void listBooks() {
		System.out.println();
		System.out.println("List of Books: ");
		for(Book b: books) {
			System.out.println("ISBN: "+b.getIsbn()+" Title: "+b.getTitle()+" Pages: "+b.getPages()+" Author Name: "+b.getAuthor().getName()+" Publisher: "+b.getPublisher().getName()+" City: "+b.getPublisher().getCity());
		}
		
	}
	

}