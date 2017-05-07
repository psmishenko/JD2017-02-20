package by.it.smirnov.project.java.DAO;


/**
 * Created by aleksey.smirnov on 03.05.2017.
 */
public class DAO {
    private static DAO instance;

    private BankDAO bank;
    private CountryDAO country;
    private GroupBankDAO groupBank;
    private KursValutDAO kursValut;
    private LimitDAO limit;
    private OperTypeDAO operType;
    private RoleDAO role;
    private SdelDAO sdel;
    private SysOperDAO sysOper;
    private UserDAO user;
    private UserRoleDAO userRole;
    private ValutDAO valut;

    private DAO() {
    }

    public static DAO getInstance(){
        if (instance==null){
            synchronized (DAO.class){
                if(instance==null){
                    instance = new DAO();
                    instance.bank = new BankDAO();
                    instance.country = new CountryDAO();
                    instance.groupBank = new GroupBankDAO();
                    instance.kursValut = new KursValutDAO();
                    instance.limit = new LimitDAO();
                    instance.operType = new OperTypeDAO();
                    instance.role = new RoleDAO();
                    instance.sdel = new SdelDAO();
                    instance.sysOper = new SysOperDAO();
                    instance.user = new UserDAO();
                    instance.userRole = new UserRoleDAO();
                    instance.valut = new ValutDAO();
                }
            }
        }
        return instance;
    }

    public BankDAO getBank() {
        return bank;
    }

    public CountryDAO getCountry() {
        return country;
    }

    public GroupBankDAO getGroupBank() {
        return groupBank;
    }

    public KursValutDAO getKursValut() {
        return kursValut;
    }

    public LimitDAO getLimit() {
        return limit;
    }

    public OperTypeDAO getOperType() {
        return operType;
    }

    public RoleDAO getRole() {
        return role;
    }

    public SdelDAO getSdel() {
        return sdel;
    }

    public SysOperDAO getSysOper() {
        return sysOper;
    }

//    public UserDAO getUser() {
//        return user;
//    }

    public UserDAO getUser() {
        return user;
    }

    public UserRoleDAO getUserRole() {
        return userRole;
    }

    public ValutDAO getValut() {
        return valut;
    }
}
