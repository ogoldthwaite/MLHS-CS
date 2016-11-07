package ab_2009_4;

import java.util.HashSet;
import java.util.Set;

import junit.framework.TestCase;

public class PersonTest extends TestCase
{
    private Person ahmed, bonita, chad, danielle, eric, fay;
    
    public void setUp()
    {
        ahmed = new Person("Ahmed");
        bonita = new Person("Bonita");
        chad = new Person("Chad");
        danielle = new Person("Danielle");
        eric = new Person("Eric");
        fay = new Person("Fay");
        
        ahmed.addContact(bonita);
        ahmed.addContact(eric);
        
        bonita.addContact(ahmed);
        bonita.addContact(chad);
        
        chad.addContact(bonita);
        
        danielle.addContact(eric);
        danielle.addContact(fay);
        
        eric.addContact(ahmed);
        eric.addContact(danielle);
        eric.addContact(fay);
        
        fay.addContact(danielle);
        fay.addContact(eric);
    }
    
    public void testExpandContactSet()
    {
        Set<Person> people = new HashSet<Person>();
        people.add(ahmed);
        people.add(bonita);
        
        Set<Person> peopleOrigianal = new HashSet<Person>(people);
        
        Set<Person> expectedResult = new HashSet<Person>();
        expectedResult.add(bonita);
        expectedResult.add(eric);
        expectedResult.add(ahmed);
        expectedResult.add(chad);
        
        Set<Person> actualResult = Person.expandContactSet(people);
        
        assertTrue(actualResult.equals(expectedResult));
        assertTrue(people.equals(peopleOrigianal));
    }
    
    private void verifyGetNetwork(Person p, Set<Person> expectedResult)
    {
        Set<Person> original = new HashSet<Person>(p.getContacts());
        
        Set<Person> actualResult = p.getNetwork(2);
        
        assertTrue(actualResult.equals(expectedResult));
        assertTrue(p.getContacts().equals(original));
    }
    
    public void testGetNetworkAhmed()
    {
        Set<Person> expectedResult = new HashSet<Person>();
        expectedResult.add(bonita);
        expectedResult.add(chad);
        expectedResult.add(danielle);
        expectedResult.add(eric);
        expectedResult.add(fay);
        
        verifyGetNetwork(ahmed, expectedResult);
    }
    
    public void testGetNetworkBonita()
    {
        Set<Person> expectedResult = new HashSet<Person>();
        expectedResult = new HashSet<Person>();
        expectedResult.add(ahmed);
        expectedResult.add(chad);
        expectedResult.add(eric);
        
        verifyGetNetwork(bonita, expectedResult);
    }

    public void testGetNetworkChad()
    {
        Set<Person> expectedResult = new HashSet<Person>();
        expectedResult.add(ahmed);
        expectedResult.add(bonita);
        
        verifyGetNetwork(chad, expectedResult);
    }
    
    public void testGetNetworkDanielle()
    {
        Set<Person> expectedResult = new HashSet<Person>();
        expectedResult.add(ahmed);
        expectedResult.add(eric);
        expectedResult.add(fay);
        
        verifyGetNetwork(danielle, expectedResult);
    }
    
    public void testGetNetworkEric()
    {
        Set<Person> expectedResult = new HashSet<Person>();
        expectedResult.add(ahmed);
        expectedResult.add(bonita);
        expectedResult.add(danielle);
        expectedResult.add(fay);
        
        verifyGetNetwork(eric, expectedResult);
    }
    
    public void testGetNetworkFay()
    {
        Set<Person> expectedResult = new HashSet<Person>();
        expectedResult.add(ahmed);
        expectedResult.add(danielle);
        expectedResult.add(eric);
        
        verifyGetNetwork(fay, expectedResult);
    }
}