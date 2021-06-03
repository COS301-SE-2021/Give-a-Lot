package com.GiveaLot.givealot.User.mockData;
import com.GiveaLot.givealot.User.dataclass.User;
import java.util.LinkedList;
import java.util.List;

public class mockUsers
{
    List<User> users;

    public mockUsers()
    {
        users = new LinkedList<>();
        users.add(new User("the givers of hope",
                "give hope to the lost",
                "givers@hope.com",
                "givers street,pretoria,South Afriza",
                "someurl/thegiversofhope",
                false,
                false));

        users.add(new User("Take the kid to the park",
                "For the children",
                "kidContact@gmai.com",
                "givers street,pretoria,South Afriza",
                "someurl/takethekidtothepark",
                true,
                true));

        users.add(new User("Take the kid to the mall",
                "For the children",
                "kidContact@gmai.com",
                "givers street,pretoria,South Afriza",
                "someurl/takethekidtothemall",
                true,
                true));

        users.add(new User("people Take the kid home",
                "For the children",
                "kidContact@gmai.com",
                "givers street,pretoria,South Afriza",
                "someurl/takethekidtothepark",
                true,
                true));

        users.add(new User("mondli food drive",
                "feeding the hungry",
                "givers@hope.com",
                "givers street,pretoria,South Afriza",
                "someurl/mondlifooddrive",
                true,
                true));


        users.add(new User("cos restore",
                "restoring lost hope of students in cos",
                "exceptionus@hcosrestore.com",
                "givers street,pretoria,South Afriza",
                "someurl/cosrestore",
                true,
                true));

    }

    public List<User> getUsers()
    {
        return users;
    }

}
