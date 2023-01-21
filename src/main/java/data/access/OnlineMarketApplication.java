package data.access;

import data.access.entity.Cart;
import data.access.entity.Product;
import data.access.service.CartDao;
import data.access.service.DaoService;
import data.access.service.ProductDao;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;


public class OnlineMarketApplication {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(DataSourceConfiguration.class);

        ProductDao productDao = context.getBean(ProductDao.class);
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        System.out.println("List of Products are ");
        for (Product product : productDao.findAll()) {
            System.out.println(product);
        }
        CartDao cartDao = context.getBean(CartDao.class);
        cartDao.create(new Cart());
        cartDao.findById(5);
    }

}