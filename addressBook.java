import java.util.*;
class Person
{
	String firstName;
	String lastName;
	String address;
	String city;
	String state;
	int zip;
	long phoneNumber;

	Person(String firstName,String lastName,String address,String city,String state,int zip,long phoneNumber)
	{
		this.firstName=firstName;
		this.lastName=lastName;	
		this.address=address;
		this.city=city;
		this.state=state;
		this.zip=zip;
		this.phoneNumber=phoneNumber;
	}

	public String getPersonFirstName()
	{
		return this.firstName;
	}

	public String getPersonLastName() 
	{
		return this.lastName;
	}

	public int getZIP()
	{
		return this.zip;
	}

	public static Comparator<Person> personLastNameComparator = new Comparator<Person>() {

		public int compare(Person p1, Person p2) {
		   String personLastName1 = p1.getPersonLastName().toUpperCase();
		   String personLastName2 = p2.getPersonLastName().toUpperCase();  
		   int result=personLastName1.compareTo(personLastName2);
		   if(result!=0)
		   {
			   return result;
		   }
		   else
		   {
			   String personFirstName1 = p1.getPersonFirstName().toUpperCase();
			   String personFirstName2 = p2.getPersonFirstName().toUpperCase();
			   return personFirstName1.compareTo(personFirstName2);
		   }
	}};

	public static Comparator<Person> personZIPComparator = new Comparator<Person>() {

		public int compare(Person p1, Person p2) {

		   int zip1 = p1.getZIP();
		   int zip2 = p2.getZIP();
		   int result=zip1-zip2;
		   if(result!=0)
			   return result;
		   else
		   {
			   String personFirstName1 = p1.getPersonFirstName().toUpperCase();
			   String personFirstName2 = p2.getPersonFirstName().toUpperCase();
			   return personFirstName1.compareTo(personFirstName2);
		   }

	}};

}


public class addressBook {
	static ArrayList<Person> addressBook=new ArrayList<Person>();
	static Scanner sc=new Scanner(System.in);
	public static void addPerson()
	{
		System.out.println("Enter details of person to be added");
		System.out.print("Enter first name:");
		String firstName=sc.next();
		System.out.print("Enter last name:");
		String lastName=sc.next();
		System.out.print("Enter email address:");
		String address=sc.next();
		System.out.println("Enter city:");
		String city=sc.next();
		System.out.println("Enter state:");
		String state=sc.next();
		System.out.print("Enter zip:");
		int zip=sc.nextInt();
		System.out.print("Enter phone number:");
		long phoneNumber=sc.nextLong();
		Person p=new Person(firstName,lastName,address,city,state,zip,phoneNumber);
		addressBook.add(p);
	}

	public static void editPerson()
	{
		System.out.println("Enter first name and last name of person to be edited:");
		String firstName=sc.next();
		String lastName=sc.next();
		int flag=0;
		for(int i=0;i<addressBook.size();i++)
		{
			Person person=addressBook.get(i);
			if(firstName.equals(person.firstName) && lastName.equals(person.lastName))
			{
					System.out.println("1.Edit address\n2.Edit city\n3.Edit state\n4.Edit zip\n5.Edit phone number");
					System.out.println("Enter option:");
					int choice=sc.nextInt();
					switch(choice)
					{
					case 1:
						System.out.println("Enter new address:");
						String address=sc.next();
						person.address=address;
						break;
					case 2:
						System.out.println("Enter new city:");
						String city=sc.next();
						person.city=city;
						break;
					case 3:
						System.out.println("Enter new state:");
						String state=sc.next();
						person.state=state;
						break;
					case 4:
						System.out.println("Enter new zip:");
						int zip=sc.nextInt();
						person.zip=zip;
						break;
					case 5:
						System.out.println("Enter new phone number:");
						long phoneNumber=sc.nextLong();
						person.phoneNumber=phoneNumber;
						break;
					default:
						System.out.println("Enter valid option");
						break;
					}
					System.out.println("Edit successful");
					flag=1;
					break;
			}

		}
		if(flag==0)
			System.out.println("No record found!");

	}

	public static void deletePerson()
	{
		System.out.println("Enter details of person to be deleted");
		System.out.println("Enter first name:");
		String firstName=sc.next();
		System.out.println("Enter last name:");
		String lastName=sc.next();
		int flag=0;
		for(int i=0;i<addressBook.size();i++)
		{
			Person person=addressBook.get(i);
			if(firstName.equals(person.firstName) && lastName.equals(person.lastName)) {
				flag=1;
				addressBook.remove(person);
				break;
			}
		}
		if(flag==0)
			System.out.println("No record found!");
		else
			System.out.println("Deletion successful!");
	}

	public static void searchPerson()
	{
		System.out.println("Enter details of person to be searched");
		System.out.println("Enter first name:");
		String firstName=sc.next();
		int flag=0;
		for(int i=0;i<addressBook.size();i++)
		{
			Person person=addressBook.get(i);
			if(firstName.equals(person.firstName)) {
				flag=1;
				System.out.println("First name:"+person.firstName);
				System.out.println("Last name:"+person.lastName);
				System.out.println("Address:"+person.address);
				System.out.println("City:"+person.city);
				System.out.println("State:"+person.state);
				System.out.println("Zip:"+person.zip);
				System.out.println("Phone number:"+person.phoneNumber);
				System.out.println("------------");
			}
		}
		if(flag==0)
			System.out.println("No record found!");
	}

	public static void printAddressBook()
	{
		if(addressBook.size()==0)
		{
			System.out.println("No records in address book!");
			System.out.println("-----------------------");
		}
		else
		{
			System.out.println("Printing address book....");
			System.out.println(" First Name        Last Name        Address        State        City         ZIP Code         Phone Number");
			System.out.println("---------------------------------------------------------------------------------------");
			for(int i=0;i<addressBook.size();i++)
			{
				Person person=addressBook.get(i);
				System.out.println(" "+person.firstName+"       "+person.lastName+"       "+person.address+"       "+person.state+"       "+person.city+"       "+person.zip+"       "+person.phoneNumber);
				System.out.println(" ");
			}
			System.out.println("--------------------------------------------------------------------------------------------");
		}
	}

	public static void sortByLastName()
	{
		Collections.sort(addressBook,Person.personLastNameComparator);
		System.out.println("Sorting by last name successful!");
	}

	public static void sortByZIP()
	{
		Collections.sort(addressBook,Person.personZIPComparator);
		System.out.println("Sorting by ZIP successful!");
	}

	public static void main(String[] args) {
		System.out.println("ADDRESS BOOK!!");
		int choice=0;
		do
		{
		System.out.println("1.Add a person\n2.Edit a person\n3.Delete a person\n4.Search a person\n5.Print Address book\n6.Sort Address book by last name\n7.Sort Address book by ZIP\n8.Exit address book");
		System.out.println("Select an option from above options:");
		choice=sc.nextInt();
		switch(choice)
		{
		case 1:
			addPerson();
			break;
		case 2:
			editPerson();
			break;
		case 3:
			deletePerson();
			break;
		case 4:
			searchPerson();
			break;
		case 5:
			printAddressBook();
			break;
		case 6:
			sortByLastName();
			break;
		case 7:
			sortByZIP();
			break;
		case 8:
			System.out.println("Exiting address book....");
			break;
		default:
			System.out.println("Enter correct option:");
			break;
		}
		System.out.println("-------------------");
		}while(choice!=8);
	}

}
