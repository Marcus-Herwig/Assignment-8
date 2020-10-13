
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Driver 
{
	public static void main(String[] args) throws Exception
	{
		BibleBookCollection theNewTestament = new BibleBookCollection("input.dat");
		theNewTestament.sortOnChapter();
		theNewTestament.sortOnName();
		System.out.println("hello");
	}
	
}