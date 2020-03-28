package com.gotszalk.travelservice.tripPackage.service;

import com.gotszalk.travelservice.offerPackage.service.OfferService;
import com.gotszalk.travelservice.personPackage.models.Person;
import com.gotszalk.travelservice.personPackage.models.Role;
import com.gotszalk.travelservice.personPackage.service.PersonService;
import com.gotszalk.travelservice.tripPackage.repository.TripRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@RunWith(MockitoJUnitRunner.class)
public class TripServiceTest {

    @Mock
    private TripRepository tripRepository;
    @Mock
    private PersonService personService;
    @Mock
    private OfferService offerService;

    @InjectMocks
    private TripService mockService;

    @Test
    public void calculateCostTest(){

        //given
        BigDecimal price = BigDecimal.valueOf(1000);

        Set<Person> people = new HashSet<>();
        Person person1 = new Person("person1", "person1S", "19-11-1995");
        person1.setRole(Role.CLIENT);
        person1.setPersonId(1L);
        people.add(person1);

        Person person2 = new Person("person2", "person2S", "19-11-1995");
        person2.setRole(Role.PASSENGER);
        person2.setPersonId(2L);
        people.add(person2);

        Person person3 = new Person("person3", "person3S", "19-11-1995");
        person3.setRole(Role.PASSENGER);
        person3.setPersonId(3L);
        people.add(person3);

        Person person4 = new Person("person4", "person4S", "19-11-1995");
        person4.setRole(Role.SALESMAN);
        person4.setPersonId(4L);
        people.add(person4);

        //then
        Assert.assertEquals(BigDecimal.valueOf(3000), mockService.calculateCost(price, people));
    }
}