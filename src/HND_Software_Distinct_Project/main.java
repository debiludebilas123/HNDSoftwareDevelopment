package HND_Software_Distinct_Project;

public class main {
    public static void main(String[] args) {
        Customer customer = new Customer("123", "sudas", "sudas", "gandonas", "myzalas", "AB12 sudas");
        CSVWriter.writeCustomerToCSV(customer);

    }
}
