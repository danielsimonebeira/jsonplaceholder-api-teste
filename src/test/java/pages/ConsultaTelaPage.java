package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ConsultaTelaPage {
    protected WebDriver driver;

    private By BotaoMenuGuide = By.xpath("/html/body/header/nav/ul/li[1]/a");
    private By LinkAlbumPhotos = By.xpath("/html/body/div/main/ul/li[2]/a");

    public void clicarBotao (String botao) {
        WebDriverWait esperaElemento = new WebDriverWait(driver, 60);
        if (botao.equals("Guide")) {
            esperaElemento.until(ExpectedConditions.visibilityOfElementLocated(BotaoMenuGuide));
            driver.findElement(BotaoMenuGuide).isDisplayed();
            driver.findElement(BotaoMenuGuide).click();
        } else if (botao.equals("/albums/1/photos")) {
            esperaElemento.until(ExpectedConditions.visibilityOfElementLocated(LinkAlbumPhotos));
            driver.findElement(LinkAlbumPhotos).isDisplayed();
            driver.findElement(LinkAlbumPhotos).click();
        } else {
            System.out.println("botão não encontrado");
        }
    }

}
