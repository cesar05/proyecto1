package co.ceiba.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import co.ceiba.domain.Person;
import co.ceiba.testdatabuilder.PersonTestDataBuilder;

public class NotifyPersonServiceTest {

	private NotifyPersonService notifyPersonService;
	private EmailService emailService;
	
	@Before
	public void setup(){
		emailService=Mockito.mock(EmailService.class);
		notifyPersonService=new NotifyPersonService(emailService);
	}
	
	@Test
	public void notifyTest(){
		//Arrange
		Person person=new PersonTestDataBuilder().build();	
		Mockito.when(emailService.sendMail(Mockito.anyString())).thenReturn("Hola mundo");
		//Act
		String message=notifyPersonService.notify(person);
		//Assert
		Assert.assertNotNull(message);
	}
	
	@Test
	public void sendMailTest(){
		String msj="enviar email";	
		emailService=new EmailService();
		Assert.assertNotNull(emailService.sendMail(msj));
	}	
	
}
