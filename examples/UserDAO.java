public class UserDAO
{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public UserDAO()
    {
        new BuilderManager(this);
    }

    @Exec(sql = "SELECT NAME FROM USER WHERE ID = ?")
    private String userNameById;


    public String findUserNameById(Long id) {

        return jdbcTemplate.queryForObject(userNameById, new Object[]{id}, String.class);

    }

}