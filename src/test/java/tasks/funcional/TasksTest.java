package tasks.funcional;


import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.openqa.selenium.remote.RemoteWebDriver;



public class TasksTest {

	public WebDriver acessarAplicação() throws MalformedURLException{
	

		
		ChromeOptions cap = new ChromeOptions();
		WebDriver driver = new RemoteWebDriver(new URL("http://172.21.0.1:4444/wd/hub"), cap);
		driver.navigate().to("http://172.21.0.1:8001/tasks");		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);		
		return driver;
	}
	

	
	@Test
	public void deveSalavarTarefasComSucesso() throws MalformedURLException  {
		
		WebDriver driver = acessarAplicação();
		
		try {
		//Cickar em add To do
		driver.findElement(By.id("addTodo")).click();
		
		
		//Escrever a descrição
		driver.findElement(By.id("task")).sendKeys("teste via selenio");
		
		
		//Escrever a data
		driver.findElement(By.id("dueDate")).sendKeys("10/10/2021");
		
		
		//Clickar em Salvar
		driver.findElement(By.id("saveButton")).click();
		
		
		//Validar mensagem e sucesso
		String message = driver.findElement(By.id("message")).getText();
		Assert.assertEquals("Sucess!", message);
		
		}
		finally {
			//Fechar o drive
			
			driver.quit();
		}

	}
	
	@Test
	public void nãoDeveSalavarTarefasSemDescrição() throws MalformedURLException {
		
		WebDriver driver = acessarAplicação();
		
		try {
		//Cickar em add To do
		driver.findElement(By.id("addTodo")).click();
		
		
		//Escrever a data
		driver.findElement(By.id("dueDate")).sendKeys("10/10/2021");
		
		
		//Clickar em Salvar
		driver.findElement(By.id("saveButton")).click();
		
		
		//Validar mensagem e sucesso
		String message = driver.findElement(By.id("message")).getText();
		Assert.assertEquals("Fill the task description", message);
		
		}
		finally {
			//Fechar o drive
			
			driver.quit();
		}

	}
	
	@Test
	public void naoDeveSalavarTarefasSemData() throws MalformedURLException  {
		
		WebDriver driver = acessarAplicação();
		
		try {
		//Cickar em add To do
		driver.findElement(By.id("addTodo")).click();
		
		
		//Escrever a descrição
		driver.findElement(By.id("task")).sendKeys("teste via selenio");
				
		
		//Clickar em Salvar
		driver.findElement(By.id("saveButton")).click();
		
		
		//Validar mensagem e sucesso
		String message = driver.findElement(By.id("message")).getText();
		Assert.assertEquals("Fill the due date", message);
		
		}
		finally {
			//Fechar o drive
			
			driver.quit();
		}

	}
	
	@Test
	public void naoSeveSalavarTarefasComDataPassada() throws MalformedURLException  {
		
		WebDriver driver = acessarAplicação();
		
		try {
		//Cickar em add To do
		driver.findElement(By.id("addTodo")).click();
		
		
		//Escrever a descrição
		driver.findElement(By.id("task")).sendKeys("teste via selenio");
		
		
		//Escrever a data
		driver.findElement(By.id("dueDate")).sendKeys("10/10/2020");
		
		
		//Clickar em Salvar
		driver.findElement(By.id("saveButton")).click();
		
		
		//Validar mensagem e sucesso
		String message = driver.findElement(By.id("message")).getText();
		Assert.assertEquals("Due date must not be in past", message);
		
		}
		finally {
			//Fechar o drive
			
			driver.quit();
		}

	}
}
