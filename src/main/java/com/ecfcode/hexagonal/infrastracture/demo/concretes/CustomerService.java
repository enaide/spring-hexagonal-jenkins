package com.ecfcode.hexagonal.infrastracture.demo.concretes;

import com.ecfcode.hexagonal.infrastracture.demo.entities.Customer;
import com.ecfcode.hexagonal.infrastracture.demo.entities.Sale;
import com.ecfcode.hexagonal.infrastracture.demo.entities.Vehicle;
import com.ecfcode.hexagonal.infrastracture.demo.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final VehicleService vehicleService;

    public CustomerService(CustomerRepository customerRepository, VehicleService vehicleService) {
        this.customerRepository = customerRepository;
        this.vehicleService = vehicleService;
    }

    public Customer saveCustomer(Customer customer) {
        Customer newCustomer = new Customer();
        newCustomer.setCustomerName(customer.getCustomerName());

        List<Long> ids = vehicleIds(customer);
        List<Vehicle> vehicles = vehicleList(ids);

        List<Sale> saleDetails = customer.getSales().stream().map(getSaleFunction(vehicles)).toList();
        saleDetails.forEach(newCustomer::addSale);

        return customerRepository.save(newCustomer);
    }

    private static Function<Sale, Sale> getSaleFunction(List<Vehicle> vehicles) {
        return sale -> {
            Sale newSale = new Sale();
            Vehicle vehicle = vehicles.stream().filter(getVehiclePredicate(sale)).findFirst().orElse(null);
            newSale.setVehicle(vehicle);
            newSale.setDiscount(sale.getDiscount());

            return newSale;
        };
    }

    private List<Long> vehicleIds(Customer customer) {
        return customer.getSales().stream().map(sale -> sale.getVehicle().getVehicleId()).toList();
    }

    private List<Vehicle> vehicleList(List<Long> saleIds) {
        return vehicleService.findAllVehicleById(saleIds);
    }

    private static Predicate<Vehicle> getVehiclePredicate(Sale sale) {
        return v -> v.getVehicleId().equals(sale.getVehicle().getVehicleId());
    }
}
