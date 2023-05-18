package software.test;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.example.Product;
import static org.example.Product.compliteflag;
import java.io.IOException;
import java.util.ArrayList;
import static org.junit.Assert.assertEquals;

public class distributeorder {
    ArrayList<String> workerDIS=new ArrayList<>();
    Product pDistribute=new Product();
    Boolean test;
    @Given("i have list of worker")
    public void i_have_list_of_worker() {

        pDistribute.listofworker();
    }
    @Then("i choose worker by id")
    public void i_choose_worker_by_id() {
        pDistribute.raya(2324);
        test = pDistribute.check(2324);
        Boolean exp =true;
        //    assertTrue(exp);
        assertEquals(test,exp);

    }
    @Then("check if this worker is avaliable")
    public void check_if_this_worker_is_avaliable() {


    }
    @Given("i found available worker")
    public void i_found_available_worker() {


    }
    @Then("distribute successful")

    public void distribute_successful() throws IOException {
        int idp= 3131;
        int idw = 6;
        pDistribute.distribute(workerDIS,idp,idw);

    }
    @Then("put worker not available")
    public void put_worker_not_available()  {

    }
    @Given("order complete")
    public void order_complete() {
     compliteflag();
    }
    @Then("send email")
    public void send_email() {

    }

}
