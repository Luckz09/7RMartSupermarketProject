package ultilities;

import com.github.javafaker.Faker;

public class FakerUtility {
	
	Faker faker=new Faker();
	
	public String createRandomUserName()
	{
		return faker.name().username();
	}
	public String createRandomPassword()
	{
		return faker.internet().password();
	}
	public String  createRandomFullName()
	{
		return faker.name().fullName();
	}
	public String createRandomAdress()
	{
		return faker.address().fullAddress();
	}
	public String createRandomEmail()
	{
		return faker.internet().emailAddress();
	}

}
