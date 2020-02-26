// package webpage;
//
// import driver.DriverInterface;
// import org.openqa.selenium.WebElement;
// import org.openqa.selenium.support.PageFactory;
//
// public class BaseWebPage {
//
//     public void setInitElement(DriverInterface driver) {
//         PageFactory.initElements(driver.get(), this);
//     }
//
// 	public void waitLoop(WebElement element) throws Exception {
// 		for(int second = 0; second < 60; second++) {
// 				Thread.sleep(1000);
// 				if(element.isDisplayed()) {
// 					break;
// 				}
// 		}
// 	}
// }
