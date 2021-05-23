package tasks.funcional;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



public class TasksTest {

	public WebDriver acessarAplicação() {
		WebDriver driver = new ChromeDriver();		
		driver.navigate().to("http://localhost:8001/tasks");		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);		
		return driver;
	}
	

	
	@Test
	public void deveSalavarTarefasComSucesso() {
		
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
	public void nãoDeveSalavarTarefasSemDescrição() {
		
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
	public void naoDeveSalavarTarefasSemData() {
		
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
	public void naoSeveSalavarTarefasComDataPassada() {
		
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
