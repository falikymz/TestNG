package techproed.tests.day19_annotations;

import org.testng.annotations.*;

public class C01_Annotations {


    @BeforeSuite
    public void beforeSuite(){
        System.out.println("her şeyden önce BeforeSuite notsayonuna sahip olan method bir kez çalışır");
    }


    @AfterSuite
    public void afterSuite(){
        System.out.println("her şeyden sonra AfterSuite notsayonuna sahip olan method bir kez çalışır");
    }


    @BeforeTest
    public void beforeTest(){
        System.out.println("Testlerden önce BeforeTest notasyonuna sahip olan method bir kez çalışır");
    }

    @AfterTest
    public void afterTest(){
        System.out.println("Testlerden sonra AfterTest notasyonuna sahip olan method bir kez çalışır");
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("Her class tan önce BeforeClass notasyonuna sahip olan method bir kez çalışır");
        System.out.println("***********************************************************");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("***********************************************************");
        System.out.println("Her class tan sonra AfterClass notasyonuna sahip olan method bir kez çalışır");
    }


    @BeforeMethod
    public void setUp() {
        System.out.println("BeforeMethod notasyonuna sahip olan method her test methodundan önce 1 kez çalışır");
    }

    @AfterMethod
    public void tearDown() {
        System.out.println("AfterMethod notasyonu sahip olan method her test methodundan sonra 1 kez çalışır");
    }


    @Test
    public void test01() {
        System.out.println("TEST 01");
    }

    @Test
    public void test02() {
        System.out.println("TEST 02");
    }

     /*
    Junit te  @BeforeClass ve  @AfterClass annotationina sahip methodhlar static olmak zorundaydi
    Test NG bu zorunlulugu kaldirdi
     */
}
