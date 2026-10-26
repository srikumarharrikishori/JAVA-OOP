package uk.ac.westminster.products_api;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private List<DigitalProduct> products = new ArrayList<DigitalProduct>();
    private Long nextId = 1L;

    public ProductService() {
        products.add(new DigitalProduct(
                nextId++, "Java E-Book", 9.99,
                "https://example.com/java-ebook.pdf", 4.5));

        products.add(new PhysicalProduct(
                nextId++, "Java Mug", 12.99,
                0.4, "12 cm x 10 cm"));
    }

    public List<DigitalProduct> getAllProducts() {
        return products;
    }
    public DigitalProduct addProduct(DigitalProduct product) {
        product.setId(nextId++); // use the value, then add one
        products.add(product);
        return product;
    }

    public Optional<DigitalProduct> getProductById(Long id) {
        return products.stream()
                .filter(product -> product.getId().equals(id))
                .findFirst();
    }

    public void deleteProduct(Long id) {
        products.removeIf(p -> p.getId().equals(id));
    }

    public List<DigitalProduct> findByName(String name) {
        return products.stream()
                .filter(p -> p.getName().contains(name))
                .toList();
    }

}
