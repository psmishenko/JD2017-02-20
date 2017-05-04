package by.it.vedom.jd03_03;

public class DAO {
    private static DAO instance;

    public UniversalDAO<Role> role;
    public UniversalDAO<User> user;
    public UniversalDAO<Product> product;
    public UniversalDAO<Order> order;

    private DAO() {
    }

    public static DAO getInstance(){
        if (instance==null){
            synchronized (DAO.class){
                if(instance==null){
                    instance=new DAO();
                    instance.user=new UniversalDAO<>(new User(),"users");
                    instance.role=new UniversalDAO<>(new Role(),"roles");
                    instance.product=new UniversalDAO<>(new Product(),"products");
                    instance.order=new UniversalDAO<>(new Order(),"orders");

                }
            }
        }
        return instance;
    }
}
