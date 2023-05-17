package software.test;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.example.Product;
import org.example.Worker;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Logger;
import static org.junit.Assert.assertEquals;

public class distributeorder {
    Worker w=new Worker();
    private static final Logger logger = Logger.getLogger("software.test.distributeorder");
    Product pDistribute=new Product();
    Boolean test;
    @Given("i have list of worker")
    public void i_have_list_of_worker() {
        pDistribute.listofworker();
    }
    @Then("i choose worker by id")
    public void i_choose_worker_by_id() {


    }
    @Then("check if this worker is avaliable")
    public void check_if_this_worker_is_avaliable() {


    }
    @Given("i found available worker")
    public void i_found_available_worker() {


    }
    @Then("distribute successful")

    public void distribute_successful() {
        pDistribute.raya(2324);
        test = pDistribute.check(2324);
        Boolean exp =true;
    //    assertTrue(exp);
        assertEquals(test,exp);

    }
    @Then("put worker not available")
    public void put_worker_not_available() throws IOException {
        ArrayList<String> workerDIS=new ArrayList<>();
      //  pDistribute.distribute(workerDIS);
    }

}
