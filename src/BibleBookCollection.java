import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class BibleBookCollection 
{
	private ArrayList<BibleBook> theBooks;
	
	public BibleBookCollection()
	{
		this.theBooks = new ArrayList<BibleBook>();
	}
	
	public BibleBookCollection(String filename)
	{
		this();
		try
		{
			Scanner input = new Scanner(new File(System.getProperty("user.dir") + "/src/" + filename));
			while(input.hasNext())
			{
				this.theBooks.add(new BibleBook(input.nextLine()));
			}
			input.close();
		}
		catch(Exception e) { e.printStackTrace();}
	}
	
	public void addBibleBook(BibleBook b)
	{
		this.theBooks.add(b);
	}
	
	public void addBibleBook(String colonDelimitedData)
	{
		this.theBooks.add(new BibleBook(colonDelimitedData));
	}
	
	public BibleBook getFirstBookGivenSearchTerm(String term) throws Exception
	{
		for(BibleBook aBook : this.theBooks)
		{
			if(aBook.searchSummary(term))
			{
				return aBook;
			}
		}
		throw new Exception("Term not found exception");
	}
	
	
	public void sortOnName()
	{
			int numSwaps;
			BibleBook temp;
			do
			{
				numSwaps = 0;
				for (int i = 0; i < theBooks.size() - 1; i++)
				{
					if(theBooks.get(i).getName().compareToIgnoreCase(theBooks.get(i+1).getName())>0)
					{
						temp = theBooks.get(i);
						theBooks.set(1, theBooks.get(i+1));
						theBooks.set(i+1,temp);
						numSwaps++;
						
					}
				}
				
			}
		while(numSwaps > 0);
	}
	public void sortOnChapter()
	{
		int numSwaps;
		BibleBook temp;
		do
		{
			numSwaps = 0;
			for (int i = 0; i < theBooks.size() - 1; i++)
			{
				if(theBooks.get(i).getNumber_of_chapters()> theBooks.get(i+1).getNumber_of_chapters())
				{
					temp = theBooks.get(i);
					theBooks.set(i, theBooks.get(i+1));
					theBooks.set(i+1, temp);
					numSwaps++;
				}
			}
		}
		while(numSwaps > 0);
	}
	public void display()
	{
		System.out.println("Book Name: " + this.name + 
				"(" + this.number_of_chapters + " chapters) - " + this.summary);
	}
	
	

}